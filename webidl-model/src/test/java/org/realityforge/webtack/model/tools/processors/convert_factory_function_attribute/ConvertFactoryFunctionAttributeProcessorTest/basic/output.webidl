interface Audio : HTMLAudioElement {
  constructor( optional DOMString src );
};

[Exposed=Window]
interface HTMLAudioElement : HTMLElement {
};

[Exposed=Window]
interface HTMLElement {
  readonly attribute DOMString accessKeyLabel;
  [HTMLConstructor]
  constructor();
  void click();
};

[Exposed=Window]
interface HTMLImageElement : HTMLElement {
  readonly attribute boolean complete;
};

[Exposed=Window]
interface HTMLOptionElement : HTMLElement {
};

interface Image : HTMLImageElement {
  constructor( optional unsigned long width, optional unsigned long height );
};

interface Option : HTMLOptionElement {
  constructor( optional DOMString text = "", optional DOMString value, optional boolean defaultSelected = false, optional boolean selected = false );
};
