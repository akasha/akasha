[Exposed=Window, LegacyOverrideBuiltIns, LegacyUnenumerableNamedProperties]
interface HTMLFormElement : HTMLElement {
  [SameObject]
  readonly attribute HTMLFormControlsCollection elements;
  readonly attribute unsigned long length;
  [SameObject, PutForwards=value]
  readonly attribute DOMTokenList relList;
  [CEReactions]
  attribute DOMString acceptCharset;
  [CEReactions]
  attribute USVString action;
  [CEReactions]
  attribute DOMString autocomplete;
  [CEReactions]
  attribute DOMString encoding;
  [CEReactions]
  attribute DOMString enctype;
  [CEReactions]
  attribute DOMString method;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute boolean noValidate;
  [CEReactions]
  attribute DOMString rel;
  [CEReactions]
  attribute DOMString target;
  [HTMLConstructor]
  constructor();
  boolean checkValidity();
  boolean reportValidity();
  void requestSubmit( optional HTMLElement? submitter = null );
  [CEReactions]
  void reset();
  void submit();
  getter Element ( unsigned long index );
  getter ( RadioNodeList or Element ) ( DOMString name );
};

[Exposed=Window]
interface HTMLLabelElement : HTMLElement {
  readonly attribute HTMLElement? control;
  readonly attribute HTMLFormElement? form;
  [CEReactions]
  attribute DOMString htmlFor;
  [HTMLConstructor]
  constructor();
};
