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
  void addRange( Range range );
  void collapse( Node? node, optional unsigned long offset = 0 );
  void collapseToEnd();
  void collapseToStart();
  boolean containsNode( Node node, optional boolean allowPartialContainment = false );
  [CEReactions]
  void deleteFromDocument();
  void empty();
  void extend( Node node, optional unsigned long offset = 0 );
  Range getRangeAt( unsigned long index );
  void removeAllRanges();
  void removeRange( Range range );
  void selectAllChildren( Node node );
  void setBaseAndExtent( Node anchorNode, unsigned long anchorOffset, Node focusNode, unsigned long focusOffset );
  void setPosition( Node? node, optional unsigned long offset = 0 );
  stringifier;
};

partial interface Window {
  Selection? getSelection();
};

partial interface Document {
  Selection? getSelection();
};
