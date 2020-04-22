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

SVGMarkerElement includes SVGFitToViewBox;
