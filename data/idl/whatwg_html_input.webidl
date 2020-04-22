[Exposed=Window]
interface HTMLInputElement : HTMLElement {
  readonly attribute HTMLFormElement? form;
  readonly attribute NodeList? labels;
  readonly attribute HTMLElement? list;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  [CEReactions]
  attribute DOMString accept;
  [CEReactions]
  attribute DOMString alt;
  [CEReactions]
  attribute DOMString autocomplete;
  attribute boolean checked;
  [CEReactions]
  attribute boolean defaultChecked;
  [CEReactions]
  attribute DOMString defaultValue;
  [CEReactions]
  attribute DOMString dirName;
  [CEReactions]
  attribute boolean disabled;
  attribute FileList? files;
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
  attribute unsigned long height;
  attribute boolean indeterminate;
  [CEReactions]
  attribute DOMString max;
  [CEReactions]
  attribute long maxLength;
  [CEReactions]
  attribute DOMString min;
  [CEReactions]
  attribute long minLength;
  [CEReactions]
  attribute boolean multiple;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString pattern;
  [CEReactions]
  attribute DOMString placeholder;
  [CEReactions]
  attribute boolean readOnly;
  [CEReactions]
  attribute boolean required;
  attribute DOMString? selectionDirection;
  attribute unsigned long? selectionEnd;
  attribute unsigned long? selectionStart;
  [CEReactions]
  attribute unsigned long size;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute DOMString step;
  [CEReactions]
  attribute DOMString type;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString value;
  attribute object? valueAsDate;
  attribute unrestricted double valueAsNumber;
  [CEReactions]
  attribute unsigned long width;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void select();
  void setCustomValidity( DOMString error );
  void setRangeText( DOMString replacement );
  void setRangeText( DOMString replacement, unsigned long start, unsigned long end, optional SelectionMode selectionMode = "preserve" );
  void setSelectionRange( unsigned long start, unsigned long end, optional DOMString direction );
  void stepDown( optional long n = 1 );
  void stepUp( optional long n = 1 );
};
