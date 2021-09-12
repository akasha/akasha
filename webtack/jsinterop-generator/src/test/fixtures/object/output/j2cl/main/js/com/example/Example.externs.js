/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {{requiredObjectValue:!Object,nullableObjectValue:(?Object|undefined),objectValue:(!Object|undefined)}}
 */
var MyDictionary;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function MyType1() {}
/** @type {!Object} */ MyType1.staticReadonlyObjectValue;
/** @type {!Object} */ MyType1.staticObjectValue;
/** @type {!Object} */ MyType1.prototype.readonlyObjectValue;
/** @type {!Object} */ MyType1.prototype.objectValue;
/**
 * @param {!Object} v1
 * @param {!Object=} v2
 * @return {!Object}
 */
MyType1.staticOjectMethod = function(v1,v2) {}
/**
 * @param {!Object} v1
 * @param {!Object=} v2
 * @return {!Object}
 */
MyType1.prototype.objectMethod = function(v1,v2) {}
