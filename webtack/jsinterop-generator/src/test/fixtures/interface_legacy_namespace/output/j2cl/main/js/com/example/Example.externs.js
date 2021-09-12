/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {{value:*,mutable:(!boolean|undefined)}}
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
 * @nosideeffects
 */
WebAssembly.CompileError = function() {}
/**
 * @constructor
 * @private
 * @nosideeffects
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
