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
  required Request request;
  DOMString resultingClientId = "";
};

dictionary MultiCacheQueryOptions : CacheQueryOptions {
  DOMString cacheName;
};

dictionary NavigationPreloadState {
  boolean enabled = false;
  ByteString headerValue;
};

dictionary RegistrationOptions {
  USVString scope;
  WorkerType type = "classic";
  ServiceWorkerUpdateViaCache updateViaCache = "imports";
};

partial interface mixin WindowOrWorkerGlobalScope {
  [SecureContext, SameObject]
  readonly attribute CacheStorage caches;
};

[SecureContext, Exposed=(Window,Worker)]
interface Cache {
  [NewObject]
  Promise<undefined> add( RequestInfo request );
  [NewObject]
  Promise<undefined> addAll( sequence<RequestInfo> requests );
  [NewObject]
  Promise<boolean> delete( RequestInfo request, optional CacheQueryOptions options = {} );
  [NewObject]
  Promise<FrozenArray<Request>> keys( optional RequestInfo request, optional CacheQueryOptions options = {} );
  [NewObject]
  Promise<( Response or undefined )> match( RequestInfo request, optional CacheQueryOptions options = {} );
  [NewObject]
  Promise<FrozenArray<Response>> matchAll( optional RequestInfo request, optional CacheQueryOptions options = {} );
  [NewObject]
  Promise<undefined> put( RequestInfo request, Response response );
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
  Promise<( Response or undefined )> match( RequestInfo request, optional MultiCacheQueryOptions options = {} );
  [NewObject]
  Promise<Cache> open( DOMString cacheName );
};

[Exposed=ServiceWorker]
interface Client {
  readonly attribute FrameType frameType;
  readonly attribute DOMString id;
  readonly attribute ClientType type;
  readonly attribute USVString url;
  undefined postMessage( any message, sequence<object> transfer );
  undefined postMessage( any message, optional PostMessageOptions options = {} );
};

[Exposed=ServiceWorker]
interface Clients {
  [NewObject]
  Promise<undefined> claim();
  [NewObject]
  Promise<( Client or undefined )> get( DOMString id );
  [NewObject]
  Promise<FrozenArray<Client>> matchAll( optional ClientQueryOptions options = {} );
  [NewObject]
  Promise<WindowClient?> openWindow( USVString url );
};

[Exposed=ServiceWorker]
interface ExtendableEvent : Event {
  constructor( DOMString type, optional ExtendableEventInit eventInitDict = {} );
  undefined waitUntil( Promise<any> f );
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

[Exposed=ServiceWorker]
interface FetchEvent : ExtendableEvent {
  readonly attribute DOMString clientId;
  readonly attribute Promise<undefined> handled;
  readonly attribute Promise<any> preloadResponse;
  readonly attribute DOMString replacesClientId;
  [SameObject]
  readonly attribute Request request;
  readonly attribute DOMString resultingClientId;
  constructor( DOMString type, FetchEventInit eventInitDict );
  undefined respondWith( Promise<Response> r );
};

[SecureContext, Exposed=(Window,Worker)]
interface NavigationPreloadManager {
  Promise<undefined> disable();
  Promise<undefined> enable();
  Promise<NavigationPreloadState> getState();
  Promise<undefined> setHeaderValue( ByteString value );
};

[SecureContext, Exposed=(Window,Worker)]
interface ServiceWorker : EventTarget {
  readonly attribute USVString scriptURL;
  readonly attribute ServiceWorkerState state;
  attribute EventHandler onstatechange;
  undefined postMessage( any message, sequence<object> transfer );
  undefined postMessage( any message, optional PostMessageOptions options = {} );
};

[SecureContext, Exposed=(Window,Worker)]
interface ServiceWorkerContainer : EventTarget {
  readonly attribute ServiceWorker? controller;
  readonly attribute Promise<ServiceWorkerRegistration> ready;
  attribute EventHandler oncontrollerchange;
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  [NewObject]
  Promise<( ServiceWorkerRegistration or undefined )> getRegistration( optional USVString clientURL = "" );
  [NewObject]
  Promise<FrozenArray<ServiceWorkerRegistration>> getRegistrations();
  [NewObject]
  Promise<ServiceWorkerRegistration> register( USVString scriptURL, optional RegistrationOptions options = {} );
  undefined startMessages();
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
  Promise<undefined> skipWaiting();
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
  Promise<undefined> update();
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

partial interface Navigator {
  [SecureContext, SameObject]
  readonly attribute ServiceWorkerContainer serviceWorker;
};

partial interface WorkerNavigator {
  [SecureContext, SameObject]
  readonly attribute ServiceWorkerContainer serviceWorker;
};

ServiceWorker includes AbstractWorker;
