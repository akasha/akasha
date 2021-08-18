dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

/**
 * Test to ensure that required members are not reordered.
 */
dictionary GPUColorDict {
  required double r;
  required double g;
  required double b;
  required double a;
};

dictionary OptionalAnyDict : RequiredAnyDict {
  any anotherValue = null;
};

dictionary PromiseRejectionEventInit : EventInit {
  required Promise<any> promise;
  any reason;
};

dictionary RTCAnswerOptions : RTCOfferAnswerOptions {
};

dictionary RTCOfferAnswerOptions {
};

dictionary RTCOfferOptions : RTCOfferAnswerOptions {
  boolean iceRestart = false;
};

dictionary RequiredAnyDict {
  required any someValue;
};

dictionary StorageEventInit : EventInit {
  DOMString? key = null;
  DOMString? newValue = null;
  DOMString? oldValue = null;
  Storage? storageArea = null;
  USVString url = "";
};

dictionary TransitionEventInit : EventInit {
  double elapsedTime = 0.0;
  DOMString propertyName = "";
  DOMString pseudoElement = "";
};

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
dictionary txAuthGenericArg {
  required USVString contentType;
};

interface Storage {
  readonly attribute unsigned long length;
  undefined clear();
  DOMString? key( unsigned long index );
  getter DOMString? getItem( DOMString key );
  setter undefined setItem( DOMString key, DOMString value );
  deleter undefined removeItem( DOMString key );
};
