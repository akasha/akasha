[Exposed=Window,
 OverrideBuiltins,
 LegacyUnenumerableNamedProperties]
interface HTMLFormElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute DOMString acceptCharset;
  [CEReactions] attribute USVString action;
  [CEReactions] attribute DOMString autocomplete;
  [CEReactions] attribute DOMString enctype;
  [CEReactions] attribute DOMString encoding;
  [CEReactions] attribute DOMString method;
  [CEReactions] attribute DOMString name;
  [CEReactions] attribute boolean noValidate;
  [CEReactions] attribute DOMString target;
  [CEReactions] attribute DOMString rel;
  [SameObject, PutForwards=value] readonly attribute DOMTokenList relList;

  [SameObject] readonly attribute HTMLFormControlsCollection elements;
  readonly attribute unsigned long length;
  getter Element (unsigned long index);
  getter (RadioNodeList or Element) (DOMString name);

  void submit();
  void requestSubmit(optional HTMLElement? submitter = null);
  [CEReactions] void reset();
  boolean checkValidity();
  boolean reportValidity();
};

[Exposed=Window]
interface HTMLLabelElement : HTMLElement {
  [HTMLConstructor] constructor();

  readonly attribute HTMLFormElement? form;
  [CEReactions] attribute DOMString htmlFor;
  readonly attribute HTMLElement? control;
};