[Exposed=Window]
interface HTMLBaseElement : HTMLElement {
  [CEReactions]
  attribute USVString href;
  [CEReactions]
  attribute DOMString target;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLHeadElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLHtmlElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLLinkElement : HTMLElement {
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList relList;
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList sizes;
  [CEReactions]
  attribute DOMString as;
  [CEReactions]
  attribute DOMString? crossOrigin;
  [CEReactions]
  attribute USVString href;
  [CEReactions]
  attribute DOMString hreflang;
  [CEReactions]
  attribute DOMString imageSizes;
  [CEReactions]
  attribute USVString imageSrcset;
  [CEReactions]
  attribute DOMString integrity;
  [CEReactions]
  attribute DOMString media;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute DOMString rel;
  [CEReactions]
  attribute DOMString type;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLMetaElement : HTMLElement {
  [CEReactions]
  attribute DOMString content;
  [CEReactions]
  attribute DOMString httpEquiv;
  [CEReactions]
  attribute DOMString name;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLStyleElement : HTMLElement {
  [CEReactions]
  attribute DOMString media;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTitleElement : HTMLElement {
  [CEReactions]
  attribute DOMString text;
  [HTMLConstructor]
  constructor();
};

HTMLLinkElement includes LinkStyle;

HTMLStyleElement includes LinkStyle;
