dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
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
  readonly attribute EventTarget? srcElement;
  readonly attribute EventTarget? target;
  readonly attribute DOMString type;
  attribute boolean cancelBubble;
  attribute boolean returnValue;
  constructor( DOMString type, optional EventInit eventInitDict = {} );
  sequence<EventTarget> composedPath();
  void initEvent( DOMString type, optional boolean bubbles = false, optional boolean cancelable = false );
  void preventDefault();
  void stopImmediatePropagation();
  void stopPropagation();
};

[Exposed=(Window,Worker,AudioWorklet)]
interface EventTarget {
  constructor();
  boolean dispatchEvent( Event event );
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
  void clear();
  boolean delete( DOMString key );
  void set( DOMString key, long value );
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
  void clear();
  DOMString? key( unsigned long index );
  getter DOMString? getItem( DOMString key );
  setter void setItem( DOMString key, DOMString value );
  deleter void removeItem( DOMString key );
};

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
interface txStorage {
  readonly attribute unsigned long length;
};
