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
 * @typedef {{bubbles2:!boolean,bubbles:(!boolean|undefined)}}
 */
var EventInit;
/**
 * @const
 */
var CSS;
/**
 * @param {!string} ident
 * @return {!string}
 */
CSS.escape = function(ident) {}
/**
 * @constructor
 * @private
 * @nosideeffects
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
 * @nosideeffects
 */
function WebGLShader() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Event() {}
