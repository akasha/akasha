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

typedef ( HTMLOrSVGImageElement or HTMLVideoElement or HTMLCanvasElement or ImageBitmap or OffscreenCanvas ) CanvasImageSource;

typedef ( HTMLImageElement or SVGImageElement ) HTMLOrSVGImageElement;

typedef ( OffscreenCanvasRenderingContext2D or ImageBitmapRenderingContext or WebGLRenderingContext or WebGL2RenderingContext ) OffscreenRenderingContext;

typedef ( CanvasRenderingContext2D or ImageBitmapRenderingContext or WebGLRenderingContext or WebGL2RenderingContext ) RenderingContext;

callback BlobCallback = void ( Blob? blob );

dictionary CanvasRenderingContext2DSettings {
  boolean alpha = true;
  boolean desynchronized = false;
};

dictionary ImageBitmapRenderingContextSettings {
  boolean alpha = true;
};

dictionary ImageEncodeOptions {
  unrestricted double quality;
  DOMString type = "image/png";
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

[Exposed=(Window,Worker)]
interface Path2D {
  constructor( optional ( Path2D or DOMString ) path );
  void addPath( Path2D path, optional DOMMatrix2DInit transform = {} );
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
