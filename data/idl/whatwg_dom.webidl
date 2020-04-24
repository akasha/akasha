enum ShadowRootMode {
  "closed",
  "open"
};

callback MutationCallback = void ( sequence<MutationRecord> mutations, MutationObserver observer );

callback interface EventListener {
  void handleEvent( Event event );
};

[Exposed=Window]
callback interface NodeFilter {
  const unsigned short FILTER_ACCEPT = 1;
  const unsigned short FILTER_REJECT = 2;
  const unsigned short FILTER_SKIP = 3;
  const unsigned long SHOW_ALL = 0xFFFFFFFF;
  const unsigned long SHOW_ATTRIBUTE = 0x2;
  const unsigned long SHOW_CDATA_SECTION = 0x8;
  const unsigned long SHOW_COMMENT = 0x80;
  const unsigned long SHOW_DOCUMENT = 0x100;
  const unsigned long SHOW_DOCUMENT_FRAGMENT = 0x400;
  const unsigned long SHOW_DOCUMENT_TYPE = 0x200;
  const unsigned long SHOW_ELEMENT = 0x1;
  const unsigned long SHOW_ENTITY = 0x20;
  const unsigned long SHOW_ENTITY_REFERENCE = 0x10;
  const unsigned long SHOW_NOTATION = 0x800;
  const unsigned long SHOW_PROCESSING_INSTRUCTION = 0x40;
  const unsigned long SHOW_TEXT = 0x4;
  unsigned short acceptNode( Node node );
};

callback interface XPathNSResolver {
  DOMString? lookupNamespaceURI( DOMString? prefix );
};

dictionary AddEventListenerOptions : EventListenerOptions {
  boolean once = false;
  boolean passive = false;
};

dictionary CustomEventInit : EventInit {
  any detail = null;
};

dictionary ElementCreationOptions {
  DOMString is;
};

dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

dictionary EventListenerOptions {
  boolean capture = false;
};

dictionary GetRootNodeOptions {
  boolean composed = false;
};

dictionary MutationObserverInit {
  sequence<DOMString> attributeFilter;
  boolean attributeOldValue;
  boolean attributes;
  boolean characterData;
  boolean characterDataOldValue;
  boolean childList = false;
  boolean subtree = false;
};

dictionary ShadowRootInit {
  boolean delegatesFocus = false;
  required ShadowRootMode mode;
};

dictionary StaticRangeInit {
  required Node endContainer;
  required unsigned long endOffset;
  required Node startContainer;
  required unsigned long startOffset;
};

interface mixin ChildNode {
  [CEReactions, Unscopable]
  void after( ( Node or DOMString )... nodes );
  [CEReactions, Unscopable]
  void before( ( Node or DOMString )... nodes );
  [CEReactions, Unscopable]
  void remove();
  [CEReactions, Unscopable]
  void replaceWith( ( Node or DOMString )... nodes );
};

interface mixin DocumentOrShadowRoot {
};

interface mixin NonDocumentTypeChildNode {
  readonly attribute Element? nextElementSibling;
  readonly attribute Element? previousElementSibling;
};

interface mixin NonElementParentNode {
  Element? getElementById( DOMString elementId );
};

interface mixin ParentNode {
  readonly attribute unsigned long childElementCount;
  [SameObject]
  readonly attribute HTMLCollection children;
  readonly attribute Element? firstElementChild;
  readonly attribute Element? lastElementChild;
  [CEReactions, Unscopable]
  void append( ( Node or DOMString )... nodes );
  [CEReactions, Unscopable]
  void prepend( ( Node or DOMString )... nodes );
  Element? querySelector( DOMString selectors );
  [NewObject]
  NodeList querySelectorAll( DOMString selectors );
  [CEReactions, Unscopable]
  void replaceChildren( ( Node or DOMString )... nodes );
};

interface mixin Slottable {
  readonly attribute HTMLSlotElement? assignedSlot;
};

interface mixin XPathEvaluatorBase {
  [NewObject]
  XPathExpression createExpression( DOMString expression, optional XPathNSResolver? resolver = null );
  XPathNSResolver createNSResolver( Node nodeResolver );
  XPathResult evaluate( DOMString expression, Node contextNode, optional XPathNSResolver? resolver = null, optional unsigned short type = 0, optional XPathResult? result = null );
};

[Exposed=(Window,Worker)]
interface AbortController {
  [SameObject]
  readonly attribute AbortSignal signal;
  constructor();
  void abort();
};

[Exposed=(Window,Worker)]
interface AbortSignal : EventTarget {
  readonly attribute boolean aborted;
  attribute EventHandler onabort;
};

