/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {{mutable:(!boolean|undefined),value:*}}
 */
var GlobalDescriptor;
/**
 * @const
 */
var WebAssembly;
/**
 * @param {!BufferSource} bytes
 * @return {!Promise<!WebAssembly.Module>}
 */
WebAssembly.compile = function(bytes) {}
/**
 * @constructor
 * @private
 */
WebAssembly.CompileError = function() {}
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
/** @type {*} */ WebAssembly.Global.prototype.value;
/**
 * @return {*}
 * @override
 */
WebAssembly.Global.prototype.valueOf = function() {}
