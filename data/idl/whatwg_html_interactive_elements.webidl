[Exposed=Window]
interface HTMLDetailsElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute boolean open;
};

[Exposed=Window]
interface HTMLDialogElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute boolean open;
  attribute DOMString returnValue;
  [CEReactions] void show();
  [CEReactions] void showModal();
  [CEReactions] void close(optional DOMString returnValue);
};