/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {(?number|!Array<?number>)}
 */
var IndexedKeyframeOffsetType;
/**
 * @typedef {(!string|!number)}
 */
var SomeDataType;
/**
 * @typedef {function(): undefined}
 */
var EventHandler1;
/**
 * @typedef {function(): undefined}
 */
var EventHandler2;
/**
 * @interface
 */
function CompletionCallback() {}
/**
 * @return {undefined}
 */
CompletionCallback.prototype.onDone = function() {}
/**
 * @interface
 */
function EventListener() {}
/**
 * @return {undefined}
 */
EventListener.prototype.onEvent = function() {}
/**
 * @typedef {{multiEntry:(!boolean|undefined),unique:(!boolean|undefined)}}
 */
var IDBIndexParameters;
/**
 * @typedef {{multiEntry:(!boolean|undefined),unique:(!boolean|undefined)}}
 */
var IDBIndexParameters2;
/**
 * @constructor
 * @private
 */
function CSSInterface() {}
/**
 * @param {!string} ident
 * @return {!string}
 */
CSSInterface.prototype.escape = function(ident) {}
/**
 * @const
 * @type {CSSInterface}
 */
var CSS;
/**
 * @constructor
 * @private
 */
function WebAssemblyInterface() {}
/**
 * @param {!string} txMode
 * @param {!string} mode
 * @return {!boolean}
 */
WebAssemblyInterface.prototype.validate = function(txMode,mode) {}
/**
 * @const
 * @type {WebAssemblyInterface}
 */
var WebAssembly;
/**
 * @constructor
 * @private
 */
function IDBObjectStore() {}
/** @type {!EventHandler1} */ IDBObjectStore.prototype.handler1;
/** @type {!EventHandler2} */ IDBObjectStore.prototype.handler2;
/**
 * @return {(!string|!number)}
 */
IDBObjectStore.prototype.returnSomeUnionThatIsPredefined = function() {}
/**
 * @param {!string} name
 * @param {!IDBIndexParameters2=} options
 * @return {!IDBIndex}
 */
IDBObjectStore.prototype.createIndex2 = function(name,options) {}
/**
 * @param {!EventListener} eventListener
 * @param {!CompletionCallback} completionCallback
 * @return {undefined}
 */
IDBObjectStore.prototype.registerListeners = function(eventListener,completionCallback) {}
/**
 * @return {(!string|!number)}
 */
IDBObjectStore.prototype.returnSomeUnionThatIsNotPredefined = function() {}
/**
 * @param {!string} name
 * @param {(!string|!Array<!string>)} keyPath
 * @param {!IDBIndexParameters=} options
 * @return {!IDBIndex}
 */
IDBObjectStore.prototype.createIndex = function(name,keyPath,options) {}
/**
 * @constructor
 * @private
 */
function IDBIndex() {}
