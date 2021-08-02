/**
 * @fileoverview
 * @externs
 */
/**
 * @constructor
 * @private
 * @extends {NotHTMLCollection}
 * @nosideeffects
 */
function HTMLCollection() {}
/**
 * @param {!string} name
 * @return {?HTMLOptionElement}
 * @override
 */
HTMLCollection.prototype.namedItem = function(name) {}
/**
 * @param {!number} index
 * @return {?HTMLOptionElement}
 * @override
 */
HTMLCollection.prototype.item = function(index) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function NotHTMLCollection() {}
/** @type {!number} */ NotHTMLCollection.prototype.length;
/**
 * @param {!string} name
 * @return {?Element}
 */
NotHTMLCollection.prototype.namedItem = function(name) {}
/**
 * @param {!number} index
 * @return {?Element}
 */
NotHTMLCollection.prototype.item = function(index) {}
/**
 * @constructor
 * @private
 * @extends {Element}
 * @nosideeffects
 */
function HTMLOptionElement() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Element() {}
