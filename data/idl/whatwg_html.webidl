enum BinaryType {
  "arraybuffer",
  "blob"
};

enum CanPlayTypeResult {
  "",
  "maybe",
  "probably"
};

enum CanvasDirection {
  "inherit",
  "ltr",
  "rtl"
};

enum CanvasFillRule {
  "evenodd",
  "nonzero"
};

enum CanvasLineCap {
  "butt",
  "round",
  "square"
};

enum CanvasLineJoin {
  "bevel",
  "miter",
  "round"
};

enum CanvasTextAlign {
  "center",
  "end",
  "left",
  "right",
  "start"
};

enum CanvasTextBaseline {
  "alphabetic",
  "bottom",
  "hanging",
  "ideographic",
  "middle",
  "top"
};

enum ColorSpaceConversion {
  "default",
  "none"
};

enum DOMParserSupportedType {
  "application/xhtml+xml",
  "application/xml",
  "image/svg+xml",
  "text/html",
  "text/xml"
};

enum DocumentReadyState {
  "complete",
  "interactive",
  "loading"
};

enum ImageOrientation {
  "flipY",
  "none"
};

enum ImageSmoothingQuality {
  "high",
  "low",
  "medium"
};

enum OffscreenRenderingContextId {
  "2d",
  "bitmaprenderer",
  "webgl",
  "webgl2"
};

enum PremultiplyAlpha {
  "default",
  "none",
  "premultiply"
};

enum ResizeQuality {
  "high",
  "low",
  "medium",
  "pixelated"
};

enum ScrollRestoration {
  "auto",
  "manual"
};

enum SelectionMode {
  "end",
  "preserve",
  "select",
  "start"
};

enum TextTrackKind {
  "captions",
  "chapters",
  "descriptions",
  "metadata",
  "subtitles"
};

enum TextTrackMode {
  "disabled",
  "hidden",
  "showing"
};

enum WorkerType {
  "classic",
  "module"
};

typedef ( HTMLOrSVGImageElement or HTMLVideoElement or HTMLCanvasElement or ImageBitmap or OffscreenCanvas ) CanvasImageSource;

typedef EventHandlerNonNull? EventHandler;

typedef ( HTMLImageElement or SVGImageElement ) HTMLOrSVGImageElement;

typedef ( HTMLScriptElement or SVGScriptElement ) HTMLOrSVGScriptElement;

typedef ( CanvasImageSource or Blob or ImageData ) ImageBitmapSource;

typedef ( MediaStream or MediaSource or Blob ) MediaProvider;

typedef ( WindowProxy or MessagePort or ServiceWorker ) MessageEventSource;

typedef ( OffscreenCanvasRenderingContext2D or ImageBitmapRenderingContext or WebGLRenderingContext or WebGL2RenderingContext ) OffscreenRenderingContext;

typedef OnBeforeUnloadEventHandlerNonNull? OnBeforeUnloadEventHandler;

typedef OnErrorEventHandlerNonNull? OnErrorEventHandler;

typedef ( CanvasRenderingContext2D or ImageBitmapRenderingContext or WebGLRenderingContext or WebGL2RenderingContext ) RenderingContext;

typedef ( DOMString or Function ) TimerHandler;

callback BlobCallback = void ( Blob? blob );

callback CustomElementConstructor = HTMLElement ();

[LegacyTreatNonObjectAsNull]
callback EventHandlerNonNull = any ( Event event );

callback FrameRequestCallback = void ( DOMHighResTimeStamp time );

callback FunctionStringCallback = void ( DOMString data );

[LegacyTreatNonObjectAsNull]
callback OnBeforeUnloadEventHandlerNonNull = DOMString? ( Event event );

[LegacyTreatNonObjectAsNull]
callback OnErrorEventHandlerNonNull = any ( ( Event or DOMString ) event, optional DOMString source, optional unsigned long lineno, optional unsigned long colno, optional any error );

dictionary AssignedNodesOptions {
  boolean flatten = false;
};

dictionary CanvasRenderingContext2DSettings {
  boolean alpha = true;
  boolean desynchronized = false;
};

dictionary CloseEventInit : EventInit {
  unsigned short code = 0;
  USVString reason = "";
  boolean wasClean = false;
};

dictionary DragEventInit : MouseEventInit {
  DataTransfer? dataTransfer = null;
};

dictionary ElementDefinitionOptions {
  DOMString extends;
};

dictionary ErrorEventInit : EventInit {
  unsigned long colno = 0;
  any error = null;
  USVString filename = "";
  unsigned long lineno = 0;
  DOMString message = "";
};

dictionary EventSourceInit {
  boolean withCredentials = false;
};

dictionary FocusOptions {
  boolean preventScroll = false;
};

dictionary FormDataEventInit : EventInit {
  required FormData formData;
};

dictionary HashChangeEventInit : EventInit {
  USVString newURL = "";
  USVString oldURL = "";
};

dictionary ImageBitmapOptions {
  ColorSpaceConversion colorSpaceConversion = "default";
  ImageOrientation imageOrientation = "none";
  PremultiplyAlpha premultiplyAlpha = "default";
  [EnforceRange]
  unsigned long resizeHeight;
  ResizeQuality resizeQuality = "low";
  [EnforceRange]
  unsigned long resizeWidth;
};

dictionary ImageBitmapRenderingContextSettings {
  boolean alpha = true;
};

dictionary ImageEncodeOptions {
  unrestricted double quality;
  DOMString type = "image/png";
};

dictionary MessageEventInit : EventInit {
  any data = null;
  DOMString lastEventId = "";
  USVString origin = "";
  sequence<MessagePort> ports = [];
  MessageEventSource? source = null;
};

dictionary PageTransitionEventInit : EventInit {
  boolean persisted = false;
};

dictionary PopStateEventInit : EventInit {
  any state = null;
};

dictionary PostMessageOptions {
  sequence<object> transfer = [];
};

dictionary PromiseRejectionEventInit : EventInit {
  required Promise<any> promise;
  any reason;
};

dictionary StorageEventInit : EventInit {
  DOMString? key = null;
  DOMString? newValue = null;
  DOMString? oldValue = null;
  Storage? storageArea = null;
  USVString url = "";
};

dictionary SubmitEventInit : EventInit {
  HTMLElement? submitter = null;
};

dictionary TrackEventInit : EventInit {
  ( VideoTrack or AudioTrack or TextTrack )? track = null;
};

dictionary ValidityStateFlags {
  boolean badInput = false;
  boolean customError = false;
  boolean patternMismatch = false;
  boolean rangeOverflow = false;
  boolean rangeUnderflow = false;
  boolean stepMismatch = false;
  boolean tooLong = false;
  boolean tooShort = false;
  boolean typeMismatch = false;
  boolean valueMissing = false;
};

dictionary WindowPostMessageOptions : PostMessageOptions {
  USVString targetOrigin = "/";
};

dictionary WorkerOptions {
  RequestCredentials credentials = "same-origin";
  DOMString name = "";
  WorkerType type = "classic";
};

interface mixin AbstractWorker {
  attribute EventHandler onerror;
};

interface mixin AnimationFrameProvider {
  void cancelAnimationFrame( unsigned long handle );
  unsigned long requestAnimationFrame( FrameRequestCallback callback );
};

interface mixin CanvasCompositing {
  attribute unrestricted double globalAlpha;
  attribute DOMString globalCompositeOperation;
};

interface mixin CanvasDrawImage {
  void drawImage( CanvasImageSource image, unrestricted double dx, unrestricted double dy );
  void drawImage( CanvasImageSource image, unrestricted double dx, unrestricted double dy, unrestricted double dw, unrestricted double dh );
  void drawImage( CanvasImageSource image, unrestricted double sx, unrestricted double sy, unrestricted double sw, unrestricted double sh, unrestricted double dx, unrestricted double dy, unrestricted double dw, unrestricted double dh );
};

interface mixin CanvasDrawPath {
  void beginPath();
  void clip( optional CanvasFillRule fillRule = "nonzero" );
  void clip( Path2D path, optional CanvasFillRule fillRule = "nonzero" );
  void fill( optional CanvasFillRule fillRule = "nonzero" );
  void fill( Path2D path, optional CanvasFillRule fillRule = "nonzero" );
  boolean isPointInPath( unrestricted double x, unrestricted double y, optional CanvasFillRule fillRule = "nonzero" );
  boolean isPointInPath( Path2D path, unrestricted double x, unrestricted double y, optional CanvasFillRule fillRule = "nonzero" );
  boolean isPointInStroke( unrestricted double x, unrestricted double y );
  boolean isPointInStroke( Path2D path, unrestricted double x, unrestricted double y );
  void stroke();
  void stroke( Path2D path );
};

interface mixin CanvasFillStrokeStyles {
  attribute ( DOMString or CanvasGradient or CanvasPattern ) fillStyle;
  attribute ( DOMString or CanvasGradient or CanvasPattern ) strokeStyle;
  CanvasGradient createLinearGradient( double x0, double y0, double x1, double y1 );
  CanvasPattern? createPattern( CanvasImageSource image, [LegacyNullToEmptyString] DOMString repetition );
  CanvasGradient createRadialGradient( double x0, double y0, double r0, double x1, double y1, double r1 );
};

interface mixin CanvasFilters {
  attribute DOMString filter;
};

interface mixin CanvasImageData {
  ImageData createImageData( long sw, long sh );
  ImageData createImageData( ImageData imagedata );
  ImageData getImageData( long sx, long sy, long sw, long sh );
  void putImageData( ImageData imagedata, long dx, long dy );
  void putImageData( ImageData imagedata, long dx, long dy, long dirtyX, long dirtyY, long dirtyWidth, long dirtyHeight );
};

