dictionary SVGBoundingBoxOptions {
  boolean clipped = false;
  boolean fill = true;
  boolean markers = false;
  boolean stroke = false;
};

interface mixin GetSVGDocument {
  Document getSVGDocument();
};

interface mixin SVGAnimatedPoints {
  [SameObject]
  readonly attribute SVGPointList animatedPoints;
  [SameObject]
  readonly attribute SVGPointList points;
};

interface mixin SVGElementInstance {
  [SameObject]
  readonly attribute SVGElement? correspondingElement;
  [SameObject]
  readonly attribute SVGUseElement? correspondingUseElement;
};

interface mixin SVGFitToViewBox {
  [SameObject]
  readonly attribute SVGAnimatedPreserveAspectRatio preserveAspectRatio;
  [SameObject]
  readonly attribute SVGAnimatedRect viewBox;
};

interface mixin SVGTests {
  [SameObject]
  readonly attribute SVGStringList requiredExtensions;
  [SameObject]
  readonly attribute SVGStringList systemLanguage;
};

interface mixin SVGURIReference {
  [SameObject]
  readonly attribute SVGAnimatedString href;
};

interface mixin SVGZoomAndPan {
  const unsigned short SVG_ZOOMANDPAN_DISABLE = 1;
  const unsigned short SVG_ZOOMANDPAN_MAGNIFY = 2;
  const unsigned short SVG_ZOOMANDPAN_UNKNOWN = 0;
  attribute unsigned short zoomAndPan;
};

[Exposed=Window]
interface SVGAElement : SVGGraphicsElement {
  [SameObject, PutsForward=value]
  readonly attribute DOMTokenList relList;
  [SameObject]
  readonly attribute SVGAnimatedString target;
  attribute DOMString download;
  attribute DOMString hreflang;
  attribute USVString ping;
  attribute DOMString referrerPolicy;
  attribute DOMString rel;
  attribute DOMString text;
  attribute DOMString type;
};

[Exposed=Window]
interface SVGAngle {
  const unsigned short SVG_ANGLETYPE_DEG = 2;
  const unsigned short SVG_ANGLETYPE_GRAD = 4;
  const unsigned short SVG_ANGLETYPE_RAD = 3;
  const unsigned short SVG_ANGLETYPE_UNKNOWN = 0;
  const unsigned short SVG_ANGLETYPE_UNSPECIFIED = 1;
  readonly attribute unsigned short unitType;
  attribute float value;
  attribute DOMString valueAsString;
  attribute float valueInSpecifiedUnits;
  void convertToSpecifiedUnits( unsigned short unitType );
  void newValueSpecifiedUnits( unsigned short unitType, float valueInSpecifiedUnits );
};

[Exposed=Window]
interface SVGAnimatedAngle {
  [SameObject]
  readonly attribute SVGAngle animVal;
  [SameObject]
  readonly attribute SVGAngle baseVal;
};

[Exposed=Window]
interface SVGAnimatedBoolean {
  readonly attribute boolean animVal;
  attribute boolean baseVal;
};

[Exposed=Window]
interface SVGAnimatedEnumeration {
  readonly attribute unsigned short animVal;
  attribute unsigned short baseVal;
};

[Exposed=Window]
interface SVGAnimatedInteger {
  readonly attribute long animVal;
  attribute long baseVal;
};

[Exposed=Window]
interface SVGAnimatedLength {
  [SameObject]
  readonly attribute SVGLength animVal;
  [SameObject]
  readonly attribute SVGLength baseVal;
};

[Exposed=Window]
interface SVGAnimatedLengthList {
  [SameObject]
  readonly attribute SVGLengthList animVal;
  [SameObject]
  readonly attribute SVGLengthList baseVal;
};

[Exposed=Window]
interface SVGAnimatedNumber {
  readonly attribute float animVal;
  attribute float baseVal;
};

[Exposed=Window]
interface SVGAnimatedNumberList {
  [SameObject]
  readonly attribute SVGNumberList animVal;
  [SameObject]
  readonly attribute SVGNumberList baseVal;
};

[Exposed=Window]
interface SVGAnimatedPreserveAspectRatio {
  [SameObject]
  readonly attribute SVGPreserveAspectRatio animVal;
  [SameObject]
  readonly attribute SVGPreserveAspectRatio baseVal;
};

