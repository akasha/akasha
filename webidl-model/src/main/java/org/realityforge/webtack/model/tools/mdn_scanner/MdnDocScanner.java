package org.realityforge.webtack.model.tools.mdn_scanner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.json.stream.JsonGenerator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.realityforge.webtack.model.tools.fetch.FetchException;
import org.realityforge.webtack.model.tools.fetch.FetchResult;
import org.realityforge.webtack.model.tools.fetch.FetchUtil;
import org.realityforge.webtack.model.tools.repository.config.DocRepositoryConfig;
import org.realityforge.webtack.model.tools.repository.config.DocSourceConfig;

public final class MdnDocScanner
{
  @Nonnull
  private static final String API_RELATIVE_URL = "/en-US/docs/Web/API/";
  @Nonnull
  private static final String HOST_URL = "https://developer.mozilla.org";
  @Nonnull
  private static final String BASE_URL = HOST_URL + API_RELATIVE_URL;
  @Nonnull
  private final DocRepositoryConfig _repository;
  @Nonnull
  private final Path _dataDirectory;

  public MdnDocScanner( @Nonnull final DocRepositoryConfig repository, @Nonnull final Path dataDirectory )
  {
    _repository = Objects.requireNonNull( repository );
    _dataDirectory = Objects.requireNonNull( dataDirectory );
  }

