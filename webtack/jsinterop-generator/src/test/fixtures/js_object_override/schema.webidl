typedef double Timestamp;

[JavaName=JsBoolean]
interface Boolean {
  boolean valueOf();
  stringifier DOMString toString();
};

[JavaName=JsDate]
interface Date {
  Timestamp valueOf();
  stringifier DOMString toString();
};

interface MyBoolean {
  boolean valueOf();
  stringifier DOMString toString();
};

interface MyDate {
  Timestamp valueOf();
  stringifier DOMString toString();
};

interface MyNumber {
  unrestricted double valueOf();
  stringifier DOMString toString( optional long radix );
};

interface MyString {
  DOMString valueOf();
  stringifier DOMString toString();
};

[JavaName=JsNumber]
interface Number {
  unrestricted double valueOf();
  stringifier DOMString toString( optional long radix );
};

[JavaName=JsString]
interface String {
  DOMString valueOf();
  stringifier DOMString toString();
};

interface WebAssemblyGlobal {
  attribute any value;
  any valueOf();
};
