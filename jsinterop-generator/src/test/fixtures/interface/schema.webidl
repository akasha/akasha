dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

/**
 * This type contains anonymous named property operations.
 */
interface DOMStringMap {
  getter DOMString ( DOMString name );
  [CEReactions]
  setter undefined ( DOMString name, DOMString value );
  [CEReactions]
  deleter undefined ( DOMString name );
};

/**
 * An indexed iterable.
 */
interface DOMTokenList {
  iterable<DOMString>;
};

[Exposed=(Window,Worker,AudioWorklet)]
interface Event {
  const unsigned short AT_TARGET = 2;
  const unsigned short BUBBLING_PHASE = 3;
  const unsigned short CAPTURING_PHASE = 1;
  const unsigned short NONE = 0;
  readonly attribute boolean bubbles;
  readonly attribute boolean cancelable;
  readonly attribute boolean composed;
  readonly attribute EventTarget? currentTarget;
  readonly attribute boolean defaultPrevented;
  readonly attribute unsigned short eventPhase;
  [LegacyUnforgeable]
  readonly attribute boolean isTrusted;
  readonly attribute any readonlyAny;
  readonly attribute EventTarget? srcElement;
  readonly attribute EventTarget? target;
  readonly attribute DOMString type;
  attribute boolean cancelBubble;
  attribute any mutableAny;
  attribute boolean returnValue;
  constructor( DOMString type, optional EventInit eventInitDict = {} );
  Promise<any> anyInReturnedPromise();
  undefined anyParameter( any value );
  any anyReturning();
  sequence<EventTarget> composedPath();
  undefined initEvent( DOMString type, optional boolean bubbles = false, optional boolean cancelable = false );
  undefined preventDefault();
  undefined stopImmediatePropagation();
  undefined stopPropagation();
};

[Exposed=(Window,Worker,AudioWorklet)]
interface EventTarget {
  constructor();
  boolean dispatchEvent( Event event );
};

/**
 * This type contains anonymous paired iterable.
 */
interface Headers {
  iterable<ByteString, ByteString>;
  undefined append( ByteString name, ByteString value );
  undefined delete( ByteString name );
  ByteString? get( ByteString name );
  boolean has( ByteString name );
  undefined set( ByteString name, ByteString value );
};

interface MyThing {
};

/**
 * This type contains anonymous indexed property operations.
 */
interface MyThingCollection {
  getter MyThing? ( unsigned long index );
  setter undefined ( unsigned long index, MyThing? option );
};

/**
 * A test for a read-only maplike.
 */
[Exposed=Window]
interface RTCStatsReport {
  readonly maplike<DOMString, object>;
};

/**
 * A test for a read-write maplike.
 * Also uses a value type that has a different boxed type non-boxed type.
 */
[Exposed=Window]
interface SomeMapLikeDefiningOverrides {
  maplike<DOMString, long>;
  undefined clear();
  boolean delete( DOMString key );
  undefined set( DOMString key, long value );
};

/**
 * A test for a read-write maplike.
 * Also uses types that have a different boxed type and non-boxed type.
 */
[Exposed=Window]
interface SomeOtherType {
  maplike<long, long>;
};

[Exposed=Window]
interface SpeechRecognitionErrorEvent : Event {
  readonly attribute DOMString message;
  constructor( DOMString type );
  stringifier DOMString messageDescription();
};

[Exposed=Window]
interface Storage {
  readonly attribute unsigned long length;
  undefined clear();
  DOMString? key( unsigned long index );
  getter DOMString? getItem( DOMString key );
  setter undefined setItem( DOMString key, DOMString value );
  deleter undefined removeItem( DOMString key );
};

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
interface txStorage {
  readonly attribute unsigned long length;
};
