[Synthetic]
typedef ( Client or ServiceWorker or MessagePort )? ClientOrServiceWorkerOrMessagePortUnion;

[Synthetic]
typedef ( double or sequence<double> ) DoubleOrDoubleArrayUnion;

[Synthetic]
typedef ( Element or Document )? ElementOrDocumentUnion;

[Synthetic]
typedef ( HTMLCollection or Element )? HTMLCollectionOrElementUnion;

[Synthetic]
typedef ( IDBObjectStore or IDBIndex ) IDBObjectStoreOrIDBIndexUnion;

dictionary ExtendableMessageEventInit {
  ClientOrServiceWorkerOrMessagePortUnion source = null;
};

dictionary IntersectionObserverInit {
  ElementOrDocumentUnion root = null;
  DoubleOrDoubleArrayUnion threshold = 0;
};

interface Client {
};

interface Document {
};

interface Element {
};

interface HTMLAllCollection {
  HTMLCollectionOrElementUnion item( optional DOMString nameOrIndex );
  getter HTMLCollectionOrElementUnion namedItem( DOMString name );
};

interface HTMLCollection {
};

interface IDBCursor {
  readonly attribute IDBObjectStoreOrIDBIndexUnion source;
};

interface IDBIndex {
};

interface IDBObjectStore {
};

interface MessagePort {
};

interface ServiceWorker {
};
