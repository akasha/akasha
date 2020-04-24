dictionary HashChangeEventInit : EventInit {
  USVString newURL = "";
  USVString oldURL = "";
};

dictionary PageTransitionEventInit : EventInit {
  boolean persisted = false;
};

dictionary PopStateEventInit : EventInit {
  any state = null;
};

[Exposed=Window]
interface BeforeUnloadEvent : Event {
  attribute DOMString returnValue;
};

[Exposed=Window, Constructor( DOMString type, optional HashChangeEventInit eventInitDict = {} )]
interface HashChangeEvent : Event {
  readonly attribute USVString newURL;
  readonly attribute USVString oldURL;
};

[Exposed=Window, Constructor( DOMString type, optional PageTransitionEventInit eventInitDict = {} )]
interface PageTransitionEvent : Event {
  readonly attribute boolean persisted;
};

[Exposed=Window, Constructor( DOMString type, optional PopStateEventInit eventInitDict = {} )]
interface PopStateEvent : Event {
  readonly attribute any state;
};
