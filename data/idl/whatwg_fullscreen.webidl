enum FullscreenNavigationUI {
  "auto",
  "hide",
  "show"
};

dictionary FullscreenOptions {
  FullscreenNavigationUI navigationUI = "auto";
};

partial interface mixin DocumentOrShadowRoot {
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
};

partial interface Document {
  [LegacyLenientSetter, Unscopable]
  readonly attribute boolean fullscreen;
  [LegacyLenientSetter]
  readonly attribute boolean fullscreenEnabled;
  attribute EventHandler onfullscreenchange;
  attribute EventHandler onfullscreenerror;
  Promise<undefined> exitFullscreen();
};

partial interface Element {
  attribute EventHandler onfullscreenchange;
  attribute EventHandler onfullscreenerror;
  Promise<undefined> requestFullscreen( optional FullscreenOptions options = {} );
};
