dictionary ExtendableMessageEventInit {
  ( Client or ServiceWorker or MessagePort )? source = null;
};

dictionary IntersectionObserverInit {
  ( Element or Document )? root = null;
  ( double or sequence<double> ) threshold = 0;
};

interface Client {
};

interface Document {
};

interface Element {
};

interface HTMLAllCollection {
  ( HTMLCollection or Element )? item( optional DOMString nameOrIndex );
  getter ( HTMLCollection or Element )? namedItem( DOMString name );
};

interface HTMLCollection {
};

interface IDBCursor {
  readonly attribute ( IDBObjectStore or IDBIndex ) source;
};

interface IDBIndex {
};

interface IDBObjectStore {
};

interface MessagePort {
};

interface ServiceWorker {
};
