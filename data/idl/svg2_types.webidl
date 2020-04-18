[Exposed=Window]
interface SVGElement : Element {

  [SameObject] readonly attribute SVGAnimatedString className;

  readonly attribute SVGSVGElement? ownerSVGElement;
  readonly attribute SVGElement? viewportElement;
};

SVGElement includes GlobalEventHandlers;
SVGElement includes DocumentAndElementEventHandlers;
SVGElement includes SVGElementInstance;
SVGElement includes HTMLOrSVGElement;

dictionary SVGBoundingBoxOptions {
  boolean fill = true;
  boolean stroke = false;
  boolean markers = false;
  boolean clipped = false;
};

interface SVGGraphicsElement : SVGElement {
  [SameObject] readonly attribute SVGAnimatedTransformList transform;

  DOMRect getBBox(optional SVGBoundingBoxOptions options);
  DOMMatrix? getCTM();
  DOMMatrix? getScreenCTM();
};

SVGGraphicsElement includes SVGTests;

[Exposed=Window]
interface SVGGeometryElement : SVGGraphicsElement {
  [SameObject] readonly attribute SVGAnimatedNumber pathLength;

  boolean isPointInFill(optional DOMPointInit point);
  boolean isPointInStroke(optional DOMPointInit point);
  float getTotalLength();
  DOMPoint getPointAtLength(float distance);
};

[Exposed=Window]
interface SVGNumber {
  attribute float value;
};

[Exposed=Window]
interface SVGLength {

  // Length Unit Types
  const unsigned short SVG_LENGTHTYPE_UNKNOWN = 0;
  const unsigned short SVG_LENGTHTYPE_NUMBER = 1;
  const unsigned short SVG_LENGTHTYPE_PERCENTAGE = 2;
  const unsigned short SVG_LENGTHTYPE_EMS = 3;
  const unsigned short SVG_LENGTHTYPE_EXS = 4;
  const unsigned short SVG_LENGTHTYPE_PX = 5;
  const unsigned short SVG_LENGTHTYPE_CM = 6;
  const unsigned short SVG_LENGTHTYPE_MM = 7;
  const unsigned short SVG_LENGTHTYPE_IN = 8;
  const unsigned short SVG_LENGTHTYPE_PT = 9;
  const unsigned short SVG_LENGTHTYPE_PC = 10;

  readonly attribute unsigned short unitType;
           attribute float value;
           attribute float valueInSpecifiedUnits;
           attribute DOMString valueAsString;

  void newValueSpecifiedUnits(unsigned short unitType, float valueInSpecifiedUnits);
  void convertToSpecifiedUnits(unsigned short unitType);
};

[Exposed=Window]
interface SVGAngle {

  // Angle Unit Types
  const unsigned short SVG_ANGLETYPE_UNKNOWN = 0;
  const unsigned short SVG_ANGLETYPE_UNSPECIFIED = 1;
  const unsigned short SVG_ANGLETYPE_DEG = 2;
  const unsigned short SVG_ANGLETYPE_RAD = 3;
  const unsigned short SVG_ANGLETYPE_GRAD = 4;

  readonly attribute unsigned short unitType;
           attribute float value;
           attribute float valueInSpecifiedUnits;
           attribute DOMString valueAsString;

  void newValueSpecifiedUnits(unsigned short unitType, float valueInSpecifiedUnits);
  void convertToSpecifiedUnits(unsigned short unitType);
};

[Exposed=Window]
interface SVGNumberList {

  readonly attribute unsigned long length;
  readonly attribute unsigned long numberOfItems;

  void clear();
  SVGNumber initialize(SVGNumber newItem);
  getter SVGNumber getItem(unsigned long index);
  SVGNumber insertItemBefore(SVGNumber newItem, unsigned long index);
  SVGNumber replaceItem(SVGNumber newItem, unsigned long index);
  SVGNumber removeItem(unsigned long index);
  SVGNumber appendItem(SVGNumber newItem);
  setter void (unsigned long index, SVGNumber newItem);
};

