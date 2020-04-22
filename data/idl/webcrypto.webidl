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

enum KeyFormat {
  "jwk",
  "pkcs8",
  "raw",
  "spki"
};

typedef AlgorithmIdentifier HashAlgorithmIdentifier;

typedef Uint8Array BigInteger;

typedef DOMString NamedCurve;

typedef ( object or DOMString ) AlgorithmIdentifier;

dictionary RsaHashedKeyAlgorithm : RsaKeyAlgorithm {
  required KeyAlgorithm hash;
};

dictionary AesCtrParams : Algorithm {
  required BufferSource counter;
  required [EnforceRange] octet length;
};

dictionary RsaOaepParams : Algorithm {
  BufferSource label;
};

dictionary HkdfParams : Algorithm {
  required HashAlgorithmIdentifier hash;
  required BufferSource info;
  required BufferSource salt;
};

dictionary RsaPssParams : Algorithm {
  required [EnforceRange] unsigned long saltLength;
};

dictionary EcKeyGenParams : Algorithm {
  required NamedCurve namedCurve;
};

dictionary EcKeyImportParams : Algorithm {
  required NamedCurve namedCurve;
};

dictionary HmacKeyGenParams : Algorithm {
  required HashAlgorithmIdentifier hash;
  [EnforceRange]
  unsigned long length;
};

dictionary RsaKeyGenParams : Algorithm {
  required [EnforceRange] unsigned long modulusLength;
  required BigInteger publicExponent;
};

dictionary AesCbcParams : Algorithm {
  required BufferSource iv;
};

dictionary HmacImportParams : Algorithm {
  required HashAlgorithmIdentifier hash;
  [EnforceRange]
  unsigned long length;
};

dictionary CryptoKeyPair {
  CryptoKey privateKey;
  CryptoKey publicKey;
};

dictionary RsaOtherPrimesInfo {
  DOMString d;
  DOMString r;
  DOMString t;
};

dictionary EcdhKeyDeriveParams : Algorithm {
  required CryptoKey public;
};

dictionary Pbkdf2Params : Algorithm {
  required HashAlgorithmIdentifier hash;
  required [EnforceRange] unsigned long iterations;
  required BufferSource salt;
};

dictionary EcdsaParams : Algorithm {
  required HashAlgorithmIdentifier hash;
};

dictionary RsaHashedImportParams : Algorithm {
  required HashAlgorithmIdentifier hash;
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

dictionary Algorithm {
  required DOMString name;
};

dictionary RsaHashedKeyGenParams : RsaKeyGenParams {
  required HashAlgorithmIdentifier hash;
};

dictionary AesKeyAlgorithm : KeyAlgorithm {
  required unsigned short length;
};

dictionary KeyAlgorithm {
  required DOMString name;
};

dictionary AesGcmParams : Algorithm {
  BufferSource additionalData;
  required BufferSource iv;
  [EnforceRange]
  octet tagLength;
};

dictionary HmacKeyAlgorithm : KeyAlgorithm {
  required KeyAlgorithm hash;
  required unsigned long length;
};

dictionary AesDerivedKeyParams : Algorithm {
  required [EnforceRange] unsigned short length;
};

dictionary AesKeyGenParams : Algorithm {
  required [EnforceRange] unsigned short length;
};

dictionary EcKeyAlgorithm : KeyAlgorithm {
  required NamedCurve namedCurve;
};

dictionary RsaKeyAlgorithm : KeyAlgorithm {
  required unsigned long modulusLength;
  required BigInteger publicExponent;
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

[SecureContext, Exposed=(Window,Worker)]
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
