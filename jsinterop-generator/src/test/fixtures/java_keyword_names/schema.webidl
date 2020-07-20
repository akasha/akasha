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
  attribute object notify;
  attribute object notifyAll;
  attribute object private;
  attribute object protected;
  attribute object public;
  attribute object toString;
  attribute object wait;
};
