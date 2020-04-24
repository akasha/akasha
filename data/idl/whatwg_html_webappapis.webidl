typedef EventHandlerNonNull? EventHandler;

typedef OnBeforeUnloadEventHandlerNonNull? OnBeforeUnloadEventHandler;

typedef OnErrorEventHandlerNonNull? OnErrorEventHandler;

typedef ( DOMString or Function ) TimerHandler;

[LegacyTreatNonObjectAsNull]
callback EventHandlerNonNull = any ( Event event );

[LegacyTreatNonObjectAsNull]
callback OnBeforeUnloadEventHandlerNonNull = DOMString? ( Event event );

[LegacyTreatNonObjectAsNull]
callback OnErrorEventHandlerNonNull = any ( ( Event or DOMString ) event, optional DOMString source, optional unsigned long lineno, optional unsigned long colno, optional any error );

dictionary ErrorEventInit : EventInit {
  unsigned long colno = 0;
  any error = null;
  USVString filename = "";
  unsigned long lineno = 0;
  DOMString message = "";
};

dictionary PromiseRejectionEventInit : EventInit {
  required Promise<any> promise;
  any reason;
};

interface mixin DocumentAndElementEventHandlers {
  attribute EventHandler oncopy;
  attribute EventHandler oncut;
  attribute EventHandler onpaste;
};

interface mixin GlobalEventHandlers {
  attribute EventHandler onabort;
  attribute EventHandler onauxclick;
  attribute EventHandler onblur;
  attribute EventHandler oncancel;
  attribute EventHandler oncanplay;
  attribute EventHandler oncanplaythrough;
  attribute EventHandler onchange;
  attribute EventHandler onclick;
  attribute EventHandler onclose;
  attribute EventHandler oncontextmenu;
  attribute EventHandler oncuechange;
  attribute EventHandler ondblclick;
  attribute EventHandler ondrag;
  attribute EventHandler ondragend;
  attribute EventHandler ondragenter;
  attribute EventHandler ondragexit;
  attribute EventHandler ondragleave;
  attribute EventHandler ondragover;
  attribute EventHandler ondragstart;
  attribute EventHandler ondrop;
  attribute EventHandler ondurationchange;
  attribute EventHandler onemptied;
  attribute EventHandler onended;
  attribute OnErrorEventHandler onerror;
  attribute EventHandler onfocus;
  attribute EventHandler onformdata;
  attribute EventHandler oninput;
  attribute EventHandler oninvalid;
  attribute EventHandler onkeydown;
  attribute EventHandler onkeypress;
  attribute EventHandler onkeyup;
  attribute EventHandler onload;
  attribute EventHandler onloadeddata;
  attribute EventHandler onloadedmetadata;
  attribute EventHandler onloadstart;
  attribute EventHandler onmousedown;
  [LegacyLenientThis]
  attribute EventHandler onmouseenter;
  [LegacyLenientThis]
  attribute EventHandler onmouseleave;
  attribute EventHandler onmousemove;
  attribute EventHandler onmouseout;
  attribute EventHandler onmouseover;
  attribute EventHandler onmouseup;
  attribute EventHandler onpause;
  attribute EventHandler onplay;
  attribute EventHandler onplaying;
  attribute EventHandler onprogress;
  attribute EventHandler onratechange;
  attribute EventHandler onreset;
  attribute EventHandler onresize;
  attribute EventHandler onscroll;
  attribute EventHandler onsecuritypolicyviolation;
  attribute EventHandler onseeked;
  attribute EventHandler onseeking;
  attribute EventHandler onselect;
  attribute EventHandler onslotchange;
  attribute EventHandler onstalled;
  attribute EventHandler onsubmit;
  attribute EventHandler onsuspend;
  attribute EventHandler ontimeupdate;
  attribute EventHandler ontoggle;
  attribute EventHandler onvolumechange;
  attribute EventHandler onwaiting;
  attribute EventHandler onwebkitanimationend;
  attribute EventHandler onwebkitanimationiteration;
  attribute EventHandler onwebkitanimationstart;
  attribute EventHandler onwebkittransitionend;
  attribute EventHandler onwheel;
};

interface mixin WindowEventHandlers {
  attribute EventHandler onafterprint;
  attribute EventHandler onbeforeprint;
  attribute OnBeforeUnloadEventHandler onbeforeunload;
  attribute EventHandler onhashchange;
  attribute EventHandler onlanguagechange;
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  attribute EventHandler onoffline;
  attribute EventHandler ononline;
  attribute EventHandler onpagehide;
  attribute EventHandler onpageshow;
  attribute EventHandler onpopstate;
  attribute EventHandler onrejectionhandled;
  attribute EventHandler onstorage;
  attribute EventHandler onunhandledrejection;
  attribute EventHandler onunload;
};

interface mixin WindowOrWorkerGlobalScope {
  [Replaceable]
  readonly attribute USVString origin;
  ByteString atob( DOMString data );
  DOMString btoa( DOMString data );
  void clearInterval( optional long handle = 0 );
  void clearTimeout( optional long handle = 0 );
  Promise<ImageBitmap> createImageBitmap( ImageBitmapSource image, optional ImageBitmapOptions options = {} );
  Promise<ImageBitmap> createImageBitmap( ImageBitmapSource image, long sx, long sy, long sw, long sh, optional ImageBitmapOptions options = {} );
  void queueMicrotask( VoidFunction callback );
  long setInterval( TimerHandler handler, optional long timeout = 0, any... arguments );
  long setTimeout( TimerHandler handler, optional long timeout = 0, any... arguments );
};

[Exposed=(Window,Worker)]
interface ErrorEvent : Event {
  readonly attribute unsigned long colno;
  readonly attribute any error;
  readonly attribute USVString filename;
  readonly attribute unsigned long lineno;
  readonly attribute DOMString message;
  constructor( DOMString type, optional ErrorEventInit eventInitDict = {} );
};

[Exposed=(Window,Worker)]
interface PromiseRejectionEvent : Event {
  readonly attribute Promise<any> promise;
  readonly attribute any reason;
  constructor( DOMString type, PromiseRejectionEventInit eventInitDict );
};

Window includes WindowOrWorkerGlobalScope;

WorkerGlobalScope includes WindowOrWorkerGlobalScope;