  public void fetchDocumentation( @Nonnull final DocKind kind,
                                  @Nonnull final String type,
                                  @Nullable final String member,
                                  final boolean force,
                                  final boolean removeSource )
    throws DocException
  {
    final DocSourceConfig source = findOrCreateDocSourceConfig( kind, type, member );
    final Path target = _dataDirectory.resolve( source.getName() + ".json" );
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
        removeExistingSourceFiles( source, target );
        // TODO: If kind == Type then delete all dependent
        return;
      }
      else
      {
        throw new SourceFetchException( source, fe.getCause() );
      }
    }
    if ( null != result )
    {
      source.setLastModifiedAt( result.getLastModifiedAt() );

      createParentDirectoryIfRequired( source, target );
      removeExistingSourceFiles( source, target );

      final Path tmpTarget = asTmpTarget( target );

      // just copy to tmp file for now
      try
      {
        Files.move( result.getPath(), tmpTarget );
      }
      catch ( final IOException ioe )
      {
        throw new SourceIOException( source, "Failed to copy fetched content to temp file", ioe );
      }

      extractDocs( source, tmpTarget, target );

      saveRepository();
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

      if( DocKind.Type == kind )
      {
        // TODO: If kind == Type then delete all dependent that are not part of doc and trigger fetch for all others
      }
    }
  }

  private void removeExistingSourceFiles( @Nonnull final DocSourceConfig source, @Nonnull final Path target )
    throws SourceIOException
  {
    try
    {
      Files.deleteIfExists( target );
      Files.deleteIfExists( asTmpTarget( target ) );
    }
    catch ( final IOException ioe )
    {
      throw new SourceIOException( source, "Failed to remove existing files for source", ioe );
    }
  }

  private void extractDocs( @Nonnull final DocSourceConfig source,
                            @Nonnull final Path input,
                            @Nonnull final Path output )
    throws SourceIOException
  {
    try
    {
      final JsonObjectBuilder json = Json.createObjectBuilder();
      final Document document = Jsoup.parse( input.toFile(), StandardCharsets.UTF_8.name() );

      for ( final Element anchor : document.select( "a[href^=\"/en-US/docs/Web/API/\"]" ) )
      {
        // TODO: In the future we can try to process href and add local {@link } in.
        //  For now we are just replacing the link with text.
        replaceElementWithChildren( anchor );
      }
      // Remove span element and just nest content.
      for ( final Element span : document.select( "span[class=\"seoSummary\"]" ) )
      {
        replaceElementWithChildren( span );
      }
      // Make all anchors absolute so anything we include will correctly crosslink
      for ( final Element anchor : document.select( "a[href^=\"/\"]" ) )
      {
        anchor.attr( "href", HOST_URL + anchor.attr( "href" ) );
      }

      final Element article = document.selectFirst( "#wikiArticle" );
      final StringBuilder description = new StringBuilder();
      boolean firstNode = true;
      for ( final Node node : article.childNodes() )
      {
        if ( firstNode )
        {
          // Ignore the first div which seems to be notices about state of element
          assert node instanceof Element && "div".equals( ( (Element) node ).tagName() );
          firstNode = false;
        }
        if ( node instanceof Element )
        {
          final Element child = (Element) node;
          if ( "h2".equals( child.tagName() ) )
          {
            break;
          }
          else
          {
            if ( 0 == description.length() )
            {
              description.append( child.html() );
              description.append( "\n" );
            }
            else
            {
              description.append( child.outerHtml() );
              description.append( "\n" );
            }
          }
        }
      }

      json.add( "name", source.getName() );
      json.add( "href", source.getUrl() );
      json.add( "description", cleanDescription( description.toString() ) );

      final List<String> constructors =
        document
          .select( "#Constructors + p + dl > dt > code, #Constructors + dl > dt > code" )
          .stream()
          .map( Element::text )
          // Strip out the type name that sometimes appears in the documentation
          .map( text -> text.replaceAll( "^" + source.getName() + "\\.", "" ) )
          .collect( Collectors.toList() );
      if ( !constructors.isEmpty() )
      {
        json.add( "constructors", Json.createArrayBuilder( constructors ) );
      }
      final List<String> properties =
        document
          .select( "#Properties + p + dl > dt > code, #Properties + dl > dt > code" )
          .stream()
          .map( Element::text )
          // Strip out the type name that sometimes appears in the documentation
          .map( text -> text.replaceAll( "^" + source.getName() + "\\.", "" ) )
          .collect( Collectors.toList() );
      if ( !properties.isEmpty() )
      {
        json.add( "properties", Json.createArrayBuilder( properties ) );
      }
      final List<String> methods =
        document
          .select(
            "#Methods + p + dl > dt > code, #Methods + dl > dt > code, #Static_methods + p + dl > dt > code, #Static_methods + dl > dt > code" )
          .stream()
          .map( Element::text )
          // Strip the brackets at end of methods
          .map( text -> text.replaceAll( "\\(.*", "" ) )
          // Strip out the type name that sometimes appears in the documentation
          .map( text -> text.replaceAll( "^" + source.getName() + "\\.", "" ) )
          .collect( Collectors.toList() );
      if ( !methods.isEmpty() )
      {
        json.add( "methods", Json.createArrayBuilder( methods ) );
      }

      writeJson( output, json.build() );
    }
    catch ( final IOException ioe )
    {
      throw new SourceIOException( source, "Failed to read local file for source", ioe );
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

  private void writeJson( @Nonnull final Path output, @Nonnull final JsonObject jsonObject )
    throws IOException
  {
    try ( final FileOutputStream outputStream = new FileOutputStream( output.toFile() ) )
    {
      final Map<String, Object> config = new HashMap<>();
      config.put( JsonGenerator.PRETTY_PRINTING, true );
      try ( JsonWriter writer = Json.createWriterFactory( config ).createWriter( outputStream ) )
      {
        writer.write( jsonObject );
      }
    }
    // Add newline as json output omits trailing new line
    Files.write( output, new byte[]{ '\n' }, StandardOpenOption.APPEND );
  }

  @Nonnull
  private Path asTmpTarget( @Nonnull final Path target )
  {
    return target.getParent().resolve( target.getName( target.getNameCount() - 1 ) + ".tmp.html" );
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
    DocSourceConfig source = _repository.findSourceByName( name );
    if ( null == source )
    {
      source = new DocSourceConfig();
      source.setName( name );
      source.setLastModifiedAt( 0 );
      source.setUrl( getElementUrl( type, member, kind ) );
      _repository.getSources().add( source );
      saveRepository();
    }
    return source;
  }

  private void saveRepository()
    throws RepositorySaveException
  {
    try
    {
      DocRepositoryConfig.save( _repository );
    }
    catch ( final Exception e )
    {
      throw new RepositorySaveException( _repository, e );
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
