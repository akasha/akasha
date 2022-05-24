enum NavigationTimingType {
  "back_forward",
  "navigate",
  "prerender",
  "reload"
};

[Exposed=Window]
interface PerformanceNavigation {
  const unsigned short TYPE_BACK_FORWARD = 2;
  const unsigned short TYPE_NAVIGATE = 0;
  const unsigned short TYPE_RELOAD = 1;
  const unsigned short TYPE_RESERVED = 255;
  readonly attribute unsigned short redirectCount;
  readonly attribute unsigned short type;
  [Default]
  object toJSON();
};

[Exposed=Window]
interface PerformanceNavigationTiming : PerformanceResourceTiming {
  readonly attribute DOMHighResTimeStamp domComplete;
  readonly attribute DOMHighResTimeStamp domContentLoadedEventEnd;
  readonly attribute DOMHighResTimeStamp domContentLoadedEventStart;
  readonly attribute DOMHighResTimeStamp domInteractive;
  readonly attribute DOMHighResTimeStamp loadEventEnd;
  readonly attribute DOMHighResTimeStamp loadEventStart;
  readonly attribute unsigned short redirectCount;
  readonly attribute NavigationTimingType type;
  readonly attribute DOMHighResTimeStamp unloadEventEnd;
  readonly attribute DOMHighResTimeStamp unloadEventStart;
  [Default]
  object toJSON();
};

[Exposed=Window]
interface PerformanceTiming {
  readonly attribute unsigned long long connectEnd;
  readonly attribute unsigned long long connectStart;
  readonly attribute unsigned long long domComplete;
  readonly attribute unsigned long long domContentLoadedEventEnd;
  readonly attribute unsigned long long domContentLoadedEventStart;
  readonly attribute unsigned long long domInteractive;
  readonly attribute unsigned long long domLoading;
  readonly attribute unsigned long long domainLookupEnd;
  readonly attribute unsigned long long domainLookupStart;
  readonly attribute unsigned long long fetchStart;
  readonly attribute unsigned long long loadEventEnd;
  readonly attribute unsigned long long loadEventStart;
  readonly attribute unsigned long long navigationStart;
  readonly attribute unsigned long long redirectEnd;
  readonly attribute unsigned long long redirectStart;
  readonly attribute unsigned long long requestStart;
  readonly attribute unsigned long long responseEnd;
  readonly attribute unsigned long long responseStart;
  readonly attribute unsigned long long secureConnectionStart;
  readonly attribute unsigned long long unloadEventEnd;
  readonly attribute unsigned long long unloadEventStart;
  [Default]
  object toJSON();
};

[Exposed=Window]
partial interface Performance {
  [SameObject]
  readonly attribute PerformanceNavigation navigation;
  [SameObject]
  readonly attribute PerformanceTiming timing;
};
