[JsName=NumbersList]
typedef ( Int32Array or sequence<long> ) Int32List;

[JsName=JsMath]
namespace Math {
  [JsName=JsE]
  const double E = 2.7182818284590452354;
  [JavaNoInline, JsName=JsPI]
  const double PI = 3.1415926535897932;
};

[JsName=JsEventInit]
dictionary EventInit {
  [JsName=jsElapsedTime]
  double elapsedTime = 0.0;
  DOMString propertyName = "";
};

[JsName=JsTransitionEventInit]
dictionary TransitionEventInit : EventInit {
  [JsName=js_pseudoElement]
  DOMString pseudoElement = "";
};

interface Element {
};

[JsName=NotHTMLCollection]
interface HTMLCollection {
  readonly attribute unsigned long length;
  getter Element? item( unsigned long index );
  getter Element? namedItem( DOMString name );
};

interface HTMLOptionElement : Element {
};

[JsName=HTMLCollection]
interface HTMLReadOnlyOptionsCollection : HTMLCollection {
  getter HTMLOptionElement? item( unsigned long index );
  getter HTMLOptionElement? namedItem( DOMString name );
};

interface HTMLSelectElement {
  readonly attribute HTMLReadOnlyOptionsCollection selectedOptions;
};

interface Int32Array {
};

interface Thing {
  [JsName=zeSize]
  readonly attribute unsigned long length;
  [JsName=leItem]
  getter Element? item( [JsName=i] unsigned long index );
};
