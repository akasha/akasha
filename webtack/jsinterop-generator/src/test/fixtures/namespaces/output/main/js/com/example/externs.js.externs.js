/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {!ArrayBuffer}
 */
var BufferSource;
/**
 * @constructor
 * @private
 */
function consoleInterface() {}
/**
 * @param {...*} data
 * @return {undefined}
 */
consoleInterface.prototype.warn = function(data) {}
/**
 * @param {!boolean=} condition
 * @param {...*} data
 * @return {undefined}
 */
consoleInterface.prototype.assert = function(condition,data) {}
/**
 * @return {undefined}
 */
consoleInterface.prototype.clear = function() {}
/**
 * @const
 * @type {consoleInterface}
 */
var console;
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
 * @param {!BufferSource} bytes
 * @return {!boolean}
 */
WebAssemblyInterface.prototype.validate = function(bytes) {}
/**
 * @const
 * @type {WebAssemblyInterface}
 */
var WebAssembly;
/**
 * @constructor
 * @private
 */
function MathInterface() {}
/** @const {!number} */ MathInterface.E;
/** @const {!number} */ MathInterface.LN10;
/**
 * @param {!number} x
 * @return {!number}
 */
MathInterface.prototype.abs = function(x) {}
/**
 * @const
 * @type {MathInterface}
 */
var Math;
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
