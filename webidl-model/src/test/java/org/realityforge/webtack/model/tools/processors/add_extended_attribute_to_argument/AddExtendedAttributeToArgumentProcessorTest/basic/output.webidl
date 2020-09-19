dictionary PostMessageOptions {
};

/**
 * This type is not matched by the filter.
 */
[Exposed=ServiceWorker]
interface Client {
  void postMessage( any message, sequence<object> transfer );
  void postMessage( any message, optional PostMessageOptions options = {} );
};

[Global=(Worker,DedicatedWorker), Exposed=DedicatedWorker]
interface DedicatedWorkerGlobalScope {
  void close();
  void postMessage( any message, [Transferables] sequence<object> transfer );
  void postMessage( any message, optional PostMessageOptions options = {} );
};

[Exposed=(Window,Worker), Serializable, Transferable]
interface ImageBitmap {
  readonly attribute unsigned long height;
  readonly attribute unsigned long width;
  void close();
};

[Exposed=(Window,Worker,AudioWorklet), Transferable]
interface MessagePort {
  void close();
  void postMessage( any message, [Transferables] sequence<object> transfer );
  /**
   * This argument matches but operation does not.
   */
  void start( sequence<object> transfer );
};
