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

dictionary FetchEventInit : ExtendableEventInit {
  required Request request;
  DOMString clientId = "";
  Promise<undefined> handled;
  Promise<any> preloadResponse;
  DOMString replacesClientId = "";
  DOMString resultingClientId = "";
};
