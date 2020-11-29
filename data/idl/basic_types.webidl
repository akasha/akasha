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

  // Note: toLocaleString has not been specified as we have seen no usage of it in the wild and
  // it is somewhat complex to define
  // DOMString toLocaleString(...);

  DOMString toPrecision(optional long precision);

  stringifier DOMString toString( optional long radix );

  unrestricted double valueOf();
};
