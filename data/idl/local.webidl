
// A WindowProxy is an exotic object that wraps a Window ordinary object, indirecting most
// operations through to the wrapped object
//
// See https://html.spec.whatwg.org/multipage/window-object.html#windowproxy
[MarkerType]
typedef Window WindowProxy;

// CSSOMString can be either DOMString or USVString it seems.
typedef DOMString CSSOMString;
