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
function CompileError() {}
/**
 * @constructor
 * @private
 */
function ArrayBuffer() {}
/**
 * @constructor
 * @private
 */
function Module() {}
/**
 * @constructor
 * @param {!GlobalDescriptor} descriptor
 * @param {*=} v
 */
function Global(descriptor,v) {}
/**
 * @return {*}
 */
Global.prototype.valueOf = function() {}
