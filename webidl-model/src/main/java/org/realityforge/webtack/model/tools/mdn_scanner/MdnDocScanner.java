package org.realityforge.webtack.model.tools.mdn_scanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
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
        // TODO: If kind == Type then delete all dependent that is not user created
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
      if ( DocKind.Type == entry.getKind() )
      {
        final List<String> constructors = entry.getConstructors();
        if ( null != constructors )
        {
          for ( final String constructor : constructors )
          {
            fetchDocumentation( DocKind.Constructor, type, constructor, force, removeSource );
          }
        }
        final List<String> properties = entry.getProperties();
        if ( null != properties )
        {
          for ( final String property : properties )
          {
            fetchDocumentation( DocKind.Property, type, property, force, removeSource );
          }
        }
        final List<String> methods = entry.getMethods();
        if ( null != methods )
        {
          for ( final String method : methods )
          {
            fetchDocumentation( DocKind.Method, type, method, force, removeSource );
          }
        }
        final List<String> events = entry.getEvents();
        if ( null != events )
        {
          for ( final String event : events )
          {
            fetchDocumentation( DocKind.Event, type, event, force, removeSource );
          }
        }
        //TODO: Remove any sources for type if they are not present above and they are not
        // user supplied rather than downloaded. User supplied docs have no corresponding url
      }
      return new DocFetchResult( source, entry, extractResult.isChanged() );
    }
    else
    {
      return new DocFetchResult( source, null, !isNew );
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
      entry.setKind( kind );
      entry.setName( source.getName() );
      entry.setHref( source.getUrl() );
      entry.setDescription( description );

      final List<String> constructors =
        document
          .select( "#Constructors + p + dl > dt > a > code, #Constructors + dl > dt > a > code" )
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
          .select( "#Properties + p + dl > dt > code, #Properties + dl > dt > code" )
          .stream()
          .map( Element::text )
          // Strip out the type name that sometimes appears in the documentation
          .map( text -> text.replaceAll( "^" + source.getName() + "\\.", "" ) )
          .sorted()
          .collect( Collectors.toList() );
      if ( !properties.isEmpty() )
      {
        entry.setProperties( properties );
      }
      final List<String> methods =
        document
          .select(
            "#Methods + p + dl > dt > a > code, #Methods + dl > dt > a code, #Static_methods + p + dl > dt > a > code, #Static_methods + dl > dt > a > code" )
          .stream()
          .map( Element::text )
          // Strip the brackets at end of methods
          .map( text -> text.replaceAll( "\\(.*", "" ) )
          // Strip out the type name that sometimes appears in the documentation
          .map( text -> text.replaceAll( "^" + source.getName() + "\\.", "" ) )
          .sorted()
          .collect( Collectors.toList() );
      if ( !methods.isEmpty() )
      {
        // Sometimes constructors are documented as methods so instead register them as constructors
        final List<String> newConstructors =
          methods
            .stream()
            .filter( m -> m.equals( source.getName() ) )
            .map( m -> m + "." + m )
            .collect( Collectors.toList() );
        if ( !newConstructors.isEmpty() )
        {
          newConstructors.addAll( constructors );
          entry.setConstructors( newConstructors.stream().sorted().collect( Collectors.toList() ) );
        }

        final List<String> actualMethods =
          methods.stream().filter( m -> !m.equals( source.getName() ) ).collect( Collectors.toList() );
        if ( !actualMethods.isEmpty() )
        {
          entry.setMethods( actualMethods );
        }

        final List<String> events =
          document
            .select( "#Events + p + dl > dt > a[href$=\"_event\"] > code, #Events + dl > dt > a[href$=\"_event\"] > code" )
            .stream()
            .map( Element::text )
            // Strip out the type name that sometimes appears in the documentation
            .map( text -> text.replaceAll( "^" + source.getName() + "\\.", "" ) )
            .sorted()
            .collect( Collectors.toList() );
        if ( !events.isEmpty() )
        {
          entry.setEvents( events );
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

  private void replaceElementWithChildren( final Element span )
  {
    for ( final Node child : new ArrayList<>( span.childNodes() ) )
    {
      span.before( child );
    }
    span.remove();
  }

  @Nonnull
  private String cleanDescription( @Nonnull final String text )
  {
    return text.replaceAll( " +", " " ).replace( "&nbsp;", "" ).trim();
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
