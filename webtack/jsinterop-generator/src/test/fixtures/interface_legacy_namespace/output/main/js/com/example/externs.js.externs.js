/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {!ArrayBuffer}
 */
var BufferSource;
/**
 * @typedef {{mutable:(!boolean|undefined),value:*}}
 */
var GlobalDescriptor;
/**
 * @const
 */
var WebAssembly = {};
/**
 * @param {!BufferSource} bytes
 * @return {!Promise<!Module>}
 */
WebAssembly.prototype.compile = function(bytes) {}
/**
 * @constructor
 * @private
 */
WebAssembly.CompileError = function() {}
/**
 * @constructor
 * @private
 */
function ArrayBuffer() {}
/**
 * @constructor
 * @private
 */
WebAssembly.Module = function() {}
/**
 * @constructor
 * @param {!GlobalDescriptor} descriptor
 * @param {*=} v
 */
WebAssembly.Global = function(descriptor,v) {}
/**
 * @return {*}
 */
WebAssembly.Global.prototype.valueOf = function() {}
