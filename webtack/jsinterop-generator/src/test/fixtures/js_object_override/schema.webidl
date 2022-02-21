typedef double Timestamp;

[JavaName=JsBoolean]
interface Boolean {
  boolean valueOf();
  DOMString toString();
};

[JavaName=JsDate]
interface Date {
  Timestamp valueOf();
  DOMString toString();
};

interface MyBoolean {
  boolean valueOf();
  DOMString toString();
};

interface MyDate {
  Timestamp valueOf();
  DOMString toString();
};

interface MyNumber {
  unrestricted double valueOf();
  stringifier DOMString toString( optional long radix );
};

interface MyString {
  DOMString valueOf();
  DOMString toString();
};

[JavaName=JsNumber]
interface Number {
  unrestricted double valueOf();
  stringifier DOMString toString( optional long radix );
};

interface ReportBody {
  [Default]
  object toJSON();
};

[JavaName=JsString]
interface String {
  DOMString valueOf();
  DOMString toString();
};

interface WebAssemblyGlobal {
  attribute any value;
  any valueOf();
};
