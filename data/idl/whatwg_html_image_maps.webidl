[Exposed=Window]
interface HTMLAreaElement : HTMLElement {
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList relList;
  [CEReactions]
  attribute DOMString alt;
  [CEReactions]
  attribute DOMString coords;
  [CEReactions]
  attribute DOMString download;
  [CEReactions]
  attribute USVString ping;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute DOMString rel;
  [CEReactions]
  attribute DOMString shape;
  [CEReactions]
  attribute DOMString target;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLMapElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection areas;
  [CEReactions]
  attribute DOMString name;
  [HTMLConstructor]
  constructor();
};

HTMLAreaElement includes HTMLHyperlinkElementUtils;
