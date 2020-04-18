enum FullscreenNavigationUI {
  "auto",
  "show",
  "hide"
};

dictionary FullscreenOptions {
  FullscreenNavigationUI navigationUI = "auto";
};

partial interface Element {
  Promise<void> requestFullscreen(optional FullscreenOptions options = {});

  attribute EventHandler onfullscreenchange;
  attribute EventHandler onfullscreenerror;
};

partial interface Document {
  [LenientSetter] readonly attribute boolean fullscreenEnabled;
  [LenientSetter, Unscopable] readonly attribute boolean fullscreen; // historical

  Promise<void> exitFullscreen();

  attribute EventHandler onfullscreenchange;
  attribute EventHandler onfullscreenerror;
};

partial interface mixin DocumentOrShadowRoot {
  [LenientSetter] readonly attribute Element? fullscreenElement;
};