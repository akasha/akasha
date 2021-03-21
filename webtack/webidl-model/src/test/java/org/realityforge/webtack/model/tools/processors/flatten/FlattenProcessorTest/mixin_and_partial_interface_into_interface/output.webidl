[Exposed=Window]
interface Document : Node {
  readonly attribute USVString URL;
  readonly attribute Element? activeElement;
  readonly attribute DOMString characterSet;
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
  readonly attribute SVGSVGElement? rootElement;
  [SameObject]
  readonly attribute StyleSheetList styleSheets;
  readonly attribute DocumentTimeline timeline;
  [NewObject]
  Range createRange();
  sequence<Animation> getAnimations();
  [NewObject]
  HTMLCollection getElementsByTagNameNS( DOMString? namespace, DOMString localName );
  [CEReactions, NewObject]
  Node importNode( Node node, optional boolean deep = false );
};
