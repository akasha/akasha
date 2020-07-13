partial interface mixin DocumentOrShadowRoot {
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
};

partial interface mixin DocumentOrShadowRoot {
  readonly attribute Element? activeElement;
};

partial interface mixin DocumentOrShadowRoot {
  [SameObject]
  readonly attribute StyleSheetList styleSheets;
};

interface mixin DocumentOrShadowRoot {
};