[Exposed=Window]
interface SVGAnimatedRect {
  [SameObject]
  readonly attribute DOMRectReadOnly animVal;
  [SameObject]
  readonly attribute DOMRect baseVal;
};

[Exposed=Window]
interface SVGAnimatedString {
  readonly attribute DOMString animVal;
  attribute DOMString baseVal;
};

[Exposed=Window]
interface SVGAnimatedTransformList {
  [SameObject]
  readonly attribute SVGTransformList animVal;
  [SameObject]
  readonly attribute SVGTransformList baseVal;
};

[Exposed=Window]
interface SVGCircleElement : SVGGeometryElement {
  [SameObject]
  readonly attribute SVGAnimatedLength cx;
  [SameObject]
  readonly attribute SVGAnimatedLength cy;
  [SameObject]
  readonly attribute SVGAnimatedLength r;
};

[Exposed=Window]
interface SVGDefsElement : SVGGraphicsElement {
};

[Exposed=Window]
interface SVGDescElement : SVGElement {
};

[Exposed=Window]
interface SVGElement : Element {
  [SameObject]
  readonly attribute SVGAnimatedString className;
  readonly attribute SVGSVGElement? ownerSVGElement;
  readonly attribute SVGElement? viewportElement;
};

[Exposed=Window]
interface SVGEllipseElement : SVGGeometryElement {
  [SameObject]
  readonly attribute SVGAnimatedLength cx;
  [SameObject]
  readonly attribute SVGAnimatedLength cy;
  [SameObject]
  readonly attribute SVGAnimatedLength rx;
  [SameObject]
  readonly attribute SVGAnimatedLength ry;
};

[Exposed=Window]
interface SVGForeignObjectElement : SVGGraphicsElement {
  [SameObject]
  readonly attribute SVGAnimatedLength height;
  [SameObject]
  readonly attribute SVGAnimatedLength width;
  [SameObject]
  readonly attribute SVGAnimatedLength x;
  [SameObject]
  readonly attribute SVGAnimatedLength y;
};

[Exposed=Window]
interface SVGGElement : SVGGraphicsElement {
};

[Exposed=Window]
interface SVGGeometryElement : SVGGraphicsElement {
  [SameObject]
  readonly attribute SVGAnimatedNumber pathLength;
  DOMPoint getPointAtLength( float distance );
  float getTotalLength();
  boolean isPointInFill( optional DOMPointInit point );
  boolean isPointInStroke( optional DOMPointInit point );
};

[Exposed=Window]
interface SVGGradientElement : SVGElement {
  const unsigned short SVG_SPREADMETHOD_PAD = 1;
  const unsigned short SVG_SPREADMETHOD_REFLECT = 2;
  const unsigned short SVG_SPREADMETHOD_REPEAT = 3;
  const unsigned short SVG_SPREADMETHOD_UNKNOWN = 0;
  [SameObject]
  readonly attribute SVGAnimatedTransformList gradientTransform;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration gradientUnits;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration spreadMethod;
};

interface SVGGraphicsElement : SVGElement {
  [SameObject]
  readonly attribute SVGAnimatedTransformList transform;
  DOMRect getBBox( optional SVGBoundingBoxOptions options );
  DOMMatrix? getCTM();
  DOMMatrix? getScreenCTM();
};

[Exposed=Window]
interface SVGImageElement : SVGGraphicsElement {
  [SameObject]
  readonly attribute SVGAnimatedLength height;
  [SameObject]
  readonly attribute SVGAnimatedPreserveAspectRatio preserveAspectRatio;
  [SameObject]
  readonly attribute SVGAnimatedLength width;
  [SameObject]
  readonly attribute SVGAnimatedLength x;
  [SameObject]
  readonly attribute SVGAnimatedLength y;
  attribute DOMString? crossOrigin;
};

