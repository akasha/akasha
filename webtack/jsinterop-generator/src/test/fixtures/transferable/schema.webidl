dictionary PostMessageOptions {
  [Transferable]
  sequence<object> transfer = [];
};

[Serializable, Transferable]
interface ImageBitmap {
  readonly attribute unsigned long height;
  readonly attribute unsigned long width;
  undefined close();
};

[Transferable]
interface MessagePort {
  undefined close();
  undefined postMessage( any message, [Transferable] sequence<object> transfer );
  undefined start();
};
