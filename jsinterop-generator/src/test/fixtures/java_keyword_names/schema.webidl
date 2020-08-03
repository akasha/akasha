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
  attribute object toString;
  attribute object wait;
};

interface MyType3 {
  static void clone( object clone );
  static void default( object default );
  static void equals( object equals );
  static void finalize( object finalize );
  static void getClass( object getClass );
  static void hashCode( object hashCode );
  static void is( object is );
  static void notify( object notify );
  static void notifyAll( object notifyAll );
  static void private( object private );
  static void protected( object protected );
  static void public( object public );
  static void toString( object toString );
  static void wait( object wait );
};

interface MyType4 {
  void clone( object clone );
  void default( object default );
  void equals( object equals );
  void finalize( object finalize );
  void getClass( object getClass );
  void hashCode( object hashCode );
  void is( object is );
  void notify( object notify );
  void notifyAll( object notifyAll );
  void private( object private );
  void protected( object protected );
  void public( object public );
  void toString( object toString );
  void wait( object wait );
};
