callback CustomElementConstructor = HTMLElement ();

dictionary ElementDefinitionOptions {
  DOMString extends;
};

dictionary ValidityStateFlags {
  boolean badInput = false;
  boolean customError = false;
  boolean patternMismatch = false;
  boolean rangeOverflow = false;
  boolean rangeUnderflow = false;
  boolean stepMismatch = false;
  boolean tooLong = false;
  boolean tooShort = false;
  boolean typeMismatch = false;
  boolean valueMissing = false;
};

[Exposed=Window]
interface ElementInternals {
  readonly attribute HTMLFormElement? form;
  readonly attribute NodeList labels;
  readonly attribute DOMString validationMessage;
  readonly attribute ValidityState validity;
  readonly attribute boolean willValidate;
  boolean checkValidity();
  boolean reportValidity();
  void setFormValue( ( File or USVString or FormData )? value, optional ( File or USVString or FormData )? state );
  void setValidity( ValidityStateFlags flags, optional DOMString message, optional HTMLElement anchor );
};

[Exposed=Window]
interface CustomElementRegistry {
  [CEReactions]
  void define( DOMString name, CustomElementConstructor constructor, optional ElementDefinitionOptions options = {} );
  any get( DOMString name );
  [CEReactions]
  void upgrade( Node root );
  Promise<void> whenDefined( DOMString name );
};