[Exposed=Window]
interface AbstractRange {
  readonly attribute boolean collapsed;
  readonly attribute Node endContainer;
  readonly attribute unsigned long endOffset;
  readonly attribute Node startContainer;
  readonly attribute unsigned long startOffset;
};

[Exposed=Window]
interface Attr : Node {
  readonly attribute DOMString localName;
  readonly attribute DOMString name;
  readonly attribute DOMString? namespaceURI;
  readonly attribute Element? ownerElement;
  readonly attribute DOMString? prefix;
  readonly attribute boolean specified;
  [CEReactions]
  attribute DOMString value;
};

[Exposed=Window]
interface CDATASection : Text {
};

[Exposed=Window]
interface CharacterData : Node {
  readonly attribute unsigned long length;
  attribute [LegacyNullToEmptyString] DOMString data;
  void appendData( DOMString data );
  void deleteData( unsigned long offset, unsigned long count );
  void insertData( unsigned long offset, DOMString data );
  void replaceData( unsigned long offset, unsigned long count, DOMString data );
  DOMString substringData( unsigned long offset, unsigned long count );
};

[Exposed=Window]
interface Comment : CharacterData {
  constructor( optional DOMString data = "" );
};

[Exposed=(Window,Worker)]
interface CustomEvent : Event {
  readonly attribute any detail;
  constructor( DOMString type, optional CustomEventInit eventInitDict = {} );
  void initCustomEvent( DOMString type, optional boolean bubbles = false, optional boolean cancelable = false, optional any detail = null );
};

[Exposed=Window]
interface DOMImplementation {
  [NewObject]
  XMLDocument createDocument( DOMString? namespace, [LegacyNullToEmptyString] DOMString qualifiedName, optional DocumentType? doctype = null );
  [NewObject]
  DocumentType createDocumentType( DOMString qualifiedName, DOMString publicId, DOMString systemId );
  [NewObject]
  Document createHTMLDocument( optional DOMString title );
  boolean hasFeature();
};

[Exposed=Window]
interface DOMTokenList {
  iterable<DOMString>;
  readonly attribute unsigned long length;
  [CEReactions]
  stringifier attribute DOMString value;
  [CEReactions]
  void add( DOMString... tokens );
  boolean contains( DOMString token );
  [CEReactions]
  void remove( DOMString... tokens );
  [CEReactions]
  boolean replace( DOMString token, DOMString newToken );
  boolean supports( DOMString token );
  [CEReactions]
  boolean toggle( DOMString token, optional boolean force );
  getter DOMString? item( unsigned long index );
};

[Exposed=Window]
interface Document : Node {
  readonly attribute USVString URL;
  readonly attribute DOMString characterSet;
  readonly attribute DOMString charset;
  readonly attribute DOMString compatMode;
  readonly attribute DOMString contentType;
  readonly attribute DocumentType? doctype;
  readonly attribute Element? documentElement;
  readonly attribute USVString documentURI;
  [SameObject]
  readonly attribute DOMImplementation implementation;
  readonly attribute DOMString inputEncoding;
  constructor();
  [CEReactions]
  Node adoptNode( Node node );
  [NewObject]
  Attr createAttribute( DOMString localName );
  [NewObject]
  Attr createAttributeNS( DOMString? namespace, DOMString qualifiedName );
  [NewObject]
  CDATASection createCDATASection( DOMString data );
  [NewObject]
  Comment createComment( DOMString data );
  [NewObject]
  DocumentFragment createDocumentFragment();
  [CEReactions, NewObject]
  Element createElement( DOMString localName, optional ( DOMString or ElementCreationOptions ) options = {} );
  [CEReactions, NewObject]
  Element createElementNS( DOMString? namespace, DOMString qualifiedName, optional ( DOMString or ElementCreationOptions ) options = {} );
  [NewObject]
  Event createEvent( DOMString interface );
  [NewObject]
  NodeIterator createNodeIterator( Node root, optional unsigned long whatToShow = 0xFFFFFFFF, optional NodeFilter? filter = null );
  [NewObject]
  ProcessingInstruction createProcessingInstruction( DOMString target, DOMString data );
  [NewObject]
  Range createRange();
  [NewObject]
  Text createTextNode( DOMString data );
  [NewObject]
  TreeWalker createTreeWalker( Node root, optional unsigned long whatToShow = 0xFFFFFFFF, optional NodeFilter? filter = null );
  HTMLCollection getElementsByClassName( DOMString classNames );
  HTMLCollection getElementsByTagName( DOMString qualifiedName );
  HTMLCollection getElementsByTagNameNS( DOMString? namespace, DOMString localName );
  [CEReactions, NewObject]
  Node importNode( Node node, optional boolean deep = false );
};

