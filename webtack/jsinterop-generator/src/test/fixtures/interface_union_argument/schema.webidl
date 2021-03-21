dictionary IDBIndexParameters {
  boolean multiEntry = false;
  boolean unique = false;
};

[Exposed=(Window,Worker)]
interface IDBIndex {
};

[Exposed=(Window,Worker)]
interface IDBObjectStore {
  readonly attribute boolean autoIncrement;
  IDBIndex createIndex( DOMString name, ( DOMString or sequence<DOMString> ) keyPath, optional IDBIndexParameters options = {} );
};
