interface mixin SVGAnimatedPoints {
  [SameObject]
  readonly attribute SVGPointList animatedPoints;
  [SameObject]
  readonly attribute SVGPointList points;
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
interface SVGCircleElement : SVGGeometryElement {
  [SameObject]
  readonly attribute SVGAnimatedLength cx;
  [SameObject]
  readonly attribute SVGAnimatedLength cy;
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
interface SVGPolylineElement : SVGGeometryElement {
};

[Exposed=Window]
interface SVGPolygonElement : SVGGeometryElement {
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

SVGPolylineElement includes SVGAnimatedPoints;

SVGPolygonElement includes SVGAnimatedPoints;
