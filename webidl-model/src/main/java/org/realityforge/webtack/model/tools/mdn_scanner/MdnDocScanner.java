package org.realityforge.webtack.model.tools.mdn_scanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.realityforge.webtack.model.tools.fetch.FetchException;
import org.realityforge.webtack.model.tools.fetch.FetchResult;
import org.realityforge.webtack.model.tools.fetch.FetchUtil;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocRepositoryConfig;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocSourceConfig;

public final class MdnDocScanner
{
  @Nonnull
  private static final String API_RELATIVE_URL = "/en-US/docs/Web/API/";
  @Nonnull
  private static final String HOST_URL = "https://developer.mozilla.org";
  @Nonnull
  public static final String BASE_URL = HOST_URL + API_RELATIVE_URL;
  @Nonnull
  private final DocRepositoryRuntime _runtime;

  public MdnDocScanner( @Nonnull final DocRepositoryRuntime runtime )
  {
    _runtime = Objects.requireNonNull( runtime );
  }

  @Nonnull
  public DocFetchResult fetchDocumentation( @Nonnull final DocKind kind,
                                            @Nonnull final String type,
                                            @Nullable final String member,
                                            final boolean force,
                                            final boolean removeSource )
    throws DocException
  {
    final DocSourceConfig source = findOrCreateDocSourceConfig( kind, type, member );
    final boolean isNew = 0 == source.getLastModifiedAt();
    final Path target = _runtime.getDataFileLocation( source );
    final FetchResult result;
    try
    {
      final String url = source.getUrl();
      result = null != url ? FetchUtil.downloadURL( url, force ? 0 : source.getLastModifiedAt() ) : null;
    }
    catch ( final FetchException fe )
    {
      if ( fe.getCause() instanceof FileNotFoundException )
      {
        source.setLastModifiedAt( 0 );
        saveRepository();
        // Documentation has been removed so remove our local caches
        removeExistingTmpFiles( source, target );
        if ( DocKind.Type == kind )
        {
          removeUnexpectedConfigs( source.getName(), Collections.emptyList() );
        }
        return new DocFetchResult( source, null, !isNew );
      }
      else
      {
        throw new SourceFetchException( source, fe.getCause() );
      }
    }
    if ( null != result )
    {
      createParentDirectoryIfRequired( source, target );
      removeExistingTmpFiles( source, target );

      final Path tmpTarget = asTmpTarget( target, ".html" );

      // just copy to tmp file for now
      try
      {
        Files.move( result.getPath(), tmpTarget );
      }
      catch ( final IOException ioe )
      {
        throw new SourceIOException( source, "Failed to copy fetched content to temp file", ioe );
      }

      final ExtractResult extractResult = extractDocs( source, kind, tmpTarget, target );

      if ( extractResult.isChanged() )
      {
        source.setLastModifiedAt( result.getLastModifiedAt() );
        saveRepository();
      }

      if ( removeSource )
      {
        try
        {
          Files.delete( tmpTarget );
        }
        catch ( final IOException ioe )
        {
          throw new SourceIOException( source, "Failed to remove temp file", ioe );
        }
      }

      final DocEntry entry = extractResult.getEntry();
      if ( DocKind.Type == kind )
      {
        final List<DocSourceConfig> expected = new ArrayList<>();
        expected.add( source );
        final List<String> constructors = entry.getConstructors();
        if ( null != constructors )
        {
          for ( final String constructor : constructors )
          {
            final DocFetchResult docResult =
              fetchDocumentation( DocKind.Constructor, type, constructor, force, removeSource );
            expected.add( docResult.getSource() );
          }
        }
        final List<String> properties = entry.getProperties();
        if ( null != properties )
        {
          for ( final String property : properties )
          {
            final DocFetchResult docResult =
              fetchDocumentation( DocKind.Property, type, property, force, removeSource );
            expected.add( docResult.getSource() );
          }
        }
        final List<String> methods = entry.getMethods();
        if ( null != methods )
        {
          for ( final String method : methods )
          {
            final DocFetchResult docResult = fetchDocumentation( DocKind.Method, type, method, force, removeSource );
            expected.add( docResult.getSource() );
          }
        }
        final List<String> events = entry.getEvents();
        if ( null != events )
        {
          for ( final String event : events )
          {
            final DocFetchResult docResult = fetchDocumentation( DocKind.Event, type, event, force, removeSource );
            expected.add( docResult.getSource() );
          }
        }
        removeUnexpectedConfigs( entry.getName(), expected );
      }
      return new DocFetchResult( source, entry, extractResult.isChanged() );
    }
    else
    {
      return new DocFetchResult( source, null, !isNew );
    }
  }

