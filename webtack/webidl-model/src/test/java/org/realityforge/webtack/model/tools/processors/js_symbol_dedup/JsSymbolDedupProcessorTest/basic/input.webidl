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

[Global=(Worker,DedicatedWorker), Exposed=DedicatedWorker]
interface DedicatedWorkerGlobalScope : WorkerGlobalScope {
  attribute MessageEventHandler? onmessage;
  attribute MessageEventHandler? onmessageerror;
};

interface Document {
  Document open( optional DOMString unused1, optional DOMString unused2 );
  WindowProxy? open( USVString url, DOMString name, DOMString features );
};

interface Element {
};

interface Event {
};

interface ExtendableMessageEvent : MessageEvent {
};

interface HTMLCollection {
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
