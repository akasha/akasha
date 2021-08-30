[Internal, Synthetic]
typedef ( AudioNode or undefined ) AudioNodeOrUndefinedUnion;

[Internal, Synthetic]
typedef ( Document or Window ) DocumentOrWindowUnion;

typedef ( ExtendableMessageEventHandler or MessageEventHandler )? ExtendableMessageEventHandlerOrMessageEventHandlerUnion;

[MarkerType]
typedef Window WindowProxy;

typedef ( WorkerGlobalScope or Window ) WorkerGlobalScopeOrWindowUnion;

typedef ( WorkerLocation or Location ) WorkerLocationOrLocationUnion;

typedef ( WorkerNavigator or Navigator ) WorkerNavigatorOrNavigatorUnion;

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

[Global=(Worker,DedicatedWorker), Exposed=DedicatedWorkerGlobalScope]
interface DedicatedWorkerGlobalScope : WorkerGlobalScope {
};

interface Document {
  [TypeOverride=DocumentOrWindowUnion]
  Document open( optional DOMString unused1, optional DOMString unused2 );
  [TypeOverride=DocumentOrWindowUnion]
  WindowProxy? open( USVString url, DOMString name, DOMString features );
};

interface Event {
};

interface ExtendableMessageEvent : Event {
};

interface Location {
};

interface MessageEvent : Event {
};

interface Navigator {
};

[Global=(Worker,ServiceWorker), Exposed=ServiceWorkerGlobalScope]
interface ServiceWorkerGlobalScope : WorkerGlobalScope {
  [GlobalTypeOverride=ExtendableMessageEventHandlerOrMessageEventHandlerUnion]
  attribute ExtendableMessageEventHandler? onmessage;
};

[Global=(Worker,SharedWorker), Exposed=SharedWorkerGlobalScope]
interface SharedWorkerGlobalScope : WorkerGlobalScope {
};

[Global=Window, Exposed=Window]
interface Window {
  [GlobalTypeOverride=WorkerLocationOrLocationUnion]
  readonly attribute Location location;
  [GlobalTypeOverride=WorkerNavigatorOrNavigatorUnion]
  readonly attribute Navigator navigator;
  [Replaceable, GlobalTypeOverride=WorkerGlobalScopeOrWindowUnion]
  readonly attribute WindowProxy self;
  [GlobalTypeOverride=ExtendableMessageEventHandlerOrMessageEventHandlerUnion]
  attribute MessageEventHandler? onmessage;
};

interface WorkerGlobalScope {
  [GlobalTypeOverride=WorkerLocationOrLocationUnion]
  readonly attribute WorkerLocation location;
  [GlobalTypeOverride=WorkerNavigatorOrNavigatorUnion]
  readonly attribute WorkerNavigator navigator;
  [GlobalTypeOverride=WorkerGlobalScopeOrWindowUnion]
  readonly attribute WorkerGlobalScope self;
};

interface WorkerLocation {
};

interface WorkerNavigator {
};
