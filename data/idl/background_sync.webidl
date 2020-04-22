dictionary SyncEventInit : ExtendableEventInit {
  boolean lastChance = false;
  required DOMString tag;
};

[Constructor( DOMString type, SyncEventInit init ), Exposed=ServiceWorker]
interface SyncEvent : ExtendableEvent {
  readonly attribute boolean lastChance;
  readonly attribute DOMString tag;
};

[Exposed=(Window,Worker)]
interface SyncManager {
  Promise<sequence<DOMString>> getTags();
  Promise<void> register( DOMString tag );
};

partial interface ServiceWorkerRegistration {
  readonly attribute SyncManager sync;
};

partial interface ServiceWorkerGlobalScope {
  attribute EventHandler onsync;
};
