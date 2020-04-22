[Exposed=Window]
interface HTMLOptGroupElement : HTMLElement {
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute DOMString label;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window, LegacyFactoryFunction=Option( optional DOMString text = "", optional DOMString value, optional boolean defaultSelected = false, optional boolean selected = false )]
interface HTMLOptionElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  readonly attribute long index;
  [CEReactions]
  attribute boolean defaultSelected;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute DOMString label;
  attribute boolean selected;
  [CEReactions]
  attribute DOMString text;
  [CEReactions]
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLOutputElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList htmlFor;
  readonly attribute NodeList labels;
  readonly attribute DOMString type;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute DOMString defaultValue;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void setCustomValidity( DOMString error );
};

[Exposed=Window]
interface HTMLLegendElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLProgressElement : HTMLElement {
  readonly attribute NodeList labels;
  readonly attribute double position;
  [CEReactions]
  attribute double max;
  [CEReactions]
  attribute double value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLFieldSetElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection elements;
  readonly attribute HTMLFormElement? form;
  readonly attribute DOMString type;
  readonly attribute DOMString validationMessage;
  [SameObject]
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute DOMString name;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void setCustomValidity( DOMString error );
};

[Exposed=Window]
interface HTMLButtonElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  readonly attribute NodeList labels;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute USVString formAction;
  [CEReactions]
  attribute DOMString formEnctype;
  [CEReactions]
  attribute DOMString formMethod;
  [CEReactions]
  attribute boolean formNoValidate;
  [CEReactions]
  attribute DOMString formTarget;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString type;
  [CEReactions]
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void setCustomValidity( DOMString error );
};

[Exposed=Window]
interface HTMLDataListElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLCollection options;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLTextAreaElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  readonly attribute NodeList labels;
  readonly attribute unsigned long textLength;
  readonly attribute DOMString type;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute DOMString autocomplete;
  [CEReactions]
  attribute unsigned long cols;
  [CEReactions]
  attribute DOMString defaultValue;
  [CEReactions]
  attribute DOMString dirName;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute long maxLength;
  [CEReactions]
  attribute long minLength;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString placeholder;
  [CEReactions]
  attribute boolean readOnly;
  [CEReactions]
  attribute boolean required;
  [CEReactions]
  attribute unsigned long rows;
  attribute DOMString selectionDirection;
  attribute unsigned long selectionEnd;
  attribute unsigned long selectionStart;
  attribute [LegacyNullToEmptyString] DOMString value;
  [CEReactions]
  attribute DOMString wrap;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void select();
  void setCustomValidity( DOMString error );
  void setRangeText( DOMString replacement );
  void setRangeText( DOMString replacement, unsigned long start, unsigned long end, optional SelectionMode selectionMode = "preserve" );
  void setSelectionRange( unsigned long start, unsigned long end, optional DOMString direction );
};

[Exposed=Window]
interface HTMLMeterElement : HTMLElement {
  readonly attribute NodeList labels;
  [CEReactions]
  attribute double high;
  [CEReactions]
  attribute double low;
  [CEReactions]
  attribute double max;
  [CEReactions]
  attribute double min;
  [CEReactions]
  attribute double optimum;
  [CEReactions]
  attribute double value;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLSelectElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  readonly attribute NodeList labels;
  [SameObject]
  readonly attribute HTMLOptionsCollection options;
  [SameObject]
  readonly attribute HTMLCollection selectedOptions;
  readonly attribute DOMString type;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute DOMString autocomplete;
  [CEReactions]
  attribute boolean disabled;
  [CEReactions]
  attribute unsigned long length;
  [CEReactions]
  attribute boolean multiple;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute boolean required;
  attribute long selectedIndex;
  [CEReactions]
  attribute unsigned long size;
  attribute DOMString value;
  [HTMLConstructor]
  constructor();
  [CEReactions]
  void add( ( HTMLOptionElement or HTMLOptGroupElement ) element, optional ( HTMLElement or long )? before = null );
  boolean checkValidity();
  HTMLOptionElement? namedItem( DOMString name );
  [CEReactions]
  void remove();
  [CEReactions]
  void remove( long index );
  boolean reportValidity();
  void setCustomValidity( DOMString error );
  getter Element? item( unsigned long index );
  [CEReactions]
  setter void ( unsigned long index, HTMLOptionElement? option );
};
