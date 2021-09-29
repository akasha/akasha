/**
 * @fileoverview
 * @externs
 */
/**
 * @const
 */
var console;
/**
 * @param {...*} data
 * @return {undefined}
 */
console.warn = function(data) {}
/**
 * @param {!boolean=} condition
 * @param {...*} data
 * @return {undefined}
 */
console.assert = function(condition,data) {}
/**
 * @return {undefined}
 */
console.clear = function() {}
/**
 * @param {*=} tabularData
 * @param {!Array<!string>=} properties
 * @return {undefined}
 */
console.table = function(tabularData,properties) {}
/**
 * @const
 */
var CSS;
/**
 * @param {!string} ident
 * @return {!string}
 */
CSS.escape = function(ident) {}
/**
 * @const
 */
var VarargsType;
/**
 * @param {!Array<!string>} tokens1
 * @param {!Array<!string>} tokens2
 * @return {undefined}
 */
VarargsType.myOperation2 = function(tokens1,tokens2) {}
/**
 * @param {!Array<!string>} tokens
 * @return {undefined}
 */
VarargsType.myOperation1 = function(tokens) {}
/**
 * @const
 */
var WebAssembly;
/**
 * @param {!BufferSource} bytes
 * @return {!boolean}
 */
WebAssembly.validate = function(bytes) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Window() {}
/** @type {!boolean} */ Window.prototype.closed;
/** @type {!boolean} */ var closed;
