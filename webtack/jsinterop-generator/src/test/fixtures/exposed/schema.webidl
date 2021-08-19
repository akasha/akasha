[Global=(Worklet,AudioWorklet), Exposed=AudioWorklet]
interface AudioWorkletGlobalScope : WorkletGlobalScope {
  readonly attribute DOMString audioWorkletGlobalScopeAttribute;
};

[Global=(Worker,DedicatedWorker), Exposed=DedicatedWorker]
interface DedicatedWorkerGlobalScope : WorkerGlobalScope {
  readonly attribute DOMString dedicatedWorkerGlobalScopeAttribute;
};

interface EventTarget {
};

[Global=(Worker,ServiceWorker), Exposed=ServiceWorker]
interface ServiceWorkerGlobalScope : WorkerGlobalScope {
  readonly attribute DOMString serviceWorkerGlobalScopeAttribute;
};

[Global=(Worker,SharedWorker), Exposed=SharedWorker]
interface SharedWorkerGlobalScope : WorkerGlobalScope {
  readonly attribute DOMString sharedWorkerGlobalScopeAttribute;
};

[Global=Window, Exposed=Window]
interface Window : EventTarget {
  readonly attribute DOMString windowAttribute;
};

[Exposed=Worker]
interface WorkerGlobalScope : EventTarget {
  readonly attribute DOMString workerGlobalScopeAttribute;
};

[Exposed=Worklet, SecureContext]
interface WorkletGlobalScope {
  readonly attribute DOMString workletGlobalScopeAttribute;
};