[Exposed=Window]
interface SVGLength {
  const unsigned short SVG_LENGTHTYPE_CM = 6;
  const unsigned short SVG_LENGTHTYPE_EMS = 3;
  const unsigned short SVG_LENGTHTYPE_EXS = 4;
  const unsigned short SVG_LENGTHTYPE_IN = 8;
  const unsigned short SVG_LENGTHTYPE_MM = 7;
  const unsigned short SVG_LENGTHTYPE_NUMBER = 1;
  const unsigned short SVG_LENGTHTYPE_PC = 10;
  const unsigned short SVG_LENGTHTYPE_PERCENTAGE = 2;
  const unsigned short SVG_LENGTHTYPE_PT = 9;
  const unsigned short SVG_LENGTHTYPE_PX = 5;
  const unsigned short SVG_LENGTHTYPE_UNKNOWN = 0;
  readonly attribute unsigned short unitType;
  attribute float value;
  attribute DOMString valueAsString;
  attribute float valueInSpecifiedUnits;
  void convertToSpecifiedUnits( unsigned short unitType );
  void newValueSpecifiedUnits( unsigned short unitType, float valueInSpecifiedUnits );
};

[Exposed=Window]
interface SVGLengthList {
  readonly attribute unsigned long length;
  readonly attribute unsigned long numberOfItems;
  SVGLength appendItem( SVGLength newItem );
  void clear();
  SVGLength initialize( SVGLength newItem );
  SVGLength insertItemBefore( SVGLength newItem, unsigned long index );
  SVGLength removeItem( unsigned long index );
  SVGLength replaceItem( SVGLength newItem, unsigned long index );
  getter SVGLength getItem( unsigned long index );
  setter void ( unsigned long index, SVGLength newItem );
};

[Exposed=Window]
interface SVGLineElement : SVGGeometryElement {
  [SameObject]
  readonly attribute SVGAnimatedLength x1;
  [SameObject]
  readonly attribute SVGAnimatedLength x2;
  [SameObject]
  readonly attribute SVGAnimatedLength y1;
  [SameObject]
  readonly attribute SVGAnimatedLength y2;
};

[Exposed=Window]
interface SVGLinearGradientElement : SVGGradientElement {
  [SameObject]
  readonly attribute SVGAnimatedLength x1;
  [SameObject]
  readonly attribute SVGAnimatedLength x2;
  [SameObject]
  readonly attribute SVGAnimatedLength y1;
  [SameObject]
  readonly attribute SVGAnimatedLength y2;
};

[Exposed=Window]
interface SVGMarkerElement : SVGElement {
  const unsigned short SVG_MARKERUNITS_STROKEWIDTH = 2;
  const unsigned short SVG_MARKERUNITS_UNKNOWN = 0;
  const unsigned short SVG_MARKERUNITS_USERSPACEONUSE = 1;
  const unsigned short SVG_MARKER_ORIENT_ANGLE = 2;
  const unsigned short SVG_MARKER_ORIENT_AUTO = 1;
  const unsigned short SVG_MARKER_ORIENT_UNKNOWN = 0;
  [SameObject]
  readonly attribute SVGAnimatedLength markerHeight;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration markerUnits;
  [SameObject]
  readonly attribute SVGAnimatedLength markerWidth;
  [SameObject]
  readonly attribute SVGAnimatedAngle orientAngle;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration orientType;
  [SameObject]
  readonly attribute SVGAnimatedLength refX;
  [SameObject]
  readonly attribute SVGAnimatedLength refY;
  attribute DOMString orient;
  void setOrientToAngle( SVGAngle angle );
  void setOrientToAuto();
};

[Exposed=Window]
interface SVGMetadataElement : SVGElement {
};

[Exposed=Window]
interface SVGNumber {
  attribute float value;
};

[Exposed=Window]
interface SVGNumberList {
  readonly attribute unsigned long length;
  readonly attribute unsigned long numberOfItems;
  SVGNumber appendItem( SVGNumber newItem );
  void clear();
  SVGNumber initialize( SVGNumber newItem );
  SVGNumber insertItemBefore( SVGNumber newItem, unsigned long index );
  SVGNumber removeItem( unsigned long index );
  SVGNumber replaceItem( SVGNumber newItem, unsigned long index );
  getter SVGNumber getItem( unsigned long index );
  setter void ( unsigned long index, SVGNumber newItem );
};

[Exposed=Window]
interface SVGPathElement : SVGGeometryElement {
};

[Exposed=Window]
interface SVGPatternElement : SVGElement {
  [SameObject]
  readonly attribute SVGAnimatedLength height;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration patternContentUnits;
  [SameObject]
  readonly attribute SVGAnimatedTransformList patternTransform;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration patternUnits;
  [SameObject]
  readonly attribute SVGAnimatedLength width;
  [SameObject]
  readonly attribute SVGAnimatedLength x;
  [SameObject]
  readonly attribute SVGAnimatedLength y;
};