[Exposed=Window]
interface DocumentFragment : Node {
  constructor();
};

[Exposed=Window]
interface DocumentType : Node {
  readonly attribute DOMString name;
  readonly attribute DOMString publicId;
  readonly attribute DOMString systemId;
};

[Exposed=Window]
interface Element : Node {
  [SameObject]
  readonly attribute NamedNodeMap attributes;
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList classList;
  readonly attribute DOMString localName;
  readonly attribute DOMString? namespaceURI;
  readonly attribute DOMString? prefix;
  readonly attribute ShadowRoot? shadowRoot;
  readonly attribute DOMString tagName;
  [CEReactions]
  attribute DOMString className;
  [CEReactions]
  attribute DOMString id;
  [CEReactions, Unscopable]
  attribute DOMString slot;
  ShadowRoot attachShadow( ShadowRootInit init );
  Element? closest( DOMString selectors );
  DOMString? getAttribute( DOMString qualifiedName );
  DOMString? getAttributeNS( DOMString? namespace, DOMString localName );
  sequence<DOMString> getAttributeNames();
  Attr? getAttributeNode( DOMString qualifiedName );
  Attr? getAttributeNodeNS( DOMString? namespace, DOMString localName );
  HTMLCollection getElementsByClassName( DOMString classNames );
  HTMLCollection getElementsByTagName( DOMString qualifiedName );
  HTMLCollection getElementsByTagNameNS( DOMString? namespace, DOMString localName );
  boolean hasAttribute( DOMString qualifiedName );
  boolean hasAttributeNS( DOMString? namespace, DOMString localName );
  boolean hasAttributes();
  [CEReactions]
  Element? insertAdjacentElement( DOMString where, Element element );
  void insertAdjacentText( DOMString where, DOMString data );
  boolean matches( DOMString selectors );
  [CEReactions]
  void removeAttribute( DOMString qualifiedName );
  [CEReactions]
  void removeAttributeNS( DOMString? namespace, DOMString localName );
  [CEReactions]
  Attr removeAttributeNode( Attr attr );
  [CEReactions]
  void setAttribute( DOMString qualifiedName, DOMString value );
  [CEReactions]
  void setAttributeNS( DOMString? namespace, DOMString qualifiedName, DOMString value );
  [CEReactions]
  Attr? setAttributeNode( Attr attr );
  [CEReactions]
  Attr? setAttributeNodeNS( Attr attr );
  [CEReactions]
  boolean toggleAttribute( DOMString qualifiedName, optional boolean force );
  boolean webkitMatchesSelector( DOMString selectors );
};

[Exposed=(Window,Worker,AudioWorklet)]
interface Event {
  const unsigned short AT_TARGET = 2;
  const unsigned short BUBBLING_PHASE = 3;
  const unsigned short CAPTURING_PHASE = 1;
  const unsigned short NONE = 0;
  readonly attribute boolean bubbles;
  readonly attribute boolean cancelable;
  readonly attribute boolean composed;
  readonly attribute EventTarget? currentTarget;
  readonly attribute boolean defaultPrevented;
  readonly attribute unsigned short eventPhase;
  [LegacyUnforgeable]
  readonly attribute boolean isTrusted;
  readonly attribute EventTarget? srcElement;
  readonly attribute EventTarget? target;
  readonly attribute DOMHighResTimeStamp timeStamp;
  readonly attribute DOMString type;
  attribute boolean cancelBubble;
  attribute boolean returnValue;
  constructor( DOMString type, optional EventInit eventInitDict = {} );
  sequence<EventTarget> composedPath();
  void initEvent( DOMString type, optional boolean bubbles = false, optional boolean cancelable = false );
  void preventDefault();
  void stopImmediatePropagation();
  void stopPropagation();
};

[Exposed=(Window,Worker,AudioWorklet)]
interface EventTarget {
  constructor();
  void addEventListener( DOMString type, EventListener? callback, optional ( AddEventListenerOptions or boolean ) options = {} );
  boolean dispatchEvent( Event event );
  void removeEventListener( DOMString type, EventListener? callback, optional ( EventListenerOptions or boolean ) options = {} );
};

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface HTMLCollection {
  readonly attribute unsigned long length;
  getter Element? item( unsigned long index );
  getter Element? namedItem( DOMString name );
};

