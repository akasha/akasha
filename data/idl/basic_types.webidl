[JavaName=JsBoolean]
interface Boolean {
  constructor( optional any value );

  boolean valueOf();

  stringifier DOMString toString();
};

[JavaName=JsNumber]
interface Number {
  [JavaNoInline]
  const double EPSILON = 0;
  [JavaNoInline]
  const double MAX_SAFE_INTEGER = 9007199254740991;
  [JavaNoInline]
  const double MAX_VALUE = 0;
  [JavaNoInline]
  const double MIN_SAFE_INTEGER = -9007199254740991;
  [JavaNoInline]
  const double MIN_VALUE = 0;
  [JavaNoInline]
  const double NEGATIVE_INFINITY = -Infinity;
  [JavaNoInline]
  const double NaN = NaN;
  [JavaNoInline]
  const double POSITIVE_INFINITY = Infinity;

  constructor(optional unrestricted double value);

  static boolean isFinite(unrestricted double value);

  static boolean isInteger(unrestricted double value);

  static boolean isNaN(unrestricted double value);

  static boolean isSafeInteger(unrestricted double value);

  static double parseFloat(DOMString string);

  static long parseInt(DOMString string, long radix);

  DOMString toExponential(optional long fractionDigits);
  DOMString toFixed(optional long digits);

  // Note: The toLocale* method has not been defined as we have seen no usage of it in the wild and
  // it is somewhat complex to define
  // DOMString toLocaleString(...);

  DOMString toPrecision(optional long precision);

  stringifier DOMString toString( optional long radix );

  unrestricted double valueOf();
};

callback PropertyAccessorFunction = any ();

callback PropertyMutatorFunction = void ( any value );

dictionary ObjectPropertyDescriptor {
  boolean configurable = false;
  boolean enumerable = false;
  PropertyAccessorFunction get = null;
  PropertyMutatorFunction set = null;
  any value = null;
  boolean writable = false;
};

// This is hand-written
interface ObjectPropertyEntry {
};

[JavaName=JsObject]
interface Object {
  static object assign( object target, object... sources );
  static object create( object? proto, optional record<DOMString, ObjectPropertyDescriptor>? props = null );
  static undefined defineProperties( object obj, record<DOMString, ObjectPropertyDescriptor> props );
  static undefined defineProperty( object obj, (DOMString or Symbol) prop, ObjectPropertyDescriptor descriptor );
  static sequence<ObjectPropertyEntry> entries( object obj );
  static undefined freeze( object obj );
  static object fromEntries( [JavaSequenceType=Iterable] sequence<ObjectPropertyEntry> iterable );
  static ObjectPropertyDescriptor? getOwnPropertyDescriptor( object obj, (DOMString or Symbol) prop );
  static sequence<ObjectPropertyDescriptor> getOwnPropertyDescriptors( object obj );
  static sequence<DOMString> getOwnPropertyNames( object obj );
  static sequence<Symbol> getOwnPropertySymbols( object obj );

  static object? getPrototypeOf( object obj );
  static boolean is( object value1, object value2 );
  static boolean isExtensible( object obj );
  static boolean isFrozen( object obj );
  static boolean isSealed( object obj );
  static sequence<DOMString> keys( object obj );
  static undefined preventExtensions( object obj );
  static undefined seal( object obj );
  static undefined setPrototypeOf( object obj, object prototype );
  static sequence<any> values( object obj );

  constructor( optional any value );

  boolean hasOwnProperty( Symbol prop );
  boolean hasOwnProperty( DOMString prop );

  boolean propertyIsEnumerable( DOMString prop );
  boolean isPrototypeOf( object obj );

  // Note: The toLocale* method has not been defined as we have seen no usage of it in the wild and
  // it is somewhat complex to define
  // DOMString toLocaleString(...);

  [JavaName=valueOf_]
  any valueOf();

  stringifier DOMString toString();
};
