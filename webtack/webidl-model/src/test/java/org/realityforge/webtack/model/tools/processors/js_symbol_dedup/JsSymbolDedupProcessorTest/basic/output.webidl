[Internal, Synthetic]
typedef ( AudioNode or undefined ) AudioNodeOrUndefinedUnion;

[Internal, Synthetic]
typedef ( Document or WindowProxy? )? DocumentOrWindowProxyUnion;

[Internal, Synthetic]
typedef ( Element? or HTMLOptionElement? )? ElementOrHTMLOptionElementUnion;

[Internal, Synthetic]
typedef ( MessageEventHandler? or ExtendableMessageEventHandler? )? MessageEventHandlerOrExtendableMessageEventHandlerUnion;

[Internal, Synthetic]
typedef ( MessageEventHandler? or NullableEventHandler )? MessageEventHandlerOrNullableEventHandlerUnion;

typedef EventHandler? NullableEventHandler;

typedef Window WindowProxy;

[Internal, Synthetic]
typedef ( WorkerGlobalScope or WindowProxy ) WorkerGlobalScopeOrWindowProxyUnion;

[Internal, Synthetic]
typedef ( WorkerLocation or Location ) WorkerLocationOrLocationUnion;

[Internal, Synthetic]
typedef ( WorkerNavigator or Navigator ) WorkerNavigatorOrNavigatorUnion;

callback EventHandler = undefined ( Event event );

callback ExtendableMessageEventHandler = undefined ( ExtendableMessageEvent event );

callback MessageEventHandler = undefined ( MessageEvent event );

interface AudioNode {
  [TypeOverride=AudioNodeOrUndefinedUnion]
  AudioNode connect( AudioNode destinationNode, optional unsigned long output = 0, optional unsigned long input = 0 );
  [TypeOverride=AudioNodeOrUndefinedUnion]
  undefined connect( AudioParam destinationParam, optional unsigned long output = 0 );
};

interface AudioParam {
};

[Global=(Worker,DedicatedWorker), Exposed=DedicatedWorker]
interface DedicatedWorkerGlobalScope : WorkerGlobalScope {
  [GlobalTypeOverride=MessageEventHandlerOrExtendableMessageEventHandlerUnion]
  attribute MessageEventHandler? onmessage;
  [GlobalTypeOverride=MessageEventHandlerOrNullableEventHandlerUnion]
  attribute MessageEventHandler? onmessageerror;
};

interface Document {
  [TypeOverride=DocumentOrWindowProxyUnion]
  Document open( optional DOMString unused1, optional DOMString unused2 );
  [TypeOverride=DocumentOrWindowProxyUnion]
  WindowProxy? open( USVString url, DOMString name, DOMString features );
};

interface Element {
};

interface Event {
};

interface ExtendableMessageEvent : MessageEvent {
};

interface HTMLCollection {
  [TypeOverride=ElementOrHTMLOptionElementUnion]
  getter Element? item( unsigned long index );
  [TypeOverride=ElementOrHTMLOptionElementUnion]
  getter Element? namedItem( DOMString name );
};

interface HTMLOptionElement : Element {
};

interface HTMLOptionsCollection : HTMLCollection {
  [TypeOverride=ElementOrHTMLOptionElementUnion]
  getter HTMLOptionElement? item( unsigned long index );
  [TypeOverride=ElementOrHTMLOptionElementUnion]
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
  [GlobalTypeOverride=MessageEventHandlerOrExtendableMessageEventHandlerUnion]
  attribute ExtendableMessageEventHandler? onmessage;
  [GlobalTypeOverride=MessageEventHandlerOrNullableEventHandlerUnion]
  attribute NullableEventHandler onmessageerror;
};

[Global=Window, Exposed=Window]
interface Window {
  [GlobalTypeOverride=WorkerLocationOrLocationUnion]
  readonly attribute Location location;
  [GlobalTypeOverride=WorkerNavigatorOrNavigatorUnion]
  readonly attribute Navigator navigator;
  [GlobalTypeOverride=WorkerGlobalScopeOrWindowProxyUnion]
  readonly attribute WindowProxy self;
  [GlobalTypeOverride=MessageEventHandlerOrExtendableMessageEventHandlerUnion]
  attribute MessageEventHandler? onmessage;
  [GlobalTypeOverride=MessageEventHandlerOrNullableEventHandlerUnion]
  attribute MessageEventHandler? onmessageerror;
};

interface WorkerGlobalScope {
  [GlobalTypeOverride=WorkerLocationOrLocationUnion]
  readonly attribute WorkerLocation location;
  [GlobalTypeOverride=WorkerNavigatorOrNavigatorUnion]
  readonly attribute WorkerNavigator navigator;
  [GlobalTypeOverride=WorkerGlobalScopeOrWindowProxyUnion]
  readonly attribute WorkerGlobalScope self;
};

interface WorkerNavigator {
};
