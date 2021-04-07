enum KeyType {
  "private",
  "public",
  "secret"
};

dictionary MyDictionary1 {
  required object clone;
  required object default;
  required object equals;
  required object finalize;
  required object getClass;
  required object hashCode;
  required object is;
  required object notify;
  required object notifyAll;
  required object private;
  required object protected;
  required object public;
  required object toString;
  required object wait;
};

dictionary MyDictionary2 {
  object clone;
  object default;
  object equals;
  object finalize;
  object getClass;
  object hashCode;
  object is;
  object notify;
  object notifyAll;
  object private;
  object protected;
  object public;
  object toString;
  object wait;
};

dictionary RTCCertificateStats {
  DOMString isNot;
  DOMString issuerCertificateId;
};

interface MyType1 {
  readonly attribute object clone;
  readonly attribute object default;
  readonly attribute object equals;
  readonly attribute object finalize;
  readonly attribute object getClass;
  readonly attribute object hashCode;
  readonly attribute object is;
  readonly attribute object notify;
  readonly attribute object notifyAll;
  readonly attribute object private;
  readonly attribute object protected;
  readonly attribute object public;
  readonly attribute object toString;
  readonly attribute object wait;
};

interface MyType2 {
  attribute object clone;
  attribute object default;
  attribute object equals;
  attribute object finalize;
  attribute object getClass;
  attribute object hashCode;
  attribute object is;
  attribute object notify;
  attribute object notifyAll;
  attribute object private;
  attribute object protected;
  attribute object public;
  attribute object wait;
};

interface MyType3 {
  static undefined clone( object clone );
  static undefined default( object default );
  static undefined equals( object equals );
  static undefined finalize( object finalize );
  static undefined getClass( object getClass );
  static undefined hashCode( object hashCode );
  static undefined is( object is );
  static undefined notify( object notify );
  static undefined notifyAll( object notifyAll );
  static undefined private( object private );
  static undefined protected( object protected );
  static undefined public( object public );
  static undefined wait( object wait );
};

interface MyType4 {
  undefined clone( object clone );
  undefined default( object default );
  undefined equals( object equals );
  undefined finalize( object finalize );
  undefined getClass( object getClass );
  undefined hashCode( object hashCode );
  undefined is( object is );
  undefined notify( object notify );
  undefined notifyAll( object notifyAll );
  undefined other( object toString );
  undefined private( object private );
  undefined protected( object protected );
  undefined public( object public );
  DOMString toString();
  undefined wait( object wait );
};
