/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {!ArrayBuffer}
 */
var BufferSource;
/**
 * @const
 */
var console = {};
/**
 * @param {...*} data
 * @return {undefined}
 */
console.prototype.warn = function(data) {}
/**
 * @param {!boolean=} condition
 * @param {...*} data
 * @return {undefined}
 */
console.prototype.assert = function(condition,data) {}
/**
 * @return {undefined}
 */
console.prototype.clear = function() {}
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
 * @param {!BufferSource} bytes
 * @return {!boolean}
 */
WebAssembly.prototype.validate = function(bytes) {}
/**
 * @const
 */
var Math = {};
/** @const {!number} */ Math.E;
/** @const {!number} */ Math.LN10;
/**
 * @param {!number} x
 * @return {!number}
 */
Math.prototype.abs = function(x) {}
/**
 * @constructor
 * @private
 */
function Window() {}
/**
 * @constructor
 * @private
 */
function ArrayBuffer() {}
