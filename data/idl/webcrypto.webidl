enum KeyFormat {
  "jwk",
  "pkcs8",
  "raw",
  "spki"
};

enum KeyType {
  "private",
  "public",
  "secret"
};

enum KeyUsage {
  "decrypt",
  "deriveBits",
  "deriveKey",
  "encrypt",
  "sign",
  "unwrapKey",
  "verify",
  "wrapKey"
};

typedef ( object or DOMString ) AlgorithmIdentifier;

typedef Uint8Array BigInteger;

typedef AlgorithmIdentifier HashAlgorithmIdentifier;

typedef DOMString NamedCurve;

dictionary AesCbcParams : Algorithm {
  required BufferSource iv;
};

dictionary AesCtrParams : Algorithm {
  required BufferSource counter;
  required [EnforceRange] octet length;
};

dictionary AesDerivedKeyParams : Algorithm {
  required [EnforceRange] unsigned short length;
};

dictionary AesGcmParams : Algorithm {
  required BufferSource iv;
  BufferSource additionalData;
  [EnforceRange]
  octet tagLength;
};

dictionary AesKeyAlgorithm : KeyAlgorithm {
  required unsigned short length;
};

dictionary AesKeyGenParams : Algorithm {
  required [EnforceRange] unsigned short length;
};

dictionary Algorithm {
  required DOMString name;
};

dictionary CryptoKeyPair {
  CryptoKey privateKey;
  CryptoKey publicKey;
};

dictionary EcKeyAlgorithm : KeyAlgorithm {
  required NamedCurve namedCurve;
};

dictionary EcKeyGenParams : Algorithm {
  required NamedCurve namedCurve;
};

dictionary EcKeyImportParams : Algorithm {
  required NamedCurve namedCurve;
};

dictionary EcdhKeyDeriveParams : Algorithm {
  required CryptoKey public;
};

dictionary EcdsaParams : Algorithm {
  required HashAlgorithmIdentifier hash;
};

dictionary HkdfParams : Algorithm {
  required HashAlgorithmIdentifier hash;
  required BufferSource salt;
  required BufferSource info;
};

dictionary HmacImportParams : Algorithm {
  required HashAlgorithmIdentifier hash;
  [EnforceRange]
  unsigned long length;
};

dictionary HmacKeyAlgorithm : KeyAlgorithm {
  required KeyAlgorithm hash;
  required unsigned long length;
};

dictionary HmacKeyGenParams : Algorithm {
  required HashAlgorithmIdentifier hash;
  [EnforceRange]
  unsigned long length;
};

dictionary JsonWebKey {
  DOMString alg;
  DOMString crv;
  DOMString d;
  DOMString dp;
  DOMString dq;
  DOMString e;
  boolean ext;
  DOMString k;
  sequence<DOMString> key_ops;
  DOMString kty;
  DOMString n;
  sequence<RsaOtherPrimesInfo> oth;
  DOMString p;
  DOMString q;
  DOMString qi;
  DOMString use;
  DOMString x;
  DOMString y;
};

dictionary KeyAlgorithm {
  required DOMString name;
};

dictionary Pbkdf2Params : Algorithm {
  required BufferSource salt;
  required [EnforceRange] unsigned long iterations;
  required HashAlgorithmIdentifier hash;
};

dictionary RsaHashedImportParams : Algorithm {
  required HashAlgorithmIdentifier hash;
};

dictionary RsaHashedKeyAlgorithm : RsaKeyAlgorithm {
  required KeyAlgorithm hash;
};

dictionary RsaHashedKeyGenParams : RsaKeyGenParams {
  required HashAlgorithmIdentifier hash;
};

dictionary RsaKeyAlgorithm : KeyAlgorithm {
  required unsigned long modulusLength;
  required BigInteger publicExponent;
};

dictionary RsaKeyGenParams : Algorithm {
  required [EnforceRange] unsigned long modulusLength;
  required BigInteger publicExponent;
};

dictionary RsaOaepParams : Algorithm {
  BufferSource label;
};

dictionary RsaOtherPrimesInfo {
  DOMString d;
  DOMString r;
  DOMString t;
};

dictionary RsaPssParams : Algorithm {
  required [EnforceRange] unsigned long saltLength;
};

partial interface mixin WindowOrWorkerGlobalScope {
  [SameObject]
  readonly attribute Crypto crypto;
};

[Exposed=(Window,Worker)]
interface Crypto {
  [SecureContext]
  readonly attribute SubtleCrypto subtle;
  ArrayBufferView getRandomValues( ArrayBufferView array );
};

[SecureContext, Exposed=(Window,Worker), Serializable]
interface CryptoKey {
  readonly attribute object algorithm;
  readonly attribute boolean extractable;
  readonly attribute KeyType type;
  readonly attribute object usages;
};

[SecureContext, Exposed=(Window,Worker)]
interface SubtleCrypto {
  Promise<any> decrypt( AlgorithmIdentifier algorithm, CryptoKey key, BufferSource data );
  Promise<ArrayBuffer> deriveBits( AlgorithmIdentifier algorithm, CryptoKey baseKey, unsigned long length );
  Promise<any> deriveKey( AlgorithmIdentifier algorithm, CryptoKey baseKey, AlgorithmIdentifier derivedKeyType, boolean extractable, sequence<KeyUsage> keyUsages );
  Promise<any> digest( AlgorithmIdentifier algorithm, BufferSource data );
  Promise<any> encrypt( AlgorithmIdentifier algorithm, CryptoKey key, BufferSource data );
  Promise<any> exportKey( KeyFormat format, CryptoKey key );
  Promise<any> generateKey( AlgorithmIdentifier algorithm, boolean extractable, sequence<KeyUsage> keyUsages );
  Promise<CryptoKey> importKey( KeyFormat format, ( BufferSource or JsonWebKey ) keyData, AlgorithmIdentifier algorithm, boolean extractable, sequence<KeyUsage> keyUsages );
  Promise<any> sign( AlgorithmIdentifier algorithm, CryptoKey key, BufferSource data );
  Promise<CryptoKey> unwrapKey( KeyFormat format, BufferSource wrappedKey, CryptoKey unwrappingKey, AlgorithmIdentifier unwrapAlgorithm, AlgorithmIdentifier unwrappedKeyAlgorithm, boolean extractable, sequence<KeyUsage> keyUsages );
  Promise<any> verify( AlgorithmIdentifier algorithm, CryptoKey key, BufferSource signature, BufferSource data );
  Promise<any> wrapKey( KeyFormat format, CryptoKey key, CryptoKey wrappingKey, AlgorithmIdentifier wrapAlgorithm );
};