  private void removeUnexpectedConfigs( @Nonnull final String typeName, @Nonnull final List<DocSourceConfig> expected )
    throws SourceIOException, RepositorySaveException
  {
    final DocRepositoryConfig repository = _runtime.getRepository();
    final List<DocSourceConfig> sourcesToRemove =
      repository
        .getSources()
        .stream()
        .filter( s -> s.getName().startsWith( typeName + "." ) )
        .filter( s -> null != s.getUrl() && s.getUrl().startsWith( BASE_URL ) )
        .filter( s -> !expected.contains( s ) )
        .collect( Collectors.toList() );

    for ( final DocSourceConfig source : sourcesToRemove )
    {
      repository.getSources().remove( source );
      final Path path = _runtime.getDataFileLocation( source );
      try
      {
        Files.deleteIfExists( path );
      }
      catch ( final IOException ioe )
      {
        throw new SourceIOException( source, "Failed to remove existing file for removed source", ioe );
      }
    }
    if ( !sourcesToRemove.isEmpty() )
    {
      saveRepository();
    }
  }

  private void removeExistingTmpFiles( @Nonnull final DocSourceConfig source, @Nonnull final Path target )
    throws SourceIOException
  {
    try
    {
      Files.deleteIfExists( asTmpTarget( target, ".html" ) );
      Files.deleteIfExists( asTmpTarget( target, "" ) );
    }
    catch ( final IOException ioe )
    {
      throw new SourceIOException( source, "Failed to remove existing files for source", ioe );
    }
  }

  @Nonnull
  private ExtractResult extractDocs( @Nonnull final DocSourceConfig source,
                                     @Nonnull final DocKind kind,
                                     @Nonnull final Path input,
                                     @Nonnull final Path output )
    throws SourceIOException
  {
    try
    {
      final Document document = Jsoup.parse( input.toFile(), StandardCharsets.UTF_8.name() );

      // Make all anchors absolute so anything we include will correctly crosslink
      for ( final Element anchor : document.select( "[href^=\"/\"]" ) )
      {
        anchor.attr( "href", HOST_URL + anchor.attr( "href" ) );
      }

      final DocEntry entry = new DocEntry();
      final Element element = document.selectFirst( "meta[name=\"description\"]" );
      final String description = null != element ? element.attr( "content" ) : "";

      // We use the localName as some APIs have been updated in spec but MDN still uses "old"
      // name and redirects at http level when you request the new name. i.e. XR type was called XRSystem
      final Element localNameElement = document.selectFirst( "meta[property=\"og:title\"]" );
      final String localName = null != localNameElement ? localNameElement.attr( "content" ) : "";

      entry.setKind( kind );
      entry.setName( source.getName() );
      entry.setHref( source.getUrl() );
      entry.setDescription( description );
      if ( DocKind.Type == kind )
      {
        final List<String> constructors =
          document
            .select( "#Constructors + p + dl > dt > a > code, " +
                     "#Constructors + dl > dt > a > code" )
            .stream()
            .map( Element::text )
            // Strip the brackets at end of constructors
            .map( text -> text.replaceAll( "\\(.*", "" ) )
            .sorted()
            .collect( Collectors.toList() );
        if ( !constructors.isEmpty() )
        {
          entry.setConstructors( constructors );
        }
        final List<String> properties =
          document
            .select( "#Properties + p + dl > dt > a > code, " +
                     "#Properties + dl > dt > a > code, " +

                     // GlobalEventHandlers has event handler properties here
                     "#Properties > dl > dt > a > code, " +

                     // XRSessionInit has dictionary members that are not cross-linked as does other dictionaries here
                     "#Properties + p + dl > dt > code, " +

                     // Sometimes events section actually lists event handler properties
                     "#Events + p + dl > dt > a:not([href$=\"_event\"]) > code, " +
                     "#Events + dl > dt > a:not([href$=\"_event\"]) > code" )
            .stream()
            .map( Element::text )
            // Strip out the type name that sometimes appears in the documentation
            .map( text -> text.replaceAll( "^" + localName + "\\.", "" ) )
            .sorted()
            .collect( Collectors.toList() );
        if ( !properties.isEmpty() )
        {
          entry.setProperties( properties );
        }
        final List<String> methods =
          document
            .select( "#Methods + p + dl > dt > a > code, " +
                     "#Methods + dl > dt > a code, " +
                     "#Static_methods + p + dl > dt > a > code, " +
                     "#Static_methods + dl > dt > a > code" )
            .stream()
            .map( Element::text )
            // Strip the brackets at end of methods
            .map( text -> text.replaceAll( "\\(.*", "" ) )
            // Strip out the type name that sometimes appears in the documentation
            .map( text -> text.replaceAll( "^" + localName + "\\.", "" ) )
            .sorted()
            .collect( Collectors.toList() );
        if ( !methods.isEmpty() )
        {
          // Sometimes constructors are documented as methods so instead register them as constructors
          final List<String> newConstructors =
            methods
              .stream()
              .filter( m -> m.equals( localName ) )
              .map( m -> m + "." + m )
              .collect( Collectors.toList() );
          if ( !newConstructors.isEmpty() )
          {
            newConstructors.addAll( constructors );
            entry.setConstructors( newConstructors.stream().sorted().distinct().collect( Collectors.toList() ) );
          }

          final List<String> actualMethods =
            methods.stream().filter( m -> !m.equals( localName ) ).collect( Collectors.toList() );
          if ( !actualMethods.isEmpty() )
          {
            entry.setMethods( actualMethods );
          }

          final List<String> events =
            document
              .select( "#Events + p + dl > dt > a[href$=\"_event\"] > code, " +
                       "#Events + dl > dt > a[href$=\"_event\"] > code" )
              .stream()
              .map( Element::text )
              // Strip out the type name that sometimes appears in the documentation
              .map( text -> text.replaceAll( "^" + localName + "\\.", "" ) )
              .sorted()
              .collect( Collectors.toList() );
          if ( !events.isEmpty() )
          {
            entry.setEvents( events );

            // Not all doc pages explicitly list onx event handlers as properties so we try and scrape the page
            // to try and find them
            final List<String> newProperties =
              events
                .stream()
                .map( e -> "on" + e )
                .filter( e -> !document.select( "a[href=\"" + BASE_URL + localName + "/" + e + "\"]" ).isEmpty() )
                .collect( Collectors.toList() );
            if ( !newProperties.isEmpty() )
            {
              newProperties.addAll( properties );
              entry.setProperties( newProperties.stream().sorted().distinct().collect( Collectors.toList() ) );
            }
          }
        }
      }
      else if ( DocKind.Event == kind )
      {
        final Elements headers = document.select( "#wikiArticle > table.properties > tbody > tr > th[scope=\"row\"]" );
        for ( final Element th : headers )
        {
          final Element td = th.nextElementSibling();
          assert "td".equals( td.tagName() );

          final String text = th.text();
          if ( "Interface".equals( text ) )
          {
            entry.setEventType( td.text() );
          }
          else if ( "Event handler".equals( text ) || "Event handler property".equals( text ) )
          {
            entry.setEventHandlerProperty( td.text().replaceAll( "^.*\\.", "" ) );
          }
        }
      }

      final Path tmpOutput = asTmpTarget( output, "" );
      DocEntry.save( entry, tmpOutput );
      if ( Files.exists( output ) && doFileContentsMatch( output, tmpOutput ) )
      {
        Files.delete( tmpOutput );
        return new ExtractResult( entry, false );
      }
      else
      {
        Files.move( tmpOutput, output, StandardCopyOption.REPLACE_EXISTING );
        return new ExtractResult( entry, true );
      }
    }
    catch ( final Exception e )
    {
      throw new SourceIOException( source, "Failed to read local file for source", e );
    }
  }

