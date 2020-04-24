[Exposed=Window]
interface HTMLAnchorElement : HTMLElement {
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList relList;
  [CEReactions]
  attribute DOMString download;
  [CEReactions]
  attribute DOMString hreflang;
  [CEReactions]
  attribute USVString ping;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute DOMString rel;
  [CEReactions]
  attribute DOMString target;
  [CEReactions]
  attribute DOMString text;
  [CEReactions]
  attribute DOMString type;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLBRElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLDataElement : HTMLElement {
  [CEReactions]
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLSpanElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTimeElement : HTMLElement {
  [CEReactions]
  attribute DOMString dateTime;
  [HTMLConstructor]
  constructor();
};

HTMLAnchorElement includes HTMLHyperlinkElementUtils;
