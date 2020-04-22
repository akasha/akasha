dictionary EventSourceInit {
  boolean withCredentials = false;
};

[Exposed=(Window,Worker)]
interface EventSource : EventTarget {
  const unsigned short CLOSED = 2;
  const unsigned short CONNECTING = 0;
  const unsigned short OPEN = 1;
  readonly attribute unsigned short readyState;
  readonly attribute USVString url;
  readonly attribute boolean withCredentials;
  attribute EventHandler onerror;
  attribute EventHandler onmessage;
  attribute EventHandler onopen;
  constructor( USVString url, optional EventSourceInit eventSourceInitDict = {} );
  void close();
};
