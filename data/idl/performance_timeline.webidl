typedef sequence<PerformanceEntry> PerformanceEntryList;

callback PerformanceObserverCallback = void ( PerformanceObserverEntryList entries, PerformanceObserver observer, optional boolean hasDroppedEntry = false );

dictionary PerformanceObserverInit {
  boolean buffered;
  sequence<DOMString> entryTypes;
  DOMString type;
};

[Exposed=(Window,Worker)]
interface PerformanceEntry {
  readonly attribute DOMHighResTimeStamp duration;
  readonly attribute DOMString entryType;
  readonly attribute DOMString name;
  readonly attribute DOMHighResTimeStamp startTime;
  [Default]
  object toJSON();
};

[Exposed=(Window,Worker)]
interface PerformanceObserver {
  [SameObject]
  static readonly attribute FrozenArray<DOMString> supportedEntryTypes;
  constructor( PerformanceObserverCallback callback );
  void disconnect();
  void observe( optional PerformanceObserverInit options = {} );
  PerformanceEntryList takeRecords();
};

[Exposed=(Window,Worker)]
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