interface mixin CanvasImageSmoothing {
  attribute boolean imageSmoothingEnabled;
  attribute ImageSmoothingQuality imageSmoothingQuality;
};

interface mixin CanvasPath {
  void arc( unrestricted double x, unrestricted double y, unrestricted double radius, unrestricted double startAngle, unrestricted double endAngle, optional boolean anticlockwise = false );
  void arcTo( unrestricted double x1, unrestricted double y1, unrestricted double x2, unrestricted double y2, unrestricted double radius );
  void bezierCurveTo( unrestricted double cp1x, unrestricted double cp1y, unrestricted double cp2x, unrestricted double cp2y, unrestricted double x, unrestricted double y );
  void closePath();
  void ellipse( unrestricted double x, unrestricted double y, unrestricted double radiusX, unrestricted double radiusY, unrestricted double rotation, unrestricted double startAngle, unrestricted double endAngle, optional boolean anticlockwise = false );
  void lineTo( unrestricted double x, unrestricted double y );
  void moveTo( unrestricted double x, unrestricted double y );
  void quadraticCurveTo( unrestricted double cpx, unrestricted double cpy, unrestricted double x, unrestricted double y );
  void rect( unrestricted double x, unrestricted double y, unrestricted double w, unrestricted double h );
};

interface mixin CanvasPathDrawingStyles {
  attribute CanvasLineCap lineCap;
  attribute unrestricted double lineDashOffset;
  attribute CanvasLineJoin lineJoin;
  attribute unrestricted double lineWidth;
  attribute unrestricted double miterLimit;
  sequence<unrestricted double> getLineDash();
  void setLineDash( sequence<unrestricted double> segments );
};

interface mixin CanvasRect {
  void clearRect( unrestricted double x, unrestricted double y, unrestricted double w, unrestricted double h );
  void fillRect( unrestricted double x, unrestricted double y, unrestricted double w, unrestricted double h );
  void strokeRect( unrestricted double x, unrestricted double y, unrestricted double w, unrestricted double h );
};

interface mixin CanvasShadowStyles {
  attribute unrestricted double shadowBlur;
  attribute DOMString shadowColor;
  attribute unrestricted double shadowOffsetX;
  attribute unrestricted double shadowOffsetY;
};

interface mixin CanvasState {
  void restore();
  void save();
};

interface mixin CanvasText {
  void fillText( DOMString text, unrestricted double x, unrestricted double y, optional unrestricted double maxWidth );
  TextMetrics measureText( DOMString text );
  void strokeText( DOMString text, unrestricted double x, unrestricted double y, optional unrestricted double maxWidth );
};

interface mixin CanvasTextDrawingStyles {
  attribute CanvasDirection direction;
  attribute DOMString font;
  attribute CanvasTextAlign textAlign;
  attribute CanvasTextBaseline textBaseline;
};

interface mixin CanvasTransform {
  [NewObject]
  DOMMatrix getTransform();
  void resetTransform();
  void rotate( unrestricted double angle );
  void scale( unrestricted double x, unrestricted double y );
  void setTransform( unrestricted double a, unrestricted double b, unrestricted double c, unrestricted double d, unrestricted double e, unrestricted double f );
  void setTransform( optional DOMMatrix2DInit transform = {} );
  void transform( unrestricted double a, unrestricted double b, unrestricted double c, unrestricted double d, unrestricted double e, unrestricted double f );
  void translate( unrestricted double x, unrestricted double y );
};

interface mixin CanvasUserInterface {
  void drawFocusIfNeeded( Element element );
  void drawFocusIfNeeded( Path2D path, Element element );
  void scrollPathIntoView();
  void scrollPathIntoView( Path2D path );
};

interface mixin DocumentAndElementEventHandlers {
  attribute EventHandler oncopy;
  attribute EventHandler oncut;
  attribute EventHandler onpaste;
};

interface mixin ElementContentEditable {
  readonly attribute boolean isContentEditable;
  [CEReactions]
  attribute DOMString contentEditable;
  [CEReactions]
  attribute DOMString enterKeyHint;
  [CEReactions]
  attribute DOMString inputMode;
};

interface mixin GlobalEventHandlers {
  attribute EventHandler onabort;
  attribute EventHandler onauxclick;
  attribute EventHandler onblur;
  attribute EventHandler oncancel;
  attribute EventHandler oncanplay;
  attribute EventHandler oncanplaythrough;
  attribute EventHandler onchange;
  attribute EventHandler onclick;
  attribute EventHandler onclose;
  attribute EventHandler oncontextmenu;
  attribute EventHandler oncuechange;
  attribute EventHandler ondblclick;
  attribute EventHandler ondrag;
  attribute EventHandler ondragend;
  attribute EventHandler ondragenter;
  attribute EventHandler ondragexit;
  attribute EventHandler ondragleave;
  attribute EventHandler ondragover;
  attribute EventHandler ondragstart;
  attribute EventHandler ondrop;
  attribute EventHandler ondurationchange;
  attribute EventHandler onemptied;
  attribute EventHandler onended;
  attribute OnErrorEventHandler onerror;
  attribute EventHandler onfocus;
  attribute EventHandler onformdata;
  attribute EventHandler oninput;
  attribute EventHandler oninvalid;
  attribute EventHandler onkeydown;
  attribute EventHandler onkeypress;
  attribute EventHandler onkeyup;
  attribute EventHandler onload;
  attribute EventHandler onloadeddata;
  attribute EventHandler onloadedmetadata;
  attribute EventHandler onloadstart;
  attribute EventHandler onmousedown;
  [LegacyLenientThis]
  attribute EventHandler onmouseenter;
  [LegacyLenientThis]
  attribute EventHandler onmouseleave;
  attribute EventHandler onmousemove;
  attribute EventHandler onmouseout;
  attribute EventHandler onmouseover;
  attribute EventHandler onmouseup;
  attribute EventHandler onpause;
  attribute EventHandler onplay;
  attribute EventHandler onplaying;
  attribute EventHandler onprogress;
  attribute EventHandler onratechange;
  attribute EventHandler onreset;
  attribute EventHandler onresize;
  attribute EventHandler onscroll;
  attribute EventHandler onsecuritypolicyviolation;
  attribute EventHandler onseeked;
  attribute EventHandler onseeking;
  attribute EventHandler onselect;
  attribute EventHandler onslotchange;
  attribute EventHandler onstalled;
  attribute EventHandler onsubmit;
  attribute EventHandler onsuspend;
  attribute EventHandler ontimeupdate;
  attribute EventHandler ontoggle;
  attribute EventHandler onvolumechange;
  attribute EventHandler onwaiting;
  attribute EventHandler onwebkitanimationend;
  attribute EventHandler onwebkitanimationiteration;
  attribute EventHandler onwebkitanimationstart;
  attribute EventHandler onwebkittransitionend;
  attribute EventHandler onwheel;
};

interface mixin HTMLHyperlinkElementUtils {
  readonly attribute USVString origin;
  [CEReactions]
  attribute USVString hash;
  [CEReactions]
  attribute USVString host;
  [CEReactions]
  attribute USVString hostname;
  [CEReactions]
  attribute USVString password;
  [CEReactions]
  attribute USVString pathname;
  [CEReactions]
  attribute USVString port;
  [CEReactions]
  attribute USVString protocol;
  [CEReactions]
  attribute USVString search;
  [CEReactions]
  attribute USVString username;
  [CEReactions]
  stringifier attribute USVString href;
};

interface mixin HTMLOrSVGElement {
  [SameObject]
  readonly attribute DOMStringMap dataset;
  [CEReactions]
  attribute boolean autofocus;
  attribute DOMString nonce;
  [CEReactions]
  attribute long tabIndex;
  void blur();
  void focus( optional FocusOptions options = {} );
};

interface mixin NavigatorConcurrentHardware {
  readonly attribute unsigned long long hardwareConcurrency;
};

interface mixin NavigatorContentUtils {
  [SecureContext]
  void registerProtocolHandler( DOMString scheme, USVString url );
  [SecureContext]
  void unregisterProtocolHandler( DOMString scheme, USVString url );
};

interface mixin NavigatorCookies {
  readonly attribute boolean cookieEnabled;
};

interface mixin NavigatorID {
  readonly attribute DOMString appCodeName;
  readonly attribute DOMString appName;
  readonly attribute DOMString appVersion;
  readonly attribute DOMString platform;
  readonly attribute DOMString product;
  [Exposed=Window]
  readonly attribute DOMString productSub;
  readonly attribute DOMString userAgent;
  [Exposed=Window]
  readonly attribute DOMString vendor;
  [Exposed=Window]
  readonly attribute DOMString vendorSub;
};

interface mixin NavigatorLanguage {
  readonly attribute DOMString language;
  readonly attribute FrozenArray<DOMString> languages;
};

interface mixin NavigatorOnLine {
  readonly attribute boolean onLine;
};

interface mixin NavigatorPlugins {
  [SameObject]
  readonly attribute MimeTypeArray mimeTypes;
  [SameObject]
  readonly attribute PluginArray plugins;
  boolean javaEnabled();
};

