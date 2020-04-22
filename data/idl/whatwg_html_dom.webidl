enum DocumentReadyState {
  "complete",
  "interactive",
  "loading"
};

typedef ( HTMLScriptElement or SVGScriptElement ) HTMLOrSVGScriptElement;

interface mixin HTMLOrSVGElement {
  [SameObject]
  readonly attribute DOMStringMap dataset;
  [CEReactions]
  attribute boolean autofocus;
  attribute DOMString nonce;
  [CEReactions]
  attribute long tabIndex;
  void blur();
  void focus( optional FocusOptions options = {} );
};

partial interface mixin DocumentOrShadowRoot {
  readonly attribute Element? activeElement;
};

[Exposed=Window]
interface HTMLElement : Element {
  readonly attribute DOMString accessKeyLabel;
  [CEReactions]
  attribute DOMString accessKey;
  [CEReactions]
  attribute DOMString autocapitalize;
  [CEReactions]
  attribute DOMString dir;
  [CEReactions]
  attribute boolean draggable;
  [CEReactions]
  attribute boolean hidden;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString innerText;
  [CEReactions]
  attribute DOMString lang;
  [CEReactions]
  attribute boolean spellcheck;
  [CEReactions]
  attribute DOMString title;
  [CEReactions]
  attribute boolean translate;
  [HTMLConstructor]
  constructor();
  ElementInternals attachInternals();
  void click();
};

[Exposed=Window, LegacyOverrideBuiltIns]
interface DOMStringMap {
  getter DOMString ( DOMString name );
  [CEReactions]
  setter void ( DOMString name, DOMString value );
  [CEReactions]
  deleter void ( DOMString name );
};

[Exposed=Window]
interface HTMLUnknownElement : HTMLElement {
};

[LegacyOverrideBuiltIns]
partial interface Document {
  readonly attribute HTMLOrSVGScriptElement? currentScript;
  readonly attribute WindowProxy? defaultView;
  [SameObject]
  readonly attribute HTMLCollection embeds;
  [SameObject]
  readonly attribute HTMLCollection forms;
  readonly attribute HTMLHeadElement? head;
  [SameObject]
  readonly attribute HTMLCollection images;
  readonly attribute DOMString lastModified;
  [SameObject]
  readonly attribute HTMLCollection links;
  [PutForwards=href, LegacyUnforgeable]
  readonly attribute Location? location;
  [SameObject]
  readonly attribute HTMLCollection plugins;
  readonly attribute DocumentReadyState readyState;
  readonly attribute USVString referrer;
  [SameObject]
  readonly attribute HTMLCollection scripts;
  [CEReactions]
  attribute HTMLElement? body;
  attribute USVString cookie;
  [CEReactions]
  attribute DOMString designMode;
  [CEReactions]
  attribute DOMString dir;
  attribute USVString domain;
  [LegacyLenientThis]
  attribute EventHandler onreadystatechange;
  [CEReactions]
  attribute DOMString title;
  [CEReactions]
  void close();
  [CEReactions]
  boolean execCommand( DOMString commandId, optional boolean showUI = false, optional DOMString value = "" );
  NodeList getElementsByName( DOMString elementName );
  boolean hasFocus();
  [CEReactions]
  Document open( optional DOMString unused1, optional DOMString unused2 );
  WindowProxy? open( USVString url, DOMString name, DOMString features );
  boolean queryCommandEnabled( DOMString commandId );
  boolean queryCommandIndeterm( DOMString commandId );
  boolean queryCommandState( DOMString commandId );
  boolean queryCommandSupported( DOMString commandId );
  DOMString queryCommandValue( DOMString commandId );
  [CEReactions]
  void write( DOMString... text );
  [CEReactions]
  void writeln( DOMString... text );
  getter object ( DOMString name );
};

Document includes GlobalEventHandlers;

HTMLElement includes GlobalEventHandlers;

Document includes DocumentAndElementEventHandlers;

HTMLElement includes ElementContentEditable;

HTMLElement includes DocumentAndElementEventHandlers;

HTMLElement includes HTMLOrSVGElement;
