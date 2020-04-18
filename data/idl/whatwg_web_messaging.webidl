[Constructor, Exposed=(Window,Worker)]
interface MessageChannel {
  readonly attribute MessagePort port1;
  readonly attribute MessagePort port2;
};

[Exposed=(Window,Worker,AudioWorklet), Transferable]
interface MessagePort : EventTarget {
  void postMessage(any message, sequence<object> transfer);
  void postMessage(any message, optional PostMessageOptions options = {});
  void start();
  void close();

  // event handlers
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
};

dictionary PostMessageOptions {
  sequence<object> transfer = [];
};

[Exposed=(Window,Worker)]
interface BroadcastChannel : EventTarget {
  constructor(DOMString name);

  readonly attribute DOMString name;
  void postMessage(any message);
  void close();
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
};