enum IDBCursorDirection {
  "next",
  "nextunique",
  "prev",
  "prevunique"
};

enum IDBTransactionMode {
  "readonly",
  "readwrite",
  "versionchange"
};

enum IDBRequestReadyState {
  "done",
  "pending"
};

dictionary IDBObjectStoreParameters {
  boolean autoIncrement = false;
  ( DOMString or sequence<DOMString> )? keyPath = null;
};

dictionary IDBIndexParameters {
  boolean multiEntry = false;
  boolean unique = false;
};

dictionary IDBVersionChangeEventInit : EventInit {
  unsigned long long? newVersion = null;
  unsigned long long oldVersion = 0;
};

[Exposed=(Window,Worker)]
interface IDBOpenDBRequest : IDBRequest {
  attribute EventHandler onblocked;
  attribute EventHandler onupgradeneeded;
};

[Exposed=(Window,Worker)]
interface IDBObjectStore {
  readonly attribute boolean autoIncrement;
  readonly attribute DOMStringList indexNames;
  readonly attribute any keyPath;
  [SameObject]
  readonly attribute IDBTransaction transaction;
  attribute DOMString name;
  [NewObject]
  IDBRequest add( any value, optional any key );
  [NewObject]
  IDBRequest clear();
  [NewObject]
  IDBRequest count( optional any query );
  [NewObject]
  IDBIndex createIndex( DOMString name, ( DOMString or sequence<DOMString> ) keyPath, optional IDBIndexParameters options );
  [NewObject]
  IDBRequest delete( any query );
  void deleteIndex( DOMString name );
  [NewObject]
  IDBRequest get( any query );
  [NewObject]
  IDBRequest getAll( optional any query, optional [EnforceRange] unsigned long count );
  [NewObject]
  IDBRequest getAllKeys( optional any query, optional [EnforceRange] unsigned long count );
  [NewObject]
  IDBRequest getKey( any query );
  IDBIndex index( DOMString name );
  [NewObject]
  IDBRequest openCursor( optional any query, optional IDBCursorDirection direction = "next" );
  [NewObject]
  IDBRequest openKeyCursor( optional any query, optional IDBCursorDirection direction = "next" );
  [NewObject]
  IDBRequest put( any value, optional any key );
};

[Exposed=(Window,Worker)]
interface IDBFactory {
  short cmp( any first, any second );
  [NewObject]
  IDBOpenDBRequest deleteDatabase( DOMString name );
  [NewObject]
  IDBOpenDBRequest open( DOMString name, optional [EnforceRange] unsigned long long version );
};

[Exposed=(Window,Worker)]
interface IDBDatabase : EventTarget {
  readonly attribute DOMString name;
  readonly attribute DOMStringList objectStoreNames;
  readonly attribute unsigned long long version;
  attribute EventHandler onabort;
  attribute EventHandler onclose;
  attribute EventHandler onerror;
  attribute EventHandler onversionchange;
  void close();
  [NewObject]
  IDBObjectStore createObjectStore( DOMString name, optional IDBObjectStoreParameters options );
  void deleteObjectStore( DOMString name );
  [NewObject]
  IDBTransaction transaction( ( DOMString or sequence<DOMString> ) storeNames, optional IDBTransactionMode mode = "readonly" );
};

[Exposed=(Window,Worker)]
interface IDBKeyRange {
  readonly attribute any lower;
  readonly attribute boolean lowerOpen;
  readonly attribute any upper;
  readonly attribute boolean upperOpen;
  [NewObject]
  static IDBKeyRange bound( any lower, any upper, optional boolean lowerOpen = false, optional boolean upperOpen = false );
  [NewObject]
  static IDBKeyRange lowerBound( any lower, optional boolean open = false );
  [NewObject]
  static IDBKeyRange only( any value );
  [NewObject]
  static IDBKeyRange upperBound( any upper, optional boolean open = false );
  boolean _includes( any key );
};

[Exposed=(Window,Worker)]
interface IDBCursor {
  readonly attribute IDBCursorDirection direction;
  readonly attribute any key;
  readonly attribute any primaryKey;
  readonly attribute ( IDBObjectStore or IDBIndex ) source;
  void advance( [EnforceRange] unsigned long count );
  void continue( optional any key );
  void continuePrimaryKey( any key, any primaryKey );
  [NewObject]
  IDBRequest delete();
  [NewObject]
  IDBRequest update( any value );
};

[Exposed=(Window,Worker)]
interface IDBTransaction : EventTarget {
  [SameObject]
  readonly attribute IDBDatabase db;
  readonly attribute DOMException error;
  readonly attribute IDBTransactionMode mode;
  readonly attribute DOMStringList objectStoreNames;
  attribute EventHandler onabort;
  attribute EventHandler oncomplete;
  attribute EventHandler onerror;
  void abort();
  IDBObjectStore objectStore( DOMString name );
};

[Exposed=(Window,Worker), Constructor( DOMString type, optional IDBVersionChangeEventInit eventInitDict )]
interface IDBVersionChangeEvent : Event {
  readonly attribute unsigned long long? newVersion;
  readonly attribute unsigned long long oldVersion;
};

[Exposed=(Window,Worker)]
interface IDBRequest : EventTarget {
  readonly attribute DOMException? error;
  readonly attribute IDBRequestReadyState readyState;
  readonly attribute any result;
  readonly attribute ( IDBObjectStore or IDBIndex or IDBCursor )? source;
  readonly attribute IDBTransaction? transaction;
  attribute EventHandler onerror;
  attribute EventHandler onsuccess;
};

[Exposed=(Window,Worker)]
interface IDBCursorWithValue : IDBCursor {
  readonly attribute any value;
};

[Exposed=(Window,Worker)]
interface IDBIndex {
  readonly attribute any keyPath;
  readonly attribute boolean multiEntry;
  [SameObject]
  readonly attribute IDBObjectStore objectStore;
  readonly attribute boolean unique;
  attribute DOMString name;
  [NewObject]
  IDBRequest count( optional any query );
  [NewObject]
  IDBRequest get( any query );
  [NewObject]
  IDBRequest getAll( optional any query, optional [EnforceRange] unsigned long count );
  [NewObject]
  IDBRequest getAllKeys( optional any query, optional [EnforceRange] unsigned long count );
  [NewObject]
  IDBRequest getKey( any query );
  [NewObject]
  IDBRequest openCursor( optional any query, optional IDBCursorDirection direction = "next" );
  [NewObject]
  IDBRequest openKeyCursor( optional any query, optional IDBCursorDirection direction = "next" );
};

partial interface WindowOrWorkerGlobalScope {
  [SameObject]
  readonly attribute IDBFactory indexedDB;
};
