[Exposed=Window]
interface SVGClipPathElement : SVGElement {
  readonly attribute SVGAnimatedEnumeration clipPathUnits;
  readonly attribute SVGAnimatedTransformList transform;
};

[Exposed=Window]
interface SVGMaskElement : SVGElement {
  readonly attribute SVGAnimatedLength height;
  readonly attribute SVGAnimatedEnumeration maskContentUnits;
  readonly attribute SVGAnimatedEnumeration maskUnits;
  readonly attribute SVGAnimatedLength width;
  readonly attribute SVGAnimatedLength x;
  readonly attribute SVGAnimatedLength y;
};
