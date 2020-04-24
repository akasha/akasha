enum CredentialMediationRequirement {
  "optional",
  "required",
  "silent"
};

typedef ( PasswordCredentialData or HTMLFormElement ) PasswordCredentialInit;

dictionary CredentialCreationOptions {
  AbortSignal signal;
};

dictionary CredentialData {
  required USVString id;
};

dictionary CredentialRequestOptions {
  CredentialMediationRequirement mediation = "optional";
  AbortSignal signal;
};

dictionary FederatedCredentialInit : CredentialData {
  USVString iconURL;
  USVString name;
  required USVString origin;
  DOMString protocol;
  required USVString provider;
};

dictionary FederatedCredentialRequestOptions {
  sequence<DOMString> protocols;
  sequence<USVString> providers;
};

dictionary PasswordCredentialData : CredentialData {
  USVString iconURL;
  USVString name;
  required USVString origin;
  required USVString password;
};

partial dictionary CredentialCreationOptions {
  PasswordCredentialInit password;
};

partial dictionary CredentialCreationOptions {
  FederatedCredentialInit federated;
};

partial dictionary CredentialRequestOptions {
  boolean password = false;
};

partial dictionary CredentialRequestOptions {
  FederatedCredentialRequestOptions federated;
};

[SecureContext]
interface mixin CredentialUserData {
  readonly attribute USVString iconURL;
  readonly attribute USVString name;
};

[Exposed=Window, SecureContext]
interface Credential {
  readonly attribute USVString id;
  readonly attribute DOMString type;
};

[Exposed=Window, SecureContext]
interface CredentialsContainer {
  Promise<Credential?> create( optional CredentialCreationOptions options );
  Promise<Credential?> get( optional CredentialRequestOptions options );
  Promise<void> preventSilentAccess();
  Promise<Credential> store( Credential credential );
};

[Constructor( FederatedCredentialInit data ), Exposed=Window, SecureContext]
interface FederatedCredential : Credential {
  readonly attribute DOMString? protocol;
  readonly attribute USVString provider;
};

[Constructor( HTMLFormElement form ), Constructor( PasswordCredentialData data ), Exposed=Window, SecureContext]
interface PasswordCredential : Credential {
  readonly attribute USVString password;
};

partial interface Navigator {
  [SecureContext, SameObject]
  readonly attribute CredentialsContainer credentials;
};

FederatedCredential includes CredentialUserData;

PasswordCredential includes CredentialUserData;