[Exposed=Window]
interface SVGPointList {
  readonly attribute unsigned long length;
  readonly attribute unsigned long numberOfItems;
  DOMPoint appendItem( DOMPoint newItem );
  void clear();
  DOMPoint initialize( DOMPoint newItem );
  DOMPoint insertItemBefore( DOMPoint newItem, unsigned long index );
  DOMPoint removeItem( unsigned long index );
  DOMPoint replaceItem( DOMPoint newItem, unsigned long index );
  getter DOMPoint getItem( unsigned long index );
  setter void ( unsigned long index, DOMPoint newItem );
};

[Exposed=Window]
interface SVGPolygonElement : SVGGeometryElement {
};

[Exposed=Window]
interface SVGPolylineElement : SVGGeometryElement {
};

[Exposed=Window]
interface SVGPreserveAspectRatio {
  const unsigned short SVG_MEETORSLICE_MEET = 1;
  const unsigned short SVG_MEETORSLICE_SLICE = 2;
  const unsigned short SVG_MEETORSLICE_UNKNOWN = 0;
  const unsigned short SVG_PRESERVEASPECTRATIO_NONE = 1;
  const unsigned short SVG_PRESERVEASPECTRATIO_UNKNOWN = 0;
  const unsigned short SVG_PRESERVEASPECTRATIO_XMAXYMAX = 10;
  const unsigned short SVG_PRESERVEASPECTRATIO_XMAXYMID = 7;
  const unsigned short SVG_PRESERVEASPECTRATIO_XMAXYMIN = 4;
  const unsigned short SVG_PRESERVEASPECTRATIO_XMIDYMAX = 9;
  const unsigned short SVG_PRESERVEASPECTRATIO_XMIDYMID = 6;
  const unsigned short SVG_PRESERVEASPECTRATIO_XMIDYMIN = 3;
  const unsigned short SVG_PRESERVEASPECTRATIO_XMINYMAX = 8;
  const unsigned short SVG_PRESERVEASPECTRATIO_XMINYMID = 5;
  const unsigned short SVG_PRESERVEASPECTRATIO_XMINYMIN = 2;
  attribute unsigned short align;
  attribute unsigned short meetOrSlice;
};

[Exposed=Window]
interface SVGRadialGradientElement : SVGGradientElement {
  [SameObject]
  readonly attribute SVGAnimatedLength cx;
  [SameObject]
  readonly attribute SVGAnimatedLength cy;
  [SameObject]
  readonly attribute SVGAnimatedLength fr;
  [SameObject]
  readonly attribute SVGAnimatedLength fx;
  [SameObject]
  readonly attribute SVGAnimatedLength fy;
  [SameObject]
  readonly attribute SVGAnimatedLength r;
};

[Exposed=Window]
interface SVGRectElement : SVGGeometryElement {
  [SameObject]
  readonly attribute SVGAnimatedLength height;
  [SameObject]
  readonly attribute SVGAnimatedLength rx;
  [SameObject]
  readonly attribute SVGAnimatedLength ry;
  [SameObject]
  readonly attribute SVGAnimatedLength width;
  [SameObject]
  readonly attribute SVGAnimatedLength x;
  [SameObject]
  readonly attribute SVGAnimatedLength y;
};

[Exposed=Window]
interface SVGSVGElement : SVGGraphicsElement {
  [SameObject]
  readonly attribute DOMPointReadOnly currentTranslate;
  [SameObject]
  readonly attribute SVGAnimatedLength height;
  [SameObject]
  readonly attribute SVGAnimatedLength width;
  [SameObject]
  readonly attribute SVGAnimatedLength x;
  [SameObject]
  readonly attribute SVGAnimatedLength y;
  attribute float currentScale;
  boolean checkEnclosure( SVGElement element, DOMRectReadOnly rect );
  boolean checkIntersection( SVGElement element, DOMRectReadOnly rect );
  SVGAngle createSVGAngle();
  SVGLength createSVGLength();
  DOMMatrix createSVGMatrix();
  SVGNumber createSVGNumber();
  DOMPoint createSVGPoint();
  DOMRect createSVGRect();
  SVGTransform createSVGTransform();
  SVGTransform createSVGTransformFromMatrix( DOMMatrixReadOnly matrix );
  void deselectAll();
  void forceRedraw();
  Element getElementById( DOMString elementId );
  NodeList getEnclosureList( DOMRectReadOnly rect, SVGElement? referenceElement );
  NodeList getIntersectionList( DOMRectReadOnly rect, SVGElement? referenceElement );
  unsigned long suspendRedraw( unsigned long maxWaitMilliseconds );
  void unsuspendRedraw( unsigned long suspendHandleID );
  void unsuspendRedrawAll();
};

