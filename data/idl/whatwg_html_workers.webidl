enum WorkerType {
  "classic",
  "module"
};

dictionary WorkerOptions {
  RequestCredentials credentials = "same-origin";
  DOMString name = "";
  WorkerType type = "classic";
};

interface mixin AbstractWorker {
  attribute EventHandler onerror;
};

interface mixin NavigatorConcurrentHardware {
  readonly attribute unsigned long long hardwareConcurrency;
};

[Exposed=Worker]
interface WorkerGlobalScope : EventTarget {
  readonly attribute WorkerLocation location;
  readonly attribute WorkerNavigator navigator;
  readonly attribute WorkerGlobalScope self;
  attribute OnErrorEventHandler onerror;
  attribute EventHandler onlanguagechange;
  attribute EventHandler onoffline;
  attribute EventHandler ononline;
  attribute EventHandler onrejectionhandled;
  attribute EventHandler onunhandledrejection;
  void importScripts( USVString... urls );
};

[Global=(Worker,DedicatedWorker), Exposed=DedicatedWorker]
interface DedicatedWorkerGlobalScope : WorkerGlobalScope {
  [Replaceable]
  readonly attribute DOMString name;
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  void close();
  void postMessage( any message, sequence<object> transfer );
  void postMessage( any message, optional PostMessageOptions options = {} );
};

[Exposed=(Window,Worker)]
interface SharedWorker : EventTarget {
  readonly attribute MessagePort port;
  constructor( USVString scriptURL, optional ( DOMString or WorkerOptions ) options = {} );
};

[Exposed=(Window,Worker)]
interface Worker : EventTarget {
  attribute EventHandler onmessage;
  attribute EventHandler onmessageerror;
  constructor( USVString scriptURL, optional WorkerOptions options = {} );
  void postMessage( any message, sequence<object> transfer );
  void postMessage( any message, optional PostMessageOptions options = {} );
  void terminate();
};

[Global=(Worker,SharedWorker), Exposed=SharedWorker]
interface SharedWorkerGlobalScope : WorkerGlobalScope {
  [Replaceable]
  readonly attribute DOMString name;
  attribute EventHandler onconnect;
  void close();
};

[Exposed=Worker]
interface WorkerNavigator {
};

[Exposed=Worker]
interface WorkerLocation {
  readonly attribute USVString hash;
  readonly attribute USVString host;
  readonly attribute USVString hostname;
  readonly attribute USVString origin;
  readonly attribute USVString pathname;
  readonly attribute USVString port;
  readonly attribute USVString protocol;
  readonly attribute USVString search;
  stringifier readonly attribute USVString href;
};

Worker includes AbstractWorker;

SharedWorker includes AbstractWorker;

WorkerNavigator includes NavigatorID;

WorkerNavigator includes NavigatorConcurrentHardware;

WorkerNavigator includes NavigatorOnLine;

WorkerNavigator includes NavigatorLanguage;
