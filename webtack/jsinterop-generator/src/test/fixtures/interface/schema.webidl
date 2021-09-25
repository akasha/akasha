dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsBoolean {
  getter boolean ( unsigned long index );
  setter undefined ( unsigned long index, boolean value );
  deleter undefined ( unsigned long index );
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsByte {
  getter byte ( unsigned long index );
  setter undefined ( unsigned long index, byte value );
  deleter undefined ( unsigned long index );
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsFloat {
  getter float ( unsigned long index );
  setter undefined ( unsigned long index, float value );
  deleter undefined ( float name );
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsLong {
  getter long ( unsigned long index );
  setter undefined ( unsigned long index, long value );
  deleter undefined ( unsigned long index );
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsLongLong {
  getter long long ( unsigned long index );
  setter undefined ( unsigned long index, long long value );
  deleter undefined ( unsigned long index );
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsOctet {
  getter octet ( unsigned long index );
  setter undefined ( unsigned long index, octet value );
  deleter undefined ( unsigned long index );
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsShort {
  getter short ( unsigned long index );
  setter undefined ( unsigned long index, short value );
  deleter undefined ( unsigned long index );
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsUnrestrictedFloat {
  getter unrestricted float ( unsigned long index );
  setter undefined ( unsigned long index, unrestricted float value );
  deleter undefined ( unsigned long index );
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsUnsignedLong {
  getter unsigned long ( unsigned long index );
  setter undefined ( unsigned long index, unsigned long value );
  deleter undefined ( unsigned long index );
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsUnsignedLongLong {
  getter unsigned long long ( unsigned long index );
  setter undefined ( unsigned long index, unsigned long long value );
  deleter undefined ( unsigned long index );
};

/**
 * This type contains anonymous indexed property operations.
 */
interface AnonymousIndexedAccessorsUnsignedShort {
  getter unsigned short ( unsigned long index );
  setter undefined ( unsigned long index, unsigned short value );
  deleter undefined ( unsigned long index );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsBoolean {
  getter boolean ( DOMString name );
  setter undefined ( DOMString name, boolean value );
  deleter undefined ( DOMString name );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsByte {
  getter byte ( DOMString name );
  setter undefined ( DOMString name, byte value );
  deleter undefined ( DOMString name );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsFloat {
  getter float ( DOMString name );
  setter undefined ( DOMString name, float value );
  deleter undefined ( float name );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsLong {
  getter long ( DOMString name );
  setter undefined ( DOMString name, long value );
  deleter undefined ( DOMString name );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsLongLong {
  getter long long ( DOMString name );
  setter undefined ( DOMString name, long long value );
  deleter undefined ( DOMString name );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsOctet {
  getter octet ( DOMString name );
  setter undefined ( DOMString name, octet value );
  deleter undefined ( DOMString name );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsShort {
  getter short ( DOMString name );
  setter undefined ( DOMString name, short value );
  deleter undefined ( DOMString name );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsUnrestrictedFloat {
  getter unrestricted float ( DOMString name );
  setter undefined ( DOMString name, unrestricted float value );
  deleter undefined ( DOMString name );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsUnsignedLong {
  getter unsigned long ( DOMString name );
  setter undefined ( DOMString name, unsigned long value );
  deleter undefined ( DOMString name );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsUnsignedLongLong {
  getter unsigned long long ( DOMString name );
  setter undefined ( DOMString name, unsigned long long value );
  deleter undefined ( DOMString name );
};

/**
 * This type contains anonymous named property operations.
 */
interface AnonymousNamedAccessorsUnsignedShort {
  getter unsigned short ( DOMString name );
  setter undefined ( DOMString name, unsigned short value );
  deleter undefined ( DOMString name );
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

/**
 * An indexed iterable where the type needs to be boxed.
 */
interface Int8Array {
  iterable<byte>;
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
interface RTCStatsReport {
  readonly maplike<DOMString, object>;
};

/**
 * A test for a read-write maplike.
 * Also uses a value type that has a different boxed type non-boxed type.
 */
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
interface SomeOtherType {
  maplike<long, long>;
};

/**
 * A test for a read-only setlike.
 */
interface SomeReadOnlySetLike {
  readonly setlike<DOMString>;
};

/**
 * A test for a read-write setlike.
 */
interface SomeWriteSetLike {
  setlike<DOMString>;
};

interface SpeechRecognitionErrorEvent : Event {
  readonly attribute DOMString message;
  constructor( DOMString type );
  stringifier DOMString messageDescription();
};

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
