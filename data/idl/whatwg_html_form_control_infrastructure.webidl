enum SelectionMode {
  "end",
  "preserve",
  "select",
  "start"
};

dictionary FormDataEventInit : EventInit {
  required FormData formData;
};

dictionary SubmitEventInit : EventInit {
  HTMLElement? submitter = null;
};

[Exposed=Window]
interface ValidityState {
  readonly attribute boolean badInput;
  readonly attribute boolean customError;
  readonly attribute boolean patternMismatch;
  readonly attribute boolean rangeOverflow;
  readonly attribute boolean rangeUnderflow;
  readonly attribute boolean stepMismatch;
  readonly attribute boolean tooLong;
  readonly attribute boolean tooShort;
  readonly attribute boolean typeMismatch;
  readonly attribute boolean valid;
  readonly attribute boolean valueMissing;
};

[Exposed=Window]
interface SubmitEvent : Event {
  readonly attribute HTMLElement? submitter;
  constructor( DOMString type, optional SubmitEventInit eventInitDict = {} );
};

[Exposed=Window]
interface FormDataEvent : Event {
  readonly attribute FormData formData;
  constructor( DOMString type, FormDataEventInit eventInitDict );
};
