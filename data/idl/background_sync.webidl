dictionary SyncEventInit : ExtendableEventInit {
  boolean lastChance = false;
  required DOMString tag;
};

[Exposed=ServiceWorker]
interface SyncEvent : ExtendableEvent {
  readonly attribute boolean lastChance;
  readonly attribute DOMString tag;
  constructor( DOMString type, SyncEventInit init );
};

[Exposed=(Window,Worker)]
interface SyncManager {
  Promise<sequence<DOMString>> getTags();
  Promise<void> register( DOMString tag );
};

partial interface ServiceWorkerGlobalScope {
  attribute EventHandler onsync;
};

partial interface ServiceWorkerRegistration {
  readonly attribute SyncManager sync;
};