[Exposed=Window]
interface MutationObserver {
  constructor( MutationCallback callback );
  void disconnect();
  void observe( Node target, optional MutationObserverInit options = {} );
  sequence<MutationRecord> takeRecords();
};

[Exposed=Window]
interface MutationRecord {
  [SameObject]
  readonly attribute NodeList addedNodes;
  readonly attribute DOMString? attributeName;
  readonly attribute DOMString? attributeNamespace;
  readonly attribute Node? nextSibling;
  readonly attribute DOMString? oldValue;
  readonly attribute Node? previousSibling;
  [SameObject]
  readonly attribute NodeList removedNodes;
  [SameObject]
  readonly attribute Node target;
  readonly attribute DOMString type;
};

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface NamedNodeMap {
  readonly attribute unsigned long length;
  Attr? getNamedItemNS( DOMString? namespace, DOMString localName );
  [CEReactions]
  Attr removeNamedItem( DOMString qualifiedName );
  [CEReactions]
  Attr removeNamedItemNS( DOMString? namespace, DOMString localName );
  [CEReactions]
  Attr? setNamedItem( Attr attr );
  [CEReactions]
  Attr? setNamedItemNS( Attr attr );
  getter Attr? getNamedItem( DOMString qualifiedName );
  getter Attr? item( unsigned long index );
};

[Exposed=Window]
interface Node : EventTarget {
  const unsigned short ATTRIBUTE_NODE = 2;
  const unsigned short CDATA_SECTION_NODE = 4;
  const unsigned short COMMENT_NODE = 8;
  const unsigned short DOCUMENT_FRAGMENT_NODE = 11;
  const unsigned short DOCUMENT_NODE = 9;
  const unsigned short DOCUMENT_POSITION_CONTAINED_BY = 0x10;
  const unsigned short DOCUMENT_POSITION_CONTAINS = 0x08;
  const unsigned short DOCUMENT_POSITION_DISCONNECTED = 0x01;
  const unsigned short DOCUMENT_POSITION_FOLLOWING = 0x04;
  const unsigned short DOCUMENT_POSITION_IMPLEMENTATION_SPECIFIC = 0x20;
  const unsigned short DOCUMENT_POSITION_PRECEDING = 0x02;
  const unsigned short DOCUMENT_TYPE_NODE = 10;
  const unsigned short ELEMENT_NODE = 1;
  const unsigned short ENTITY_NODE = 6;
  const unsigned short ENTITY_REFERENCE_NODE = 5;
  const unsigned short NOTATION_NODE = 12;
  const unsigned short PROCESSING_INSTRUCTION_NODE = 7;
  const unsigned short TEXT_NODE = 3;
  readonly attribute USVString baseURI;
  [SameObject]
  readonly attribute NodeList childNodes;
  readonly attribute Node? firstChild;
  readonly attribute boolean isConnected;
  readonly attribute Node? lastChild;
  readonly attribute Node? nextSibling;
  readonly attribute DOMString nodeName;
  readonly attribute unsigned short nodeType;
  readonly attribute Document? ownerDocument;
  readonly attribute Element? parentElement;
  readonly attribute Node? parentNode;
  readonly attribute Node? previousSibling;
  [CEReactions]
  attribute DOMString? nodeValue;
  [CEReactions]
  attribute DOMString? textContent;
  [CEReactions]
  Node appendChild( Node node );
  [CEReactions, NewObject]
  Node cloneNode( optional boolean deep = false );
  unsigned short compareDocumentPosition( Node other );
  boolean contains( Node? other );
  Node getRootNode( optional GetRootNodeOptions options = {} );
  boolean hasChildNodes();
  [CEReactions]
  Node insertBefore( Node node, Node? child );
  boolean isDefaultNamespace( DOMString? namespace );
  boolean isEqualNode( Node? otherNode );
  boolean isSameNode( Node? otherNode );
  DOMString? lookupNamespaceURI( DOMString? prefix );
  DOMString? lookupPrefix( DOMString? namespace );
  [CEReactions]
  void normalize();
  [CEReactions]
  Node removeChild( Node child );
  [CEReactions]
  Node replaceChild( Node node, Node child );
};

[Exposed=Window]
interface NodeIterator {
  readonly attribute NodeFilter? filter;
  readonly attribute boolean pointerBeforeReferenceNode;
  readonly attribute Node referenceNode;
  [SameObject]
  readonly attribute Node root;
  readonly attribute unsigned long whatToShow;
  void detach();
  Node? nextNode();
  Node? previousNode();
};

[Exposed=Window]
interface NodeList {
  iterable<Node>;
  readonly attribute unsigned long length;
  getter Node? item( unsigned long index );
};

