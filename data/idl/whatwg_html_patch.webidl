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
enum ButtonType {
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
  attribute ButtonType type;
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
  [JavaName=urlencoded] "application/x-www-form-urlencoded",
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

/**
 * An enumeration specifying the type of input control to render.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#%3Cinput%3E_types"><code>&lt;input&gt;</code> type - MDN</a>
 *
 */
enum InputType {
  /**
   * A push button with no default behavior displaying the value of the value attribute, empty by default.
   */
  "button",
  /**
   * A check box allowing single values to be selected/deselected.
   */
  "checkbox",
  /**
   * A control for specifying a color; opening a color picker when active in supporting browsers.
   */
  "color",
  /**
   * A control for entering a date (year, month, and day, with no time). Opens a date picker or numeric wheels for year, month, day when active in supporting browsers.
   */
  "date",
  /**
   * A control for entering a date and time, with no time zone. Opens a date picker or numeric wheels for date- and time-components when active in supporting browsers.
   */
  "datetime-local",
  /**
   * A field for editing an email address. Looks like a text input, but has validation parameters and relevant keyboard in supporting browsers and devices with dynamic keyboards.
   */
  "email",
  /**
   * A control that lets the user select a file. Use the accept attribute to define the types of files that the control can select.
   */
  "file",
  /**
   * A control that is not displayed but whose value is submitted to the server.
   */
  "hidden",
  /**
   * A graphical submit button. Displays an image defined by the src attribute. The alt attribute displays if the image src is missing.
   */
  "image",
  /**
   * A control for entering a month and year, with no time zone.
   */
  "month",
  /**
   * A control for entering a number. Displays a spinner and adds default validation when supported.
   * Displays a numeric keypad in some devices with dynamic keypads.
   */
  "number",
  /**
   * A single-line text field whose value is obscured. Will alert user if site is not secure.
   */
  "password",
  /**
   * A radio button, allowing a single value to be selected out of multiple choices with the same name value.
   */
  "radio",
  /**
   * A control for entering a number whose exact value is not important.
   * Displays as a range widget defaulting to the middle value. Used in conjunction min and max to define
   * the range of acceptable values.
   */
  "range",
  /**
   * A button that resets the contents of the form to default values. Not recommended.
   */
  "reset",
  /**
   * A single-line text field for entering search strings. Line-breaks are automatically
   * removed from the input value. May include a delete icon in supporting browsers that
   * can be used to clear the field. Displays a search icon instead of enter key on some
   * devices with dynamic keypads.
   */
  "search",
  /**
   * A button that submits the form.
   */
  "submit",
  /**
   * A control for entering a telephone number.
   * Displays a telephone keypad in some devices with dynamic keypads.
   */
  "tel",
  /**
   * The default value. A single-line text field. Line-breaks are automatically removed from the input value.
   */
  "text",
  /**
   * A control for entering a time value with no time zone.
   */
  "time",
  /**
   * A field for entering a URL. Looks like a text input, but has validation parameters and relevant keyboard in supporting browsers and devices with dynamic keyboards.
   */
  "url",
  /**
   * A control for entering a date consisting of a week-year number and a week number with no time zone.
   */
  "week"
};

partial interface HTMLInputElement {
  [CEReactions]
  attribute InputType type;
};

/**
 * An enumerated value to provide a hint to the browser about what the author thinks will lead to the best user experience.
 */
enum MediaPreloadType {
  /**
   * Indicates that the audio should not be preloaded.
   */
  "none",
  /**
   * Indicates that only audio metadata (e.g. length) is fetched.
   */
  "metadata",
  /**
   * Indicates that the whole audio file can be downloaded, even if the user is not expected to use it.
   */
  "auto"
};

partial interface HTMLMediaElement {
  [CEReactions]
  attribute MediaPreloadType preload;
};

/**
 * An enumerated value to indicate whether to use CORS to fetch resources.
 */
enum CrossOriginType {
  /**
   * Sends a cross-origin request without a credential. In other words, it sends
   * the <code>Origin:</code> HTTP header without a cookie, X.509 certificate, or performing HTTP
   * Basic authentication. If the server does not give credentials to the origin site (by not setting
   * the <code>Access-Control-Allow-Origin:</code> HTTP header), the image will be tainted, and its
   * usage restricted.
   */
  "anonymous",
  /**
   * Sends a cross-origin request with a credential. In other words, it sends the
   * <code>Origin:</code> HTTP header with a cookie, a certificate, or performing
   * HTTP Basic authentication. If the server does not give credentials to the origin
   * site (through <code>Access-Control-Allow-Credentials:</code> HTTP header), the
   * image will be tainted and its usage restricted.
   */
  "use-credentials"
};

partial interface HTMLMediaElement {
  [CEReactions]
  attribute CrossOriginType? crossOrigin;
};

partial interface HTMLLinkElement {
  [CEReactions]
  attribute CrossOriginType? crossOrigin;
};

partial interface HTMLImageElement {
  [CEReactions]
  attribute CrossOriginType? crossOrigin;
};

partial interface HTMLScriptElement {
  [CEReactions]
  attribute CrossOriginType? crossOrigin;
};

/**
 * An enumerated value to define the cells that the header element relates to.
 */
enum ScopeType {
  /**
   * The header relates to all cells of the row it belongs to.
   */
  "row",
  /**
   * The header relates to all cells of the column it belongs to.
   */
  "col",
  /**
   * The header belongs to a rowgroup and relates to all of its cells. These cells can be
   * placed to the right or the left of the header, depending on the value of the <code>dir</code>
   * attribute in the <code>&lt;table&gt;</code> element.
   */
  "rowgroup",
  /**
   * The header belongs to a colgroup and relates to all of its cells.
   */
  "colgroup",
  /**
   * The default value.
   */
  "auto"
};

partial interface HTMLTableCellElement {
  [CEReactions]
  attribute ScopeType scope;
};

/**
 * An enumerated value to indicates which referrer to send when fetching the resource.
 *
 * @see <a href="https://w3c.github.io/webappsec-referrer-policy/#referrer-policies">ReferrerPolicy - Specification</a>
 */
enum ReferrerPolicy {
  /**
   * The Referer header will not be sent.
   */
  "no-referrer",
  /**
   * The Referer header will not be sent to origins without TLS. This is the default value.
   */
  "no-referrer-when-downgrade",
  /**
   * The sent referrer will be limited to the origin of the referring page: its scheme, host, and port.
   */
  "origin",
  /**
   * The referrer sent to other origins will be limited to the scheme, the host, and the port. Navigations on the same origin will still include the path.
   */
  "origin-when-cross-origin",
  /**
   * A referrer will be sent for same origin, but cross-origin requests will contain no referrer information.
   */
  "same-origin",
  /**
   * Only send the origin of the document as the referrer when the protocol security level stays the same (e.g. HTTPS &#8594; HTTPS), but don't send it to a less secure destination (e.g. HTTPS &#8594; HTTP).
   */
  "strict-origin",
  /**
   * Send a full URL when performing a same-origin request, but only send the origin when the protocol security level stays the same (e.g.HTTPS &#8594; HTTPS), and send no header to a less secure destination (e.g. HTTPS &#8594; HTTP).
   */
  "strict-origin-when-cross-origin",
  /**
   * The referrer will include the origin and the path (but not the fragment, password, or username). This value is unsafe, because it leaks origins and paths from TLS-protected resources to insecure origins.
   */
  "unsafe-url"
};

partial interface HTMLAnchorElement {
  [CEReactions]
  attribute ReferrerPolicy referrerPolicy;
};

partial interface HTMLAreaElement {
  [CEReactions]
  attribute ReferrerPolicy referrerPolicy;
};

partial interface HTMLIFrameElement {
  [CEReactions]
  attribute ReferrerPolicy referrerPolicy;
};

partial interface HTMLImageElement {
  [CEReactions]
  attribute ReferrerPolicy referrerPolicy;
};

partial interface HTMLLinkElement {
  [CEReactions]
  attribute ReferrerPolicy referrerPolicy;
};

partial interface HTMLScriptElement {
  [CEReactions]
  attribute ReferrerPolicy referrerPolicy;
};

/**
 * An enumerated value to indicate how the browser should load the resource.
 */
enum LoadingType {
  /**
   * Load the resource immediately, regardless of whether or not the resource is currently within
   * the visible viewport (this is the default value).
   */
  "eager",
  /**
   * Defer loading of the resource until it reaches a calculated distance from the viewport, as defined
   * by the browser. The intent is to avoid the network and storage bandwidth needed to handle the image
   * until it's reasonably certain that it will be needed. This generally improves the performance of the
   * content in most typical use cases.
   */
  "lazy"
};

partial interface HTMLIFrameElement {
  [CEReactions]
  attribute LoadingType loading;
};

partial interface HTMLImageElement {
  [CEReactions]
  attribute LoadingType loading;
};

/**
 * An enumerated value to indicate how the text track is meant to be used.
 */
enum TrackKind {
  /**
   * Subtitles provide translation of content that cannot be understood by the viewer. For example
   * dialogue or text that is not English in an English language film. Subtitles may contain additional
   * content, usually extra background information. For example the text at the beginning of the Star Wars
   * films, or the date, time, and location of a scene.
   */
  "subtitles",
  /**
   * Closed captions provide a transcription and possibly a translation of audio.
   * It may include important non-verbal information such as music cues or sound effects. It may indicate the cue's source (e.g. music, text, character).
   * Suitable for users who are deaf or when the sound is muted.
   */
  "captions",
  /**
   * Textual description of the video content.
   * Suitable for users who are blind or where the video cannot be seen.
   */
  "descriptions",
  /**
   * Chapter titles are intended to be used when the user is navigating the media resource.
   */
  "chapters",
  /**
   * Tracks used by scripts. Not visible to the user.
   */
  "metadata"
};

partial interface HTMLTrackElement {
  [CEReactions]
  attribute TrackKind kind;
};

/**
 * An enumerated value to indicate how the control wraps text.
 */
enum WrapType {
  /**
   * The browser automatically inserts line breaks (CR+LF) so that each line has no more
   * than the width of the control; the cols attribute must also be specified for this to
   * take effect.
   */
  "hard",
  /**
   * The browser ensures that all line breaks in the value consist of a CR+LF pair, but does
   * not insert any additional line breaks. This is the default value.
   */
  "soft"
};

partial interface HTMLTextAreaElement {
  [CEReactions]
  attribute DOMString wrap;
};

/**
 * An enumerated value to indicate how the control wraps text.
 */
enum RenderContextType {
  /**
   * The context type designates a {@link CanvasRenderingContext2D}, a two-dimensional rendering context.
   */
  "2d",
  /**
   * The context type designates a {@link WebGLRenderingContext}, a three-dimensional rendering context.
   * This context is only available on browsers that implement WebGL version 1 (OpenGL ES 2.0).
   */
  "webgl",
  /**
   * The context type designates a {@link WebGL2RenderingContext}, a three-dimensional rendering context.
   * This context is only available on browsers that implement WebGL version 2 (OpenGL ES 3.0).
   */
  "webgl2",

