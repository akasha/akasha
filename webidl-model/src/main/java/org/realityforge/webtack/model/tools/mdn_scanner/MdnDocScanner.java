package org.realityforge.webtack.model.tools.mdn_scanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.SourceVersion;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.realityforge.webtack.model.tools.fetch.FetchException;
import org.realityforge.webtack.model.tools.fetch.FetchResult;
import org.realityforge.webtack.model.tools.fetch.FetchUtil;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.DocIndex;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.EntryIndex;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.IndexException;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.IndexIOException;
import org.realityforge.webtack.model.tools.util.StringUtil;

public final class MdnDocScanner
{
  @Nonnull
  public static final String API_DOCS_BASE_URL = "https://developer.mozilla.org/en-US/docs/Web/API/";
  @Nonnull
  public static final String JS_DOCS_BASE_URL =
    "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/";
  @Nonnull
  public static final Set<String> JS_TYPES = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
    "AggregateError",
    "Array",
    "ArrayBuffer",
    "AsyncFunction",
    "Atomics",
    "BigInt",
    "BigInt64Array",
    "BigUint64Array",
    "Boolean",
    "DataView",
    "Date",
    "Error",
    "EvalError",
    "FinalizationRegistry",
    "Float32Array",
    "Float64Array",
    "Function",
    "Generator",
    "GeneratorFunction",
    "Infinity",
    "Int16Array",
    "Int32Array",
    "Int8Array",
    "InternalError",
    "Intl",
    "JSON",
    "Map",
    "Math",
    "NaN",
    "Number",
    "Object",
    "Promise",
    "Proxy",
    "RangeError",
    "ReferenceError",
    "Reflect",
    "RegExp",
    "Set",
    "SharedArrayBuffer",
    "String",
    "Symbol",
    "SyntaxError",
    "TypeError",
    "TypedArray",
    "URIError",
    "Uint16Array",
    "Uint32Array",
    "Uint8Array",
    "Uint8ClampedArray",
    "WeakMap",
    "WeakRef",
    "WeakSet",
    "WebAssembly",
    "WebAssembly.Module",
    "WebAssembly.Global",
    "WebAssembly.Instance",
    "WebAssembly.Memory",
    "WebAssembly.Table",
    "WebAssembly.CompileError",
    "WebAssembly.LinkError",
    "WebAssembly.RuntimeError"
  ) ) );
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
      index.findOrCreateEntry( DocKind.Type == kind ? EntryIndex.TYPE_KEY :
                               DocKind.Event == kind ? member + "_event" :
                               Objects.requireNonNull( member ) );
    removeTempFile( entryIndex );

    final String url = deriveUrl( kind, type, entryIndex );

    final DocEntry entry = _runtime.findDocEntry( entryIndex );
    if ( null != entry && !url.equals( entry.getHref() ) )
    {
      _listener.entrySkipped( entry );
      return;
    }

    _listener.preEntryFetch( entryIndex, url );
    final FetchResult result = fetchEntry( entryIndex, url, force );
    if ( null != result )
    {
      _listener.postEntryFetch( entryIndex, url );
      index.getContent().setLastModifiedAt( System.currentTimeMillis() );
      index.save();
      final Path tmpTarget = getTmpTarget( entryIndex );
      try
      {
        Files.move( result.getPath(), tmpTarget );
      }
      catch ( final IOException ioe )
      {
        throw new IndexIOException( "Failed to copy fetched content to temp file", ioe );
      }

      extractEntry( entryIndex, entry, kind, result.getUrl(), tmpTarget, result.getLastModifiedAt() );

      if ( removeSource )
      {
        removeTempFile( entryIndex );
      }
    }
  }

  @Nonnull
  private String deriveUrl( @Nonnull final DocKind kind,
                            @Nonnull final String type,
                            @Nonnull final EntryIndex entryIndex )
  {
    final String baseUrl = JS_TYPES.contains( type ) ? JS_DOCS_BASE_URL : API_DOCS_BASE_URL;
    return baseUrl + type.replace( '.', '/' ) + ( DocKind.Type == kind ? "" : "/" + entryIndex.getName() );
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
                             @Nullable final DocEntry docEntry,
                             @Nonnull final DocKind kind,
                             @Nonnull final String url,
                             @Nonnull final Path input,
                             final long modifiedAt )
    throws IndexIOException
  {
    DocEntry entry = docEntry;
    if ( null == entry )
    {
      entry = new DocEntry();
      entry.setKind( kind );
      entry.setName( deriveName( kind, entryIndex ) );
      entry.setHref( url );
    }
    else
    {
      assert Objects.equals( entry.getKind(), kind );
      assert Objects.equals( entry.getName(), deriveName( kind, entryIndex ) );
      assert Objects.equals( entry.getHref(), url );
    }
    try
    {
      final Document document = Jsoup.parse( input.toFile(), StandardCharsets.UTF_8.name() );

      final Element element = document.selectFirst( "meta[name=\"description\"]" );
      final String description = null != element ? element.attr( "content" ) : "";

      // Replace any non-breaking-space characters with a space as that is the best way for downstream consumers
      // Then replace any other special characters with their equivalent html entities as the description is
      // expected to be HTML "phrasing content" soo that it can easily be added to javadoc like tools
      entry.setDescription( StringUtil.encodeHtml( description.replace( '\u00A0', ' ' ).replace( ' ', ' ' ) ) );

      entry.setRefs( null );
      final Element standardsElement = document.selectFirst( "#Specifications + table.standard-table" );
      if ( null != standardsElement )
      {
        final List<ExternalRef> refs = new ArrayList<>();
        for ( final Element row : standardsElement.select( "tr" ) )
        {
          final Elements nodes = row.children();
          if ( nodes.size() >= 1 && nodes.get( 0 ).tagName().equals( "td" ) )
          {
            final Element td = nodes.get( 0 );
            final Element a = td.selectFirst( "a" );
            if ( null != a )
            {
              final List<TextNode> textNodes = a.textNodes();
              final String name = textNodes.get( 0 ).text();
              final String href = a.attr( "href" ).trim();
              if ( !href.isEmpty() )
              {
                final String refDescription =
                  a
                    .text()
                    .substring( name.length() )
                    .trim()
                    .replace( "that specification", "the '" + name + "' specification" );
                final ExternalRef ref = new ExternalRef();
                ref.setName( name );
                ref.setHref( href );
                if ( !refDescription.isEmpty() )
                {
                  ref.setDescription( StringUtil.encodeHtml( refDescription ) );
                }
                refs.add( ref );
              }
            }
          }
        }
        if ( !refs.isEmpty() )
        {
          entry.setRefs( refs.toArray( new ExternalRef[ 0 ] ) );
        }
      }

      if ( DocKind.Type == kind )
      {
        scanTypePage( document, entryIndex );
      }
      else if ( DocKind.Event == kind )
      {
        scanEventPage( document, entryIndex, entry );
      }
      if ( !entry.valid() )
      {
        entryIndex.remove();
        if ( 0 != entryIndex.getLastModifiedAt() )
        {
          _listener.entryInvalid( entryIndex, entry );
        }
      }
      else if ( _runtime.save( entryIndex, entry, modifiedAt ) )
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

  private void scanEventPage( @Nonnull final Document document,
                              @Nonnull final EntryIndex entryIndex,
                              @Nonnull final DocEntry entry )
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
      else if ( "Bubbles".equals( text ) )
      {
        entry.setEventBubbles( td.text().equalsIgnoreCase( "no" ) );
      }
      else if ( "Cancelable".equals( text ) )
      {
        entry.setEventCancelable( td.text().equalsIgnoreCase( "no" ) );
      }
      else if ( "Event handler".equals( text ) || "Event handler property".equals( text ) )
      {
        entry.setEventHandlerProperty( td.text().replaceAll( "^.*\\.", "" ) );
      }
    }
  }

  private void scanTypePage( @Nonnull final Document document, @Nonnull final EntryIndex entryIndex )
  {
    final String typeName = entryIndex.getDocIndex().getName();

    // We use the localName as some APIs have been updated in spec but MDN still uses "old"
    // name and redirects at http level when you request the new name. i.e. XR type was called XRSystem
    final Element localNameElement = document.selectFirst( "meta[property=\"og:title\"]" );
    final String localName = null != localNameElement ? localNameElement.attr( "content" ) : "";

    final List<String> constructorNames = new ArrayList<>();
    final List<String> propertyNames = new ArrayList<>();
    final List<String> methodsNames = new ArrayList<>();
    for ( final Element element : document.select( ".quick-links > div > ol > li > details > summary" ) )
    {
      final String sectionType = element.text();
      if ( sectionType.equalsIgnoreCase( "Methods" ) )
      {
        element.parent().select( "ol > li > a > code" ).stream().map( Element::text ).forEach( methodsNames::add );
      }
      else if ( sectionType.equalsIgnoreCase( "Properties" ) )
      {
        element.parent().select( "ol > li > a > code" ).stream().map( Element::text ).forEach( propertyNames::add );
      }
      else if ( sectionType.equalsIgnoreCase( "Constructor" ) || sectionType.equalsIgnoreCase( "Constructors" ) )
      {
        element.parent().select( "ol > li > a > code" ).stream().map( Element::text ).forEach( constructorNames::add );
      }
    }
    for ( final Element element : document.select( ".quick-links > div > ol > li > a > strong" ) )
    {
      final String sectionType = element.text();
      if ( sectionType.equalsIgnoreCase( "Methods" ) )
      {
        element.parent()
          .parent()
          .select( "ol > li > a > code" )
          .stream()
          .map( Element::text )
          .filter( v -> !v.contains( "." ) || v.startsWith( localName + "." ) )
          .forEach( methodsNames::add );
      }
      else if ( sectionType.equalsIgnoreCase( "Properties" ) )
      {
        element.parent()
          .parent()
          .select( "ol > li > a > code" )
          .stream()
          .map( Element::text )
          .filter( v -> !v.contains( "." ) || v.startsWith( localName + "." ) )
          .forEach( propertyNames::add );
      }
      else if ( sectionType.equalsIgnoreCase( "Constructor" ) || sectionType.equalsIgnoreCase( "Constructors" ) )
      {
        element.parent()
          .parent()
          .select( "ol > li > a > code" )
          .stream()
          .map( Element::text )
          .filter( v -> !v.contains( "." ) || v.startsWith( localName + "." ) )
          .forEach( constructorNames::add );
      }
    }

    document
      .select( "#Constructors + p + dl > dt > a > code, " +
               "#Constructors + dl > dt > a > code" +
               "#Constructor + p + dl > dt > a > code, " +
               "#Constructor + dl > dt > a > code" )
      .stream()
      .map( Element::text )
      .forEach( constructorNames::add );

    constructorNames
      .stream()
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
               "#Events + dl > dt > a:not([href$=\"_event\"]) > code, " +

               // Some regular js methods such as those for WebAssembly
               "#Instance_properties + dl > dt > a > code" )
      .stream()
      .map( Element::text )
      .forEach( propertyNames::add );

    propertyNames
      .stream()
      // Strip out the type name that sometimes appears in the documentation
      .map( text -> text.replaceAll( "^" + localName + "\\.prototype\\.", "" ) )
      .map( text -> text.replaceAll( "^" + typeName + "\\.prototype\\.", "" ) )
      .map( text -> text.replaceAll( "^" + localName + "\\.", "" ) )
      .map( text -> text.replaceAll( "^" + typeName + "\\.", "" ) )
      .map( text -> text.replaceAll( "^" + typeName.replaceAll( "^.+\\.", "" ) + "\\.prototype\\.", "" ) )
      .filter( SourceVersion::isName )
      .sorted()
      .distinct()
      .forEach( property -> queueRequest( DocKind.Property, typeName, property ) );

    methodsNames.addAll( document
                           .select( "#Methods + p + dl > dt > a > code, " +
                                    "#Methods + dl > dt > a code, " +
                                    "#Static_methods + p + dl > dt > a > code, " +
                                    "#Static_methods + dl > dt > a > code, " +

                                    // Some regular js methods such as those for WebAssembly
                                    "#Instance_methods + dl > dt > a > code" )
                           .stream()
                           .map( Element::text )
                           .collect( Collectors.toList() ) );

    final List<String> methods =
      methodsNames
        .stream()
        // Strip the brackets at end of methods
        .map( text -> text.replaceAll( "\\(.*", "" ) )
        // Strip out the type name that sometimes appears in the documentation
        .map( text -> text.replaceAll( "^" + localName + "\\.", "" ) )
        .map( text -> text.replaceAll( "^" + typeName + "\\.", "" ) )
        .map( text -> text.replaceAll( "^" + typeName + "\\.prototype\\.", "" ) )
        .map( text -> text.replaceAll( "^" + typeName.replaceAll( "^.+\\.", "" ) + "\\.prototype\\.", "" ) )

        // Many of the WebGL elements have one page to describe multiple methods with different type
        // decorations ala "uniform[1234][fi][v]()" which this tries to address
        .map( text -> text.replaceAll( "\\[.*", "" ) )
        .filter( SourceVersion::isName )
        .sorted()
        .distinct()
        .collect( Collectors.toList() );
    if ( !methods.isEmpty() )
    {
      // Sometimes constructors are documented as methods so instead register them as constructors
      methods
        .stream()
        .filter( m -> m.equals( localName ) || m.equals( typeName ) )
        .forEach( property -> queueRequest( DocKind.Constructor, typeName, typeName ) );

      methods
        .stream()
        .filter( m -> !m.equals( localName ) && !m.equals( typeName ) )
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
        .map( text -> text.replaceAll( "^" + typeName + "\\.", "" ) )
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
        .filter( e -> !document.select( "a[href$=\"/" + typeName + "/" + e + "\"]" ).isEmpty() )
        .forEach( property -> queueRequest( DocKind.Property, typeName, property ) );
    }
  }

  private String deriveName( @Nonnull final DocKind kind, @Nonnull final EntryIndex entryIndex )
  {
    return DocKind.Type == kind ? entryIndex.getDocIndex().getName() : entryIndex.getQualifiedName();
  }

  private void queueRequest( @Nonnull final DocKind kind, @Nonnull final String typeName, @Nullable final String name )
  {
    _listener.queueScan( kind, typeName, name );
    _requestQueue.add( new ScanRequest( kind, typeName, name ) );
  }
}
