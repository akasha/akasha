dictionary StorageEventInit : EventInit {
  DOMString? key = null;
  DOMString? newValue = null;
  DOMString? oldValue = null;
  Storage? storageArea = null;
  USVString url = "";
};

interface mixin WindowLocalStorage {
  readonly attribute Storage localStorage;
};

interface mixin WindowSessionStorage {
  readonly attribute Storage sessionStorage;
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

[Exposed=Window, Constructor( DOMString type, optional StorageEventInit eventInitDict = {} )]
interface StorageEvent : Event {
  readonly attribute DOMString? key;
  readonly attribute DOMString? newValue;
  readonly attribute DOMString? oldValue;
  readonly attribute Storage? storageArea;
  readonly attribute USVString url;
  void initStorageEvent( DOMString type, optional boolean bubbles = false, optional boolean cancelable = false, optional DOMString? key = null, optional DOMString? oldValue = null, optional DOMString? newValue = null, optional USVString url = "", optional Storage? storageArea = null );
};

Window includes WindowLocalStorage;

Window includes WindowSessionStorage;
