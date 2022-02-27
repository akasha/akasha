interface SpeechSynthesis {
  readonly attribute boolean paused;
  readonly attribute boolean pending;
  readonly attribute boolean speaking;
  stringifier;
};

/**
 * An indexed iterable.
 */
partial interface DOMTokenList {
  iterable<DOMString>;
};

/**
 * This type contains anonymous paired iterable.
 */
partial interface Headers {
  iterable<ByteString, ByteString>;
  undefined append( ByteString name, ByteString value );
  undefined delete( ByteString name );
  ByteString? get( ByteString name );
  boolean has( ByteString name );
  undefined set( ByteString name, ByteString value );
};

/**
 * A test for a read-only maplike.
 */
partial interface RTCStatsReport {
  readonly maplike<DOMString, object>;
};

/**
 * A test for a read-write maplike.
 * Also uses a value type that has a different boxed type non-boxed type.
 */
partial interface SomeMapLikeDefiningOverrides {
  maplike<DOMString, long>;
  undefined clear();
  boolean delete( DOMString key );
  undefined set( DOMString key, long value );
};

/**
 * A test for a read-write maplike.
 * Also uses types that have a different boxed type and non-boxed type.
 */
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
