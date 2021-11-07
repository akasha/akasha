typedef sequence<Report> ReportList;

callback ReportingObserverCallback = undefined ( sequence<Report> reports, ReportingObserver observer );

dictionary GenerateTestReportParameters {
  required DOMString message;
  DOMString group = "default";
};

dictionary ReportingObserverOptions {
  boolean buffered = false;
  sequence<DOMString> types;
};

[Exposed=(Window,Worker)]
interface Report {
  readonly attribute ReportBody? body;
  readonly attribute DOMString type;
  readonly attribute DOMString url;
  [Default]
  object toJSON();
};

[Exposed=(Window,Worker)]
interface ReportBody {
  [Default]
  object toJSON();
};

[Exposed=(Window,Worker)]
interface ReportingObserver {
  constructor( ReportingObserverCallback callback, optional ReportingObserverOptions options = {} );
  undefined disconnect();
  undefined observe();
  ReportList takeRecords();
};
