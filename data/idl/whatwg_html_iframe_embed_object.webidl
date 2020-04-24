[Exposed=Window]
interface HTMLEmbedElement : HTMLElement {
  [CEReactions]
  attribute DOMString height;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute DOMString type;
  [CEReactions]
  attribute DOMString width;
  [HTMLConstructor]
  constructor();
  Document? getSVGDocument();
};

[Exposed=Window]
interface HTMLIFrameElement : HTMLElement {
  readonly attribute Document? contentDocument;
  readonly attribute WindowProxy? contentWindow;
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList sandbox;
  [CEReactions]
  attribute DOMString allow;
  [CEReactions]
  attribute boolean allowFullscreen;
  [CEReactions]
  attribute boolean allowPaymentRequest;
  [CEReactions]
  attribute DOMString height;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute DOMString srcdoc;
  [CEReactions]
  attribute DOMString width;
  [HTMLConstructor]
  constructor();
  Document? getSVGDocument();
};

[Exposed=Window]
interface HTMLObjectElement : HTMLElement {
  readonly attribute Document? contentDocument;
  readonly attribute WindowProxy? contentWindow;
  readonly attribute HTMLFormElement? form;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute USVString data;
  [CEReactions]
  attribute DOMString height;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString type;
  [CEReactions]
  attribute DOMString useMap;
  [CEReactions]
  attribute DOMString width;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  Document? getSVGDocument();
  boolean reportValidity();
  void setCustomValidity( DOMString error );
};

[Exposed=Window]
interface HTMLParamElement : HTMLElement {
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
};
