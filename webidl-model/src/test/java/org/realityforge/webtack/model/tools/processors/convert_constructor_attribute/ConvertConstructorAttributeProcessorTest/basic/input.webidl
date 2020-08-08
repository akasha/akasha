/**
 * Example that defines single constructor attribute.
 */
[Constructor( optional unrestricted double x = 0, optional unrestricted double y = 0, optional unrestricted double z = 0, optional unrestricted double w = 1 ), Exposed=(Window,Worker), Serializable]
interface DOMPointReadOnly {
  readonly attribute unrestricted double w;
  readonly attribute unrestricted double x;
  readonly attribute unrestricted double y;
  readonly attribute unrestricted double z;
  [Default]
  object toJSON();
};

/**
 * Example that defines multiple constructor attributes.
 */
[Constructor( ArrayBuffer data ), Constructor( DOMString data ), Exposed=Window, SecureContext]
interface PasswordCredential {
  readonly attribute USVString password;
};


/**
 * Example with no constructor attributes.
 */
[Exposed=Window, SecureContext]
interface SomeOtherType {
};
