typedef EventHandler? NullableEventHandler;

typedef ( double or sequence<double> ) Numbers;

typedef double Timestamp;

typedef Window WindowProxy;

callback EventHandler = undefined ( Event event );

callback ExtendableMessageEventHandler = undefined ( ExtendableMessageEvent event );

callback MessageEventHandler = undefined ( MessageEvent event );

callback RTCPeerConnectionErrorCallback = undefined ( DOMException error );

callback RTCSessionDescriptionCallback = undefined ( RTCSessionDescriptionInit description );

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

[Global=MyFakeGlobalType1, Exposed=ServiceWorker]
interface MyFakeGlobalType1 {
  readonly attribute double counter;
  /**
   * This should not have a union as the other myOperations are all equivalent (when resolved)
   */
  double myOperation( DOMString myParam );
};

[Global=MyFakeGlobalType2, Exposed=ServiceWorker]
interface MyFakeGlobalType2 {
  readonly attribute Timestamp counter;
  /**
   * This should not have a union as the other myOperations are all equivalent (when resolved)
   */
  Timestamp myOperation( DOMString myParam1, DOMString myParam2 );
};

interface MyFakeType {
  /**
   * This should not have a union as the other myOperations are all equivalent (when resolved)
   */
  double myOperation( DOMString myParam );
  /**
   * This should not have a union as the other myOperations are all equivalent (when resolved)
   */
  double myOperation();
  /**
   * This should not have a union as the other myOperations are all equivalent (when resolved)
   */
  Timestamp myOperation( DOMString myParam1, DOMString myParam2 );
  /**
   * This should not have a union as the return types are equivalent.
   */
  Numbers myOperation2( DOMString myParam );
  /**
   * This should not have a union as the return types are equivalent.
   */
  Numbers myOperation2();
};

interface Navigator {
};

interface Object {
  /**
   * A static method should not cause collisions with instance operations with the same name.
   */
  static sequence<DOMString> keys( object obj );
};

interface RTCOfferOptions {
};

interface RTCPeerConnection {
  Promise<RTCSessionDescriptionInit> createOffer( optional RTCOfferOptions options = {} );
  Promise<undefined> createOffer( RTCSessionDescriptionCallback successCallback, RTCPeerConnectionErrorCallback failureCallback, optional RTCOfferOptions options = {} );
};

interface RTCSessionDescriptionInit {
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
