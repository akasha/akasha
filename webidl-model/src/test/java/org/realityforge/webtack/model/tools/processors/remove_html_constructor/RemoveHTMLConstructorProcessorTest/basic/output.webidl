[Exposed=Window]
interface Element {
  constructor();
};

[Exposed=Window, LegacyFactoryFunction=Audio( optional DOMString src )]
interface HTMLAudioElement : HTMLElement {
};

[Exposed=Window]
interface HTMLElement : Element {
  readonly attribute DOMString accessKeyLabel;
  void click();
};

[Exposed=Window, LegacyFactoryFunction=Image( optional unsigned long width, optional unsigned long height )]
interface HTMLImageElement : HTMLElement {
  readonly attribute boolean complete;
};

[Exposed=Window, LegacyFactoryFunction=Option( optional DOMString text = "", optional DOMString value, optional boolean defaultSelected = false, optional boolean selected = false )]
interface HTMLOptionElement : HTMLElement {
};
