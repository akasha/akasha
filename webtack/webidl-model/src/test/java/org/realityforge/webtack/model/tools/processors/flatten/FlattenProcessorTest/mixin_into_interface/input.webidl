interface mixin DocumentOrShadowRoot {
  event BlurEvent blur;
};

partial interface mixin DocumentOrShadowRoot {
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
};

partial interface mixin DocumentOrShadowRoot {
  readonly attribute Element? activeElement;
  event Event close;
};

partial interface mixin DocumentOrShadowRoot {
  [SameObject]
  readonly attribute StyleSheetList styleSheets;
  /**
   * Documentation attached to event from partial mixin.
   */
  event FocusEvent focus;
};

interface BlurEvent : Event {
};

[Exposed=Window]
interface Document : Node {
  readonly attribute USVString URL;
  readonly attribute DOMString characterSet;
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

Document includes DocumentOrShadowRoot;
