callback IntersectionObserverCallback = void ( sequence<IntersectionObserverEntry> entries, IntersectionObserver observer );

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
  Element? root = null;
  DOMString rootMargin = "0px";
  ( double or sequence<double> ) threshold = 0;
};

[Constructor( IntersectionObserverCallback callback, optional IntersectionObserverInit options ), Exposed=Window]
interface IntersectionObserver {
  readonly attribute Element? root;
  readonly attribute DOMString rootMargin;
  readonly attribute FrozenArray<double> thresholds;
  void disconnect();
  void observe( Element target );
  sequence<IntersectionObserverEntry> takeRecords();
  void unobserve( Element target );
};

[Constructor( IntersectionObserverEntryInit intersectionObserverEntryInit )]
interface IntersectionObserverEntry {
  readonly attribute DOMRectReadOnly boundingClientRect;
  readonly attribute double intersectionRatio;
  readonly attribute DOMRectReadOnly intersectionRect;
  readonly attribute boolean isIntersecting;
  readonly attribute DOMRectReadOnly? rootBounds;
  readonly attribute Element target;
  readonly attribute DOMHighResTimeStamp time;
};
