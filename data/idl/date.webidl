
// Note that this is more accurately represented as "unsigned long long" but
// the jsinterop generator would map this to long but for consistency with elemental2
// API we have decided to map this to double instead...
typedef double Timestamp;
//typedef unsigned long long Timestamp;

[JavaSubPackage=core, JavaName=JsDate]
interface Date {

  static Timestamp UTC(long year, optional long month = 0, optional long date = 0, optional long hours = 0, optional long minute = 0, optional long second = 0, optional long ms = 0 );

  static Timestamp now();

  static Timestamp parse( DOMString date );

  constructor();

  constructor( DOMString date );

  constructor( Timestamp date );

  constructor( long year, long month, optional long date = 0, optional long hours = 0, optional long minute = 0, optional long second = 0, optional long ms = 0 );

  long getDate();

  long getDay();

  long getFullYear();

  long getHours();

  long getMilliseconds();

  long getMinutes();

  long getMonth();

  long getSeconds();

  Timestamp getTime();

  long getTimezoneOffset();

  long getUTCDate();

  long getUTCDay();

  long getUTCFullYear();

  long getUTCHours();

  long getUTCMilliseconds();

  long getUTCMinutes();

  long getUTCMonth();

  long getUTCSeconds();

  Timestamp setDate( long dayValue );

  Timestamp setFullYear( long yearValue, optional long monthValue = 0, optional long dayValue = 0 );

  Timestamp setHours( long hoursValue, optional long minutesValue = 0, optional long secondsValue = 0, optional long msValue = 0 );

  Timestamp setMilliseconds( long millisecondsValue );

  Timestamp setMinutes( long minutesValue, optional long secondsValue = 0, optional long msValue = 0 );

  Timestamp setMonth( long monthValue, optional long dayValue = 0 );

  Timestamp setSeconds( long secondsValue, optional long msValue = 0 );

  Timestamp setTime( Timestamp timeValue );

  Timestamp setUTCDate( long dayValue );

  Timestamp setUTCFullYear( long yearValue, optional long monthValue = 0, optional long dayValue = 1 );

  Timestamp setUTCHours( long hoursValue, optional long minutesValue = 0, optional long secondsValue = 0, optional long msValue = 0 );

  Timestamp setUTCMilliseconds( long millisecondsValue );

  Timestamp setUTCMinutes( long minutesValue, optional long secondsValue = 0, optional long msValue = 0 );

  Timestamp setUTCMonth( long monthValue, optional long dayValue = 0 );

  Timestamp setUTCSeconds( long secondsValue, optional long msValue = 0 );

  DOMString toDateString();

  DOMString toISOString();

  // Note: The toLocale* methods have not been defined as we have seen no usage of it in the wild and
  // it is somewhat complex to define
  // DOMString toLocaleDateString(...);
  // DOMString toLocaleString(...);
  // DOMString toLocaleTimeString(...);

  DOMString toJSON();

  DOMString toTimeString();

  DOMString toUTCString();

  Timestamp valueOf();

  DOMString toString();
};
