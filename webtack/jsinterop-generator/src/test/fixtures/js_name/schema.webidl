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
