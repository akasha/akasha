enum AttestationConveyancePreference {
  "direct",
  "enterprise",
  "indirect",
  "none"
};

enum AuthenticatorAttachment {
  "cross-platform",
  "platform"
};

enum AuthenticatorTransport {
  "ble",
  "internal",
  "nfc",
  "usb"
};

enum LargeBlobSupport {
  "preferred",
  "required"
};

enum PublicKeyCredentialType {
  "public-key"
};

enum ResidentKeyRequirement {
  "discouraged",
  "preferred",
  "required"
};

enum TokenBindingStatus {
  "present",
  "supported"
};

enum UserVerificationRequirement {
  "discouraged",
  "preferred",
  "required"
};

typedef long COSEAlgorithmIdentifier;

typedef sequence<UvmEntry> UvmEntries;

typedef sequence<unsigned long> UvmEntry;

dictionary AuthenticationExtensionsClientInputs {
};

dictionary AuthenticationExtensionsClientOutputs {
};

dictionary AuthenticationExtensionsLargeBlobInputs {
  boolean read;
  DOMString support;
  BufferSource write;
};

dictionary AuthenticationExtensionsLargeBlobOutputs {
  ArrayBuffer blob;
  boolean supported;
  boolean written;
};

dictionary AuthenticatorSelectionCriteria {
  DOMString authenticatorAttachment;
  boolean requireResidentKey = false;
  DOMString residentKey;
  DOMString userVerification = "preferred";
};

dictionary CollectedClientData {
  required DOMString challenge;
  boolean crossOrigin;
  required DOMString origin;
  TokenBinding tokenBinding;
  required DOMString type;
};

dictionary CredentialPropertiesOutput {
  boolean rk;
};

dictionary PublicKeyCredentialCreationOptions {
  DOMString attestation = "none";
  AuthenticatorSelectionCriteria authenticatorSelection;
  required BufferSource challenge;
  sequence<PublicKeyCredentialDescriptor> excludeCredentials = [];
  AuthenticationExtensionsClientInputs extensions;
  required sequence<PublicKeyCredentialParameters> pubKeyCredParams;
  required PublicKeyCredentialRpEntity rp;
  unsigned long timeout;
  required PublicKeyCredentialUserEntity user;
};

dictionary PublicKeyCredentialDescriptor {
  required BufferSource id;
  sequence<DOMString> transports;
  required DOMString type;
};

dictionary PublicKeyCredentialEntity {
  required DOMString name;
};

dictionary PublicKeyCredentialParameters {
  required COSEAlgorithmIdentifier alg;
  required DOMString type;
};

dictionary PublicKeyCredentialRequestOptions {
  sequence<PublicKeyCredentialDescriptor> allowCredentials = [];
  required BufferSource challenge;
  AuthenticationExtensionsClientInputs extensions;
  USVString rpId;
  unsigned long timeout;
  DOMString userVerification = "preferred";
};

dictionary PublicKeyCredentialRpEntity : PublicKeyCredentialEntity {
  DOMString id;
};

dictionary PublicKeyCredentialUserEntity : PublicKeyCredentialEntity {
  required DOMString displayName;
  required BufferSource id;
};

dictionary TokenBinding {
  DOMString id;
  required DOMString status;
};

partial dictionary AuthenticationExtensionsClientInputs {
  USVString appid;
};

partial dictionary AuthenticationExtensionsClientInputs {
  USVString appidExclude;
};

partial dictionary AuthenticationExtensionsClientInputs {
  boolean uvm;
};

partial dictionary AuthenticationExtensionsClientInputs {
  boolean credProps;
};

partial dictionary AuthenticationExtensionsClientInputs {
  AuthenticationExtensionsLargeBlobInputs largeBlob;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  boolean appid;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  boolean appidExclude;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  UvmEntries uvm;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  CredentialPropertiesOutput credProps;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  AuthenticationExtensionsLargeBlobOutputs largeBlob;
};

partial dictionary CredentialCreationOptions {
  PublicKeyCredentialCreationOptions publicKey;
};

partial dictionary CredentialRequestOptions {
  PublicKeyCredentialRequestOptions publicKey;
};

[SecureContext, Exposed=Window]
interface AuthenticatorAssertionResponse : AuthenticatorResponse {
  [SameObject]
  readonly attribute ArrayBuffer authenticatorData;
  [SameObject]
  readonly attribute ArrayBuffer signature;
  [SameObject]
  readonly attribute ArrayBuffer? userHandle;
};

[SecureContext, Exposed=Window]
interface AuthenticatorAttestationResponse : AuthenticatorResponse {
  [SameObject]
  readonly attribute ArrayBuffer attestationObject;
  ArrayBuffer getAuthenticatorData();
  ArrayBuffer? getPublicKey();
  COSEAlgorithmIdentifier getPublicKeyAlgorithm();
  sequence<DOMString> getTransports();
};

[SecureContext, Exposed=Window]
interface AuthenticatorResponse {
  [SameObject]
  readonly attribute ArrayBuffer clientDataJSON;
};

[SecureContext, Exposed=Window]
interface PublicKeyCredential : Credential {
  [SameObject]
  readonly attribute ArrayBuffer rawId;
  [SameObject]
  readonly attribute AuthenticatorResponse response;
  AuthenticationExtensionsClientOutputs getClientExtensionResults();
};

partial interface PublicKeyCredential {
  static Promise<boolean> isUserVerifyingPlatformAuthenticatorAvailable();
};
