enum IDBCursorDirection {
  "next",
  "nextunique",
  "prev",
  "prevunique"
};

enum IDBRequestReadyState {
  "done",
  "pending"
};

enum IDBTransactionDurability {
  "default",
  "relaxed",
  "strict"
};

enum IDBTransactionMode {
  "readonly",
  "readwrite",
  "versionchange"
};

dictionary IDBDatabaseInfo {
  DOMString name;
  unsigned long long version;
};

dictionary IDBIndexParameters {
  boolean multiEntry = false;
  boolean unique = false;
};

dictionary IDBObjectStoreParameters {
  boolean autoIncrement = false;
  ( DOMString or sequence<DOMString> )? keyPath = null;
};

dictionary IDBTransactionOptions {
  IDBTransactionDurability durability = "default";
};

dictionary IDBVersionChangeEventInit : EventInit {
  unsigned long long? newVersion = null;
  unsigned long long oldVersion = 0;
};

partial interface mixin WindowOrWorkerGlobalScope {
  [SameObject]
  readonly attribute IDBFactory indexedDB;
};

[Exposed=(Window,Worker)]
interface IDBCursor {
  readonly attribute IDBCursorDirection direction;
  readonly attribute any key;
  readonly attribute any primaryKey;
  [SameObject]
  readonly attribute IDBRequest request;
  readonly attribute ( IDBObjectStore or IDBIndex ) source;
  undefined advance( [EnforceRange] unsigned long count );
  undefined continue( optional any key );
  undefined continuePrimaryKey( any key, any primaryKey );
  [NewObject]
  IDBRequest delete();
  [NewObject]
  IDBRequest update( any value );
};

[Exposed=(Window,Worker)]
interface IDBCursorWithValue : IDBCursor {
  readonly attribute any value;
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
  undefined close();
  [NewObject]
  IDBObjectStore createObjectStore( DOMString name, optional IDBObjectStoreParameters options = {} );
  undefined deleteObjectStore( DOMString name );
  [NewObject]
  IDBTransaction transaction( ( DOMString or sequence<DOMString> ) storeNames, optional IDBTransactionMode mode = "readonly", optional IDBTransactionOptions options = {} );
};

[Exposed=(Window,Worker)]
interface IDBFactory {
  short cmp( any first, any second );
  Promise<sequence<IDBDatabaseInfo>> databases();
  [NewObject]
  IDBOpenDBRequest deleteDatabase( DOMString name );
  [NewObject]
  IDBOpenDBRequest open( DOMString name, optional [EnforceRange] unsigned long long version );
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
  boolean includes( any key );
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
  IDBIndex createIndex( DOMString name, ( DOMString or sequence<DOMString> ) keyPath, optional IDBIndexParameters options = {} );
  [NewObject]
  IDBRequest delete( any query );
  undefined deleteIndex( DOMString name );
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
interface IDBOpenDBRequest : IDBRequest {
  attribute EventHandler onblocked;
  attribute EventHandler onupgradeneeded;
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
interface IDBTransaction : EventTarget {
  [SameObject]
  readonly attribute IDBDatabase db;
  readonly attribute IDBTransactionDurability durability;
  readonly attribute DOMException? error;
  readonly attribute IDBTransactionMode mode;
  readonly attribute DOMStringList objectStoreNames;
  attribute EventHandler onabort;
  attribute EventHandler oncomplete;
  attribute EventHandler onerror;
  undefined abort();
  undefined commit();
  IDBObjectStore objectStore( DOMString name );
};

[Exposed=(Window,Worker)]
interface IDBVersionChangeEvent : Event {
  readonly attribute unsigned long long? newVersion;
  readonly attribute unsigned long long oldVersion;
  constructor( DOMString type, optional IDBVersionChangeEventInit eventInitDict = {} );
};
