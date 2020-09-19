[Exposed=(Window,Worker), Serializable, Transferable]
interface ImageBitmap {
  readonly attribute unsigned long height;
  readonly attribute unsigned long width;
  void close();
};

[Exposed=(Window,Worker,AudioWorklet), Transferable]
interface MessagePort {
  void close();
  void postMessage( any message, [Transferable] sequence<object> transfer );
  void start();
};
