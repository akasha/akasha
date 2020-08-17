[Exposed=Window]
interface SpeechSynthesis {
  readonly attribute boolean paused;
  readonly attribute boolean pending;
  readonly attribute boolean speaking;
  stringifier void customToString();
};

/**
 * A test for a read-only maplike.
 */
[Exposed=Window]
partial interface RTCStatsReport {
  readonly maplike<DOMString, object>;
};

/**
 * A test for a read-write maplike.
 * Also uses a value type that has a different boxed type non-boxed type.
 */
[Exposed=Window]
partial interface SomeMapLikeDefiningOverrides {
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
partial interface SomeOtherType {
  maplike<long, long>;
};

partial interface Window {
  [SameObject]
  readonly attribute SpeechSynthesis speechSynthesis;
};

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
partial interface rtcThingie {
  readonly maplike<DOMString, object>;
};
