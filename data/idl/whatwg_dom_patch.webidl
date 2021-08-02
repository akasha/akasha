const enum EventPhase {
  Event.NONE,
  Event.CAPTURING_PHASE,
  Event.AT_TARGET,
  Event.BUBBLING_PHASE
};

const enum RangeCompareType {
  Range.START_TO_START,
  Range.START_TO_END,
  Range.END_TO_END,
  Range.END_TO_START
};

const enum XPathResultResultType {
  XPathResult.ANY_TYPE,
  XPathResult.STRING_TYPE,
  XPathResult.NUMBER_TYPE,
  XPathResult.BOOLEAN_TYPE,
  XPathResult.UNORDERED_NODE_ITERATOR_TYPE,
  XPathResult.ORDERED_NODE_ITERATOR_TYPE,
  XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,
  XPathResult.ORDERED_NODE_SNAPSHOT_TYPE,
  XPathResult.ANY_UNORDERED_NODE_TYPE,
  XPathResult.FIRST_ORDERED_NODE_TYPE
};

const enum NodeType {
  Node.ELEMENT_NODE,
  Node.ATTRIBUTE_NODE,
  Node.TEXT_NODE,
  Node.CDATA_SECTION_NODE,
  Node.ENTITY_REFERENCE_NODE,
  Node.ENTITY_NODE,
  Node.PROCESSING_INSTRUCTION_NODE,
  Node.COMMENT_NODE,
  Node.DOCUMENT_NODE,
  Node.DOCUMENT_TYPE_NODE,
  Node.DOCUMENT_FRAGMENT_NODE,
  Node.NOTATION_NODE
};

[JavaOnly, JsName=HTMLCollection]
interface HTMLReadOnlyOptionsCollection : HTMLCollection {
  getter HTMLOptionElement? item( unsigned long index );
  getter HTMLOptionElement? namedItem( DOMString name );
};
