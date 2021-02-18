partial interface mixin GlobalEventHandlers {
  attribute EventHandler onselectionchange;
  attribute EventHandler onselectstart;
};

[Exposed=Window]
interface Selection {
  readonly attribute Node? anchorNode;
  readonly attribute unsigned long anchorOffset;
  readonly attribute Node? focusNode;
  readonly attribute unsigned long focusOffset;
  readonly attribute boolean isCollapsed;
  readonly attribute unsigned long rangeCount;
  readonly attribute DOMString type;
  undefined addRange( Range range );
  undefined collapse( Node? node, optional unsigned long offset = 0 );
  undefined collapseToEnd();
  undefined collapseToStart();
  boolean containsNode( Node node, optional boolean allowPartialContainment = false );
  [CEReactions]
  undefined deleteFromDocument();
  undefined empty();
  undefined extend( Node node, optional unsigned long offset = 0 );
  Range getRangeAt( unsigned long index );
  undefined removeAllRanges();
  undefined removeRange( Range range );
  undefined selectAllChildren( Node node );
  undefined setBaseAndExtent( Node anchorNode, unsigned long anchorOffset, Node focusNode, unsigned long focusOffset );
  undefined setPosition( Node? node, optional unsigned long offset = 0 );
  stringifier;
};

partial interface Document {
  Selection? getSelection();
};

partial interface Window {
  Selection? getSelection();
};
