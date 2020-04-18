[Exposed=Window]
interface CustomElementRegistry {
  [CEReactions] void define(DOMString name, CustomElementConstructor constructor, optional ElementDefinitionOptions options = {});
  any get(DOMString name);
  Promise<void> whenDefined(DOMString name);
  [CEReactions] void upgrade(Node root);
};

callback CustomElementConstructor = HTMLElement ();

dictionary ElementDefinitionOptions {
  DOMString extends;
};

[Exposed=Window]
interface ElementInternals {
  // Form-associated custom elements

  void setFormValue((File or USVString or FormData)? value,
                    optional (File or USVString or FormData)? state);

  readonly attribute HTMLFormElement? form;

  void setValidity(ValidityStateFlags flags,
                   optional DOMString message,
                   optional HTMLElement anchor);
  readonly attribute boolean willValidate;
  readonly attribute ValidityState validity;
  readonly attribute DOMString validationMessage;
  boolean checkValidity();
  boolean reportValidity();

  readonly attribute NodeList labels;
};

dictionary ValidityStateFlags {
  boolean valueMissing = false;
  boolean typeMismatch = false;
  boolean patternMismatch = false;
  boolean tooLong = false;
  boolean tooShort = false;
  boolean rangeUnderflow = false;
  boolean rangeOverflow = false;
  boolean stepMismatch = false;
  boolean badInput = false;
  boolean customError = false;
};