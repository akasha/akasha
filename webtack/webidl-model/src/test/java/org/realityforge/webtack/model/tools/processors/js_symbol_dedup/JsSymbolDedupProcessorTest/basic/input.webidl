typedef EventHandler? NullableEventHandler;

typedef Window WindowProxy;

callback EventHandler = undefined ( Event event );

callback ExtendableMessageEventHandler = undefined ( ExtendableMessageEvent event );

callback MessageEventHandler = undefined ( MessageEvent event );

interface AudioNode {
  AudioNode connect( AudioNode destinationNode, optional unsigned long output = 0, optional unsigned long input = 0 );
  undefined connect( AudioParam destinationParam, optional unsigned long output = 0 );
};

interface AudioParam {
};

interface Cache : Object {
  Promise<FrozenArray<DOMString>> keys( optional DOMString request );
};

interface CacheStorage : Object {
  Promise<sequence<DOMString>> keys();
};

[Global=(Worker,DedicatedWorker), Exposed=DedicatedWorker]
interface DedicatedWorkerGlobalScope : WorkerGlobalScope {
  attribute MessageEventHandler? onmessage;
  attribute MessageEventHandler? onmessageerror;
};

interface Document : Object {
  Document open( optional DOMString unused1, optional DOMString unused2 );
  WindowProxy? open( USVString url, DOMString name, DOMString features );
};

interface Element : Object {
};

interface Event : Object {
};

interface ExtendableMessageEvent : MessageEvent {
};

interface HTMLCollection : Object {
  getter Element? item( unsigned long index );
  getter Element? namedItem( DOMString name );
};

interface HTMLOptionElement : Element {
};

interface HTMLOptionsCollection : HTMLCollection {
  getter HTMLOptionElement? item( unsigned long index );
  getter HTMLOptionElement? namedItem( DOMString name );
};

interface Location {
};

interface MessageEvent : Event {
};

interface Navigator {
};

interface Object {
  /**
   * A static method should not cause collisions with instance operations with the same name.
   */
  static sequence<DOMString> keys( object obj );
};

[Global=(Worker,ServiceWorker), Exposed=ServiceWorker]
interface ServiceWorkerGlobalScope : WorkerGlobalScope {
  attribute ExtendableMessageEventHandler? onmessage;
  attribute NullableEventHandler onmessageerror;
};

[Global=Window, Exposed=Window]
interface Window {
  readonly attribute Location location;
  readonly attribute Navigator navigator;
  readonly attribute WindowProxy self;
  attribute MessageEventHandler? onmessage;
  attribute MessageEventHandler? onmessageerror;
};

interface WorkerGlobalScope {
  readonly attribute WorkerLocation location;
  readonly attribute WorkerNavigator navigator;
  readonly attribute WorkerGlobalScope self;
};

interface WorkerNavigator {
};
