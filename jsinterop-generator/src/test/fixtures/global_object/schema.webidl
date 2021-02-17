[GlobalObject, NoFlatten]
interface mixin GlobalObject1 {
  DOMString decodeURI( DOMString encodedURI );
};

[GlobalObject, NoFlatten]
interface mixin GlobalObject2 {
  DOMString decodeURIComponent( DOMString encodedURI );
};

[GlobalObject, NoFlatten]
interface mixin GlobalObject3 {
  DOMString encodeURI( DOMString uri );
};

[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface Window {
  readonly attribute boolean isSecureContext;
  attribute DOMString name;
};
