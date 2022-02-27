typedef double Timestamp;

[JavaName=JsBoolean]
interface Boolean {
  DOMString toString();
  boolean valueOf();
};

[JavaName=JsDate]
interface Date {
  DOMString toString();
  Timestamp valueOf();
};

interface MyBoolean {
  DOMString toString();
  boolean valueOf();
};

interface MyDate {
  DOMString toString();
  Timestamp valueOf();
};

interface MyNumber {
  unrestricted double valueOf();
  stringifier;
};

interface MyString {
  DOMString toString();
  DOMString valueOf();
};

[JavaName=JsNumber]
interface Number {
  unrestricted double valueOf();
  stringifier;
};

interface ReportBody {
  [Default]
  object toJSON();
};

[JavaName=JsString]
interface String {
  DOMString toString();
  DOMString valueOf();
};

interface WebAssemblyGlobal {
  attribute any value;
  any valueOf();
};
