[JavaSubPackage=core, JavaName=JsString]
interface String {
  readonly attribute unsigned long length;

  static DOMString fromCharCode( long long... charCodes );
  static DOMString fromCodePoint( long long codePoint, long long... codePoints );

  constructor( optional DOMString str = "" );

  DOMString charAt( long long index );
  long long charCodeAt();
  long long charCodeAt( long long index );
  long long codePointAt( long long index );
  DOMString concat( DOMString... strings );
  boolean endsWith( DOMString searchString, optional long long position = 0 );
  boolean includes( DOMString searchString, optional long long position = 0 );
  long long indexOf( DOMString searchValue, optional long long fromIndex = 0 );
  long long lastIndexOf( DOMString searchValue, optional long long fromIndex = 0 );
  long long localeCompare( DOMString compareString, optional ( DOMString or sequence<DOMString> ) locales, optional object options );
  sequence<DOMString> match( RegExp regexp );
  sequence<DOMString> match( DOMString regexp );
  [SequenceType=Iterator] sequence<RegExpResult> matchAll( RegExp regexp );
  [SequenceType=Iterator] sequence<RegExpResult> matchAll( DOMString regexp );
  DOMString normalize( optional DOMString form = "" );
  DOMString padEnd( long long targetLength, optional DOMString padString = "" );
  DOMString padStart( long long targetLength, optional DOMString padString = "" );
  DOMString repeat( long long count );
  DOMString replace( RegExp pattern, DOMString replacement );
  DOMString replace( DOMString pattern, DOMString replacement );
  long long search( RegExp pattern );
  long long search( DOMString pattern );
  DOMString slice( long long begin, optional long long end = -1 );
  sequence<DOMString> split( optional ( RegExp or DOMString ) separator = "", optional long long limit = -1 );
  boolean startsWith( DOMString searchString, optional long long position = -1 );
  DOMString substring( long long start, optional long long end = -1 );
  DOMString toLocaleLowerCase( optional sequence<DOMString> locales = [] );
  DOMString toLocaleUpperCase( optional sequence<DOMString> locales = [] );
  DOMString toLowerCase();
  DOMString toUpperCase();
  DOMString trim();
  DOMString trimEnd();
  DOMString trimLeft();
  DOMString trimRight();
  DOMString trimStart();
  DOMString valueOf();
  DOMString toString();
};
