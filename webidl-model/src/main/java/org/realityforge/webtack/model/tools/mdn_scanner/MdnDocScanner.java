package org.realityforge.webtack.model.tools.mdn_scanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.SourceVersion;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.realityforge.webtack.model.tools.fetch.FetchException;
import org.realityforge.webtack.model.tools.fetch.FetchResult;
import org.realityforge.webtack.model.tools.fetch.FetchUtil;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.DocIndex;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.EntryIndex;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.IndexException;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.IndexIOException;

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
  @Nonnull
  private final MdnScannerListener _listener;
  @Nonnull
  private final Deque<ScanRequest> _requestQueue = new LinkedList<>();

  public MdnDocScanner( @Nonnull final DocRepositoryRuntime runtime,
                        @Nonnull final MdnScannerListener listener )
  {
    _runtime = Objects.requireNonNull( runtime );
    _listener = Objects.requireNonNull( listener );
  }

  public void fetchDocumentation( @Nonnull final String type,
                                  @Nullable final String member,
                                  final boolean force,
                                  final boolean removeSource )
    throws DocException
  {
    queueRequest( DocKind.Type, type, member );
    processRequests( force, removeSource );
  }

  private void processRequests( final boolean force, final boolean removeSource )
  {
    while ( !_requestQueue.isEmpty() )
    {
      final ScanRequest request = _requestQueue.removeFirst();
      doFetchDocumentation( request.getKind(), request.getType(), request.getMember(), force, removeSource );
    }
  }

  private void doFetchDocumentation( @Nonnull final DocKind kind,
                                     @Nonnull final String type,
                                     @Nullable final String member,
                                     final boolean force,
                                     final boolean removeSource )
    throws DocException
  {
    final DocIndex index = _runtime.findOrCreateIndexForType( type );
    final EntryIndex entryIndex =
      index.findOrCreateEntry( DocKind.Type == kind ? "__type__" :
                               DocKind.Event == kind ? member + "_event" :
                               Objects.requireNonNull( member ) );
    removeTempFile( entryIndex );

    final String url = BASE_URL + type + ( DocKind.Type == kind ? "" : "/" + entryIndex.getName() );

    final DocEntry entry = _runtime.findDocEntry( entryIndex );
    if ( null != entry && null != entry.getHref() && !entry.getHref().equals( url ) )
    {
      _listener.entrySkipped( entry );
      return;
    }

    _listener.preEntryFetch( entryIndex, url );
    final FetchResult result = fetchEntry( entryIndex, url, force );
    if ( null != result )
    {
      _listener.postEntryFetch( entryIndex, url );
      final Path tmpTarget = getTmpTarget( entryIndex );
      try
      {
        Files.move( result.getPath(), tmpTarget );
      }
      catch ( final IOException ioe )
      {
        throw new IndexIOException( "Failed to copy fetched content to temp file", ioe );
      }

      extractEntry( entryIndex, kind, result.getUrl(), tmpTarget, result.getLastModifiedAt() );

      if ( removeSource )
      {
        removeTempFile( entryIndex );
      }
    }
  }

  @Nonnull
  private Path getTmpTarget( @Nonnull final EntryIndex entryIndex )
  {
    final Path target = _runtime.getDocEntryPath( entryIndex );
    return target.getParent().resolve( target.getName( target.getNameCount() - 1 ) + ".tmp.html" );
  }

  @Nullable
  private FetchResult fetchEntry( @Nonnull final EntryIndex entryIndex, @Nonnull final String url, final boolean force )
    throws IndexException, SourceFetchException
  {
    try
    {
      return FetchUtil.downloadURL( url, force ? 0 : entryIndex.getLastModifiedAt() );
    }
    catch ( final FetchException fe )
    {
      if ( fe.getCause() instanceof FileNotFoundException )
      {
        if ( 0 != entryIndex.getLastModifiedAt() )
        {
          _listener.entryDeleted( entryIndex );
        }
        _runtime.removeEntry( entryIndex );
        return null;
      }
      else
      {
        throw new SourceFetchException( entryIndex.getQualifiedName(), fe.getCause() );
      }
    }
  }

  private void removeTempFile( @Nonnull final EntryIndex entryIndex )
    throws IndexIOException
  {
    try
    {
      Files.deleteIfExists( getTmpTarget( entryIndex ) );
    }
    catch ( final IOException ioe )
    {
      throw new IndexIOException( "Failed to remove temp file", ioe );
    }
  }

  private void extractEntry( @Nonnull final EntryIndex entryIndex,
                             @Nonnull final DocKind kind,
                             @Nonnull final String url,
                             @Nonnull final Path input,
                             final long modifiedAt )
    throws IndexIOException
  {
    DocEntry entry = _runtime.findDocEntry( entryIndex );
    if ( null == entry )
    {
      entry = new DocEntry();
      entry.setKind( kind );
      entry.setName( DocKind.Type == kind ? entryIndex.getDocIndex().getName() : entryIndex.getQualifiedName() );
      entry.setHref( url );
    }
    try
    {
      final Document document = Jsoup.parse( input.toFile(), StandardCharsets.UTF_8.name() );

      final Element element = document.selectFirst( "meta[name=\"description\"]" );
      final String description = null != element ? element.attr( "content" ) : "";

      // We use the localName as some APIs have been updated in spec but MDN still uses "old"
      // name and redirects at http level when you request the new name. i.e. XR type was called XRSystem
      final Element localNameElement = document.selectFirst( "meta[property=\"og:title\"]" );
      final String localName = null != localNameElement ? localNameElement.attr( "content" ) : "";

      final String typeName = entryIndex.getDocIndex().getName();
      entry.setDescription( description );
      if ( DocKind.Type == kind )
      {
        document
          .select( "#Constructors + p + dl > dt > a > code, " +
                   "#Constructors + dl > dt > a > code" +
                   "#Constructor + p + dl > dt > a > code, " +
                   "#Constructor + dl > dt > a > code" )
          .stream()
          .map( Element::text )
          // Strip the brackets at end of constructors
          .map( text -> text.replaceAll( "\\(.*", "" ) )
          .filter( SourceVersion::isName )
          .forEach( constructor -> queueRequest( DocKind.Constructor, typeName, constructor ) );
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
          .filter( SourceVersion::isName )
          .forEach( property -> queueRequest( DocKind.Property, typeName, property ) );

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
            .filter( SourceVersion::isName )
            .collect( Collectors.toList() );
        if ( !methods.isEmpty() )
        {
          // Sometimes constructors are documented as methods so instead register them as constructors
          methods
            .stream()
            .filter( m -> m.equals( localName ) )
            .forEach( property -> queueRequest( DocKind.Constructor, typeName, typeName ) );

          methods
            .stream()
            .filter( m -> !m.equals( localName ) )
            .forEach( method -> queueRequest( DocKind.Method, typeName, method ) );
        }
        final List<String> events =
          document
            .select( "#Events + p + dl > dt > a[href$=\"_event\"] > code, " +
                     "#Events + dl > dt > a[href$=\"_event\"] > code, " +

                     // SpeechSynthesisUtterance among others nests <a/> in code
                     "#Events + p + dl > dt > code > a[href$=\"_event\"], " +
                     "#Events + dl > dt > code > a[href$=\"_event\"], " +

                     "[id*='_events'] + p + dl > dt > a[href$=\"_event\"] > code, " +
                     // This pattern added for Window docs
                     "[id*='_events'] + dl > dt > a[href$=\"_event\"] > code" )
            .stream()
            .map( Element::text )
            // Strip out the type name that sometimes appears in the documentation
            .map( text -> text.replaceAll( "^" + localName + "\\.", "" ) )
            .filter( SourceVersion::isName )
            .collect( Collectors.toList() );
        if ( !events.isEmpty() )
        {
          events.forEach( event -> queueRequest( DocKind.Event, typeName, event ) );

          // Not all doc pages explicitly list onx event handlers as properties so we try and scrape the page
          // to try and find them
          events
            .stream()
            .map( e -> "on" + e )
            .filter( e -> !document.select( "a[href$=\"/" + localName + "/" + e + "\"]" ).isEmpty() )
            .forEach( property -> queueRequest( DocKind.Property, typeName, property ) );
        }
      }
      else if ( DocKind.Event == kind )
      {
        entry.setEventName( entryIndex.getName().replaceAll( "_event$", "" ) );
        final Elements headers = document.select( "#wikiArticle > table.properties > tbody > tr > th" );
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
      if ( _runtime.save( entry, modifiedAt ) )
      {
        _listener.entryUpdated( entryIndex, entry );
      }
      else
      {
        _listener.entryUnmodified( entryIndex, entry );
      }

    }
    catch ( final Exception e )
    {
      throw new IndexIOException( "Failed to read local file for " + entryIndex.getQualifiedName(), e );
    }
  }

  private void queueRequest( @Nonnull final DocKind kind, @Nonnull final String typeName, @Nullable final String name )
  {
    _listener.queueScan( kind, typeName, name );
    _requestQueue.add( new ScanRequest( kind, typeName, name ) );
  }
}
