/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {{multiEntry:(!boolean|undefined),unique:(!boolean|undefined)}}
 */
var IDBIndexParameters;
/**
 * @constructor
 * @private
 */
function IDBObjectStore() {}
/** @type {!boolean} */ IDBObjectStore.prototype.autoIncrement;
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
