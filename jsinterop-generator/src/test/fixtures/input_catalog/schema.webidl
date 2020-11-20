/**
 * This is a predefined type.
 */
enum ActiveMode {
  "active",
  "passive"
};

enum txMode {
  "not-allowed",
  "requires",
  "requires_new"
};

typedef ( double? or sequence<double?> ) IndexedKeyframeOffsetType;

/**
 * This is a predefined type.
 */
typedef ( DOMString or long ) SomeDataType;

/**
 * This is a predefined type.
 */
namespace CSS {
  DOMString escape( DOMString ident );
};

namespace WebAssembly {
  boolean validate( txMode txMode, ActiveMode mode );
};

/**
 * This is a predefined type.
 */
callback EventHandler1 = undefined ();

callback EventHandler2 = undefined ();

callback interface CompletionCallback {
  undefined onDone();
};

/**
 * This is a predefined type.
 */
callback interface EventListener {
  undefined onEvent();
};

/**
 * This is a predefined type.
 */
dictionary IDBIndexParameters {
  boolean multiEntry = false;
  boolean unique = false;
};

dictionary IDBIndexParameters2 {
  boolean multiEntry = false;
  boolean unique = false;
};

/**
 * This is a predefined type.
 */
[Exposed=(Window,Worker)]
interface IDBIndex {
};

[Exposed=(Window,Worker)]
interface IDBObjectStore {
  attribute EventHandler1 handler1;
  attribute EventHandler2 handler2;
  IDBIndex createIndex( DOMString name, ( DOMString or sequence<DOMString> ) keyPath, optional IDBIndexParameters options = {} );
  IDBIndex createIndex2( DOMString name, optional IDBIndexParameters2 options = {} );
  undefined registerListeners( EventListener eventListener, CompletionCallback completionCallback );
  ( DOMString or float ) returnSomeUnionThatIsNotPredefined();
  ( DOMString or long long ) returnSomeUnionThatIsPredefined();
};

/**
 * This is a predefined type.
 */
partial interface Window {
  readonly attribute IDBIndex index;
};

partial interface Worker {
  readonly attribute IDBObjectStore store;
};