[Exposed=Window]
interface ProcessingInstruction : CharacterData {
  readonly attribute DOMString target;
};

[Exposed=Window]
interface Range : AbstractRange {
  const unsigned short END_TO_END = 2;
  const unsigned short END_TO_START = 3;
  const unsigned short START_TO_END = 1;
  const unsigned short START_TO_START = 0;
  readonly attribute Node commonAncestorContainer;
  constructor();
  [CEReactions, NewObject]
  DocumentFragment cloneContents();
  [NewObject]
  Range cloneRange();
  void collapse( optional boolean toStart = false );
  short compareBoundaryPoints( unsigned short how, Range sourceRange );
  short comparePoint( Node node, unsigned long offset );
  [CEReactions]
  void deleteContents();
  void detach();
  [CEReactions, NewObject]
  DocumentFragment extractContents();
  [CEReactions]
  void insertNode( Node node );
  boolean intersectsNode( Node node );
  boolean isPointInRange( Node node, unsigned long offset );
  void selectNode( Node node );
  void selectNodeContents( Node node );
  void setEnd( Node node, unsigned long offset );
  void setEndAfter( Node node );
  void setEndBefore( Node node );
  void setStart( Node node, unsigned long offset );
  void setStartAfter( Node node );
  void setStartBefore( Node node );
  [CEReactions]
  void surroundContents( Node newParent );
  stringifier;
};

[Exposed=Window]
interface ShadowRoot : DocumentFragment {
  readonly attribute Element host;
  readonly attribute ShadowRootMode mode;
  attribute EventHandler onslotchange;
};

[Exposed=Window]
interface StaticRange : AbstractRange {
  constructor( StaticRangeInit init );
};

[Exposed=Window]
interface Text : CharacterData {
  readonly attribute DOMString wholeText;
  constructor( optional DOMString data = "" );
  [NewObject]
  Text splitText( unsigned long offset );
};

[Exposed=Window]
interface TreeWalker {
  readonly attribute NodeFilter? filter;
  [SameObject]
  readonly attribute Node root;
  readonly attribute unsigned long whatToShow;
  attribute Node currentNode;
  Node? firstChild();
  Node? lastChild();
  Node? nextNode();
  Node? nextSibling();
  Node? parentNode();
  Node? previousNode();
  Node? previousSibling();
};

[Exposed=Window]
interface XMLDocument : Document {
};

[Exposed=Window]
interface XPathEvaluator {
  constructor();
};

[Exposed=Window]
interface XPathExpression {
  XPathResult evaluate( Node contextNode, optional unsigned short type = 0, optional XPathResult? result = null );
};

[Exposed=Window]
interface XPathResult {
  const unsigned short ANY_TYPE = 0;
  const unsigned short ANY_UNORDERED_NODE_TYPE = 8;
  const unsigned short BOOLEAN_TYPE = 3;
  const unsigned short FIRST_ORDERED_NODE_TYPE = 9;
  const unsigned short NUMBER_TYPE = 1;
  const unsigned short ORDERED_NODE_ITERATOR_TYPE = 5;
  const unsigned short ORDERED_NODE_SNAPSHOT_TYPE = 7;
  const unsigned short STRING_TYPE = 2;
  const unsigned short UNORDERED_NODE_ITERATOR_TYPE = 4;
  const unsigned short UNORDERED_NODE_SNAPSHOT_TYPE = 6;
  readonly attribute boolean booleanValue;
  readonly attribute boolean invalidIteratorState;
  readonly attribute unrestricted double numberValue;
  readonly attribute unsigned short resultType;
  readonly attribute Node? singleNodeValue;
  readonly attribute unsigned long snapshotLength;
  readonly attribute DOMString stringValue;
  Node? iterateNext();
  Node? snapshotItem( unsigned long index );
};

partial interface Window {
  [Replaceable]
  readonly attribute any event;
};

CharacterData includes ChildNode;

CharacterData includes NonDocumentTypeChildNode;

Document includes DocumentOrShadowRoot;

Document includes NonElementParentNode;

Document includes ParentNode;

Document includes XPathEvaluatorBase;

DocumentFragment includes NonElementParentNode;

DocumentFragment includes ParentNode;

DocumentType includes ChildNode;

Element includes ChildNode;

Element includes NonDocumentTypeChildNode;

Element includes ParentNode;

Element includes Slottable;

ShadowRoot includes DocumentOrShadowRoot;

Text includes Slottable;

XPathEvaluator includes XPathEvaluatorBase;
