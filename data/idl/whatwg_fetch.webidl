enum RequestCache {
  "default",
  "force-cache",
  "no-cache",
  "no-store",
  "only-if-cached",
  "reload"
};

enum RequestCredentials {
  "include",
  "omit",
  "same-origin"
};

enum RequestDestination {
  "",
  "audio",
  "audioworklet",
  "document",
  "embed",
  "font",
  "frame",
  "iframe",
  "image",
  "manifest",
  "object",
  "paintworklet",
  "report",
  "script",
  "sharedworker",
  "style",
  "track",
  "video",
  "worker",
  "xslt"
};

enum RequestMode {
  "cors",
  "navigate",
  "no-cors",
  "same-origin"
};

enum RequestRedirect {
  "error",
  "follow",
  "manual"
};

enum ResponseType {
  "basic",
  "cors",
  "default",
  "error",
  "opaque",
  "opaqueredirect"
};

typedef ( ReadableStream or XMLHttpRequestBodyInit ) BodyInit;

typedef ( sequence<sequence<ByteString>> or record<ByteString, ByteString> ) HeadersInit;

typedef ( Request or USVString ) RequestInfo;

typedef ( Blob or BufferSource or FormData or URLSearchParams or USVString ) XMLHttpRequestBodyInit;

dictionary RequestInit {
  BodyInit? body;
  RequestCache cache;
  RequestCredentials credentials;
  HeadersInit headers;
  DOMString integrity;
  boolean keepalive;
  ByteString method;
  RequestMode mode;
  RequestRedirect redirect;
  USVString referrer;
  ReferrerPolicy referrerPolicy;
  AbortSignal? signal;
  any window;
};

dictionary ResponseInit {
  HeadersInit headers;
  unsigned short status = 200;
  ByteString statusText = "";
};

interface mixin Body {
  readonly attribute ReadableStream? body;
  readonly attribute boolean bodyUsed;
  [NewObject]
  Promise<ArrayBuffer> arrayBuffer();
  [NewObject]
  Promise<Blob> blob();
  [NewObject]
  Promise<FormData> formData();
  [NewObject]
  Promise<any> json();
  [NewObject]
  Promise<USVString> text();
};

partial interface mixin WindowOrWorkerGlobalScope {
  [NewObject]
  Promise<Response> fetch( RequestInfo input, optional RequestInit init = {} );
};

[Exposed=(Window,Worker)]
interface Headers {
  iterable<ByteString, ByteString>;
  constructor( optional HeadersInit init );
  undefined append( ByteString name, ByteString value );
  undefined delete( ByteString name );
  ByteString? get( ByteString name );
  boolean has( ByteString name );
  undefined set( ByteString name, ByteString value );
};

[Exposed=(Window,Worker)]
interface Request {
  readonly attribute RequestCache cache;
  readonly attribute RequestCredentials credentials;
  readonly attribute RequestDestination destination;
  [SameObject]
  readonly attribute Headers headers;
  readonly attribute DOMString integrity;
  readonly attribute boolean isHistoryNavigation;
  readonly attribute boolean isReloadNavigation;
  readonly attribute boolean keepalive;
  readonly attribute ByteString method;
  readonly attribute RequestMode mode;
  readonly attribute RequestRedirect redirect;
  readonly attribute USVString referrer;
  readonly attribute ReferrerPolicy referrerPolicy;
  readonly attribute AbortSignal signal;
  readonly attribute USVString url;
  constructor( RequestInfo input, optional RequestInit init = {} );
  [NewObject]
  Request clone();
};

[Exposed=(Window,Worker)]
interface Response {
  [SameObject]
  readonly attribute Headers headers;
  readonly attribute boolean ok;
  readonly attribute boolean redirected;
  readonly attribute unsigned short status;
  readonly attribute ByteString statusText;
  readonly attribute ResponseType type;
  readonly attribute USVString url;
  [NewObject]
  static Response error();
  [NewObject]
  static Response redirect( USVString url, optional unsigned short status = 302 );
  constructor( optional BodyInit? body = null, optional ResponseInit init = {} );
  [NewObject]
  Response clone();
};

Request includes Body;

Response includes Body;