[Exposed=Window]
interface SVGLengthList {

  readonly attribute unsigned long length;
  readonly attribute unsigned long numberOfItems;

  void clear();
  SVGLength initialize(SVGLength newItem);
  getter SVGLength getItem(unsigned long index);
  SVGLength insertItemBefore(SVGLength newItem, unsigned long index);
  SVGLength replaceItem(SVGLength newItem, unsigned long index);
  SVGLength removeItem(unsigned long index);
  SVGLength appendItem(SVGLength newItem);
  setter void (unsigned long index, SVGLength newItem);
};

[Exposed=Window]
interface SVGStringList {

  readonly attribute unsigned long length;
  readonly attribute unsigned long numberOfItems;

  void clear();
  DOMString initialize(DOMString newItem);
  getter DOMString getItem(unsigned long index);
  DOMString insertItemBefore(DOMString newItem, unsigned long index);
  DOMString replaceItem(DOMString newItem, unsigned long index);
  DOMString removeItem(unsigned long index);
  DOMString appendItem(DOMString newItem);
  setter void (unsigned long index, DOMString newItem);
};

[Exposed=Window]
interface SVGAnimatedBoolean {
           attribute boolean baseVal;
  readonly attribute boolean animVal;
};

[Exposed=Window]
interface SVGAnimatedEnumeration {
           attribute unsigned short baseVal;
  readonly attribute unsigned short animVal;
};

[Exposed=Window]
interface SVGAnimatedInteger {
           attribute long baseVal;
  readonly attribute long animVal;
};

[Exposed=Window]
interface SVGAnimatedNumber {
           attribute float baseVal;
  readonly attribute float animVal;
};

[Exposed=Window]
interface SVGAnimatedLength {
  [SameObject] readonly attribute SVGLength baseVal;
  [SameObject] readonly attribute SVGLength animVal;
};

[Exposed=Window]
interface SVGAnimatedAngle {
  [SameObject] readonly attribute SVGAngle baseVal;
  [SameObject] readonly attribute SVGAngle animVal;
};

[Exposed=Window]
interface SVGAnimatedString {
           attribute DOMString baseVal;
  readonly attribute DOMString animVal;
};

[Exposed=Window]
interface SVGAnimatedRect {
  [SameObject] readonly attribute DOMRect baseVal;
  [SameObject] readonly attribute DOMRectReadOnly animVal;
};

[Exposed=Window]
interface SVGAnimatedNumberList {
  [SameObject] readonly attribute SVGNumberList baseVal;
  [SameObject] readonly attribute SVGNumberList animVal;
};

[Exposed=Window]
interface SVGAnimatedLengthList {
  [SameObject] readonly attribute SVGLengthList baseVal;
  [SameObject] readonly attribute SVGLengthList animVal;
};

[Exposed=Window]
interface SVGUnitTypes {
  // Unit Types
  const unsigned short SVG_UNIT_TYPE_UNKNOWN = 0;
  const unsigned short SVG_UNIT_TYPE_USERSPACEONUSE = 1;
  const unsigned short SVG_UNIT_TYPE_OBJECTBOUNDINGBOX = 2;
};

interface mixin SVGTests {
  [SameObject] readonly attribute SVGStringList requiredExtensions;
  [SameObject] readonly attribute SVGStringList systemLanguage;
};

interface mixin SVGFitToViewBox {
  [SameObject] readonly attribute SVGAnimatedRect viewBox;
  [SameObject] readonly attribute SVGAnimatedPreserveAspectRatio preserveAspectRatio;
};

interface mixin SVGZoomAndPan {

  // Zoom and Pan Types
  const unsigned short SVG_ZOOMANDPAN_UNKNOWN = 0;
  const unsigned short SVG_ZOOMANDPAN_DISABLE = 1;
  const unsigned short SVG_ZOOMANDPAN_MAGNIFY = 2;

  attribute unsigned short zoomAndPan;
};

interface mixin SVGURIReference {
  [SameObject] readonly attribute SVGAnimatedString href;
};