interface mixin InnerHTML {
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString innerHTML;
};

[Exposed=Window]
interface XMLSerializer {
  constructor();
  DOMString serializeToString( Node root );
};

partial interface Element {
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString outerHTML;
  [CEReactions]
  void insertAdjacentHTML( DOMString position, DOMString text );
};

partial interface Range {
  [CEReactions, NewObject]
  DocumentFragment createContextualFragment( DOMString fragment );
};

ShadowRoot includes InnerHTML;

Element includes InnerHTML;
