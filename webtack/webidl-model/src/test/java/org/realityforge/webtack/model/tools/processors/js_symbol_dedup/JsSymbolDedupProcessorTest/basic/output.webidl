[Internal, Synthetic]
typedef ( AudioNode or undefined ) AudioNodeOrUndefinedUnion;

[Internal, Synthetic]
typedef ( Document or Window ) DocumentOrWindowUnion;

[Internal, Synthetic]
typedef ( Element? or HTMLOptionElement? )? ElementOrHTMLOptionElementUnion;

[Internal, Synthetic]
typedef ( EventHandler? or MessageEventHandler? )? EventHandlerOrMessageEventHandlerUnion;

[Internal, Synthetic]
typedef ( ExtendableMessageEventHandler? or MessageEventHandler? )? ExtendableMessageEventHandlerOrMessageEventHandlerUnion;

typedef EventHandler? NullableEventHandler;

typedef Window WindowProxy;

[Internal, Synthetic]
typedef ( WorkerGlobalScope or Window ) WorkerGlobalScopeOrWindowUnion;

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
  [GlobalTypeOverride=ExtendableMessageEventHandlerOrMessageEventHandlerUnion]
  attribute MessageEventHandler? onmessage;
  [GlobalTypeOverride=EventHandlerOrMessageEventHandlerUnion]
  attribute MessageEventHandler? onmessageerror;
};

interface Document {
  [TypeOverride=DocumentOrWindowUnion]
  Document open( optional DOMString unused1, optional DOMString unused2 );
  [TypeOverride=DocumentOrWindowUnion]
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
  [GlobalTypeOverride=ExtendableMessageEventHandlerOrMessageEventHandlerUnion]
  attribute ExtendableMessageEventHandler? onmessage;
  [GlobalTypeOverride=EventHandlerOrMessageEventHandlerUnion]
  attribute NullableEventHandler onmessageerror;
};

[Global=Window, Exposed=Window]
interface Window {
  [GlobalTypeOverride=WorkerLocationOrLocationUnion]
  readonly attribute Location location;
  [GlobalTypeOverride=WorkerNavigatorOrNavigatorUnion]
  readonly attribute Navigator navigator;
  [GlobalTypeOverride=WorkerGlobalScopeOrWindowUnion]
  readonly attribute WindowProxy self;
  [GlobalTypeOverride=ExtendableMessageEventHandlerOrMessageEventHandlerUnion]
  attribute MessageEventHandler? onmessage;
  [GlobalTypeOverride=EventHandlerOrMessageEventHandlerUnion]
  attribute MessageEventHandler? onmessageerror;
};

interface WorkerGlobalScope {
  [GlobalTypeOverride=WorkerLocationOrLocationUnion]
  readonly attribute WorkerLocation location;
  [GlobalTypeOverride=WorkerNavigatorOrNavigatorUnion]
  readonly attribute WorkerNavigator navigator;
  [GlobalTypeOverride=WorkerGlobalScopeOrWindowUnion]
  readonly attribute WorkerGlobalScope self;
};

interface WorkerNavigator {
};
