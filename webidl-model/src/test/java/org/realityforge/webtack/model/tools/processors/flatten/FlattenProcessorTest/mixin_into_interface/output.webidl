[Exposed=Window]
interface Document : Node {
  readonly attribute USVString URL;
  readonly attribute Element? activeElement;
  readonly attribute DOMString characterSet;
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
  [SameObject]
  readonly attribute StyleSheetList styleSheets;
  [NewObject]
  Range createRange();
  [NewObject]
  HTMLCollection getElementsByTagNameNS( DOMString? namespace, DOMString localName );
  [CEReactions, NewObject]
  Node importNode( Node node, optional boolean deep = false );
};
