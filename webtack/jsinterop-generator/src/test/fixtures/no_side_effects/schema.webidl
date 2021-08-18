namespace FakeMath {
  const double SQRT2 = 1.4142135623730951;
  unrestricted double abs( unrestricted double x );
  [NoSideEffects]
  unrestricted double acos( unrestricted double x );
};

[GlobalObject]
interface mixin GlobalObject {
  [NoSideEffects]
  DOMString escape( DOMString str );
  [NoSideEffects]
  boolean isFinite( double num );
  [NoSideEffects]
  boolean isNaN( double value );
  long long parseInt( DOMString string, long long radix );
  DOMString unescape( DOMString str );
};

interface CSSFontPaletteValuesRule {
  maplike<unsigned long, DOMString>;
  attribute DOMString basePalette;
  attribute DOMString fontFamily;
};

interface FakeRegExpGroups {
  readonly maplike<DOMString, DOMString>;
};

interface FakeRegExpResult {
  iterable<DOMString>;
  readonly attribute unsigned long index;
  readonly attribute DOMString input;
  readonly attribute unsigned long length;
  getter DOMString? get( unsigned long index );
};

interface OffscreenCanvas {
  [NoSideEffects]
  constructor();
  undefined drawStuff();
  [NoSideEffects]
  boolean isValid();
};

interface Performance {
  [NoSideEffects]
  long now();
};

[LegacyNoInterfaceObject]
interface WEBGL_debug_shaders {
  [NoSideEffects]
  DOMString getTranslatedShaderSource( long shaderId );
};
