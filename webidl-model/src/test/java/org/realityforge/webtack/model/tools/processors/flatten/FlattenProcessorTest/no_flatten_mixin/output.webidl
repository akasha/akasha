[NoFlatten]
interface mixin DocumentOrShadowRoot {
  readonly attribute Element? activeElement;
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
  [SameObject]
  readonly attribute StyleSheetList styleSheets;
  /**
   * Documentation attached to event from partial mixin.
   */
  event Event close;
  /**
   * Documentation attached to event from partial mixin.
   */
  event FocusEvent focus;
};

interface Event {
};

interface FocusEvent : Event {
};
