partial interface Performance {
        PerformanceEntryList getEntries ();
        PerformanceEntryList getEntriesByType (DOMString type);
        PerformanceEntryList getEntriesByName (DOMString name, optional DOMString type);
      };
      typedef sequence<PerformanceEntry> PerformanceEntryList;

[Exposed=(Window,Worker)]
      interface PerformanceEntry {
        readonly    attribute DOMString           name;
        readonly    attribute DOMString           entryType;
        readonly    attribute DOMHighResTimeStamp startTime;
        readonly    attribute DOMHighResTimeStamp duration;
        [Default] object toJSON();
      };

callback PerformanceObserverCallback = void (PerformanceObserverEntryList entries,
                                                   PerformanceObserver observer);
      [Exposed=(Window,Worker)]
      interface PerformanceObserver {
        constructor(PerformanceObserverCallback callback);
        void observe (optional PerformanceObserverInit options = {});
        void disconnect ();
        PerformanceEntryList takeRecords();
        [SameObject] static readonly attribute FrozenArray<DOMString> supportedEntryTypes;
      };

dictionary PerformanceObserverInit {
            sequence<DOMString> entryTypes;
            DOMString type;
            boolean buffered;
          };

[Exposed=(Window,Worker)]
          interface PerformanceObserverEntryList {
            PerformanceEntryList getEntries();
            PerformanceEntryList getEntriesByType (DOMString type);
            PerformanceEntryList getEntriesByName (DOMString name, optional DOMString type);
          };