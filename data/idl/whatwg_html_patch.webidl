
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

partial interface HTMLFormElement {
  [CEReactions]
  attribute FormMethodType method;
};
