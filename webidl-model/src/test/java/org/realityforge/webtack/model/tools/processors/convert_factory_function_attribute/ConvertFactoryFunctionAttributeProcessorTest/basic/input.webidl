[Exposed=Window, LegacyFactoryFunction=Audio( optional DOMString src )]
interface HTMLAudioElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLElement {
  readonly attribute DOMString accessKeyLabel;
  [HTMLConstructor]
  constructor();
  void click();
};

[Exposed=Window, LegacyFactoryFunction=Image( optional unsigned long width, optional unsigned long height )]
interface HTMLImageElement : HTMLElement {
  readonly attribute boolean complete;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window, LegacyFactoryFunction=Option( optional DOMString text = "", optional DOMString value, optional boolean defaultSelected = false, optional boolean selected = false )]
interface HTMLOptionElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};
