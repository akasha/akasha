[Exposed=(Window,Worker)]
interface PerformanceMeasure : PerformanceEntry {
};

[Exposed=(Window,Worker)]
interface PerformanceMark : PerformanceEntry {
};

partial interface Performance {
  void clearMarks( optional DOMString markName );
  void clearMeasures( optional DOMString measureName );
  void mark( DOMString markName );
  void measure( DOMString measureName, optional DOMString startMark, optional DOMString endMark );
};
