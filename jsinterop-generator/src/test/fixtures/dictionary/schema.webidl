dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

dictionary OptionalAnyDict : RequiredAnyDict {
  any anotherValue = null;
};

dictionary PromiseRejectionEventInit : EventInit {
  required Promise<any> promise;
  any reason;
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

[Exposed=Window]
interface Storage {
  readonly attribute unsigned long length;
  undefined clear();
  DOMString? key( unsigned long index );
  getter DOMString? getItem( DOMString key );
  setter undefined setItem( DOMString key, DOMString value );
  deleter undefined removeItem( DOMString key );
};