  private boolean doFileContentsMatch( @Nonnull final Path path1, @Nonnull final Path path2 )
    throws IOException
  {
    final byte[] path1Bytes = Files.readAllBytes( path1 );
    final byte[] path2Bytes = Files.readAllBytes( path2 );
    if ( path1Bytes.length == path2Bytes.length )
    {
      for ( int i = 0; i < path1Bytes.length; i++ )
      {
        if ( path1Bytes[ i ] != path2Bytes[ i ] )
        {
          return false;
        }
      }
      return true;
    }
    else
    {
      return false;
    }
  }

  @Nonnull
  private Path asTmpTarget( @Nonnull final Path target, @Nonnull final String suffix )
  {
    return target.getParent().resolve( target.getName( target.getNameCount() - 1 ) + ".tmp" + suffix );
  }

  private void createParentDirectoryIfRequired( @Nonnull final DocSourceConfig source, @Nonnull final Path path )
    throws SourceIOException
  {
    if ( !Files.exists( path.getParent() ) )
    {
      try
      {
        Files.createDirectories( path.getParent() );
      }
      catch ( final IOException ioe )
      {
        throw new SourceIOException( source, "Failed to create directory to contain source", ioe );
      }
    }
  }

  @Nonnull
  private DocSourceConfig findOrCreateDocSourceConfig( @Nonnull final DocKind kind,
                                                       @Nonnull final String type,
                                                       @Nullable final String member )
    throws RepositorySaveException
  {
    assert null == member || DocKind.Type != kind;
    final String name = type + ( null == member ? "" : "." + member );
    final DocRepositoryConfig repository = _runtime.getRepository();
    DocSourceConfig source = repository.findSourceByName( name );
    if ( null == source )
    {
      source = new DocSourceConfig();
      source.setName( name );
      source.setLastModifiedAt( 0 );
      source.setUrl( getElementUrl( type, member, kind ) );
      repository.getSources().add( source );
      saveRepository();
    }
    return source;
  }

  private void saveRepository()
    throws RepositorySaveException
  {
    final DocRepositoryConfig repository = _runtime.getRepository();
    try
    {
      DocRepositoryConfig.save( repository );
    }
    catch ( final Exception e )
    {
      throw new RepositorySaveException( repository, e );
    }
  }

  @Nonnull
  private String getElementUrl( @Nonnull final String type,
                                @Nullable final String member,
                                @Nonnull final DocKind kind )
  {
    return BASE_URL + type + ( null == member ? "" : "/" + member ) + ( DocKind.Event == kind ? "_event" : "" );
  }
}
