enum KeyType {
  "private",
  "public",
  "secret"
};

dictionary EcdhKeyDeriveParams {
  DOMString default;
  required CryptoKey public;
};

[SecureContext, Exposed=(Window,Worker)]
interface CryptoKey {
  readonly attribute object private;
  attribute boolean default;
};
