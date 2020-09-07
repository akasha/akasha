/**
 * An enumeration describing the whether elements can have their values automatically completed by the browser.
 */
enum AutocompleteType {
  /**
   * The browser may not automatically complete entries.
   */
  "off",
  /**
   * The browser may automatically complete entries.
   */
  "on"
};

partial interface HTMLTextAreaElement {
  [CEReactions]
  attribute AutocompleteType autocomplete;
};

partial interface HTMLSelectElement {
  [CEReactions]
  attribute AutocompleteType autocomplete;
};

partial interface HTMLInputElement {
  [CEReactions]
  attribute AutocompleteType autocomplete;
};

partial interface HTMLFormElement {
  [CEReactions]
  attribute AutocompleteType autocomplete;
};

/**
 * An enumeration describing the behavior of the button.
 */
enum HTMLButtonElementType {
  /**
   * The button submits the form. This is the default value if the attribute is not specified, or if it is dynamically changed to an empty or invalid value.
   */
  "submit",
  /**
   * The button resets the form.
   */
  "reset",
  /**
   * The button has no default behaviour.
   */
  "button",
  /**
   * The button displays a menu.
   * This is an experimental feature.
   */
  "menu"
};

partial interface HTMLButtonElement {
  [CEReactions]
  attribute HTMLButtonElementType type;
};

/**
 * Controls whether and how text input is automatically capitalized as it is entered/edited by the user.
 */
enum AutocapitalizeType {
  /**
   * No autocapitalization is applied (all letters default to lowercase).
   */
  "off",
  /**
   * No autocapitalization is applied (all letters default to lowercase).
   */
  "none",
  /**
   * The first letter of each sentence defaults to a capital letter; all other letters default to lowercase.
   */
  "on",
  /**
   * The first letter of each sentence defaults to a capital letter; all other letters default to lowercase.
   */
  "sentences",
  /**
   * The first letter of each word defaults to a capital letter; all other letters default to lowercase.
   */
  "words",
  /**
   * All letters should default to uppercase.
   */
  "characters"
};

/**
 * An enumerated attribute indicating the directionality of the element's text.
 */
enum DirType {
  /**
   * Left to right direction which is to be used for languages that are written from the left to the right, such as English.
   */
  "ltr",
  /**
   * Right to left direction which is to be used for languages that are written from the right to the left, such as Arabic.
   */
  "rtl",
  /**
   * Auto direction which lets the user agent decide. It uses a basic algorithm as it parses the characters inside the element until it finds a character with a strong directionality, then it applies that directionality to the whole element.
   */
  "auto"
};

partial interface HTMLElement {
  [CEReactions]
  attribute AutocapitalizeType autocapitalize;
  [CEReactions]
  attribute DirType dir;
};

/**
 * An enumeration specifying the HTTP method to submit the form with.
 */
enum FormMethodType {
  /**
   * The POST method; form data sent as the request body.
   */
  "post",
  /**
   * The GET method; form data appended to the action URL with a ? separator. Use this method when the form has no side-effects.
   */
  "get",
  /**
   * When the form is inside a &lt;dialog&gt;, closes the dialog on submission.
   */
  "dialog"
};

/**
 * An enumeration specifying the HTTP method to submit the form with.
 */
enum FormEncodingType {
  /**
   * The default value.
   */
  "application/x-www-form-urlencoded",
  /**
   * Use this if the form contains <input> elements with type=file.
   */
  "multipart/form-data",
  /**
   * Introduced by HTML5 for debugging purposes.
   */
  "text/plain"
};

partial interface HTMLFormElement {
  [CEReactions]
  attribute FormMethodType method;
  [CEReactions]
  attribute FormEncodingType enctype;
};

partial interface HTMLInputElement {
  [CEReactions]
  attribute FormMethodType formMethod;
  [CEReactions]
  attribute FormEncodingType formEnctype;
};

partial interface HTMLButtonElement {
  [CEReactions]
  attribute FormMethodType formMethod;
  [CEReactions]
  attribute FormEncodingType formEnctype;
};
