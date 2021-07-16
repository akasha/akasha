[Exposed=(Window,Worker)]
interface PerformanceResourceTiming : PerformanceEntry {
  readonly attribute DOMHighResTimeStamp connectEnd;
  readonly attribute DOMHighResTimeStamp connectStart;
  readonly attribute unsigned long long decodedBodySize;
  readonly attribute DOMHighResTimeStamp domainLookupEnd;
  readonly attribute DOMHighResTimeStamp domainLookupStart;
  readonly attribute unsigned long long encodedBodySize;
  readonly attribute DOMHighResTimeStamp fetchStart;
  readonly attribute DOMString initiatorType;
  readonly attribute ByteString nextHopProtocol;
  readonly attribute DOMHighResTimeStamp redirectEnd;
  readonly attribute DOMHighResTimeStamp redirectStart;
  readonly attribute DOMHighResTimeStamp requestStart;
  readonly attribute DOMHighResTimeStamp responseEnd;
  readonly attribute DOMHighResTimeStamp responseStart;
  readonly attribute DOMHighResTimeStamp secureConnectionStart;
  readonly attribute unsigned long long transferSize;
  readonly attribute DOMHighResTimeStamp workerStart;
  [Default]
  object toJSON();
};

partial interface Performance {
  attribute EventHandler onresourcetimingbufferfull;
  undefined clearResourceTimings();
  undefined setResourceTimingBufferSize( unsigned long maxSize );
};
