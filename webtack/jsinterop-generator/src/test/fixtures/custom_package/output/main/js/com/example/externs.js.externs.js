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
function Event() {}
