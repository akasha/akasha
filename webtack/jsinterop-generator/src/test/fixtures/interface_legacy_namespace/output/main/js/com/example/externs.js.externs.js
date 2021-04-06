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
 * @constructor
 * @private
 */
function WebAssemblyInterface() {}
/**
 * @param {!BufferSource} bytes
 * @return {!Promise<!Module>}
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