  /**
   * The context type designates a {@link ImageBitmapRenderingContext}.
   * The context provides functionality to replace the content of the canvas with a given ImageBitmap.
   */
  "bitmaprenderer"
};

partial interface HTMLCanvasElement {
  RenderingContext? getContext( RenderContextType contextId, optional (CanvasRenderingContext2DSettings or ImageBitmapRenderingContextSettings or WebGLContextAttributes) options = null );
};

const enum ApplicationCacheStatus {
  ApplicationCache.UNCACHED,
  ApplicationCache.IDLE,
  ApplicationCache.CHECKING,
  ApplicationCache.DOWNLOADING,
  ApplicationCache.UPDATEREADY,
  ApplicationCache.OBSOLETE
};

partial interface ApplicationCache {
  readonly attribute ApplicationCacheStatus status;
};

const enum EventSourceReadyState {
  EventSource.CONNECTING,
  EventSource.OPEN,
  EventSource.CLOSED
};

partial interface EventSource {
  readonly attribute EventSourceReadyState readyState;
};

const enum WebSocketReadyState {
  WebSocket.CONNECTING,
  WebSocket.OPEN,
  WebSocket.CLOSING,
  WebSocket.CLOSED
};

partial interface WebSocket {
  readonly attribute WebSocketReadyState readyState;
};

const enum HTMLTrackElementReadyState {
  HTMLTrackElement.NONE,
  HTMLTrackElement.LOADING,
  HTMLTrackElement.LOADED,
  HTMLTrackElement.ERROR
};

partial interface HTMLTrackElement {
  readonly attribute HTMLTrackElementReadyState readyState;
};

const enum MediaErrorCode {
  MediaError.MEDIA_ERR_ABORTED,
  MediaError.MEDIA_ERR_NETWORK,
  MediaError.MEDIA_ERR_DECODE,
  MediaError.MEDIA_ERR_SRC_NOT_SUPPORTED
};

partial interface MediaError {
  readonly attribute MediaErrorCode code;
};

const enum HTMLMediaElementReadyState {
  HTMLMediaElement.HAVE_NOTHING,
  HTMLMediaElement.HAVE_CURRENT_DATA,
  HTMLMediaElement.HAVE_METADATA,
  HTMLMediaElement.HAVE_FUTURE_DATA,
  HTMLMediaElement.HAVE_ENOUGH_DATA
};

const enum HTMLMediaElementNetworkState {
  HTMLMediaElement.NETWORK_EMPTY,
  HTMLMediaElement.NETWORK_IDLE,
  HTMLMediaElement.NETWORK_LOADING,
  HTMLMediaElement.NETWORK_NO_SOURCE
};

partial interface HTMLMediaElement {
  readonly attribute HTMLMediaElementNetworkState networkState;
  readonly attribute HTMLMediaElementReadyState readyState;
};

partial dictionary PostMessageOptions {
  sequence<Transferable> transfer = [];
};
