/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {function(!string=): undefined}
 */
var OnActionHandler;
/**
 * @interface
 */
function NodeFilter() {}
/** @const {!number} */ NodeFilter.FILTER_ACCEPT;
/**
 * @param {!Node} node
 * @return {!number}
 */
NodeFilter.prototype.acceptNode = function(node) {}
/**
 * @typedef {{bubbles:(!boolean|undefined),cancelable:!boolean}}
 */
var EventInit;
/**
 * @constructor
 * @private
 */
function Node() {}
/**
 * @constructor
 * @param {!string} type
 * @param {!EventInit=} eventInitDict
 */
function Event(type,eventInitDict) {}
/** @const {!number} */ Event.AT_TARGET;
/** @const {!number} */ Event.prototype.AT_TARGET;
/** @type {!boolean} */ Event.prototype.bubbles;
/** @type {!boolean} */ Event.prototype.cancelBubble;
/**
 * @return {!Array<!EventTarget>}
 */
Event.prototype.composedPath = function() {}
/**
 * @param {!string} type
 * @return {!Event}
 */
Event.filterGlobalEvent = function(type) {}
/**
 * @constructor
 * @private
 */
function EventTarget() {}
