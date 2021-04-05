/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {function(!Event): undefined}
 */
var MyEventHandler;
/**
 * @constructor
 */
function OtherEventListener() {};
/**
 * @param {!Event} event
 * @return {undefined}
 */
OtherEventListener.prototype.handleEvent = function(event) {};
/**
 * @constructor
 */
function EventListener() {};
/**
 * @param {!Event} event
 * @return {undefined}
 */
EventListener.prototype.handleEvent = function(event) {};
