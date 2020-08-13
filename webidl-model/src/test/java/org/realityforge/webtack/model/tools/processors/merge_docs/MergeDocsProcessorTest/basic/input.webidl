[Exposed=Window]
callback interface NodeFilter {
  const unsigned short FILTER_ACCEPT = 1;
  const unsigned short FILTER_REJECT = 2;
  /**
   * Documentation for FILTER_SKIP.
   * This should be retained as there is no docs in doc repository
   */
  const unsigned short FILTER_SKIP = 3;
  unsigned short acceptNode( Node node );
};

dictionary EventInit {
};

dictionary XRSessionInit {
  sequence<any> optionalFeatures;
};

partial dictionary XRSessionInit {
  sequence<any> requiredFeatures;
};

interface mixin GlobalEventHandlers {
  attribute EventHandler onabort;
  event Event abort;
  event Event undocumented2;
};

partial interface mixin GlobalEventHandlers {
  attribute EventHandler onblur;
  event BlurEvent blur;
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

[Exposed=(Window,Worker,AudioWorklet)]
interface Event {
  const unsigned short AT_TARGET = 2;
  readonly attribute boolean bubbles;
  attribute boolean cancelBubble;
  static Event filterGlobalEvent( DOMString type );
  constructor( DOMString type, optional EventInit eventInitDict = {} );
  sequence<EventTarget> composedPath();
};

interface EventTarget {
};

interface FocusEvent : Event {
};

interface HTMLFormElement {
  event Event focus;
};

interface Node {
  event Event eventnoexisto;
};

interface Window {
  event Event focus;
};

partial interface Window {
  readonly attribute DOMString someVar;
  event Event orientationchange;
};
