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

callback GenerateAssertionCallback = Promise<RTCIdentityAssertionResult> ( DOMString contents, DOMString origin, RTCIdentityProviderOptions options );

callback ValidateAssertionCallback = Promise<RTCIdentityValidationResult> ( DOMString assertion, DOMString origin );

dictionary RTCIdentityAssertionResult {
  required RTCIdentityProviderDetails idp;
  required DOMString assertion;
};

dictionary RTCIdentityProvider {
  required GenerateAssertionCallback generateAssertion;
  required ValidateAssertionCallback validateAssertion;
};

dictionary RTCIdentityProviderDetails {
  required DOMString domain;
  DOMString protocol = "default";
};

dictionary RTCIdentityProviderOptions {
  DOMString peerIdentity;
  DOMString protocol = "default";
  DOMString usernameHint;
};

dictionary RTCIdentityValidationResult {
  required DOMString identity;
  required DOMString contents;
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

[Global=(Worker,RTCIdentityProvider), Exposed=RTCIdentityProvider]
interface RTCIdentityProviderGlobalScope : WorkerGlobalScope {
  readonly attribute RTCIdentityProviderRegistrar rtcIdentityProvider;
};

[Exposed=RTCIdentityProvider]
interface RTCIdentityProviderRegistrar {
  undefined register( RTCIdentityProvider idp );
};

partial interface MediaStreamTrack {
  readonly attribute boolean isolated;
  attribute EventHandler onisolationchange;
};

partial interface RTCError {
  readonly attribute long? httpRequestStatusCode;
};

partial interface RTCPeerConnection {
  readonly attribute DOMString? idpErrorInfo;
  readonly attribute DOMString? idpLoginUrl;
  readonly attribute Promise<RTCIdentityAssertion> peerIdentity;
  Promise<DOMString> getIdentityAssertion();
  undefined setIdentityProvider( DOMString provider, optional RTCIdentityProviderOptions options = {} );
};
