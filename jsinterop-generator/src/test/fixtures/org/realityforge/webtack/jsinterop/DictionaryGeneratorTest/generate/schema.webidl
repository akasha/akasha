dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

dictionary PromiseRejectionEventInit : EventInit {
  required Promise<any> promise;
  any reason;
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

[Exposed=Window]
interface Storage {
  readonly attribute unsigned long length;
  void clear();
  DOMString? key( unsigned long index );
  getter DOMString? getItem( DOMString key );
  setter void setItem( DOMString key, DOMString value );
  deleter void removeItem( DOMString key );
};
