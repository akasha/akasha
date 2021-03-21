interface BlurEvent : Event {
};

[Exposed=Window]
interface Document : Node {
  readonly attribute USVString URL;
  readonly attribute Element? activeElement;
  readonly attribute DOMString characterSet;
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
  [SameObject]
  readonly attribute StyleSheetList styleSheets;
  event BlurEvent blur;
  event Event close;
  /**
   * Documentation attached to event from partial mixin.
   */
  event FocusEvent focus;
  [NewObject]
  Range createRange();
  [NewObject]
  HTMLCollection getElementsByTagNameNS( DOMString? namespace, DOMString localName );
  [CEReactions, NewObject]
  Node importNode( Node node, optional boolean deep = false );
};

interface Event {
};

interface FocusEvent : Event {
};