[Exposed=Window]
interface SVGScriptElement : SVGElement {
  attribute DOMString? crossOrigin;
  attribute DOMString type;
};

[Exposed=Window]
interface SVGStopElement : SVGElement {
  [SameObject]
  readonly attribute SVGAnimatedNumber offset;
};

[Exposed=Window]
interface SVGStringList {
  readonly attribute unsigned long length;
  readonly attribute unsigned long numberOfItems;
  DOMString appendItem( DOMString newItem );
  void clear();
  DOMString initialize( DOMString newItem );
  DOMString insertItemBefore( DOMString newItem, unsigned long index );
  DOMString removeItem( unsigned long index );
  DOMString replaceItem( DOMString newItem, unsigned long index );
  getter DOMString getItem( unsigned long index );
  setter void ( unsigned long index, DOMString newItem );
};

[Exposed=Window]
interface SVGStyleElement : SVGElement {
  attribute DOMString media;
  attribute DOMString title;
  attribute DOMString type;
};

[Exposed=Window]
interface SVGSwitchElement : SVGGraphicsElement {
};

[Exposed=Window]
interface SVGSymbolElement : SVGGraphicsElement {
};

[Exposed=Window]
interface SVGTSpanElement : SVGTextPositioningElement {
};

[Exposed=Window]
interface SVGTextContentElement : SVGGraphicsElement {
  const unsigned short LENGTHADJUST_SPACING = 1;
  const unsigned short LENGTHADJUST_SPACINGANDGLYPHS = 2;
  const unsigned short LENGTHADJUST_UNKNOWN = 0;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration lengthAdjust;
  [SameObject]
  readonly attribute SVGAnimatedLength textLength;
  long getCharNumAtPosition( optional DOMPointInit point );
  float getComputedTextLength();
  DOMPoint getEndPositionOfChar( unsigned long charnum );
  DOMRect getExtentOfChar( unsigned long charnum );
  long getNumberOfChars();
  float getRotationOfChar( unsigned long charnum );
  DOMPoint getStartPositionOfChar( unsigned long charnum );
  float getSubStringLength( unsigned long charnum, unsigned long nchars );
  void selectSubString( unsigned long charnum, unsigned long nchars );
};

[Exposed=Window]
interface SVGTextElement : SVGTextPositioningElement {
};

[Exposed=Window]
interface SVGTextPathElement : SVGTextContentElement {
  const unsigned short TEXTPATH_METHODTYPE_ALIGN = 1;
  const unsigned short TEXTPATH_METHODTYPE_STRETCH = 2;
  const unsigned short TEXTPATH_METHODTYPE_UNKNOWN = 0;
  const unsigned short TEXTPATH_SPACINGTYPE_AUTO = 1;
  const unsigned short TEXTPATH_SPACINGTYPE_EXACT = 2;
  const unsigned short TEXTPATH_SPACINGTYPE_UNKNOWN = 0;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration method;
  [SameObject]
  readonly attribute SVGAnimatedEnumeration spacing;
  [SameObject]
  readonly attribute SVGAnimatedLength startOffset;
};

[Exposed=Window]
interface SVGTextPositioningElement : SVGTextContentElement {
  [SameObject]
  readonly attribute SVGAnimatedLengthList dx;
  [SameObject]
  readonly attribute SVGAnimatedLengthList dy;
  [SameObject]
  readonly attribute SVGAnimatedNumberList rotate;
  [SameObject]
  readonly attribute SVGAnimatedLengthList x;
  [SameObject]
  readonly attribute SVGAnimatedLengthList y;
};

[Exposed=Window]
interface SVGTitleElement : SVGElement {
};

