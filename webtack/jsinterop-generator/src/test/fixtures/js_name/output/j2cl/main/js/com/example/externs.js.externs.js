/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {(!Int32Array|!Array<!number>)}
 */
var NumbersList;
/**
 * @typedef {{jsElapsedTime:(!number|undefined),propertyName:(!string|undefined)}}
 */
var JsEventInit;
/**
 * @typedef {{js_pseudoElement:(!string|undefined),jsElapsedTime:(!number|undefined),propertyName:(!string|undefined)}}
 */
var JsTransitionEventInit;
/**
 * @const
 */
var JsMath;
/** @const {!number} */ JsMath.JsE;
/** @const {!number} */ JsMath.JsPI;
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
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function HTMLSelectElement() {}
/** @type {!HTMLCollection} */ HTMLSelectElement.prototype.selectedOptions;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Thing() {}
/** @type {!number} */ Thing.prototype.zeSize;
/**
 * @param {!number} i
 * @return {?Element}
 */
Thing.prototype.leItem = function(i) {}
