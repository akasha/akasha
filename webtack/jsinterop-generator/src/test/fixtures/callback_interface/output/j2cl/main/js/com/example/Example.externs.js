/**
 * @fileoverview
 * @externs
 */
/**
 * @interface
 */
function txCallback() {}
/**
 * @param {!Event} event
 * @param {!string=} source
 * @param {!CallbackOptions=} metadata
 * @return {undefined}
 */
txCallback.prototype.handleEvent = function(event,source,metadata) {}
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
 * @typedef {{label:(!string|undefined)}}
 */
var CallbackOptions;
/**
 * @constructor
 */
function Event() {}
