partial interface mixin DocumentOrShadowRoot {
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
};

partial interface Document {
  readonly attribute DocumentTimeline timeline;
  sequence<Animation> getAnimations();
};

partial interface Document {
  readonly attribute SVGSVGElement? rootElement;
};

partial interface mixin DocumentOrShadowRoot {
  readonly attribute SVGSVGElement? rootElement;
};

interface mixin DocumentOrShadowRoot {
};

Document includes DocumentOrShadowRoot;

[Exposed=Window]
interface Document : Node {
};
