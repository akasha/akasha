enum AttestationConveyancePreference {
  "direct",
  "indirect",
  "none"
};

enum UserVerificationRequirement {
  "discouraged",
  "preferred",
  "required"
};

enum AuthenticatorAttachment {
  "cross-platform",
  "platform"
};

enum TokenBindingStatus {
  "present",
  "supported"
};

enum PublicKeyCredentialType {
  "public-key"
};

enum AuthenticatorTransport {
  "ble",
  "internal",
  "nfc",
  "usb"
};

typedef sequence<AAGUID> AuthenticatorSelectionList;

typedef sequence<unsigned long> UvmEntry;

typedef long COSEAlgorithmIdentifier;

typedef sequence<USVString> AuthenticationExtensionsSupported;

typedef record<DOMString, DOMString> AuthenticationExtensionsAuthenticatorInputs;

typedef BufferSource AAGUID;

typedef sequence<UvmEntry> UvmEntries;

dictionary PublicKeyCredentialCreationOptions {
  AttestationConveyancePreference attestation = "none";
  AuthenticatorSelectionCriteria authenticatorSelection;
  required BufferSource challenge;
  sequence<PublicKeyCredentialDescriptor> excludeCredentials = [];
  AuthenticationExtensionsClientInputs extensions;
  required sequence<PublicKeyCredentialParameters> pubKeyCredParams;
  required PublicKeyCredentialRpEntity rp;
  unsigned long timeout;
  required PublicKeyCredentialUserEntity user;
};

dictionary TokenBinding {
  DOMString id;
  required TokenBindingStatus status;
};

dictionary PublicKeyCredentialRpEntity : PublicKeyCredentialEntity {
  DOMString id;
};

dictionary PublicKeyCredentialUserEntity : PublicKeyCredentialEntity {
  required DOMString displayName;
  required BufferSource id;
};

dictionary PublicKeyCredentialRequestOptions {
  sequence<PublicKeyCredentialDescriptor> allowCredentials = [];
  required BufferSource challenge;
  AuthenticationExtensionsClientInputs extensions;
  USVString rpId;
  unsigned long timeout;
  UserVerificationRequirement userVerification = "preferred";
};

dictionary PublicKeyCredentialDescriptor {
  required BufferSource id;
  sequence<AuthenticatorTransport> transports;
  required PublicKeyCredentialType type;
};

dictionary CollectedClientData {
  required DOMString challenge;
  required DOMString origin;
  TokenBinding tokenBinding;
  required DOMString type;
};

dictionary txAuthGenericArg {
  required ArrayBuffer content;
  required USVString contentType;
};

dictionary PublicKeyCredentialParameters {
  required COSEAlgorithmIdentifier alg;
  required PublicKeyCredentialType type;
};

dictionary PublicKeyCredentialEntity {
  USVString icon;
  required DOMString name;
};

dictionary AuthenticationExtensionsClientInputs {
};

dictionary AuthenticatorSelectionCriteria {
  AuthenticatorAttachment authenticatorAttachment;
  boolean requireResidentKey = false;
  UserVerificationRequirement userVerification = "preferred";
};

dictionary AuthenticationExtensionsClientOutputs {
};

dictionary authenticatorBiometricPerfBounds {
  float FAR;
  float FRR;
};

partial dictionary CredentialRequestOptions {
  PublicKeyCredentialRequestOptions publicKey;
};

partial dictionary AuthenticationExtensionsClientInputs {
  USVString appid;
};

partial dictionary AuthenticationExtensionsClientInputs {
  USVString txAuthSimple;
};

partial dictionary AuthenticationExtensionsClientInputs {
  txAuthGenericArg txAuthGeneric;
};

partial dictionary AuthenticationExtensionsClientInputs {
  AuthenticatorSelectionList authnSel;
};

partial dictionary AuthenticationExtensionsClientInputs {
  boolean exts;
};

partial dictionary AuthenticationExtensionsClientInputs {
  boolean uvi;
};

partial dictionary AuthenticationExtensionsClientInputs {
  boolean loc;
};

partial dictionary AuthenticationExtensionsClientInputs {
  boolean uvm;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  boolean appid;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  USVString txAuthSimple;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  ArrayBuffer txAuthGeneric;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  boolean authnSel;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  AuthenticationExtensionsSupported exts;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  ArrayBuffer uvi;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  Coordinates loc;
};

partial dictionary AuthenticationExtensionsClientOutputs {
  UvmEntries uvm;
};

partial dictionary CredentialCreationOptions {
  PublicKeyCredentialCreationOptions publicKey;
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
interface PublicKeyCredential : Credential {
  [SameObject]
  readonly attribute ArrayBuffer rawId;
  [SameObject]
  readonly attribute AuthenticatorResponse response;
  AuthenticationExtensionsClientOutputs getClientExtensionResults();
};

[SecureContext, Exposed=Window]
interface AuthenticatorAttestationResponse : AuthenticatorResponse {
  [SameObject]
  readonly attribute ArrayBuffer attestationObject;
};

[SecureContext, Exposed=Window]
interface AuthenticatorResponse {
  [SameObject]
  readonly attribute ArrayBuffer clientDataJSON;
};

partial interface PublicKeyCredential {
  static Promise<boolean> isUserVerifyingPlatformAuthenticatorAvailable();
};
