enum PushEncryptionKeyName {
  "auth",
  "p256dh"
};

typedef ( BufferSource or USVString ) PushMessageDataInit;

dictionary PushEventInit : ExtendableEventInit {
  PushMessageDataInit data;
};

dictionary PushPermissionDescriptor : PermissionDescriptor {
  boolean userVisibleOnly = false;
};

dictionary PushSubscriptionChangeEventInit : ExtendableEventInit {
  PushSubscription newSubscription = null;
  PushSubscription oldSubscription = null;
};

dictionary PushSubscriptionJSON {
  USVString endpoint;
  EpochTimeStamp? expirationTime = null;
  record<DOMString, USVString> keys;
};

dictionary PushSubscriptionOptionsInit {
  ( BufferSource or DOMString )? applicationServerKey = null;
  boolean userVisibleOnly = false;
};

[Exposed=ServiceWorker, SecureContext]
interface PushEvent : ExtendableEvent {
  readonly attribute PushMessageData? data;
  constructor( DOMString type, optional PushEventInit eventInitDict = {} );
};

[Exposed=(Window,Worker), SecureContext]
interface PushManager {
  [SameObject]
  static readonly attribute FrozenArray<DOMString> supportedContentEncodings;
  Promise<PushSubscription?> getSubscription();
  Promise<PermissionState> permissionState( optional PushSubscriptionOptionsInit options = {} );
  Promise<PushSubscription> subscribe( optional PushSubscriptionOptionsInit options = {} );
};

[Exposed=ServiceWorker, SecureContext]
interface PushMessageData {
  ArrayBuffer arrayBuffer();
  Blob blob();
  any json();
  USVString text();
};

[Exposed=(Window,Worker), SecureContext]
interface PushSubscription {
  readonly attribute USVString endpoint;
  readonly attribute EpochTimeStamp? expirationTime;
  [SameObject]
  readonly attribute PushSubscriptionOptions options;
  ArrayBuffer? getKey( PushEncryptionKeyName name );
  PushSubscriptionJSON toJSON();
  Promise<boolean> unsubscribe();
};

[Exposed=ServiceWorker, SecureContext]
interface PushSubscriptionChangeEvent : ExtendableEvent {
  readonly attribute PushSubscription? newSubscription;
  readonly attribute PushSubscription? oldSubscription;
  constructor( DOMString type, optional PushSubscriptionChangeEventInit eventInitDict = {} );
};

[Exposed=(Window,Worker), SecureContext]
interface PushSubscriptionOptions {
  [SameObject]
  readonly attribute ArrayBuffer? applicationServerKey;
  readonly attribute boolean userVisibleOnly;
};

[Exposed=ServiceWorker, SecureContext]
partial interface ServiceWorkerGlobalScope {
  attribute EventHandler onpush;
  attribute EventHandler onpushsubscriptionchange;
};

[SecureContext]
partial interface ServiceWorkerRegistration {
  readonly attribute PushManager pushManager;
};
