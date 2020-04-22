typedef ( WindowProxy or MessagePort or ServiceWorker ) MessageEventSource;

dictionary MessageEventInit : EventInit {
  any data = null;
  DOMString lastEventId = "";
  USVString origin = "";
  sequence<MessagePort> ports = [];
  MessageEventSource? source = null;
};

[Exposed=(Window,Worker,AudioWorklet)]
interface MessageEvent : Event {
  readonly attribute any data;
  readonly attribute DOMString lastEventId;
  readonly attribute USVString origin;
  readonly attribute FrozenArray<MessagePort> ports;
  readonly attribute MessageEventSource? source;
  constructor( DOMString type, optional MessageEventInit eventInitDict = {} );
  void initMessageEvent( DOMString type, optional boolean bubbles = false, optional boolean cancelable = false, optional any data = null, optional USVString origin = "", optional DOMString lastEventId = "", optional MessageEventSource? source = null, optional sequence<MessagePort> ports = [] );
};
