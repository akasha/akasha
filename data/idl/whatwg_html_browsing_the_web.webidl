[Exposed=Window,
 Constructor(DOMString type, optional PopStateEventInit eventInitDict = {})]
interface PopStateEvent : Event {
  readonly attribute any state;
};

dictionary PopStateEventInit : EventInit {
  any state = null;
};

[Exposed=Window,
 Constructor(DOMString type, optional HashChangeEventInit eventInitDict = {})]
interface HashChangeEvent : Event {
  readonly attribute USVString oldURL;
  readonly attribute USVString newURL;
};

dictionary HashChangeEventInit : EventInit {
  USVString oldURL = "";
  USVString newURL = "";
};

[Exposed=Window,
 Constructor(DOMString type, optional PageTransitionEventInit eventInitDict = {})]
interface PageTransitionEvent : Event {
  readonly attribute boolean persisted;
};

dictionary PageTransitionEventInit : EventInit {
  boolean persisted = false;
};

[Exposed=Window]
interface BeforeUnloadEvent : Event {
  attribute DOMString returnValue;
};