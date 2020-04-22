[Exposed=Window]
interface HTMLBodyElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLHeadingElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

HTMLBodyElement includes WindowEventHandlers;
