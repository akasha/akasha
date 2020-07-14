enum XMLHttpRequestResponseType {
  "",
  "arraybuffer",
  "blob",
  "document",
  "json",
  "text"
};

typedef ( File or USVString ) FormDataEntryValue;

dictionary ProgressEventInit : EventInit {
  boolean lengthComputable = false;
  unsigned long long loaded = 0;
  unsigned long long total = 0;
};

[Exposed=(Window,Worker)]
interface FormData {
  iterable<USVString, FormDataEntryValue>;
  constructor( optional HTMLFormElement form );
  void append( USVString name, USVString value );
  void append( USVString name, Blob blobValue, optional USVString filename );
  void delete( USVString name );
  FormDataEntryValue? get( USVString name );
  sequence<FormDataEntryValue> getAll( USVString name );
  boolean has( USVString name );
  void set( USVString name, USVString value );
  void set( USVString name, Blob blobValue, optional USVString filename );
};

[Exposed=(Window,DedicatedWorker,SharedWorker)]
interface ProgressEvent : Event {
  readonly attribute boolean lengthComputable;
  readonly attribute unsigned long long loaded;
  readonly attribute unsigned long long total;
  constructor( DOMString type, optional ProgressEventInit eventInitDict = {} );
};

[Exposed=(Window,DedicatedWorker,SharedWorker)]
interface XMLHttpRequest : XMLHttpRequestEventTarget {
  const unsigned short DONE = 4;
  const unsigned short HEADERS_RECEIVED = 2;
  const unsigned short LOADING = 3;
  const unsigned short OPENED = 1;
  const unsigned short UNSENT = 0;
  readonly attribute unsigned short readyState;
  readonly attribute any response;
  readonly attribute USVString responseText;
  readonly attribute USVString responseURL;
  [Exposed=Window]
  readonly attribute Document? responseXML;
  readonly attribute unsigned short status;
  readonly attribute ByteString statusText;
  [SameObject]
  readonly attribute XMLHttpRequestUpload upload;
  attribute EventHandler onreadystatechange;
  attribute XMLHttpRequestResponseType responseType;
  attribute unsigned long timeout;
  attribute boolean withCredentials;
  constructor();
  void abort();
  ByteString getAllResponseHeaders();
  ByteString? getResponseHeader( ByteString name );
  void open( ByteString method, USVString url );
  void open( ByteString method, USVString url, boolean async, optional USVString? username = null, optional USVString? password = null );
  void overrideMimeType( DOMString mime );
  void send( optional ( Document or XMLHttpRequestBodyInit )? body = null );
  void setRequestHeader( ByteString name, ByteString value );
};

[Exposed=(Window,DedicatedWorker,SharedWorker)]
interface XMLHttpRequestEventTarget : EventTarget {
  attribute EventHandler onabort;
  attribute EventHandler onerror;
  attribute EventHandler onload;
  attribute EventHandler onloadend;
  attribute EventHandler onloadstart;
  attribute EventHandler onprogress;
  attribute EventHandler ontimeout;
};

[Exposed=(Window,DedicatedWorker,SharedWorker)]
interface XMLHttpRequestUpload : XMLHttpRequestEventTarget {
};
