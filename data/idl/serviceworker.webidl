enum ServiceWorkerState {
  "activated",
  "activating",
  "installed",
  "installing",
  "parsed",
  "redundant"
};

enum ServiceWorkerUpdateViaCache {
  "all",
  "imports",
  "none"
};

enum ClientType {
  "all",
  "sharedworker",
  "window",
  "worker"
};

enum FrameType {
  "auxiliary",
  "nested",
  "none",
  "top-level"
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

dictionary ClientQueryOptions {
  boolean includeUncontrolled = false;
  ClientType type = "window";
};

dictionary CacheQueryOptions {
  boolean ignoreMethod = false;
  boolean ignoreSearch = false;
  boolean ignoreVary = false;
};

dictionary MultiCacheQueryOptions : CacheQueryOptions {
  DOMString cacheName;
};

dictionary RegistrationOptions {
  USVString scope;
  WorkerType type = "classic";
  ServiceWorkerUpdateViaCache updateViaCache = "imports";
};

dictionary NavigationPreloadState {
  boolean enabled = false;
  ByteString headerValue;
};

dictionary FetchEventInit : ExtendableEventInit {
  DOMString clientId = "";
  Promise<void> handled;
  Promise<any> preloadResponse;
  DOMString replacesClientId = "";
  required Request request;
  DOMString resultingClientId = "";
};

partial interface mixin WindowOrWorkerGlobalScope {
  [SecureContext, SameObject]
  readonly attribute CacheStorage caches;
};

[SecureContext, Exposed=(Window,Worker)]
interface CacheStorage {
  [NewObject]
  Promise<boolean> delete( DOMString cacheName );
  [NewObject]
  Promise<boolean> has( DOMString cacheName );
  [NewObject]
  Promise<sequence<DOMString>> keys();
  [NewObject]
  Promise<any> match( RequestInfo request, optional MultiCacheQueryOptions options = {} );
  [NewObject]
  Promise<Cache> open( DOMString cacheName );
};

[Exposed=ServiceWorker]
interface FetchEvent : ExtendableEvent {
  readonly attribute DOMString clientId;
  readonly attribute Promise<void> handled;
  readonly attribute Promise<any> preloadResponse;
  readonly attribute DOMString replacesClientId;
  [SameObject]
  readonly attribute Request request;
  readonly attribute DOMString resultingClientId;
  constructor( DOMString type, FetchEventInit eventInitDict );
  void respondWith( Promise<Response> r );
};

[Exposed=ServiceWorker]
interface ExtendableEvent : Event {
  constructor( DOMString type, optional ExtendableEventInit eventInitDict = {} );
  void waitUntil( Promise<any> f );
};

[Global=(Worker,ServiceWorker), Exposed=ServiceWorker]
interface ServiceWorkerGlobalScope : WorkerGlobalScope {
  [SameObject]
  readonly attribute Clients clients;
  [SameObject]
  readonly attribute ServiceWorkerRegistration registration;
  [SameObject]
  readonly attribute ServiceWorker serviceWorker;
  attribute EventHandler onactivate;
  attribute EventHandler onfetch;
  attribute EventHandler oninstall;
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  [NewObject]
  Promise<void> skipWaiting();
};

[Exposed=ServiceWorker]
interface Clients {
  [NewObject]
  Promise<void> claim();
  [NewObject]
  Promise<any> get( DOMString id );
  [NewObject]
  Promise<FrozenArray<Client>> matchAll( optional ClientQueryOptions options = {} );
  [NewObject]
  Promise<WindowClient?> openWindow( USVString url );
};

[SecureContext, Exposed=(Window,Worker)]
interface NavigationPreloadManager {
  Promise<void> disable();
  Promise<void> enable();
  Promise<NavigationPreloadState> getState();
  Promise<void> setHeaderValue( ByteString value );
};

[Exposed=ServiceWorker]
interface WindowClient : Client {
  [SameObject]
  readonly attribute FrozenArray<USVString> ancestorOrigins;
  readonly attribute boolean focused;
  readonly attribute VisibilityState visibilityState;
  [NewObject]
  Promise<WindowClient> focus();
  [NewObject]
  Promise<WindowClient?> navigate( USVString url );
};

[SecureContext, Exposed=(Window,Worker)]
interface ServiceWorkerRegistration : EventTarget {
  readonly attribute ServiceWorker? active;
  readonly attribute ServiceWorker? installing;
  [SameObject]
  readonly attribute NavigationPreloadManager navigationPreload;
  readonly attribute USVString scope;
  readonly attribute ServiceWorkerUpdateViaCache updateViaCache;
  readonly attribute ServiceWorker? waiting;
  attribute EventHandler onupdatefound;
  [NewObject]
  Promise<boolean> unregister();
  [NewObject]
  Promise<void> update();
};

[Exposed=ServiceWorker]
interface ExtendableMessageEvent : ExtendableEvent {
  readonly attribute any data;
  readonly attribute DOMString lastEventId;
  readonly attribute USVString origin;
  readonly attribute FrozenArray<MessagePort> ports;
  [SameObject]
  readonly attribute ( Client or ServiceWorker or MessagePort )? source;
  constructor( DOMString type, optional ExtendableMessageEventInit eventInitDict = {} );
};

[SecureContext, Exposed=(Window,Worker)]
interface ServiceWorker : EventTarget {
  readonly attribute USVString scriptURL;
  readonly attribute ServiceWorkerState state;
  attribute EventHandler onstatechange;
  void postMessage( any message, sequence<object> transfer );
  void postMessage( any message, optional PostMessageOptions options = {} );
};

[SecureContext, Exposed=(Window,Worker)]
interface ServiceWorkerContainer : EventTarget {
  readonly attribute ServiceWorker? controller;
  readonly attribute Promise<ServiceWorkerRegistration> ready;
  attribute EventHandler oncontrollerchange;
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  [NewObject]
  Promise<any> getRegistration( optional USVString clientURL = "" );
  [NewObject]
  Promise<FrozenArray<ServiceWorkerRegistration>> getRegistrations();
  [NewObject]
  Promise<ServiceWorkerRegistration> register( USVString scriptURL, optional RegistrationOptions options = {} );
  void startMessages();
};

[Exposed=ServiceWorker]
interface Client {
  readonly attribute FrameType frameType;
  readonly attribute DOMString id;
  readonly attribute ClientType type;
  readonly attribute USVString url;
  void postMessage( any message, sequence<object> transfer );
  void postMessage( any message, optional PostMessageOptions options = {} );
};

[SecureContext, Exposed=(Window,Worker)]
interface Cache {
  [NewObject]
  Promise<void> add( RequestInfo request );
  [NewObject]
  Promise<void> addAll( sequence<RequestInfo> requests );
  [NewObject]
  Promise<boolean> delete( RequestInfo request, optional CacheQueryOptions options = {} );
  [NewObject]
  Promise<FrozenArray<Request>> keys( optional RequestInfo request, optional CacheQueryOptions options = {} );
  [NewObject]
  Promise<any> match( RequestInfo request, optional CacheQueryOptions options = {} );
  [NewObject]
  Promise<FrozenArray<Response>> matchAll( optional RequestInfo request, optional CacheQueryOptions options = {} );
  [NewObject]
  Promise<void> put( RequestInfo request, Response response );
};

partial interface Navigator {
  [SecureContext, SameObject]
  readonly attribute ServiceWorkerContainer serviceWorker;
};

partial interface WorkerNavigator {
  [SecureContext, SameObject]
  readonly attribute ServiceWorkerContainer serviceWorker;
};

ServiceWorker includes AbstractWorker;