[Exposed=Window]
interface SVGTransform {
  const unsigned short SVG_TRANSFORM_MATRIX = 1;
  const unsigned short SVG_TRANSFORM_ROTATE = 4;
  const unsigned short SVG_TRANSFORM_SCALE = 3;
  const unsigned short SVG_TRANSFORM_SKEWX = 5;
  const unsigned short SVG_TRANSFORM_SKEWY = 6;
  const unsigned short SVG_TRANSFORM_TRANSLATE = 2;
  const unsigned short SVG_TRANSFORM_UNKNOWN = 0;
  readonly attribute float angle;
  [SameObject]
  readonly attribute DOMMatrix matrix;
  readonly attribute unsigned short type;
  void setMatrix( DOMMatrixReadOnly matrix );
  void setRotate( float angle, float cx, float cy );
  void setScale( float sx, float sy );
  void setSkewX( float angle );
  void setSkewY( float angle );
  void setTranslate( float tx, float ty );
};

[Exposed=Window]
interface SVGTransformList {
  readonly attribute unsigned long length;
  readonly attribute unsigned long numberOfItems;
  SVGTransform appendItem( SVGTransform newItem );
  void clear();
  SVGTransform? consolidate();
  SVGTransform createSVGTransformFromMatrix( DOMMatrixReadOnly matrix );
  SVGTransform initialize( SVGTransform newItem );
  SVGTransform insertItemBefore( SVGTransform newItem, unsigned long index );
  SVGTransform removeItem( unsigned long index );
  SVGTransform replaceItem( SVGTransform newItem, unsigned long index );
  getter SVGTransform getItem( unsigned long index );
  setter void ( unsigned long index, SVGTransform newItem );
};

[Exposed=Window]
interface SVGUnitTypes {
  const unsigned short SVG_UNIT_TYPE_OBJECTBOUNDINGBOX = 2;
  const unsigned short SVG_UNIT_TYPE_UNKNOWN = 0;
  const unsigned short SVG_UNIT_TYPE_USERSPACEONUSE = 1;
};

[Exposed=Window]
interface SVGUnknownElement : SVGGraphicsElement {
};

[Exposed=Window]
interface SVGUseElement : SVGGraphicsElement {
  [SameObject]
  readonly attribute SVGElement? animatedInstanceRoot;
  [SameObject]
  readonly attribute SVGAnimatedLength height;
  [SameObject]
  readonly attribute SVGElement? instanceRoot;
  [SameObject]
  readonly attribute SVGAnimatedLength width;
  [SameObject]
  readonly attribute SVGAnimatedLength x;
  [SameObject]
  readonly attribute SVGAnimatedLength y;
};

[Exposed=Window]
interface SVGUseElementShadowRoot : ShadowRoot {
};

[Exposed=Window]
interface SVGViewElement : SVGElement {
};

[Constructor( Animation source, Animatable newTarget ), Exposed=Window]
interface ShadowAnimation : Animation {
  [SameObject]
  readonly attribute Animation sourceAnimation;
};

partial interface Document {
  readonly attribute SVGSVGElement? rootElement;
};

SVGAElement includes HTMLHyperlinkElementUtils;

SVGAElement includes SVGURIReference;

SVGElement includes DocumentAndElementEventHandlers;

SVGElement includes GlobalEventHandlers;

SVGElement includes HTMLOrSVGElement;

SVGElement includes SVGElementInstance;

SVGGradientElement includes SVGURIReference;

SVGGraphicsElement includes SVGTests;

SVGImageElement includes SVGURIReference;

SVGMarkerElement includes SVGFitToViewBox;

SVGPatternElement includes SVGFitToViewBox;

SVGPatternElement includes SVGURIReference;

SVGPolygonElement includes SVGAnimatedPoints;

SVGPolylineElement includes SVGAnimatedPoints;

SVGSVGElement includes SVGFitToViewBox;

SVGSVGElement includes SVGZoomAndPan;

SVGSVGElement includes WindowEventHandlers;

SVGScriptElement includes SVGURIReference;

SVGStyleElement includes LinkStyle;

SVGSymbolElement includes SVGFitToViewBox;

SVGTextPathElement includes SVGURIReference;

SVGUseElement includes SVGURIReference;

SVGViewElement includes SVGFitToViewBox;

SVGViewElement includes SVGZoomAndPan;
