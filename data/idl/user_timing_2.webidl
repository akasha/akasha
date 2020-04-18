partial interface Performance {
    void mark(DOMString markName);
    void clearMarks(optional DOMString markName);
    void measure(DOMString measureName, optional DOMString startMark, optional DOMString endMark);
    void clearMeasures(optional DOMString measureName);
};

[Exposed=(Window,Worker)]
interface PerformanceMark : PerformanceEntry {
};

[Exposed=(Window,Worker)]
interface PerformanceMeasure : PerformanceEntry {
};