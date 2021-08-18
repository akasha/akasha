dictionary IDBIndexParameters {
  boolean multiEntry = false;
  boolean unique = false;
};

interface IDBIndex {
};

interface IDBObjectStore {
  readonly attribute boolean autoIncrement;
  IDBIndex createIndex( DOMString name, ( DOMString or sequence<DOMString> ) keyPath, optional IDBIndexParameters options = {} );
};
