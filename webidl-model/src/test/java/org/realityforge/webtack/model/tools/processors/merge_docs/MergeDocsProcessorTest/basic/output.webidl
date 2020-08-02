/**
 * Documentation for NodeFilter
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/NodeFilter">NodeFilter - MDN</a>
 */
[Exposed=Window]
callback interface NodeFilter {
  /**
   * Documentation for NodeFilter.FILTER_ACCEPT
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/NodeFilter/FILTER_ACCEPT">NodeFilter.FILTER_ACCEPT - MDN</a>
   */
  const unsigned short FILTER_ACCEPT = 1;
  const unsigned short FILTER_REJECT = 2;
  /**
   * Documentation for FILTER_SKIP.
   * This should be retained as there is no docs in doc repository
   */
  const unsigned short FILTER_SKIP = 3;
  /**
   * Documentation for NodeFilter.acceptNode
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/NodeFilter/acceptNode">NodeFilter.acceptNode - MDN</a>
   */
  unsigned short acceptNode( Node node );
};

dictionary EventInit {
};

/**
 * Documentation for Event. It covers multiple
 * lines.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event">Event - MDN</a>
 */
[Exposed=(Window,Worker,AudioWorklet)]
interface Event {
  /**
   * Documentation for Event.AT_TARGET constant.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/AT_TARGET">Event.AT_TARGET - MDN</a>
   */
  const unsigned short AT_TARGET = 2;
  /**
   * Documentation for Event.bubbles readonly attribute.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/bubbles">Event.bubbles - MDN</a>
   */
  readonly attribute boolean bubbles;
  /**
   * Documentation for Event.cancelBubble attribute.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/cancelBubble">Event.cancelBubble - MDN</a>
   */
  attribute boolean cancelBubble;
  /**
   * Documentation for Event.filterGlobalEvent static operation.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/filterGlobalEvent">Event.filterGlobalEvent - MDN</a>
   */
  static Event filterGlobalEvent( DOMString type );
  constructor( DOMString type, optional EventInit eventInitDict = {} );
  /**
   * Documentation for Event.composedPath operation.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/composedPath">Event.composedPath - MDN</a>
   */
  sequence<EventTarget> composedPath();
};

interface EventTarget {
};

interface Node {
};

/**
 * Documentation for Window partial.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window">Window - MDN</a>
 */
partial interface Window {
  /**
   * Documentation for Window.someVar
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/someVar">Window.someVar - MDN</a>
   */
  readonly attribute DOMString someVar;
};
