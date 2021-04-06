/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {(!string|!number)}
 */
var MyTypedefedUnion;
/**
 * @typedef {function(!Event): undefined}
 */
var MyEventHandler;
/**
 * @interface
 */
function EventListener() {}
/**
 * @param {!Event} event
 * @return {undefined}
 */
EventListener.prototype.handleEvent = function(event) {}
/**
 * @constructor
 * @private
 */
function WebGL2RenderingContext() {}
/**
 * @param {!WebGLShader} shader
 * @return {?string}
 */
WebGL2RenderingContext.prototype.getShaderSource = function(shader) {}
/**
 * @constructor
 * @private
 */
function WebGLShader() {}
/**
 * @constructor
 * @private
 */
function Event() {}
