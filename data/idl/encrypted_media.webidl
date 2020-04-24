enum MediaKeyMessageType {
  "individualization-request",
  "license-release",
  "license-renewal",
  "license-request"
};

enum MediaKeySessionType {
  "persistent-license",
  "temporary"
};

enum MediaKeyStatus {
  "expired",
  "internal-error",
  "output-downscaled",
  "output-restricted",
  "released",
  "status-pending",
  "usable"
};

enum MediaKeysRequirement {
  "not-allowed",
  "optional",
  "required"
};

dictionary MediaEncryptedEventInit : EventInit {
  ArrayBuffer? initData = null;
  DOMString initDataType = "";
};

dictionary MediaKeyMessageEventInit : EventInit {
  required ArrayBuffer message;
  required MediaKeyMessageType messageType;
};

dictionary MediaKeySystemConfiguration {
  sequence<MediaKeySystemMediaCapability> audioCapabilities = [];
  MediaKeysRequirement distinctiveIdentifier = "optional";
  sequence<DOMString> initDataTypes = [];
  DOMString label = "";
  MediaKeysRequirement persistentState = "optional";
  sequence<DOMString> sessionTypes;
  sequence<MediaKeySystemMediaCapability> videoCapabilities = [];
};

dictionary MediaKeySystemMediaCapability {
  DOMString contentType = "";
  DOMString robustness = "";
};

[Constructor( DOMString type, optional MediaEncryptedEventInit eventInitDict )]
interface MediaEncryptedEvent : Event {
  readonly attribute ArrayBuffer? initData;
  readonly attribute DOMString initDataType;
};

[SecureContext, Constructor( DOMString type, MediaKeyMessageEventInit eventInitDict )]
interface MediaKeyMessageEvent : Event {
  readonly attribute ArrayBuffer message;
  readonly attribute MediaKeyMessageType messageType;
};

[SecureContext]
interface MediaKeySession : EventTarget {
  readonly attribute Promise<void> closed;
  readonly attribute unrestricted double expiration;
  readonly attribute MediaKeyStatusMap keyStatuses;
  readonly attribute DOMString sessionId;
  attribute EventHandler onkeystatuseschange;
  attribute EventHandler onmessage;
  Promise<void> close();
  Promise<void> generateRequest( DOMString initDataType, BufferSource initData );
  Promise<boolean> load( DOMString sessionId );
  Promise<void> remove();
  Promise<void> update( BufferSource response );
};

[SecureContext]
interface MediaKeyStatusMap {
  iterable<BufferSource, MediaKeyStatus>;
  readonly attribute unsigned long size;
  any get( BufferSource keyId );
  boolean has( BufferSource keyId );
};

[SecureContext]
interface MediaKeySystemAccess {
  readonly attribute DOMString keySystem;
  Promise<MediaKeys> createMediaKeys();
  MediaKeySystemConfiguration getConfiguration();
};

[SecureContext]
interface MediaKeys {
  MediaKeySession createSession( optional MediaKeySessionType sessionType = "temporary" );
  Promise<boolean> setServerCertificate( BufferSource serverCertificate );
};

partial interface HTMLMediaElement {
  [SecureContext]
  readonly attribute MediaKeys? mediaKeys;
  attribute EventHandler onencrypted;
  attribute EventHandler onwaitingforkey;
  [SecureContext]
  Promise<void> setMediaKeys( MediaKeys? mediaKeys );
};

partial interface Navigator {
  [SecureContext]
  Promise<MediaKeySystemAccess> requestMediaKeySystemAccess( DOMString keySystem, sequence<MediaKeySystemConfiguration> supportedConfigurations );
};
