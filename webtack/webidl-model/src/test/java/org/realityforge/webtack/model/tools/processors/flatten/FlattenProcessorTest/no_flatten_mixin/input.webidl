[NoFlatten]
interface mixin DocumentOrShadowRoot {
};

partial interface mixin DocumentOrShadowRoot {
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
  /**
   * Documentation attached to event from partial mixin.
   */
  event FocusEvent focus;
};

partial interface mixin DocumentOrShadowRoot {
  readonly attribute Element? activeElement;
  /**
   * Documentation attached to event from partial mixin.
   */
  event Event close;
};

partial interface mixin DocumentOrShadowRoot {
  [SameObject]
  readonly attribute StyleSheetList styleSheets;
};

interface Event {
};

interface FocusEvent : Event {
};
