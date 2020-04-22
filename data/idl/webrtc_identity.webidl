enum RTCErrorDetailTypeIdp {
  "idp-bad-script-failure",
  "idp-execution-failure",
  "idp-load-failure",
  "idp-need-login",
  "idp-timeout",
  "idp-tls-failure",
  "idp-token-expired",
  "idp-token-invalid"
};

callback ValidateAssertionCallback = Promise<RTCIdentityValidationResult> ( DOMString assertion, DOMString origin );

callback GenerateAssertionCallback = Promise<RTCIdentityAssertionResult> ( DOMString contents, DOMString origin, RTCIdentityProviderOptions options );

dictionary RTCIdentityProviderDetails {
  required DOMString domain;
  DOMString protocol = "default";
};

dictionary RTCIdentityAssertionResult {
  required DOMString assertion;
  required RTCIdentityProviderDetails idp;
};

dictionary RTCIdentityValidationResult {
  required DOMString contents;
  required DOMString identity;
};

dictionary RTCIdentityProvider {
  required GenerateAssertionCallback generateAssertion;
  required ValidateAssertionCallback validateAssertion;
};

dictionary RTCIdentityProviderOptions {
  DOMString peerIdentity;
  DOMString protocol = "default";
  DOMString usernameHint;
};

partial dictionary MediaStreamConstraints {
  DOMString peerIdentity;
};

partial dictionary RTCConfiguration {
  DOMString peerIdentity;
};

partial dictionary RTCErrorInit {
  long httpRequestStatusCode;
};

[Exposed=Window]
interface RTCIdentityAssertion {
  attribute DOMString idp;
  attribute DOMString name;
  constructor( DOMString idp, DOMString name );
};

[Exposed=RTCIdentityProviderGlobalScope]
interface RTCIdentityProviderRegistrar {
  void register( RTCIdentityProvider idp );
};

[Global, Exposed=RTCIdentityProviderGlobalScope]
interface RTCIdentityProviderGlobalScope : WorkerGlobalScope {
  readonly attribute RTCIdentityProviderRegistrar rtcIdentityProvider;
};

partial interface RTCError {
  readonly attribute long? httpRequestStatusCode;
};

partial interface RTCPeerConnection {
  readonly attribute DOMString? idpErrorInfo;
  readonly attribute DOMString? idpLoginUrl;
  readonly attribute Promise<RTCIdentityAssertion> peerIdentity;
  Promise<DOMString> getIdentityAssertion();
  void setIdentityProvider( DOMString provider, optional RTCIdentityProviderOptions options = {} );
};

partial interface MediaStreamTrack {
  readonly attribute boolean isolated;
  attribute EventHandler onisolationchange;
};
