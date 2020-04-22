[Exposed=Window]
interface HTMLModElement : HTMLElement {
  [CEReactions]
  attribute USVString cite;
  [CEReactions]
  attribute DOMString dateTime;
  [HTMLConstructor]
  constructor();
};
