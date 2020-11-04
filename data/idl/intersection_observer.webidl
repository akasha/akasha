callback IntersectionObserverCallback = undefined ( sequence<IntersectionObserverEntry> entries, IntersectionObserver observer );

dictionary IntersectionObserverEntryInit {
  required DOMRectInit boundingClientRect;
  required double intersectionRatio;
  required DOMRectInit intersectionRect;
  required boolean isIntersecting;
  required DOMRectInit? rootBounds;
  required Element target;
  required DOMHighResTimeStamp time;
};

dictionary IntersectionObserverInit {
  ( Element or Document )? root = null;
  DOMString rootMargin = "0px";
  ( double or sequence<double> ) threshold = 0;
};

[Exposed=Window]
interface IntersectionObserver {
  readonly attribute ( Element or Document )? root;
  readonly attribute DOMString rootMargin;
  readonly attribute FrozenArray<double> thresholds;
  constructor( IntersectionObserverCallback callback, optional IntersectionObserverInit options = {} );
  undefined disconnect();
  undefined observe( Element target );
  sequence<IntersectionObserverEntry> takeRecords();
  undefined unobserve( Element target );
};

[Exposed=Window]
interface IntersectionObserverEntry {
  readonly attribute DOMRectReadOnly boundingClientRect;
  readonly attribute double intersectionRatio;
  readonly attribute DOMRectReadOnly intersectionRect;
  readonly attribute boolean isIntersecting;
  readonly attribute DOMRectReadOnly? rootBounds;
  readonly attribute Element target;
  readonly attribute DOMHighResTimeStamp time;
  constructor( IntersectionObserverEntryInit intersectionObserverEntryInit );
};
