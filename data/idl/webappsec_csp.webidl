enum SecurityPolicyViolationEventDisposition {
  "enforce",
  "report"
};

dictionary SecurityPolicyViolationEventInit : EventInit {
  USVString blockedURI = "";
  unsigned long columnNumber = 0;
  required SecurityPolicyViolationEventDisposition disposition;
  required USVString documentURI;
  required DOMString effectiveDirective;
  unsigned long lineNumber = 0;
  required DOMString originalPolicy;
  USVString referrer = "";
  DOMString sample = "";
  USVString sourceFile = "";
  required unsigned short statusCode;
  required DOMString violatedDirective;
};

[Exposed=Window]
interface CSPViolationReportBody : ReportBody {
  readonly attribute USVString? blockedURL;
  readonly attribute unsigned long? columnNumber;
  readonly attribute SecurityPolicyViolationEventDisposition disposition;
  readonly attribute USVString documentURL;
  readonly attribute DOMString effectiveDirective;
  readonly attribute unsigned long? lineNumber;
  readonly attribute DOMString originalPolicy;
  readonly attribute USVString? referrer;
  readonly attribute DOMString? sample;
  readonly attribute USVString? sourceFile;
  readonly attribute unsigned short statusCode;
};

[Exposed=(Window,Worker)]
interface SecurityPolicyViolationEvent : Event {
  readonly attribute USVString blockedURI;
  readonly attribute unsigned long columnNumber;
  readonly attribute SecurityPolicyViolationEventDisposition disposition;
  readonly attribute USVString documentURI;
  readonly attribute DOMString effectiveDirective;
  readonly attribute unsigned long lineNumber;
  readonly attribute DOMString originalPolicy;
  readonly attribute USVString referrer;
  readonly attribute DOMString sample;
  readonly attribute USVString sourceFile;
  readonly attribute unsigned short statusCode;
  readonly attribute DOMString violatedDirective;
  constructor( DOMString type, optional SecurityPolicyViolationEventInit eventInitDict = {} );
};
