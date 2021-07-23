enum ServiceWorkerUpdateViaCache {
  "all",
  "imports",
  "none"
};

dictionary CacheQueryOptions {
  boolean ignoreMethod = false;
  boolean ignoreSearch = false;
  boolean ignoreVary = false;
};

dictionary ClientQueryOptions {
  boolean includeUncontrolled = false;
  ClientType type = "window";
};

dictionary ExtendableEventInit : EventInit {
};

dictionary ExtendableMessageEventInit : ExtendableEventInit {
  any data = null;
  DOMString lastEventId = "";
  USVString origin = "";
  sequence<MessagePort> ports = [];
  ( Client or ServiceWorker or MessagePort )? source = null;
};

dictionary FetchEventInit : ExtendableEventInit {
  DOMString clientId = "";
  Promise<undefined> handled;
  Promise<any> preloadResponse;
  DOMString replacesClientId = "";
  DOMString resultingClientId = "";
  required Request request;
};
