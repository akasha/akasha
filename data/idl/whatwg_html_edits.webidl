[Exposed=Window]
interface HTMLModElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute USVString cite;
  [CEReactions] attribute DOMString dateTime;
};