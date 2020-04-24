[Exposed=Window]
interface HTMLDetailsElement : HTMLElement {
  [CEReactions]
  attribute boolean open;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLDialogElement : HTMLElement {
  [CEReactions]
  attribute boolean open;
  attribute DOMString returnValue;
  [HTMLConstructor]
  constructor();
  [CEReactions]
  void close( optional DOMString returnValue );
  [CEReactions]
  void show();
  [CEReactions]
  void showModal();
};
