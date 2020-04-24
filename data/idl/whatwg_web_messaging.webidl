dictionary PostMessageOptions {
  sequence<object> transfer = [];
};

[Exposed=(Window,Worker)]
interface BroadcastChannel : EventTarget {
  readonly attribute DOMString name;
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  constructor( DOMString name );
  void close();
  void postMessage( any message );
};

[Constructor, Exposed=(Window,Worker)]
interface MessageChannel {
  readonly attribute MessagePort port1;
  readonly attribute MessagePort port2;
};

[Exposed=(Window,Worker,AudioWorklet), Transferable]
interface MessagePort : EventTarget {
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  void close();
  void postMessage( any message, sequence<object> transfer );
  void postMessage( any message, optional PostMessageOptions options = {} );
  void start();
};
