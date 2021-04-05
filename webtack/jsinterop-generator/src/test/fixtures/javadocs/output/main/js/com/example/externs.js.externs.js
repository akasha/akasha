/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {function(!string=): undefined}
 */
var OnActionHandler;
/**
 * @constructor
 */
function NodeFilter() {};
/** @const {!number} */ NodeFilter.FILTER_ACCEPT;
/**
 * @param {!Node} node
 * @return {!number}
 */
NodeFilter.prototype.acceptNode = function(node) {};
