/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {{mutable:(!boolean|undefined),value:*}}
 */
var GlobalDescriptor;
/**
 * @constructor
 * @private
 */
function WebAssemblyInterface() {}
/**
 * @param {!BufferSource} bytes
 * @return {!Promise<!WebAssembly.Module>}
 */
WebAssemblyInterface.prototype.compile = function(bytes) {}
/**
 * @const
 * @type {WebAssemblyInterface}
 */
var WebAssembly;
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
/**
 * @return {*}
 * @override
 */
WebAssembly.Global.prototype.valueOf = function() {}
