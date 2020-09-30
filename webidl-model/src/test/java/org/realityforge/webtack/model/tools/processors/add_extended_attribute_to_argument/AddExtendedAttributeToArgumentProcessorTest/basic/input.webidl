dictionary PostMessageOptions {
};

/**
 * This type is not matched by the filter.
 */
[Exposed=ServiceWorker]
interface Client {
  undefined postMessage( any message, sequence<object> transfer );
  undefined postMessage( any message, optional PostMessageOptions options = {} );
};

[Global=(Worker,DedicatedWorker), Exposed=DedicatedWorker]
interface DedicatedWorkerGlobalScope {
  undefined close();
  undefined postMessage( any message, sequence<object> transfer );
  undefined postMessage( any message, optional PostMessageOptions options = {} );
};

[Exposed=(Window,Worker), Serializable, Transferable]
interface ImageBitmap {
  readonly attribute unsigned long height;
  readonly attribute unsigned long width;
  undefined close();
};

[Exposed=(Window,Worker,AudioWorklet), Transferable]
interface MessagePort {
  undefined close();
  undefined postMessage( any message, sequence<object> transfer );
  /**
   * This argument matches but operation does not.
   */
  undefined start( sequence<object> transfer );
};
