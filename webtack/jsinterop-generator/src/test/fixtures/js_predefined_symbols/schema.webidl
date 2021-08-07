[JsName=NumbersList]
typedef ( Int32Array or sequence<long> ) Int32List;

typedef ( Int32Array or sequence<long> ) Int32List2;

namespace JSON {
};

[JsName=JsMath]
namespace Math {
  [JsName=JsE]
  const double E = 2.7182818284590452354;
  const double E2 = 2.7182818284590452354;
  [JavaNoInline, JsName=JsPI]
  const double PI = 3.1415926535897932;
  const double PI2 = 3.1415926535897932;
};

dictionary EventInit {
  [JsName=jsElapsedTime]
  double elapsedTime = 0.0;
  DOMString propertyName = "";
  DOMString propertyName2 = "";
};

[JsName=JsTransitionEventInit]
dictionary TransitionEventInit : EventInit {
  DOMString propertyName3 = "";
  [JsName=js_pseudoElement]
  DOMString pseudoElement = "";
};

interface Element {
};

interface Int32Array {
};

interface Thing {
  [JsName=zeSize]
  readonly attribute unsigned long length;
  readonly attribute unsigned long length2;
  readonly attribute unsigned long length3;
  [JsName=leItem]
  getter Element? item( [JsName=i] unsigned long index );
  getter Element? item2( unsigned long index );
  getter Element? item3( unsigned long index );
};

interface Thing2 {
  static readonly attribute object staticReadonlyObjectValue;
  static readonly attribute object staticReadonlyObjectValue2;
  static attribute object staticObjectValue;
  static attribute object staticObjectValue2;
  readonly attribute unsigned long length3;
  static object staticMethod();
  static object staticMethod2();
  getter Element? item3( unsigned long index );
};
