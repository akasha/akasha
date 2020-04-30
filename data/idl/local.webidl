
// A WindowProxy is an exotic object that wraps a Window ordinary object, indirecting most
// operations through to the wrapped object
//
// See https://html.spec.whatwg.org/multipage/window-object.html#windowproxy
typedef Window WindowProxy;


// CSSOMString can be either DOMString or USVString it seems.
typedef DOMString CSSOMString;


// The streams are a WIP and require changes to WebIDL spec it seems. We
// will just add some basic types and will fix it up later. It probably means translating the JS
// API into WebIDL and adding here or perhaps some other form of magic.
//
// See https://github.com/heycam/webidl/issues/445
// See https://streams.spec.whatwg.org/#rs-class-definition

[NoInterfaceObject, Exposed=(Window,Worker)]
interface ReadableStream {};

[NoInterfaceObject, Exposed=(Window,Worker)]
interface WritableStream {};

[NoInterfaceObject, Exposed=(Window,Worker)]
interface TransformStream {};