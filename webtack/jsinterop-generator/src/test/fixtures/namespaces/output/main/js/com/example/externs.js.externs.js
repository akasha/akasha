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
