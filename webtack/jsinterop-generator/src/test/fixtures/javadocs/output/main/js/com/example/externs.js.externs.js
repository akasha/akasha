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
function () {}
/** @const {!number} */ NodeFilter.FILTER_ACCEPT;
/**
 * @param {!Node} node
 * @return {!number}
 */
NodeFilter.prototype.acceptNode = function(node) {}
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
