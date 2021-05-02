namespace FakeMath {
  const double SQRT2 = 1.4142135623730951;
  unrestricted double acos( unrestricted double x );
  unrestricted double otherOp();
};

partial namespace FakeMath {
  unrestricted double abs( unrestricted double x );
};

[GlobalObject, NoFlatten]
interface mixin GlobalObject {
  DOMString escape( DOMString str );
  boolean isFinite( double num );
  long long parseInt( DOMString string, long long radix );
  DOMString unescape( DOMString str );
};

[GlobalObject, NoFlatten]
partial interface mixin GlobalObject {
  boolean isNaN( double value );
};

[Exposed=(Window,Worker)]
interface EventTarget {
};

interface OffscreenCanvas {
  constructor();
  undefined drawStuff();
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
  DOMString getTranslatedShaderSource( long shaderId );
};

partial interface Performance {
  long now();
};
