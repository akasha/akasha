[Exposed=Window]
interface HTMLHtmlElement : HTMLElement {
  [HTMLConstructor] constructor();
};

[Exposed=Window]
interface HTMLHeadElement : HTMLElement {
  [HTMLConstructor] constructor();
};

[Exposed=Window]
interface HTMLTitleElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute DOMString text;
};

[Exposed=Window]
interface HTMLBaseElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute USVString href;
  [CEReactions] attribute DOMString target;
};

[Exposed=Window]
interface HTMLLinkElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute USVString href;
  [CEReactions] attribute DOMString? crossOrigin;
  [CEReactions] attribute DOMString rel;
  [CEReactions] attribute DOMString as; // (default "")
  [SameObject, PutForwards=value] readonly attribute DOMTokenList relList;
  [CEReactions] attribute DOMString media;
  [CEReactions] attribute DOMString integrity;
  [CEReactions] attribute DOMString hreflang;
  [CEReactions] attribute DOMString type;
  [SameObject, PutForwards=value] readonly attribute DOMTokenList sizes;
  [CEReactions] attribute USVString imageSrcset;
  [CEReactions] attribute DOMString imageSizes;
  [CEReactions] attribute DOMString referrerPolicy;
};
HTMLLinkElement includes LinkStyle;

[Exposed=Window]
interface HTMLMetaElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute DOMString name;
  [CEReactions] attribute DOMString httpEquiv;
  [CEReactions] attribute DOMString content;
};

[Exposed=Window]
interface HTMLStyleElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute DOMString media;
};
HTMLStyleElement includes LinkStyle;