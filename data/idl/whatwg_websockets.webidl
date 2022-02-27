enum BinaryType {
  "arraybuffer",
  "blob"
};

dictionary CloseEventInit : EventInit {
  unsigned short code = 0;
  USVString reason = "";
  boolean wasClean = false;
};

[Exposed=(Window,Worker)]
interface CloseEvent : Event {
  readonly attribute unsigned short code;
  readonly attribute USVString reason;
  readonly attribute boolean wasClean;
  constructor( DOMString type, optional CloseEventInit eventInitDict = {} );
};

[Exposed=(Window,Worker)]
interface WebSocket : EventTarget {
  const unsigned short CLOSED = 3;
  const unsigned short CLOSING = 2;
  const unsigned short CONNECTING = 0;
  const unsigned short OPEN = 1;
  readonly attribute unsigned long long bufferedAmount;
  readonly attribute DOMString extensions;
  readonly attribute DOMString protocol;
  readonly attribute unsigned short readyState;
  readonly attribute USVString url;
  attribute BinaryType binaryType;
  attribute EventHandler onclose;
  attribute EventHandler onerror;
  attribute EventHandler onmessage;
  attribute EventHandler onopen;
  constructor( USVString url, optional ( DOMString or sequence<DOMString> ) protocols = [] );
  undefined close( optional [Clamp] unsigned short code, optional USVString reason );
  undefined send( ( BufferSource or Blob or USVString ) data );
};
