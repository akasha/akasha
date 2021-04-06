/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {!number}
 */
var GLenum;
/**
 * @typedef {!number}
 */
var GLbitfield;
/**
 * @typedef {!number}
 */
var GLint;
/**
 * @typedef {(!Int32Array|!Array<!GLint>)}
 */
var Int32List;
/**
 * @constructor
 * @private
 */
function Int32Array() {}
/**
 * @constructor
 * @private
 */
function WebGLRenderingContext() {}
/** @const {!GLenum} */ WebGLRenderingContext.ACTIVE_ATTRIBUTES;
/**
 * @param {!GLbitfield} mask
 * @return {undefined}
 */
WebGLRenderingContext.prototype.clear = function(mask) {}
/**
 * @param {!GLenum} target
 * @return {!GLenum}
 */
WebGLRenderingContext.prototype.checkFramebufferStatus = function(target) {}
