typedef sequence<PerformanceEntry> PerformanceEntryList;

callback PerformanceObserverCallback = undefined ( PerformanceObserverEntryList entries, PerformanceObserver observer, optional PerformanceObserverCallbackOptions options = {} );

dictionary PerformanceObserverCallbackOptions {
  unsigned long long droppedEntriesCount;
};

dictionary PerformanceObserverInit {
  boolean buffered;
  sequence<DOMString> entryTypes;
  DOMString type;
};

[Exposed=*]
interface PerformanceEntry {
  readonly attribute DOMHighResTimeStamp duration;
  readonly attribute DOMString entryType;
  readonly attribute DOMString name;
  readonly attribute DOMHighResTimeStamp startTime;
  [Default]
  object toJSON();
};

[Exposed=*]
interface PerformanceObserver {
  [SameObject]
  static readonly attribute FrozenArray<DOMString> supportedEntryTypes;
  constructor( PerformanceObserverCallback callback );
  undefined disconnect();
  undefined observe( optional PerformanceObserverInit options = {} );
  PerformanceEntryList takeRecords();
};

[Exposed=*]
interface PerformanceObserverEntryList {
  PerformanceEntryList getEntries();
  PerformanceEntryList getEntriesByName( DOMString name, optional DOMString type );
  PerformanceEntryList getEntriesByType( DOMString type );
};

partial interface Performance {
  PerformanceEntryList getEntries();
  PerformanceEntryList getEntriesByName( DOMString name, optional DOMString type );
  PerformanceEntryList getEntriesByType( DOMString type );
};