interface mixin WindowEventHandlers {
  attribute EventHandler onafterprint;
  attribute EventHandler onbeforeprint;
  attribute OnBeforeUnloadEventHandler onbeforeunload;
  attribute EventHandler onhashchange;
  attribute EventHandler onlanguagechange;
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  attribute EventHandler onoffline;
  attribute EventHandler ononline;
  attribute EventHandler onpagehide;
  attribute EventHandler onpageshow;
  attribute EventHandler onpopstate;
  attribute EventHandler onrejectionhandled;
  attribute EventHandler onstorage;
  attribute EventHandler onunhandledrejection;
  attribute EventHandler onunload;
};

interface mixin WindowLocalStorage {
  readonly attribute Storage localStorage;
};

interface mixin WindowOrWorkerGlobalScope {
  readonly attribute boolean crossOriginIsolated;
  readonly attribute boolean isSecureContext;
  [Replaceable]
  readonly attribute USVString origin;
  ByteString atob( DOMString data );
  DOMString btoa( DOMString data );
  void clearInterval( optional long handle = 0 );
  void clearTimeout( optional long handle = 0 );
  Promise<ImageBitmap> createImageBitmap( ImageBitmapSource image, optional ImageBitmapOptions options = {} );
  Promise<ImageBitmap> createImageBitmap( ImageBitmapSource image, long sx, long sy, long sw, long sh, optional ImageBitmapOptions options = {} );
  void queueMicrotask( VoidFunction callback );
  long setInterval( TimerHandler handler, optional long timeout = 0, any... arguments );
  long setTimeout( TimerHandler handler, optional long timeout = 0, any... arguments );
};

interface mixin WindowSessionStorage {
  readonly attribute Storage sessionStorage;
};

partial interface mixin DocumentOrShadowRoot {
  readonly attribute Element? activeElement;
};

partial interface mixin NavigatorID {
  [Exposed=Window]
  readonly attribute DOMString oscpu;
  [Exposed=Window]
  boolean taintEnabled();
};

[SecureContext, Exposed=Window]
interface ApplicationCache : EventTarget {
  const unsigned short CHECKING = 2;
  const unsigned short DOWNLOADING = 3;
  const unsigned short IDLE = 1;
  const unsigned short OBSOLETE = 5;
  const unsigned short UNCACHED = 0;
  const unsigned short UPDATEREADY = 4;
  readonly attribute unsigned short status;
  attribute EventHandler oncached;
  attribute EventHandler onchecking;
  attribute EventHandler ondownloading;
  attribute EventHandler onerror;
  attribute EventHandler onnoupdate;
  attribute EventHandler onobsolete;
  attribute EventHandler onprogress;
  attribute EventHandler onupdateready;
  void abort();
  void swapCache();
  void update();
};

[Exposed=Window]
interface AudioTrack {
  readonly attribute DOMString id;
  readonly attribute DOMString kind;
  readonly attribute DOMString label;
  readonly attribute DOMString language;
  attribute boolean enabled;
};

[Exposed=Window]
interface AudioTrackList : EventTarget {
  readonly attribute unsigned long length;
  attribute EventHandler onaddtrack;
  attribute EventHandler onchange;
  attribute EventHandler onremovetrack;
  AudioTrack? getTrackById( DOMString id );
  getter AudioTrack ( unsigned long index );
};

[Exposed=Window]
interface BarProp {
  readonly attribute boolean visible;
};

[Exposed=Window]
interface BeforeUnloadEvent : Event {
  attribute DOMString returnValue;
};

[Exposed=(Window,Worker)]
interface BroadcastChannel : EventTarget {
  readonly attribute DOMString name;
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  constructor( DOMString name );
  void close();
  void postMessage( any message );
};

[Exposed=(Window,Worker)]
interface CanvasGradient {
  void addColorStop( double offset, DOMString color );
};

[Exposed=(Window,Worker)]
interface CanvasPattern {
  void setTransform( optional DOMMatrix2DInit transform = {} );
};

[Exposed=Window]
interface CanvasRenderingContext2D {
  readonly attribute HTMLCanvasElement canvas;
  CanvasRenderingContext2DSettings getContextAttributes();
};

[Exposed=(Window,Worker)]
interface CloseEvent : Event {
  readonly attribute unsigned short code;
  readonly attribute USVString reason;
  readonly attribute boolean wasClean;
  constructor( DOMString type, optional CloseEventInit eventInitDict = {} );
};

[Exposed=Window]
interface CustomElementRegistry {
  [CEReactions]
  void define( DOMString name, CustomElementConstructor constructor, optional ElementDefinitionOptions options = {} );
  any get( DOMString name );
  [CEReactions]
  void upgrade( Node root );
  Promise<void> whenDefined( DOMString name );
};

[Exposed=Window]
interface DOMParser {
  constructor();
  [NewObject]
  Document parseFromString( DOMString string, DOMParserSupportedType type );
};

[Exposed=(Window,Worker)]
interface DOMStringList {
  readonly attribute unsigned long length;
  boolean contains( DOMString string );
  getter DOMString? item( unsigned long index );
};

[Exposed=Window, LegacyOverrideBuiltIns]
interface DOMStringMap {
  getter DOMString ( DOMString name );
  [CEReactions]
  setter void ( DOMString name, DOMString value );
  [CEReactions]
  deleter void ( DOMString name );
};

[Exposed=Window]
interface DataTransfer {
  [SameObject]
  readonly attribute FileList files;
  [SameObject]
  readonly attribute DataTransferItemList items;
  readonly attribute FrozenArray<DOMString> types;
  attribute DOMString dropEffect;
  attribute DOMString effectAllowed;
  constructor();
  void clearData( optional DOMString format );
  DOMString getData( DOMString format );
  void setData( DOMString format, DOMString data );
  void setDragImage( Element image, long x, long y );
};

[Exposed=Window]
interface DataTransferItem {
  readonly attribute DOMString kind;
  readonly attribute DOMString type;
  File? getAsFile();
  void getAsString( FunctionStringCallback? _callback );
};

[Exposed=Window]
interface DataTransferItemList {
  readonly attribute unsigned long length;
  DataTransferItem? add( DOMString data, DOMString type );
  DataTransferItem? add( File data );
  void clear();
  void remove( unsigned long index );
  getter DataTransferItem ( unsigned long index );
};

[Global=(Worker,DedicatedWorker), Exposed=DedicatedWorker]
interface DedicatedWorkerGlobalScope : WorkerGlobalScope {
  [Replaceable]
  readonly attribute DOMString name;
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  void close();
  void postMessage( any message, sequence<object> transfer );
  void postMessage( any message, optional PostMessageOptions options = {} );
};

[Exposed=Window]
interface DragEvent : MouseEvent {
  readonly attribute DataTransfer? dataTransfer;
  constructor( DOMString type, optional DragEventInit eventInitDict = {} );
};

[Exposed=Window]
interface ElementInternals {
  readonly attribute HTMLFormElement? form;
  readonly attribute NodeList labels;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  boolean checkValidity();
  boolean reportValidity();
  void setFormValue( ( File or USVString or FormData )? value, optional ( File or USVString or FormData )? state );
  void setValidity( optional ValidityStateFlags flags = {}, optional DOMString message, optional HTMLElement anchor );
};

[Exposed=(Window,Worker)]
interface ErrorEvent : Event {
  readonly attribute unsigned long colno;
  readonly attribute any error;
  readonly attribute USVString filename;
  readonly attribute unsigned long lineno;
  readonly attribute DOMString message;
  constructor( DOMString type, optional ErrorEventInit eventInitDict = {} );
};

[Exposed=(Window,Worker)]
interface EventSource : EventTarget {
  const unsigned short CLOSED = 2;
  const unsigned short CONNECTING = 0;
  const unsigned short OPEN = 1;
  readonly attribute unsigned short readyState;
  readonly attribute USVString url;
  readonly attribute boolean withCredentials;
  attribute EventHandler onerror;
  attribute EventHandler onmessage;
  attribute EventHandler onopen;
  constructor( USVString url, optional EventSourceInit eventSourceInitDict = {} );
  void close();
};

[Exposed=Window]
interface External {
  void AddSearchProvider();
  void IsSearchProviderInstalled();
};

[Exposed=Window]
interface FormDataEvent : Event {
  readonly attribute FormData formData;
  constructor( DOMString type, FormDataEventInit eventInitDict );
};

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface HTMLAllCollection {
  readonly attribute unsigned long length;
  ( HTMLCollection or Element )? item( optional DOMString nameOrIndex );
  getter ( HTMLCollection or Element )? namedItem( DOMString name );
  getter Element ( unsigned long index );
};

