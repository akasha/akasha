namespace FakeMath {
  const double SQRT2 = 1.4142135623730951;
  unrestricted double abs( unrestricted double x );
  [NoSideEffects]
  unrestricted double acos( unrestricted double x );
};

[GlobalObject, NoFlatten]
interface mixin GlobalObject {
  [NoSideEffects]
  DOMString escape( DOMString str );
  [NoSideEffects]
  boolean isFinite( double num );
  long long parseInt( DOMString string, long long radix );
  DOMString unescape( DOMString str );
};

[GlobalObject, NoFlatten]
partial interface mixin GlobalObject {
  [NoSideEffects]
  boolean isNaN( double value );
};

[Exposed=(Window,Worker)]
interface EventTarget {
};

interface OffscreenCanvas {
  [NoSideEffects]
  constructor();
  undefined drawStuff();
  [NoSideEffects]
  boolean isValid();
};

[Exposed=(Window,Worker)]
interface Performance : EventTarget {
  readonly attribute long timeOrigin;
  [Default]
  object toJSON();
};

[Exposed=(Window,Worker), LegacyNoInterfaceObject]
interface WEBGL_debug_shaders {
  [NoSideEffects]
  DOMString getTranslatedShaderSource( long shaderId );
};

partial interface Performance {
  [NoSideEffects]
  long now();
};
