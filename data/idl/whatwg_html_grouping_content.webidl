[Exposed=Window]
interface HTMLDListElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLDivElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLHRElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLLIElement : HTMLElement {
  [CEReactions]
  attribute long value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLMenuElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLOListElement : HTMLElement {
  [CEReactions]
  attribute boolean reversed;
  [CEReactions]
  attribute long start;
  [CEReactions]
  attribute DOMString type;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLParagraphElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLPreElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLQuoteElement : HTMLElement {
  [CEReactions]
  attribute USVString cite;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLUListElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};
