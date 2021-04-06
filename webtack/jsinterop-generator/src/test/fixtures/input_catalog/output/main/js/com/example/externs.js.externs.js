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
 * @const
 */
var CSS = {};
/**
 * @param {!string} ident
 * @return {!string}
 */
CSS.prototype.escape = function(ident) {}
/**
 * @const
 */
var WebAssembly = {};
/**
 * @param {!txMode} txMode
 * @param {!ActiveMode} mode
 * @return {!boolean}
 */
WebAssembly.prototype.validate = function(txMode,mode) {}
/**
 * @constructor
 * @private
 */
function IDBObjectStore() {}
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
