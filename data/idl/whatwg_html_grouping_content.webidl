[Exposed=Window]
interface HTMLParagraphElement : HTMLElement {
  [HTMLConstructor] constructor();
};

[Exposed=Window]
interface HTMLHRElement : HTMLElement {
  [HTMLConstructor] constructor();
};

[Exposed=Window]
interface HTMLPreElement : HTMLElement {
  [HTMLConstructor] constructor();
};

[Exposed=Window]
interface HTMLQuoteElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute USVString cite;
};

[Exposed=Window]
interface HTMLOListElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute boolean reversed;
  [CEReactions] attribute long start;
  [CEReactions] attribute DOMString type;
};

[Exposed=Window]
interface HTMLUListElement : HTMLElement {
  [HTMLConstructor] constructor();
};

[Exposed=Window]
interface HTMLMenuElement : HTMLElement {
  [HTMLConstructor] constructor();
};

[Exposed=Window]
interface HTMLLIElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute long value;
};

[Exposed=Window]
interface HTMLDListElement : HTMLElement {
  [HTMLConstructor] constructor();
};

[Exposed=Window]
interface HTMLDivElement : HTMLElement {
  [HTMLConstructor] constructor();
};