/**
 * Example that defines single constructor attribute.
 */
[Exposed=(Window,Worker), Serializable]
interface DOMPointReadOnly {
  readonly attribute unrestricted double w;
  readonly attribute unrestricted double x;
  readonly attribute unrestricted double y;
  readonly attribute unrestricted double z;
  constructor( optional unrestricted double x = 0, optional unrestricted double y = 0, optional unrestricted double z = 0, optional unrestricted double w = 1 );
  [Default]
  object toJSON();
};

/**
 * Example that defines multiple constructor attributes.
 */
[Exposed=Window, SecureContext]
interface PasswordCredential {
  readonly attribute USVString password;
  constructor( ArrayBuffer data );
  constructor( DOMString data );
};

/**
 * Example with no constructor attributes.
 */
[Exposed=Window, SecureContext]
interface SomeOtherType {
};
