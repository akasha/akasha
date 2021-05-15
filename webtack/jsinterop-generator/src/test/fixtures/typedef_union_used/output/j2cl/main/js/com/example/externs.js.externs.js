/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {!Promise<!ClipboardItemDataType>}
 */
var ClipboardItemData;
/**
 * @typedef {(!string|!Blob)}
 */
var ClipboardItemDataType;
/**
 * @typedef {function(): !ClipboardItemData}
 */
var ClipboardItemDelayedCallback;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Blob() {}
/** @type {!string} */ Blob.prototype.type;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function SomeStore() {}
/** @type {LongOrTxModeUnion} */ SomeStore.prototype.transactionMode;
/**
 * @typedef {(!number|!string)}
 */
var LongOrTxModeUnion;