[Exposed=Window]
interface HTMLAnchorElement : HTMLElement {
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList relList;
  [CEReactions]
  attribute DOMString download;
  [CEReactions]
  attribute DOMString hreflang;
  [CEReactions]
  attribute USVString ping;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute DOMString rel;
  [CEReactions]
  attribute DOMString target;
  [CEReactions]
  attribute DOMString text;
  [CEReactions]
  attribute DOMString type;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLAreaElement : HTMLElement {
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList relList;
  [CEReactions]
  attribute DOMString alt;
  [CEReactions]
  attribute DOMString coords;
  [CEReactions]
  attribute DOMString download;
  [CEReactions]
  attribute USVString ping;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute DOMString rel;
  [CEReactions]
  attribute DOMString shape;
  [CEReactions]
  attribute DOMString target;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window, LegacyFactoryFunction=Audio( optional DOMString src )]
interface HTMLAudioElement : HTMLMediaElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLBRElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLBaseElement : HTMLElement {
  [CEReactions]
  attribute USVString href;
  [CEReactions]
  attribute DOMString target;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLBodyElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLButtonElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  readonly attribute NodeList labels;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute USVString formAction;
  [CEReactions]
  attribute DOMString formEnctype;
  [CEReactions]
  attribute DOMString formMethod;
  [CEReactions]
  attribute boolean formNoValidate;
  [CEReactions]
  attribute DOMString formTarget;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString type;
  [CEReactions]
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void setCustomValidity( DOMString error );
};

[Exposed=Window]
interface HTMLCanvasElement : HTMLElement {
  [CEReactions]
  attribute unsigned long height;
  [CEReactions]
  attribute unsigned long width;
  [HTMLConstructor]
  constructor();
  RenderingContext? getContext( DOMString contextId, optional any options = null );
  void toBlob( BlobCallback _callback, optional DOMString type = "image/png", optional any quality );
  USVString toDataURL( optional DOMString type = "image/png", optional any quality );
  OffscreenCanvas transferControlToOffscreen();
};

[Exposed=Window]
interface HTMLDListElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLDataElement : HTMLElement {
  [CEReactions]
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLDataListElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection options;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLDetailsElement : HTMLElement {
  [CEReactions]
  attribute boolean open;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLDialogElement : HTMLElement {
  [CEReactions]
  attribute boolean open;
  attribute DOMString returnValue;
  [HTMLConstructor]
  constructor();
  [CEReactions]
  void close( optional DOMString returnValue );
  [CEReactions]
  void show();
  [CEReactions]
  void showModal();
};

[Exposed=Window]
interface HTMLDirectoryElement : HTMLElement {
  [CEReactions]
  attribute boolean compact;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLDivElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLElement : Element {
  readonly attribute DOMString accessKeyLabel;
  [CEReactions]
  attribute DOMString accessKey;
  [CEReactions]
  attribute DOMString autocapitalize;
  [CEReactions]
  attribute DOMString dir;
  [CEReactions]
  attribute boolean draggable;
  [CEReactions]
  attribute boolean hidden;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString innerText;
  [CEReactions]
  attribute DOMString lang;
  [CEReactions]
  attribute boolean spellcheck;
  [CEReactions]
  attribute DOMString title;
  [CEReactions]
  attribute boolean translate;
  [HTMLConstructor]
  constructor();
  ElementInternals attachInternals();
  void click();
};

[Exposed=Window]
interface HTMLEmbedElement : HTMLElement {
  [CEReactions]
  attribute DOMString height;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute DOMString type;
  [CEReactions]
  attribute DOMString width;
  [HTMLConstructor]
  constructor();
  Document? getSVGDocument();
};

[Exposed=Window]
interface HTMLFieldSetElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection elements;
  readonly attribute HTMLFormElement? form;
  readonly attribute DOMString type;
  readonly attribute DOMString validationMessage;
  [SameObject]
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute DOMString name;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void setCustomValidity( DOMString error );
};

[Exposed=Window]
interface HTMLFontElement : HTMLElement {
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString color;
  [CEReactions]
  attribute DOMString face;
  [CEReactions]
  attribute DOMString size;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLFormControlsCollection : HTMLCollection {
  getter ( RadioNodeList or Element )? namedItem( DOMString name );
};

[Exposed=Window, LegacyOverrideBuiltIns, LegacyUnenumerableNamedProperties]
interface HTMLFormElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLFormControlsCollection elements;
  readonly attribute unsigned long length;
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList relList;
  [CEReactions]
  attribute DOMString acceptCharset;
  [CEReactions]
  attribute USVString action;
  [CEReactions]
  attribute DOMString autocomplete;
  [CEReactions]
  attribute DOMString encoding;
  [CEReactions]
  attribute DOMString enctype;
  [CEReactions]
  attribute DOMString method;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute boolean noValidate;
  [CEReactions]
  attribute DOMString rel;
  [CEReactions]
  attribute DOMString target;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void requestSubmit( optional HTMLElement? submitter = null );
  [CEReactions]
  void reset();
  void submit();
  getter Element ( unsigned long index );
  getter ( RadioNodeList or Element ) ( DOMString name );
};

[Exposed=Window]
interface HTMLFrameElement : HTMLElement {
  readonly attribute Document? contentDocument;
  readonly attribute WindowProxy? contentWindow;
  [CEReactions]
  attribute DOMString frameBorder;
  [CEReactions]
  attribute USVString longDesc;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString marginHeight;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString marginWidth;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute boolean noResize;
  [CEReactions]
  attribute DOMString scrolling;
  [CEReactions]
  attribute USVString src;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLFrameSetElement : HTMLElement {
  [CEReactions]
  attribute DOMString cols;
  [CEReactions]
  attribute DOMString rows;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLHRElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLHeadElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLHeadingElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLHtmlElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLIFrameElement : HTMLElement {
  readonly attribute Document? contentDocument;
  readonly attribute WindowProxy? contentWindow;
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList sandbox;
  [CEReactions]
  attribute DOMString allow;
  [CEReactions]
  attribute boolean allowFullscreen;
  [CEReactions]
  attribute boolean allowPaymentRequest;
  [CEReactions]
  attribute DOMString height;
  [CEReactions]
  attribute DOMString loading;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute DOMString srcdoc;
  [CEReactions]
  attribute DOMString width;
  [HTMLConstructor]
  constructor();
  Document? getSVGDocument();
};

[Exposed=Window, LegacyFactoryFunction=Image( optional unsigned long width, optional unsigned long height )]
interface HTMLImageElement : HTMLElement {
  readonly attribute boolean complete;
  readonly attribute USVString currentSrc;
  readonly attribute unsigned long naturalHeight;
  readonly attribute unsigned long naturalWidth;
  [CEReactions]
  attribute DOMString alt;
  [CEReactions]
  attribute DOMString? crossOrigin;
  [CEReactions]
  attribute DOMString decoding;
  [CEReactions]
  attribute unsigned long height;
  [CEReactions]
  attribute boolean isMap;
  [CEReactions]
  attribute DOMString loading;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute DOMString sizes;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute USVString srcset;
  [CEReactions]
  attribute DOMString useMap;
  [CEReactions]
  attribute unsigned long width;
  [HTMLConstructor]
  constructor();
  Promise<void> decode();
};

[Exposed=Window]
interface HTMLInputElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  readonly attribute NodeList? labels;
  readonly attribute HTMLElement? list;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute DOMString accept;
  [CEReactions]
  attribute DOMString alt;
  [CEReactions]
  attribute DOMString autocomplete;
  attribute boolean checked;
  [CEReactions]
  attribute boolean defaultChecked;
  [CEReactions]
  attribute DOMString defaultValue;
  [CEReactions]
  attribute DOMString dirName;
  [CEReactions]
  attribute boolean disabled;
  attribute FileList? files;
  [CEReactions]
  attribute USVString formAction;
  [CEReactions]
  attribute DOMString formEnctype;
  [CEReactions]
  attribute DOMString formMethod;
  [CEReactions]
  attribute boolean formNoValidate;
  [CEReactions]
  attribute DOMString formTarget;
  [CEReactions]
  attribute unsigned long height;
  attribute boolean indeterminate;
  [CEReactions]
  attribute DOMString max;
  [CEReactions]
  attribute long maxLength;
  [CEReactions]
  attribute DOMString min;
  [CEReactions]
  attribute long minLength;
  [CEReactions]
  attribute boolean multiple;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString pattern;
  [CEReactions]
  attribute DOMString placeholder;
  [CEReactions]
  attribute boolean readOnly;
  [CEReactions]
  attribute boolean required;
  attribute DOMString? selectionDirection;
  attribute unsigned long? selectionEnd;
  attribute unsigned long? selectionStart;
  [CEReactions]
  attribute unsigned long size;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute DOMString step;
  [CEReactions]
  attribute DOMString type;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString value;
  attribute object? valueAsDate;
  attribute unrestricted double valueAsNumber;
  [CEReactions]
  attribute unsigned long width;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void select();
  void setCustomValidity( DOMString error );
  void setRangeText( DOMString replacement );
  void setRangeText( DOMString replacement, unsigned long start, unsigned long end, optional SelectionMode selectionMode = "preserve" );
  void setSelectionRange( unsigned long start, unsigned long end, optional DOMString direction );
  void stepDown( optional long n = 1 );
  void stepUp( optional long n = 1 );
};

[Exposed=Window]
interface HTMLLIElement : HTMLElement {
  [CEReactions]
  attribute long value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLLabelElement : HTMLElement {
  readonly attribute HTMLElement? control;
  readonly attribute HTMLFormElement? form;
  [CEReactions]
  attribute DOMString htmlFor;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLLegendElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLLinkElement : HTMLElement {
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList relList;
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList sizes;
  [CEReactions]
  attribute DOMString as;
  [CEReactions]
  attribute DOMString? crossOrigin;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute USVString href;
  [CEReactions]
  attribute DOMString hreflang;
  [CEReactions]
  attribute DOMString imageSizes;
  [CEReactions]
  attribute USVString imageSrcset;
  [CEReactions]
  attribute DOMString integrity;
  [CEReactions]
  attribute DOMString media;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute DOMString rel;
  [CEReactions]
  attribute DOMString type;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLMapElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection areas;
  [CEReactions]
  attribute DOMString name;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLMarqueeElement : HTMLElement {
  [CEReactions]
  attribute DOMString behavior;
  [CEReactions]
  attribute DOMString bgColor;
  [CEReactions]
  attribute DOMString direction;
  [CEReactions]
  attribute DOMString height;
  [CEReactions]
  attribute unsigned long hspace;
  [CEReactions]
  attribute long loop;
  attribute EventHandler onbounce;
  attribute EventHandler onfinish;
  attribute EventHandler onstart;
  [CEReactions]
  attribute unsigned long scrollAmount;
  [CEReactions]
  attribute unsigned long scrollDelay;
  [CEReactions]
  attribute boolean trueSpeed;
  [CEReactions]
  attribute unsigned long vspace;
  [CEReactions]
  attribute DOMString width;
  [HTMLConstructor]
  constructor();
  void start();
  void stop();
};

[Exposed=Window]
interface HTMLMediaElement : HTMLElement {
  const unsigned short HAVE_CURRENT_DATA = 2;
  const unsigned short HAVE_ENOUGH_DATA = 4;
  const unsigned short HAVE_FUTURE_DATA = 3;
  const unsigned short HAVE_METADATA = 1;
  const unsigned short HAVE_NOTHING = 0;
  const unsigned short NETWORK_EMPTY = 0;
  const unsigned short NETWORK_IDLE = 1;
  const unsigned short NETWORK_LOADING = 2;
  const unsigned short NETWORK_NO_SOURCE = 3;
  [SameObject]
  readonly attribute AudioTrackList audioTracks;
  readonly attribute TimeRanges buffered;
  readonly attribute USVString currentSrc;
  readonly attribute unrestricted double duration;
  readonly attribute boolean ended;
  readonly attribute MediaError? error;
  readonly attribute unsigned short networkState;
  readonly attribute boolean paused;
  readonly attribute TimeRanges played;
  readonly attribute unsigned short readyState;
  readonly attribute TimeRanges seekable;
  readonly attribute boolean seeking;
  [SameObject]
  readonly attribute TextTrackList textTracks;
  [SameObject]
  readonly attribute VideoTrackList videoTracks;
  [CEReactions]
  attribute boolean autoplay;
  [CEReactions]
  attribute boolean controls;
  [CEReactions]
  attribute DOMString? crossOrigin;
  attribute double currentTime;
  [CEReactions]
  attribute boolean defaultMuted;
  attribute double defaultPlaybackRate;
  [CEReactions]
  attribute boolean loop;
  attribute boolean muted;
  attribute double playbackRate;
  [CEReactions]
  attribute DOMString preload;
  [CEReactions]
  attribute USVString src;
  attribute MediaProvider? srcObject;
  attribute double volume;
  TextTrack addTextTrack( TextTrackKind kind, optional DOMString label = "", optional DOMString language = "" );
  CanPlayTypeResult canPlayType( DOMString type );
  void fastSeek( double time );
  object getStartDate();
  void load();
  void pause();
  Promise<void> play();
};

[Exposed=Window]
interface HTMLMenuElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLMetaElement : HTMLElement {
  [CEReactions]
  attribute DOMString content;
  [CEReactions]
  attribute DOMString httpEquiv;
  [CEReactions]
  attribute DOMString name;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLMeterElement : HTMLElement {
  readonly attribute NodeList labels;
  [CEReactions]
  attribute double high;
  [CEReactions]
  attribute double low;
  [CEReactions]
  attribute double max;
  [CEReactions]
  attribute double min;
  [CEReactions]
  attribute double optimum;
  [CEReactions]
  attribute double value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLModElement : HTMLElement {
  [CEReactions]
  attribute USVString cite;
  [CEReactions]
  attribute DOMString dateTime;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLOListElement : HTMLElement {
  [CEReactions]
  attribute boolean reversed;
  [CEReactions]
  attribute long start;
  [CEReactions]
  attribute DOMString type;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLObjectElement : HTMLElement {
  readonly attribute Document? contentDocument;
  readonly attribute WindowProxy? contentWindow;
  readonly attribute HTMLFormElement? form;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute USVString data;
  [CEReactions]
  attribute DOMString height;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString type;
  [CEReactions]
  attribute DOMString useMap;
  [CEReactions]
  attribute DOMString width;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  Document? getSVGDocument();
  boolean reportValidity();
  void setCustomValidity( DOMString error );
};

[Exposed=Window]
interface HTMLOptGroupElement : HTMLElement {
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute DOMString label;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window, LegacyFactoryFunction=Option( optional DOMString text = "", optional DOMString value, optional boolean defaultSelected = false, optional boolean selected = false )]
interface HTMLOptionElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  readonly attribute long index;
  [CEReactions]
  attribute boolean defaultSelected;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute DOMString label;
  attribute boolean selected;
  [CEReactions]
  attribute DOMString text;
  [CEReactions]
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLOptionsCollection : HTMLCollection {
  [CEReactions]
  attribute unsigned long length;
  attribute long selectedIndex;
  [CEReactions]
  void add( ( HTMLOptionElement or HTMLOptGroupElement ) element, optional ( HTMLElement or long )? before = null );
  [CEReactions]
  void remove( long index );
  [CEReactions]
  setter void ( unsigned long index, HTMLOptionElement? option );
};

[Exposed=Window]
interface HTMLOutputElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList htmlFor;
  readonly attribute NodeList labels;
  readonly attribute DOMString type;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute DOMString defaultValue;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void setCustomValidity( DOMString error );
};

[Exposed=Window]
interface HTMLParagraphElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLParamElement : HTMLElement {
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLPictureElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLPreElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLProgressElement : HTMLElement {
  readonly attribute NodeList labels;
  readonly attribute double position;
  [CEReactions]
  attribute double max;
  [CEReactions]
  attribute double value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLQuoteElement : HTMLElement {
  [CEReactions]
  attribute USVString cite;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLScriptElement : HTMLElement {
  [CEReactions]
  attribute boolean async;
  [CEReactions]
  attribute DOMString? crossOrigin;
  [CEReactions]
  attribute boolean defer;
  [CEReactions]
  attribute DOMString integrity;
  [CEReactions]
  attribute boolean noModule;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute DOMString text;
  [CEReactions]
  attribute DOMString type;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLSelectElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  readonly attribute NodeList labels;
  [SameObject]
  readonly attribute HTMLOptionsCollection options;
  [SameObject]
  readonly attribute HTMLCollection selectedOptions;
  readonly attribute DOMString type;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute DOMString autocomplete;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute unsigned long length;
  [CEReactions]
  attribute boolean multiple;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute boolean required;
  attribute long selectedIndex;
  [CEReactions]
  attribute unsigned long size;
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
  [CEReactions]
  void add( ( HTMLOptionElement or HTMLOptGroupElement ) element, optional ( HTMLElement or long )? before = null );
  boolean checkValidity();
  HTMLOptionElement? namedItem( DOMString name );
  [CEReactions]
  void remove();
  [CEReactions]
  void remove( long index );
  boolean reportValidity();
  void setCustomValidity( DOMString error );
  getter Element? item( unsigned long index );
  [CEReactions]
  setter void ( unsigned long index, HTMLOptionElement? option );
};

[Exposed=Window]
interface HTMLSlotElement : HTMLElement {
  [CEReactions]
  attribute DOMString name;
  [HTMLConstructor]
  constructor();
  sequence<Element> assignedElements( optional AssignedNodesOptions options = {} );
  sequence<Node> assignedNodes( optional AssignedNodesOptions options = {} );
};

[Exposed=Window]
interface HTMLSourceElement : HTMLElement {
  [CEReactions]
  attribute DOMString media;
  [CEReactions]
  attribute DOMString sizes;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute USVString srcset;
  [CEReactions]
  attribute DOMString type;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLSpanElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLStyleElement : HTMLElement {
  [CEReactions]
  attribute DOMString media;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTableCaptionElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTableCellElement : HTMLElement {
  readonly attribute long cellIndex;
  [CEReactions]
  attribute DOMString abbr;
  [CEReactions]
  attribute unsigned long colSpan;
  [CEReactions]
  attribute DOMString headers;
  [CEReactions]
  attribute unsigned long rowSpan;
  [CEReactions]
  attribute DOMString scope;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTableColElement : HTMLElement {
  [CEReactions]
  attribute unsigned long span;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTableElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection rows;
  [SameObject]
  readonly attribute HTMLCollection tBodies;
  [CEReactions]
  attribute HTMLTableCaptionElement? caption;
  [CEReactions]
  attribute HTMLTableSectionElement? tFoot;
  [CEReactions]
  attribute HTMLTableSectionElement? tHead;
  [HTMLConstructor]
  constructor();
  HTMLTableCaptionElement createCaption();
  HTMLTableSectionElement createTBody();
  HTMLTableSectionElement createTFoot();
  HTMLTableSectionElement createTHead();
  [CEReactions]
  void deleteCaption();
  [CEReactions]
  void deleteRow( long index );
  [CEReactions]
  void deleteTFoot();
  [CEReactions]
  void deleteTHead();
  HTMLTableRowElement insertRow( optional long index = -1 );
};

[Exposed=Window]
interface HTMLTableRowElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection cells;
  readonly attribute long rowIndex;
  readonly attribute long sectionRowIndex;
  [HTMLConstructor]
  constructor();
  [CEReactions]
  void deleteCell( long index );
  HTMLTableCellElement insertCell( optional long index = -1 );
};

[Exposed=Window]
interface HTMLTableSectionElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection rows;
  [HTMLConstructor]
  constructor();
  [CEReactions]
  void deleteRow( long index );
  HTMLTableRowElement insertRow( optional long index = -1 );
};

[Exposed=Window]
interface HTMLTemplateElement : HTMLElement {
  readonly attribute DocumentFragment content;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTextAreaElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  readonly attribute NodeList labels;
  readonly attribute unsigned long textLength;
  readonly attribute DOMString type;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute DOMString autocomplete;
  [CEReactions]
  attribute unsigned long cols;
  [CEReactions]
  attribute DOMString defaultValue;
  [CEReactions]
  attribute DOMString dirName;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute long maxLength;
  [CEReactions]
  attribute long minLength;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString placeholder;
  [CEReactions]
  attribute boolean readOnly;
  [CEReactions]
  attribute boolean required;
  [CEReactions]
  attribute unsigned long rows;
  attribute DOMString selectionDirection;
  attribute unsigned long selectionEnd;
  attribute unsigned long selectionStart;
  attribute [LegacyNullToEmptyString] DOMString value;
  [CEReactions]
  attribute DOMString wrap;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void select();
  void setCustomValidity( DOMString error );
  void setRangeText( DOMString replacement );
  void setRangeText( DOMString replacement, unsigned long start, unsigned long end, optional SelectionMode selectionMode = "preserve" );
  void setSelectionRange( unsigned long start, unsigned long end, optional DOMString direction );
};

[Exposed=Window]
interface HTMLTimeElement : HTMLElement {
  [CEReactions]
  attribute DOMString dateTime;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTitleElement : HTMLElement {
  [CEReactions]
  attribute DOMString text;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTrackElement : HTMLElement {
  const unsigned short ERROR = 3;
  const unsigned short LOADED = 2;
  const unsigned short LOADING = 1;
  const unsigned short NONE = 0;
  readonly attribute unsigned short readyState;
  readonly attribute TextTrack track;
  [CEReactions]
  attribute boolean default;
  [CEReactions]
  attribute DOMString kind;
  [CEReactions]
  attribute DOMString label;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute DOMString srclang;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLUListElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLUnknownElement : HTMLElement {
};

[Exposed=Window]
interface HTMLVideoElement : HTMLMediaElement {
  readonly attribute unsigned long videoHeight;
  readonly attribute unsigned long videoWidth;
  [CEReactions]
  attribute unsigned long height;
  [CEReactions]
  attribute boolean playsInline;
  [CEReactions]
  attribute USVString poster;
  [CEReactions]
  attribute unsigned long width;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HashChangeEvent : Event {
  readonly attribute USVString newURL;
  readonly attribute USVString oldURL;
  constructor( DOMString type, optional HashChangeEventInit eventInitDict = {} );
};

[Exposed=Window]
interface History {
  readonly attribute unsigned long length;
  readonly attribute any state;
  attribute ScrollRestoration scrollRestoration;
  void back();
  void forward();
  void go( optional long delta = 0 );
  void pushState( any data, DOMString title, optional USVString? url = null );
  void replaceState( any data, DOMString title, optional USVString? url = null );
};

[Exposed=(Window,Worker), Serializable, Transferable]
interface ImageBitmap {
  readonly attribute unsigned long height;
  readonly attribute unsigned long width;
  void close();
};

[Exposed=(Window,Worker)]
interface ImageBitmapRenderingContext {
  readonly attribute ( HTMLCanvasElement or OffscreenCanvas ) canvas;
  void transferFromImageBitmap( ImageBitmap? bitmap );
};

[Exposed=(Window,Worker), Serializable]
interface ImageData {
  readonly attribute Uint8ClampedArray data;
  readonly attribute unsigned long height;
  readonly attribute unsigned long width;
  constructor( unsigned long sw, unsigned long sh );
  constructor( Uint8ClampedArray data, unsigned long sw, optional unsigned long sh );
};

[Exposed=Window]
interface Location {
  [LegacyUnforgeable, SameObject]
  readonly attribute DOMStringList ancestorOrigins;
  [LegacyUnforgeable]
  readonly attribute USVString origin;
  [LegacyUnforgeable]
  attribute USVString hash;
  [LegacyUnforgeable]
  attribute USVString host;
  [LegacyUnforgeable]
  attribute USVString hostname;
  [LegacyUnforgeable]
  attribute USVString pathname;
  [LegacyUnforgeable]
  attribute USVString port;
  [LegacyUnforgeable]
  attribute USVString protocol;
  [LegacyUnforgeable]
  attribute USVString search;
  [LegacyUnforgeable]
  stringifier attribute USVString href;
  [LegacyUnforgeable]
  void assign( USVString url );
  [LegacyUnforgeable]
  void reload();
  [LegacyUnforgeable]
  void replace( USVString url );
};

[Exposed=Window]
interface MediaError {
  const unsigned short MEDIA_ERR_ABORTED = 1;
  const unsigned short MEDIA_ERR_DECODE = 3;
  const unsigned short MEDIA_ERR_NETWORK = 2;
  const unsigned short MEDIA_ERR_SRC_NOT_SUPPORTED = 4;
  readonly attribute unsigned short code;
  readonly attribute DOMString message;
};

[Exposed=(Window,Worker)]
interface MessageChannel {
  readonly attribute MessagePort port1;
  readonly attribute MessagePort port2;
  constructor();
};

[Exposed=(Window,Worker,AudioWorklet)]
interface MessageEvent : Event {
  readonly attribute any data;
  readonly attribute DOMString lastEventId;
  readonly attribute USVString origin;
  readonly attribute FrozenArray<MessagePort> ports;
  readonly attribute MessageEventSource? source;
  constructor( DOMString type, optional MessageEventInit eventInitDict = {} );
  void initMessageEvent( DOMString type, optional boolean bubbles = false, optional boolean cancelable = false, optional any data = null, optional USVString origin = "", optional DOMString lastEventId = "", optional MessageEventSource? source = null, optional sequence<MessagePort> ports = [] );
};

[Exposed=(Window,Worker,AudioWorklet), Transferable]
interface MessagePort : EventTarget {
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  void close();
  void postMessage( any message, sequence<object> transfer );
  void postMessage( any message, optional PostMessageOptions options = {} );
  void start();
};

[Exposed=Window]
interface MimeType {
  readonly attribute DOMString description;
  readonly attribute Plugin enabledPlugin;
  readonly attribute DOMString suffixes;
  readonly attribute DOMString type;
};

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface MimeTypeArray {
  readonly attribute unsigned long length;
  getter MimeType? item( unsigned long index );
  getter MimeType? namedItem( DOMString name );
};

[Exposed=Window]
interface Navigator {
};

[Exposed=(Window,Worker), Transferable]
interface OffscreenCanvas : EventTarget {
  attribute [EnforceRange] unsigned long long height;
  attribute [EnforceRange] unsigned long long width;
  constructor( [EnforceRange] unsigned long long width, [EnforceRange] unsigned long long height );
  Promise<Blob> convertToBlob( optional ImageEncodeOptions options = {} );
  OffscreenRenderingContext? getContext( OffscreenRenderingContextId contextId, optional any options = null );
  ImageBitmap transferToImageBitmap();
};

[Exposed=(Window,Worker)]
interface OffscreenCanvasRenderingContext2D {
  readonly attribute OffscreenCanvas canvas;
  void commit();
};

[Exposed=Window]
interface PageTransitionEvent : Event {
  readonly attribute boolean persisted;
  constructor( DOMString type, optional PageTransitionEventInit eventInitDict = {} );
};

[Exposed=(Window,Worker)]
interface Path2D {
  constructor( optional ( Path2D or DOMString ) path );
  void addPath( Path2D path, optional DOMMatrix2DInit transform = {} );
};

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface Plugin {
  readonly attribute DOMString description;
  readonly attribute DOMString filename;
  readonly attribute unsigned long length;
  readonly attribute DOMString name;
  getter MimeType? item( unsigned long index );
  getter MimeType? namedItem( DOMString name );
};

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface PluginArray {
  readonly attribute unsigned long length;
  void refresh( optional boolean reload = false );
  getter Plugin? item( unsigned long index );
  getter Plugin? namedItem( DOMString name );
};

[Exposed=Window]
interface PopStateEvent : Event {
  readonly attribute any state;
  constructor( DOMString type, optional PopStateEventInit eventInitDict = {} );
};

[Exposed=(Window,Worker)]
interface PromiseRejectionEvent : Event {
  readonly attribute Promise<any> promise;
  readonly attribute any reason;
  constructor( DOMString type, PromiseRejectionEventInit eventInitDict );
};

[Exposed=Window]
interface RadioNodeList : NodeList {
  attribute DOMString value;
};

[Exposed=Window]
interface SharedWorker : EventTarget {
  readonly attribute MessagePort port;
  constructor( USVString scriptURL, optional ( DOMString or WorkerOptions ) options = {} );
};

[Global=(Worker,SharedWorker), Exposed=SharedWorker]
interface SharedWorkerGlobalScope : WorkerGlobalScope {
  [Replaceable]
  readonly attribute DOMString name;
  attribute EventHandler onconnect;
  void close();
};

[Exposed=Window]
interface Storage {
  readonly attribute unsigned long length;
  void clear();
  DOMString? key( unsigned long index );
  getter DOMString? getItem( DOMString key );
  setter void setItem( DOMString key, DOMString value );
  deleter void removeItem( DOMString key );
};

[Exposed=Window]
interface StorageEvent : Event {
  readonly attribute DOMString? key;
  readonly attribute DOMString? newValue;
  readonly attribute DOMString? oldValue;
  readonly attribute Storage? storageArea;
  readonly attribute USVString url;
  constructor( DOMString type, optional StorageEventInit eventInitDict = {} );
  void initStorageEvent( DOMString type, optional boolean bubbles = false, optional boolean cancelable = false, optional DOMString? key = null, optional DOMString? oldValue = null, optional DOMString? newValue = null, optional USVString url = "", optional Storage? storageArea = null );
};

[Exposed=Window]
interface SubmitEvent : Event {
  readonly attribute HTMLElement? submitter;
  constructor( DOMString type, optional SubmitEventInit eventInitDict = {} );
};

[Exposed=(Window,Worker)]
interface TextMetrics {
  readonly attribute double actualBoundingBoxAscent;
  readonly attribute double actualBoundingBoxDescent;
  readonly attribute double actualBoundingBoxLeft;
  readonly attribute double actualBoundingBoxRight;
  readonly attribute double alphabeticBaseline;
  readonly attribute double emHeightAscent;
  readonly attribute double emHeightDescent;
  readonly attribute double fontBoundingBoxAscent;
  readonly attribute double fontBoundingBoxDescent;
  readonly attribute double hangingBaseline;
  readonly attribute double ideographicBaseline;
  readonly attribute double width;
};

[Exposed=Window]
interface TextTrack : EventTarget {
  readonly attribute TextTrackCueList? activeCues;
  readonly attribute TextTrackCueList? cues;
  readonly attribute DOMString id;
  readonly attribute DOMString inBandMetadataTrackDispatchType;
  readonly attribute TextTrackKind kind;
  readonly attribute DOMString label;
  readonly attribute DOMString language;
  attribute TextTrackMode mode;
  attribute EventHandler oncuechange;
  void addCue( TextTrackCue cue );
  void removeCue( TextTrackCue cue );
};

[Exposed=Window]
interface TextTrackCue : EventTarget {
  readonly attribute TextTrack? track;
  attribute double endTime;
  attribute DOMString id;
  attribute EventHandler onenter;
  attribute EventHandler onexit;
  attribute boolean pauseOnExit;
  attribute double startTime;
};

[Exposed=Window]
interface TextTrackCueList {
  readonly attribute unsigned long length;
  TextTrackCue? getCueById( DOMString id );
  getter TextTrackCue ( unsigned long index );
};

[Exposed=Window]
interface TextTrackList : EventTarget {
  readonly attribute unsigned long length;
  attribute EventHandler onaddtrack;
  attribute EventHandler onchange;
  attribute EventHandler onremovetrack;
  TextTrack? getTrackById( DOMString id );
  getter TextTrack ( unsigned long index );
};

[Exposed=Window]
interface TimeRanges {
  readonly attribute unsigned long length;
  double end( unsigned long index );
  double start( unsigned long index );
};

[Exposed=Window]
interface TrackEvent : Event {
  readonly attribute ( VideoTrack or AudioTrack or TextTrack )? track;
  constructor( DOMString type, optional TrackEventInit eventInitDict = {} );
};

[Exposed=Window]
interface ValidityState {
  readonly attribute boolean badInput;
  readonly attribute boolean customError;
  readonly attribute boolean patternMismatch;
  readonly attribute boolean rangeOverflow;
  readonly attribute boolean rangeUnderflow;
  readonly attribute boolean stepMismatch;
  readonly attribute boolean tooLong;
  readonly attribute boolean tooShort;
  readonly attribute boolean typeMismatch;
  readonly attribute boolean valid;
  readonly attribute boolean valueMissing;
};

[Exposed=Window]
interface VideoTrack {
  readonly attribute DOMString id;
  readonly attribute DOMString kind;
  readonly attribute DOMString label;
  readonly attribute DOMString language;
  attribute boolean selected;
};

[Exposed=Window]
interface VideoTrackList : EventTarget {
  readonly attribute unsigned long length;
  readonly attribute long selectedIndex;
  attribute EventHandler onaddtrack;
  attribute EventHandler onchange;
  attribute EventHandler onremovetrack;
  VideoTrack? getTrackById( DOMString id );
  getter VideoTrack ( unsigned long index );
};

[Exposed=(Window,Worker)]
interface WebSocket : EventTarget {
  const unsigned short CLOSED = 3;
  const unsigned short CLOSING = 2;
  const unsigned short CONNECTING = 0;
  const unsigned short OPEN = 1;
  readonly attribute unsigned long long bufferedAmount;
  readonly attribute DOMString extensions;
  readonly attribute DOMString protocol;
  readonly attribute unsigned short readyState;
  readonly attribute USVString url;
  attribute BinaryType binaryType;
  attribute EventHandler onclose;
  attribute EventHandler onerror;
  attribute EventHandler onmessage;
  attribute EventHandler onopen;
  constructor( USVString url, optional ( DOMString or sequence<DOMString> ) protocols = [] );
  void close( optional [Clamp] unsigned short code, optional USVString reason );
  void send( USVString data );
  void send( Blob data );
  void send( ArrayBuffer data );
  void send( ArrayBufferView data );
};

[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface Window : EventTarget {
  [SecureContext]
  readonly attribute ApplicationCache applicationCache;
  readonly attribute boolean closed;
  readonly attribute CustomElementRegistry customElements;
  [LegacyUnforgeable]
  readonly attribute Document document;
  readonly attribute Element? frameElement;
  [Replaceable]
  readonly attribute WindowProxy frames;
  readonly attribute History history;
  [Replaceable]
  readonly attribute unsigned long length;
  [PutForwards=href, LegacyUnforgeable]
  readonly attribute Location location;
  [Replaceable]
  readonly attribute BarProp locationbar;
  [Replaceable]
  readonly attribute BarProp menubar;
  readonly attribute Navigator navigator;
  [Replaceable]
  readonly attribute WindowProxy? parent;
  [Replaceable]
  readonly attribute BarProp personalbar;
  [Replaceable]
  readonly attribute BarProp scrollbars;
  [Replaceable]
  readonly attribute WindowProxy self;
  [Replaceable]
  readonly attribute BarProp statusbar;
  [Replaceable]
  readonly attribute BarProp toolbar;
  [LegacyUnforgeable]
  readonly attribute WindowProxy? top;
  [LegacyUnforgeable]
  readonly attribute WindowProxy window;
  attribute DOMString name;
  attribute any opener;
  attribute DOMString status;
  void alert();
  void alert( DOMString message );
  void blur();
  void close();
  boolean confirm( optional DOMString message = "" );
  void focus();
  WindowProxy? open( optional USVString url = "", optional DOMString target = "_blank", optional [LegacyNullToEmptyString] DOMString features = "" );
  void postMessage( any message, USVString targetOrigin, optional sequence<object> transfer = [] );
  void postMessage( any message, optional WindowPostMessageOptions options = {} );
  void print();
  DOMString? prompt( optional DOMString message = "", optional DOMString default = "" );
  void stop();
  getter object ( DOMString name );
};

[Exposed=(Window,DedicatedWorker,SharedWorker)]
interface Worker : EventTarget {
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  constructor( USVString scriptURL, optional WorkerOptions options = {} );
  void postMessage( any message, sequence<object> transfer );
  void postMessage( any message, optional PostMessageOptions options = {} );
  void terminate();
};

[Exposed=Worker]
interface WorkerGlobalScope : EventTarget {
  readonly attribute WorkerLocation location;
  readonly attribute WorkerNavigator navigator;
  readonly attribute WorkerGlobalScope self;
  attribute OnErrorEventHandler onerror;
  attribute EventHandler onlanguagechange;
  attribute EventHandler onoffline;
  attribute EventHandler ononline;
  attribute EventHandler onrejectionhandled;
  attribute EventHandler onunhandledrejection;
  void importScripts( USVString... urls );
};

[Exposed=Worker]
interface WorkerLocation {
  readonly attribute USVString hash;
  readonly attribute USVString host;
  readonly attribute USVString hostname;
  readonly attribute USVString origin;
  readonly attribute USVString pathname;
  readonly attribute USVString port;
  readonly attribute USVString protocol;
  readonly attribute USVString search;
  stringifier readonly attribute USVString href;
};

[Exposed=Worker]
interface WorkerNavigator {
};

[LegacyOverrideBuiltIns]
partial interface Document {
  readonly attribute HTMLOrSVGScriptElement? currentScript;
  readonly attribute WindowProxy? defaultView;
  [SameObject]
  readonly attribute HTMLCollection embeds;
  [SameObject]
  readonly attribute HTMLCollection forms;
  readonly attribute HTMLHeadElement? head;
  [SameObject]
  readonly attribute HTMLCollection images;
  readonly attribute DOMString lastModified;
  [SameObject]
  readonly attribute HTMLCollection links;
  [PutForwards=href, LegacyUnforgeable]
  readonly attribute Location? location;
  [SameObject]
  readonly attribute HTMLCollection plugins;
  readonly attribute DocumentReadyState readyState;
  readonly attribute USVString referrer;
  [SameObject]
  readonly attribute HTMLCollection scripts;
  [CEReactions]
  attribute HTMLElement? body;
  attribute USVString cookie;
  [CEReactions]
  attribute DOMString designMode;
  [CEReactions]
  attribute DOMString dir;
  attribute USVString domain;
  [LegacyLenientThis]
  attribute EventHandler onreadystatechange;
  [CEReactions]
  attribute DOMString title;
  [CEReactions]
  void close();
  [CEReactions]
  boolean execCommand( DOMString commandId, optional boolean showUI = false, optional DOMString value = "" );
  NodeList getElementsByName( DOMString elementName );
  boolean hasFocus();
  [CEReactions]
  Document open( optional DOMString unused1, optional DOMString unused2 );
  WindowProxy? open( USVString url, DOMString name, DOMString features );
  boolean queryCommandEnabled( DOMString commandId );
  boolean queryCommandIndeterm( DOMString commandId );
  boolean queryCommandState( DOMString commandId );
  boolean queryCommandSupported( DOMString commandId );
  DOMString queryCommandValue( DOMString commandId );
  [CEReactions]
  void write( DOMString... text );
  [CEReactions]
  void writeln( DOMString... text );
  getter object ( DOMString name );
};

partial interface Document {
  [SameObject]
  readonly attribute HTMLAllCollection all;
  [SameObject]
  readonly attribute HTMLCollection anchors;
  [SameObject]
  readonly attribute HTMLCollection applets;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString alinkColor;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString bgColor;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString fgColor;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString linkColor;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString vlinkColor;
  void captureEvents();
  void clear();
  void releaseEvents();
};

partial interface HTMLAnchorElement {
  [CEReactions]
  attribute DOMString charset;
  [CEReactions]
  attribute DOMString coords;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString rev;
  [CEReactions]
  attribute DOMString shape;
};

partial interface HTMLAreaElement {
  [CEReactions]
  attribute boolean noHref;
};

partial interface HTMLBRElement {
  [CEReactions]
  attribute DOMString clear;
};

partial interface HTMLBodyElement {
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString aLink;
  [CEReactions]
  attribute DOMString background;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString bgColor;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString link;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString text;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString vLink;
};

partial interface HTMLDListElement {
  [CEReactions]
  attribute boolean compact;
};

partial interface HTMLDivElement {
  [CEReactions]
  attribute DOMString align;
};

partial interface HTMLEmbedElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString name;
};

partial interface HTMLHRElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString color;
  [CEReactions]
  attribute boolean noShade;
  [CEReactions]
  attribute DOMString size;
  [CEReactions]
  attribute DOMString width;
};

partial interface HTMLHeadingElement {
  [CEReactions]
  attribute DOMString align;
};

partial interface HTMLHtmlElement {
  [CEReactions]
  attribute DOMString version;
};

partial interface HTMLIFrameElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString frameBorder;
  [CEReactions]
  attribute USVString longDesc;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString marginHeight;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString marginWidth;
  [CEReactions]
  attribute DOMString scrolling;
};

partial interface HTMLImageElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString border;
  [CEReactions]
  attribute unsigned long hspace;
  [CEReactions]
  attribute USVString longDesc;
  [CEReactions]
  attribute USVString lowsrc;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute unsigned long vspace;
};

partial interface HTMLInputElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString useMap;
};

partial interface HTMLLIElement {
  [CEReactions]
  attribute DOMString type;
};

partial interface HTMLLegendElement {
  [CEReactions]
  attribute DOMString align;
};

partial interface HTMLLinkElement {
  [CEReactions]
  attribute DOMString charset;
  [CEReactions]
  attribute DOMString rev;
  [CEReactions]
  attribute DOMString target;
};

partial interface HTMLMenuElement {
  [CEReactions]
  attribute boolean compact;
};

partial interface HTMLMetaElement {
  [CEReactions]
  attribute DOMString scheme;
};

partial interface HTMLOListElement {
  [CEReactions]
  attribute boolean compact;
};

partial interface HTMLObjectElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString archive;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString border;
  [CEReactions]
  attribute DOMString code;
  [CEReactions]
  attribute DOMString codeBase;
  [CEReactions]
  attribute DOMString codeType;
  [CEReactions]
  attribute boolean declare;
  [CEReactions]
  attribute unsigned long hspace;
  [CEReactions]
  attribute DOMString standby;
  [CEReactions]
  attribute unsigned long vspace;
};

partial interface HTMLParagraphElement {
  [CEReactions]
  attribute DOMString align;
};

partial interface HTMLParamElement {
  [CEReactions]
  attribute DOMString type;
  [CEReactions]
  attribute DOMString valueType;
};

partial interface HTMLPreElement {
  [CEReactions]
  attribute long width;
};

partial interface HTMLScriptElement {
  [CEReactions]
  attribute DOMString charset;
  [CEReactions]
  attribute DOMString event;
  [CEReactions]
  attribute DOMString htmlFor;
};

partial interface HTMLStyleElement {
  [CEReactions]
  attribute DOMString type;
};

partial interface HTMLTableCaptionElement {
  [CEReactions]
  attribute DOMString align;
};

partial interface HTMLTableCellElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString axis;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString bgColor;
  [CEReactions]
  attribute DOMString ch;
  [CEReactions]
  attribute DOMString chOff;
  [CEReactions]
  attribute DOMString height;
  [CEReactions]
  attribute boolean noWrap;
  [CEReactions]
  attribute DOMString vAlign;
  [CEReactions]
  attribute DOMString width;
};

partial interface HTMLTableColElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString ch;
  [CEReactions]
  attribute DOMString chOff;
  [CEReactions]
  attribute DOMString vAlign;
  [CEReactions]
  attribute DOMString width;
};

partial interface HTMLTableElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString bgColor;
  [CEReactions]
  attribute DOMString border;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString cellPadding;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString cellSpacing;
  [CEReactions]
  attribute DOMString frame;
  [CEReactions]
  attribute DOMString rules;
  [CEReactions]
  attribute DOMString summary;
  [CEReactions]
  attribute DOMString width;
};

partial interface HTMLTableRowElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString bgColor;
  [CEReactions]
  attribute DOMString ch;
  [CEReactions]
  attribute DOMString chOff;
  [CEReactions]
  attribute DOMString vAlign;
};

partial interface HTMLTableSectionElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString ch;
  [CEReactions]
  attribute DOMString chOff;
  [CEReactions]
  attribute DOMString vAlign;
};

partial interface HTMLUListElement {
  [CEReactions]
  attribute boolean compact;
  [CEReactions]
  attribute DOMString type;
};

partial interface Window {
  [Replaceable, SameObject]
  readonly attribute External external;
  void captureEvents();
  void releaseEvents();
};

CanvasRenderingContext2D includes CanvasCompositing;

CanvasRenderingContext2D includes CanvasDrawImage;

CanvasRenderingContext2D includes CanvasDrawPath;

CanvasRenderingContext2D includes CanvasFillStrokeStyles;

CanvasRenderingContext2D includes CanvasFilters;

CanvasRenderingContext2D includes CanvasImageData;

CanvasRenderingContext2D includes CanvasImageSmoothing;

CanvasRenderingContext2D includes CanvasPath;

CanvasRenderingContext2D includes CanvasPathDrawingStyles;

CanvasRenderingContext2D includes CanvasRect;

CanvasRenderingContext2D includes CanvasShadowStyles;

CanvasRenderingContext2D includes CanvasState;

CanvasRenderingContext2D includes CanvasText;

CanvasRenderingContext2D includes CanvasTextDrawingStyles;

CanvasRenderingContext2D includes CanvasTransform;

CanvasRenderingContext2D includes CanvasUserInterface;

DedicatedWorkerGlobalScope includes AnimationFrameProvider;

Document includes DocumentAndElementEventHandlers;

Document includes GlobalEventHandlers;

HTMLAnchorElement includes HTMLHyperlinkElementUtils;

HTMLAreaElement includes HTMLHyperlinkElementUtils;

HTMLBodyElement includes WindowEventHandlers;

HTMLElement includes DocumentAndElementEventHandlers;

HTMLElement includes ElementContentEditable;

HTMLElement includes GlobalEventHandlers;

HTMLElement includes HTMLOrSVGElement;

HTMLFrameSetElement includes WindowEventHandlers;

HTMLLinkElement includes LinkStyle;

HTMLStyleElement includes LinkStyle;

Navigator includes NavigatorConcurrentHardware;

Navigator includes NavigatorContentUtils;

Navigator includes NavigatorCookies;

Navigator includes NavigatorID;

Navigator includes NavigatorLanguage;

Navigator includes NavigatorOnLine;

Navigator includes NavigatorPlugins;

OffscreenCanvasRenderingContext2D includes CanvasCompositing;

OffscreenCanvasRenderingContext2D includes CanvasDrawImage;

OffscreenCanvasRenderingContext2D includes CanvasDrawPath;

OffscreenCanvasRenderingContext2D includes CanvasFillStrokeStyles;

OffscreenCanvasRenderingContext2D includes CanvasFilters;

OffscreenCanvasRenderingContext2D includes CanvasImageData;

OffscreenCanvasRenderingContext2D includes CanvasImageSmoothing;

OffscreenCanvasRenderingContext2D includes CanvasPath;

OffscreenCanvasRenderingContext2D includes CanvasPathDrawingStyles;

OffscreenCanvasRenderingContext2D includes CanvasRect;

OffscreenCanvasRenderingContext2D includes CanvasShadowStyles;

OffscreenCanvasRenderingContext2D includes CanvasState;

OffscreenCanvasRenderingContext2D includes CanvasText;

OffscreenCanvasRenderingContext2D includes CanvasTextDrawingStyles;

OffscreenCanvasRenderingContext2D includes CanvasTransform;

Path2D includes CanvasPath;

SharedWorker includes AbstractWorker;

Window includes AnimationFrameProvider;

Window includes GlobalEventHandlers;

Window includes WindowEventHandlers;

Window includes WindowLocalStorage;

Window includes WindowOrWorkerGlobalScope;

Window includes WindowSessionStorage;

Worker includes AbstractWorker;

WorkerGlobalScope includes WindowOrWorkerGlobalScope;

WorkerNavigator includes NavigatorConcurrentHardware;

WorkerNavigator includes NavigatorID;

WorkerNavigator includes NavigatorLanguage;

WorkerNavigator includes NavigatorOnLine;
