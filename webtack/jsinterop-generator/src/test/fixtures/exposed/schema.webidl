typedef EventHandler? NullableEventHandler;

callback EventHandler = undefined ( Event event );

callback MessageEventHandler = undefined ( MessageEvent event );

[Global=(Worklet,AudioWorklet), Exposed=AudioWorklet]
interface AudioWorkletGlobalScope : WorkletGlobalScope {
  readonly attribute DOMString audioWorkletGlobalScopeAttribute;
};

[Global=(Worker,DedicatedWorker), Exposed=DedicatedWorker]
interface DedicatedWorkerGlobalScope : WorkerGlobalScope {
  readonly attribute DOMString dedicatedWorkerGlobalScopeAttribute;
};

interface Event {
};

interface EventTarget {
};

interface MessageEvent : Event {
};

[Global=(Worker,ServiceWorker), Exposed=ServiceWorker]
interface ServiceWorkerGlobalScope : WorkerGlobalScope {
  readonly attribute DOMString serviceWorkerGlobalScopeAttribute;
};

[Global=(Worker,SharedWorker), Exposed=SharedWorker]
interface SharedWorkerGlobalScope : WorkerGlobalScope {
  readonly attribute DOMString sharedWorkerGlobalScopeAttribute;
  /**
   * Operation appears in Window scope with different typing
   */
  attribute MessageEventHandler? onmessageerror;
  /**
   * Operation appears in Window scope with same typing
   */
  attribute EventHandler? onstuff;
  /**
   * Operation also appears in Window scope with same typing
   */
  unsigned long requestAnimationFrame( any callback );
  /**
   * Operation also appears in Window scope with different typing
   */
  unsigned long requestAnimationFrame2( DOMString callbackId );
};

[Global=Window, Exposed=Window]
interface Window : EventTarget {
  readonly attribute DOMString windowAttribute;
  /**
   * Operation appears in SharedWorker scope with different typing
   */
  attribute NullableEventHandler onmessageerror;
  /**
   * Operation appears in SharedWorker scope with same typing
   */
  attribute EventHandler? onstuff;
  /**
   * Operation also appears in SharedWorker scope with same typing
   */
  unsigned long requestAnimationFrame( any callback );
  /**
   * Operation also appears in SharedWorker scope with different typing
   */
  unsigned long requestAnimationFrame2( long callbackId );
};

[Exposed=Worker]
interface WorkerGlobalScope : EventTarget {
  readonly attribute DOMString workerGlobalScopeAttribute;
};

[Exposed=Worklet, SecureContext]
interface WorkletGlobalScope {
  readonly attribute DOMString workletGlobalScopeAttribute;
};
