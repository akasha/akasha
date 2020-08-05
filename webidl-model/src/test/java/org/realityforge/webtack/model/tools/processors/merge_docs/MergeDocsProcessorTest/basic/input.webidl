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

interface Node {
};

partial interface Window {
  readonly attribute DOMString someVar;
};

interface mixin GlobalEventHandlers {
  attribute EventHandler onabort;
};

partial interface mixin GlobalEventHandlers {
  attribute EventHandler onblur;
};
