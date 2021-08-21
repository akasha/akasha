/**
 * Documentation for SpeechRecognitionErrorCode.
 *
 * @see <a href="http://example.com/API/SpeechRecognitionErrorCode">SpeechRecognitionErrorCode - MDN</a>
 */
enum SpeechRecognitionErrorCode {
  /**
   * Documentation for SpeechRecognitionErrorCode.aborted with a link ala {@link SpeechRecognitionErrorCode}.
   *
   * @see <a href="http://example.com/API/SpeechRecognitionErrorCode/aborted">SpeechRecognitionErrorCode.aborted - MDN</a>
   */
  "aborted"
};

/**
 * Documentation for OnActionHandler.
 * Arbitrary link to {@link SpeechRecognitionErrorCode} and {@link NodeFilter filter}.
 *
 * @see <a href="http://example.com/API/OnActionHandler">OnActionHandler - MDN</a>
 */
callback OnActionHandler = undefined ( optional DOMString type );

/**
 * Documentation for NodeFilter.
 *
 * @see <a href="http://example.com/API/NodeFilter">NodeFilter - MDN</a>
 */
callback interface NodeFilter {
  /**
   * Documentation for FILTER_ACCEPT.
   *
   * @see <a href="http://example.com/API/NodeFilter/FILTER_ACCEPT">NodeFilter.FILTER_ACCEPT - MDN</a>
   */
  const unsigned short FILTER_ACCEPT = 1;
  /**
   * Documentation for acceptNode.
   *
   * @param node the node.
   * @return the code.
   * @see <a href="http://example.com/API/NodeFilter/acceptNode">NodeFilter.acceptNode - MDN</a>
   */
  unsigned short acceptNode( Node node );
};

/**
 * Documentation for EventInit.
 */
dictionary EventInit {
  /**
   * Documentation for member EventInit.bubbles.
   */
  boolean bubbles = false;
  /**
   * Documentation for required member EventInit.cancelable.
   */
  required boolean cancelable;
};

/**
 * Documentation for Event. It covers multiple
 * lines.
 *
 * @see <a href="http://example.com/API/Event">Event - MDN</a>
 */
interface Event {
  /**
   * Documentation for constant Event.AT_TARGET.
   *
   * @see <a href="http://example.com/API/Event/AT_TARGET">Event.AT_TARGET - MDN</a>
   */
  const unsigned short AT_TARGET = 2;
  /**
   * Documentation for readonly attribute Event.bubbles. It covers multiple
   * lines.
   *
   * @see <a href="http://example.com/API/Event/bubbles">Event.bubbles - MDN</a>
   */
  readonly attribute boolean bubbles;
  /**
   * Documentation for attribute Event.cancelBubble. It covers multiple
   * lines.
   *
   * @see <a href="http://example.com/API/Event/cancelBubble">Event.cancelBubble - MDN</a>
   */
  attribute boolean cancelBubble;
  /**
   * Documentation for Event.filterGlobalEvent.
   *
   * @param type the type of the event.
   * @return the event.
   * @see <a href="http://example.com/API/Event/filterGlobalEvent">Event.filterGlobalEvent - MDN</a>
   */
  static Event filterGlobalEvent( DOMString type );
  /**
   * Documentation for Event constructor.
   *
   * @param type this is one of the valid types. See <a href="http://example.com/someUrl">Event Types</a>.
   * @param eventInitDict initialization data for event.
   * @see <a href="http://example.com/API/Event/Event">Event.Event - MDN</a>
   */
  constructor( DOMString type, optional EventInit eventInitDict = {} );
  /**
   * Documentation for Event.composedPath.
   *
   * @return the path.
   * @see <a href="http://example.com/API/Event/composedPath">Event.composedPath - MDN</a>
   */
  sequence<EventTarget> composedPath();
};

interface EventTarget {
};

interface Node {
};

/**
 * Documentation for WindowToSoul type that defines a global execution context.
 *
 * @see <a href="http://example.com/API/WindowToSoul">WindowToSoul - MDN</a>
 */
[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface WindowToSoul {
  /**
   * Documentation for Window.someVar attribute.
   *
   * @see <a href="http://example.com/API/WindowToSoul/someVar">WindowToSoul.someVar - MDN</a>
   */
  [SameObject]
  readonly attribute DOMString someVar;
};

/**
 * Documentation for Window partial.
 *
 * @see <a href="http://example.com/API/Window">Window - MDN</a>
 */
partial interface Window {
  /**
   * Documentation for Window.someVar attribute.
   *
   * @see <a href="http://example.com/API/Window/someVar">Window.someVar - MDN</a>
   */
  [SameObject]
  readonly attribute DOMString someVar;
};
