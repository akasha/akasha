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
 * The WebXR Device API dictionary XRSessionInit specifies required and/or optional features when requesting a new XRSession by calling the navigator.xr.requestSession() method.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/XRSessionInit">XRSessionInit - MDN</a>
 */
dictionary XRSessionInit {
  /**
   * The XRSessionInit dictionary's optionalFeatures property specifies ...
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/XRSessionInit/optionalFeatures">XRSessionEventInit.optionalFeatures - MDN</a>
   */
  sequence<any> optionalFeatures;
};

/**
 * The WebXR Device API dictionary XRSessionInit specifies required and/or optional features when requesting a new XRSession by calling the navigator.xr.requestSession() method.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/XRSessionInit">XRSessionInit - MDN</a>
 */
partial dictionary XRSessionInit {
  /**
   * The XRSessionInit dictionary's requiredFeatures property specifies ...
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/XRSessionInit/requiredFeatures">XRSessionEventInit.requiredFeatures - MDN</a>
   */
  sequence<any> requiredFeatures;
};

/**
 * The GlobalEventHandlers mixin describes the event handlers common to several interfaces like HTMLElement, Document, or Window.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers">GlobalEventHandlers - MDN</a>
 */
interface mixin GlobalEventHandlers {
  /**
   * The onabort property of the GlobalEventHandlers mixin is the EventHandler for processing abort events sent to the window.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onabort">GlobalEventHandlers.onabort - MDN</a>
   */
  attribute EventHandler onabort;
  /**
   * The abort event...
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Element/abort_event">abort event - MDN</a>
   */
  event Event abort;
  /**
   * The focus event fires when an element has received focus.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Element/focus_event">focus event - MDN</a>
   */
  event FocusEvent focus;
  event Event undocumented2;
};

/**
 * The GlobalEventHandlers mixin describes the event handlers common to several interfaces like HTMLElement, Document, or Window.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers">GlobalEventHandlers - MDN</a>
 */
partial interface mixin GlobalEventHandlers {
  /**
   * The onblur property of the GlobalEventHandlers mixin is the EventHandler for processing blur events. It's available on Element, Document, and Window.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onblur">GlobalEventHandlers.onblur - MDN</a>
   */
  attribute EventHandler onblur;
  /**
   * The abort event...
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Element/abort_event">abort event - MDN</a>
   */
  event Event abort;
  /**
   * The blur event...
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Element/blur_event">blur event - MDN</a>
   */
  event BlurEvent blur;
  /**
   * The focus event fires when an element has received focus.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Element/focus_event">focus event - MDN</a>
   */
  event FocusEvent focus;
  /**
   * Existing documentation...
   */
  event Event other;
  event Event undocumented;
};

interface BlurEvent : Event {
};

interface DeviceMotionEvent : Event {
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

interface FocusEvent : Event {
};

interface HTMLFormElement {
  event Event focus;
  /**
   * The reset event fires when a form is reset.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLFormElement/reset_event">reset event - MDN</a>
   */
  [NoBubble, NoCancel]
  event Event reset;
};

interface Node {
  event Event eventnoexisto;
};

/**
 * Documentation for Window partial.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window">Window - MDN</a>
 */
interface Window {
  /**
   * The devicemotion event is fired at a regular interval and indicates the amount of physical force of acceleration the device is receiving at that time. It also provides information about the rate of rotation, if available.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/devicemotion_event">devicemotion event - MDN</a>
   */
  event DeviceMotionEvent devicemotion;
  /**
   * The focus event fires when a Window has received focus.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/focus_event">focus event - MDN</a>
   */
  event Event focus;
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
  /**
   * The orientationchange event is fired when the orientation of the device has changed.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/orientationchange_event">orientationchange event - MDN</a>
   */
  event Event orientationchange;
};
