dictionary SVGBoundingBoxOptions {
  boolean clipped = false;
  boolean fill = true;
  boolean markers = false;
  boolean stroke = false;
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
interface SVGElement : Element {
  [SameObject]
  readonly attribute SVGAnimatedString className;
  readonly attribute SVGSVGElement? ownerSVGElement;
  readonly attribute SVGElement? viewportElement;
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

interface SVGGraphicsElement : SVGElement {
  [SameObject]
  readonly attribute SVGAnimatedTransformList transform;
  DOMRect getBBox( optional SVGBoundingBoxOptions options );
  DOMMatrix? getCTM();
  DOMMatrix? getScreenCTM();
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
interface SVGUnitTypes {
  const unsigned short SVG_UNIT_TYPE_OBJECTBOUNDINGBOX = 2;
  const unsigned short SVG_UNIT_TYPE_UNKNOWN = 0;
  const unsigned short SVG_UNIT_TYPE_USERSPACEONUSE = 1;
};

SVGElement includes DocumentAndElementEventHandlers;

SVGElement includes GlobalEventHandlers;

SVGElement includes HTMLOrSVGElement;

SVGElement includes SVGElementInstance;

SVGGraphicsElement includes SVGTests;
