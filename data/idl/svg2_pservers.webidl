[Exposed=Window]
interface SVGGradientElement : SVGElement {

  // Spread Method Types
  const unsigned short SVG_SPREADMETHOD_UNKNOWN = 0;
  const unsigned short SVG_SPREADMETHOD_PAD = 1;
  const unsigned short SVG_SPREADMETHOD_REFLECT = 2;
  const unsigned short SVG_SPREADMETHOD_REPEAT = 3;

  [SameObject] readonly attribute SVGAnimatedEnumeration gradientUnits;
  [SameObject] readonly attribute SVGAnimatedTransformList gradientTransform;
  [SameObject] readonly attribute SVGAnimatedEnumeration spreadMethod;
};

SVGGradientElement includes SVGURIReference;

[Exposed=Window]
interface SVGLinearGradientElement : SVGGradientElement {
  [SameObject] readonly attribute SVGAnimatedLength x1;
  [SameObject] readonly attribute SVGAnimatedLength y1;
  [SameObject] readonly attribute SVGAnimatedLength x2;
  [SameObject] readonly attribute SVGAnimatedLength y2;
};

[Exposed=Window]
interface SVGRadialGradientElement : SVGGradientElement {
  [SameObject] readonly attribute SVGAnimatedLength cx;
  [SameObject] readonly attribute SVGAnimatedLength cy;
  [SameObject] readonly attribute SVGAnimatedLength r;
  [SameObject] readonly attribute SVGAnimatedLength fx;
  [SameObject] readonly attribute SVGAnimatedLength fy;
  [SameObject] readonly attribute SVGAnimatedLength fr;
};

[Exposed=Window]
interface SVGStopElement : SVGElement {
  [SameObject] readonly attribute SVGAnimatedNumber offset;
};

[Exposed=Window]
interface SVGPatternElement : SVGElement {
  [SameObject] readonly attribute SVGAnimatedEnumeration patternUnits;
  [SameObject] readonly attribute SVGAnimatedEnumeration patternContentUnits;
  [SameObject] readonly attribute SVGAnimatedTransformList patternTransform;
  [SameObject] readonly attribute SVGAnimatedLength x;
  [SameObject] readonly attribute SVGAnimatedLength y;
  [SameObject] readonly attribute SVGAnimatedLength width;
  [SameObject] readonly attribute SVGAnimatedLength height;
};

SVGPatternElement includes SVGFitToViewBox;
SVGPatternElement includes SVGURIReference;