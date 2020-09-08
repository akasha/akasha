/**
 * An enumeration describing the whether elements can have their values automatically completed by the browser.
 */
enum FormAutocompleteType {
  /**
   * The browser may not automatically complete entries.
   */
  "off",
  /**
   * The browser may automatically complete entries.
   */
  "on"
};

/**
 * An enumeration describing the whether elements can have their values automatically completed by the browser.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">autocomplete - MDN</a>
 * @see <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#autofill">autocomplete - Specification</a>
 */
enum AutocompleteType {
  /**
   * The browser is not permitted to automatically enter or select a value for this field. It is possible that the document or application provides its own autocomplete feature, or that security concerns require that the field's value not be automatically entered.
   *
   * <p>Note: In most modern browsers, setting autocomplete to "off" will not prevent a password manager from asking the user if they would like to save username and password information, or from automatically filling in those values in a site's login form. See the
   * <a href="https://developer.mozilla.org/en-US/docs/Web/Security/Securing_your_site/Turning_off_form_autocompletion#The_autocomplete_attribute_and_login_fields">autocomplete attribute and login fields</a>.
   */
  "off",
  /**
   * The browser is allowed to automatically complete the input. No guidance is provided as to the type of data expected in the field, so the browser may use its own judgement.
   */
  "on",
  /**
   * The field expects the value to be a person's full name. Using "name" rather than breaking the name down into its components is generally preferred because it avoids dealing with the wide diversity of human names and how they are structured.
   */
  "name",
  /**
   * The prefix or title, such as "Mrs.", "Mr.", "Miss", "Ms.", "Dr.", or "Mlle.".
   */
  "honorific-prefix",
  /**
   * The given (or "first") name.
   */
  "given-name",
  /**
   * The middle name.
   */
  "additional-name",
  /**
   * The family (or "last") name.
   */
  "family-name",
  /**
   * The suffix, such as "Jr.", "B.Sc.", "PhD.", "MBASW", or "IV".
   */
  "honorific-suffix",
  /**
   * A nickname or handle.
   */
  "nickname",
  /**
   * An email address.
   */
  "email",
  /**
   * A username or account name.
   */
  "username",
  /**
   * A new password. When creating a new account or changing passwords, this should be used for an "Enter your new password" or "Confirm new password" field, as opposed to a general "Enter your current password" field that might be present. This may be used by the browser both to avoid accidentally filling in an existing password and to offer assistance in creating a secure password.
   */
  "new-password",
  /**
   * The user's current password.
   */
  "current-password",
  /**
   * A one-time code used for verifying user identity.
   */
  "one-time-code",
  /**
   * A job title, or the title a person has within an organization, such as "Senior Technical Writer", "President", or "Assistant Troop Leader".
   */
  "organization-title",
  /**
   * A company or organization name, such as "Acme Widget Company" or "Girl Scouts of America".
   */
  "organization",
  /**
   * A street address. This can be multiple lines of text, and should fully identify the location of the address within its second administrative level (typically a city or town), but should not include the city name, ZIP or postal code, or country name.
   */
  "street-address",
  /**
   * Each individual line of the street address. These should only be present if the "street-address" is not present.
   */
  "address-line1",
  /**
   * Each individual line of the street address. These should only be present if the "street-address" is not present.
   */
  "address-line2",
  /**
   * Each individual line of the street address. These should only be present if the "street-address" is not present.
   */
  "address-line3",
  /**
   * The finest-grained administrative level, in addresses which have four levels.
   */
  "address-level4",
  /**
   * The third administrative level, in addresses with at least three administrative levels.
   */
  "address-level3",
  /**
   * The second administrative level, in addresses with at least two of them. In countries with two administrative levels, this would typically be the city, town, village, or other locality in which the address is located.
   */
  "address-level2",
  /**
   * The first administrative level in the address. This is typically the province in which the address is located. In the United States, this would be the state. In Switzerland, the canton. In the United Kingdom, the post town.
   */
  "address-level1",
  /**
   * A country or territory code.
   */
  "country",
  /**
   * A country or territory name.
   */
  "country-name",
  /**
   * A postal code (in the United States, this is the ZIP code).
   */
  "postal-code",
  /**
   * The full name as printed on or associated with a payment instrument such as a credit card. Using a full name field is preferred, typically, over breaking the name into pieces.
   */
  "cc-name",
  /**
   * A given (first) name as given on a payment instrument like a credit card.
   */
  "cc-given-name",
  /**
   * A middle name as given on a payment instrument or credit card.
   */
  "cc-additional-name",
  /**
   * A family name, as given on a credit card.
   */
  "cc-family-name",
  /**
   * A credit card number or other number identifying a payment method, such as an account number.
   */
  "cc-number",
  /**
   * A payment method expiration date, typically in the form "MM/YY" or "MM/YYYY".
   */
  "cc-exp",
  /**
   * The month in which the payment method expires.
   */
  "cc-exp-month",
  /**
   * The year in which the payment method expires.
   */
  "cc-exp-year",
  /**
   * The security code for the payment instrument; on credit cards, this is the 3-digit verification number on the back of the card.
   */
  "cc-csc",
  /**
   * The type of payment instrument (such as "Visa" or "Master Card").
   */
  "cc-type",
  /**
   * The currency in which the transaction is to take place.
   */
  "transaction-currency",
  /**
   * The amount, given in the currency specified by "transaction-currency", of the transaction, for a payment form.
   */
  "transaction-amount",
  /**
   * A preferred language, given as a valid <a href="https://en.wikipedia.org/wiki/IETF_language_tag">BCP 47 language tag</a>.
   */
  "language",
  /**
   * A birth date, as a full date.
   */
  "bday",
  /**
   * The day of the month of a birth date.
   */
  "bday-day",
  /**
   * The month of the year of a birth date.
   */
  "bday-month",
  /**
   * The year of a birth date.
   */
  "bday-year",
  /**
   * A gender identity (such as "Female", "Fa'afafine", "Male"), as freeform text without newlines.
   */
  "sex",
  /**
   * A full telephone number, including the country code.
   */
  "tel",
  /**
   * The country code, such as "1" for the United States, Canada, and other areas in North America and parts of the Caribbean.
   */
  "tel-country-code",
  /**
   * The entire phone number without the country code component, including a country-internal prefix. For the phone number "1-855-555-6502", this field's value would be "855-555-6502".
   */
  "tel-national",
  /**
   * The area code, with any country-internal prefix applied if appropriate.
   */
  "tel-area-code",
  /**
   * The phone number without the country or area code. This can be split further into two parts, for phone numbers which have an exchange number and then a number within the exchange. For the phone number "555-6502", use "tel-local-prefix" for "555" and "tel-local-suffix" for "6502".
   */
  "tel-local",
  /**
   * A telephone extension code within the phone number, such as a room or suite number in a hotel or an office extension in a company.
   */
  "tel-extension",
  /**
   * A URL for an instant messaging protocol endpoint, such as "xmpp:username@example.net".
   */
  "impp",
  /**
   * A URL, such as a home page or company web site address as appropriate given the context of the other fields in the form.
   */
  "url",
  /**
   * The URL of an image representing the person, company, or contact information given in the other fields in the form.
   */
  "photo",
  /**
   * The value is for contacting someone at their residence.
   */
  "home",
  /**
   * The value is for contacting someone at their workplace.
   */
  "work",
  /**
   * The value is for contacting someone regardless of location.
   */
  "mobile",
  /**
   * The value describes a fax machine's contact details.
   */
  "fax",
  /**
   * The value describes a pager's or beeper's contact details.
   */
  "pager"
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
  attribute FormAutocompleteType autocomplete;
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
   * Use this if the form contains <code>&lt;input&gt;</code> elements with type=file.
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

/**
 * The inputmode enumeration that hints at the type of data that might be entered by the user while editing the element or its contents.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/inputmode">inputmode - MDN</a>
 */
enum InputModeType {
  /**
   * No virtual keyboard. For when the page implements its own keyboard input control.
   */
  "none",
  /**
   * Standard input keyboard for the user's current locale.
   * This is the default value.
   */
  "text",
  /**
   * Fractional numeric input keyboard containing the digits and decimal separator for the user's locale (typically <code>.</code> or <code>,</code>).
   * Devices may or may not show a minus key (<code>-</code>).
   */
  "decimal",
  /**
   * Numeric input keyboard, but only requires the digits 0–9. Devices may or may not show a minus key.
   */
  "numeric",
  /**
   * A telephone keypad input, including the digits 0–9, the asterisk (<code>*</code>), and the pound (<code>#</code>) key.
   * Inputs that require a telephone number should typically use <code>&lt;input type="tel"&gt;</code> instead.
   */
  "tel",
  /**
   * A virtual keyboard optimized for search input.
   * For instance, the return/submit key may be labeled “Search”, along with possible other optimizations.
   * Inputs that require a search query should typically use <code>&lt;input type="search"&gt;</code> instead.
   */
  "search",
  /**
   * A virtual keyboard optimized for entering email addresses.
   * Typically includes the <code>@</code> character as well as other optimizations. Inputs that require email
   * addresses should typically use <code>&lt;input type="email"&gt;</code> instead.
   */
  "email",
  /**
   * A keypad optimized for entering URLs.
   * This may have the <code>/</code> key more prominent, for example. Enhanced features could include history
   * access and so on. Inputs that require a URL should typically use <code>&lt;input type="url"&gt;</code> instead.
   */
  "url"
};

partial interface mixin ElementContentEditable {
  [CEReactions]
  attribute InputModeType inputMode;
};
