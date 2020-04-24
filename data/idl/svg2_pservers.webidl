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
interface SVGStopElement : SVGElement {
  [SameObject]
  readonly attribute SVGAnimatedNumber offset;
};

SVGGradientElement includes SVGURIReference;

SVGPatternElement includes SVGFitToViewBox;

SVGPatternElement includes SVGURIReference;
