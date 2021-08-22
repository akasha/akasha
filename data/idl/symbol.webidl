// Typedef exists so that if any specifications starts using the "symbol" token
// defined in the WebIDL spec then out schema will work with it.
typedef Symbol symbol;

[JsName=symbol]
interface Symbol {

  static readonly attribute Symbol asyncIterator;
  static readonly attribute Symbol hasInstance;
  static readonly attribute Symbol isConcatSpreadable;
  static readonly attribute Symbol iterator;
  static readonly attribute Symbol match;
  static readonly attribute Symbol matchAll;
  static readonly attribute Symbol replace;
  static readonly attribute Symbol search;
  static readonly attribute Symbol species;
  static readonly attribute Symbol split;
  static readonly attribute Symbol toPrimitive;
  static readonly attribute Symbol toStringTag;
  static readonly attribute Symbol unscopables;

  static Symbol for( DOMString key );
  static DOMString keyFor( Symbol symbol );

  stringifier DOMString toString();
};
