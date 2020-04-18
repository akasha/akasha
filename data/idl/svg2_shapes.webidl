[Exposed=Window]
interface SVGRectElement : SVGGeometryElement {
  [SameObject] readonly attribute SVGAnimatedLength x;
  [SameObject] readonly attribute SVGAnimatedLength y;
  [SameObject] readonly attribute SVGAnimatedLength width;
  [SameObject] readonly attribute SVGAnimatedLength height;
  [SameObject] readonly attribute SVGAnimatedLength rx;
  [SameObject] readonly attribute SVGAnimatedLength ry;
};

[Exposed=Window]
interface SVGCircleElement : SVGGeometryElement {
  [SameObject] readonly attribute SVGAnimatedLength cx;
  [SameObject] readonly attribute SVGAnimatedLength cy;
  [SameObject] readonly attribute SVGAnimatedLength r;
};

[Exposed=Window]
interface SVGEllipseElement : SVGGeometryElement {
  [SameObject] readonly attribute SVGAnimatedLength cx;
  [SameObject] readonly attribute SVGAnimatedLength cy;
  [SameObject] readonly attribute SVGAnimatedLength rx;
  [SameObject] readonly attribute SVGAnimatedLength ry;
};

[Exposed=Window]
interface SVGLineElement : SVGGeometryElement {
  [SameObject] readonly attribute SVGAnimatedLength x1;
  [SameObject] readonly attribute SVGAnimatedLength y1;
  [SameObject] readonly attribute SVGAnimatedLength x2;
  [SameObject] readonly attribute SVGAnimatedLength y2;
};

interface mixin SVGAnimatedPoints {
  [SameObject] readonly attribute SVGPointList points;
  [SameObject] readonly attribute SVGPointList animatedPoints;
};

[Exposed=Window]
interface SVGPointList {

  readonly attribute unsigned long length;
  readonly attribute unsigned long numberOfItems;

  void clear();
  DOMPoint initialize(DOMPoint newItem);
  getter DOMPoint getItem(unsigned long index);
  DOMPoint insertItemBefore(DOMPoint newItem, unsigned long index);
  DOMPoint replaceItem(DOMPoint newItem, unsigned long index);
  DOMPoint removeItem(unsigned long index);
  DOMPoint appendItem(DOMPoint newItem);
  setter void (unsigned long index, DOMPoint newItem);
};

[Exposed=Window]
interface SVGPolylineElement : SVGGeometryElement {
};

SVGPolylineElement includes SVGAnimatedPoints;

[Exposed=Window]
interface SVGPolygonElement : SVGGeometryElement {
};

SVGPolygonElement includes SVGAnimatedPoints;