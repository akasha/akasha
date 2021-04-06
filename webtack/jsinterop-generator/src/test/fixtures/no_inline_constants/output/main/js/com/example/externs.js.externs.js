/**
 * @fileoverview
 * @externs
 */
/**
 * @constructor
 * @private
 */
function MathInterface() {}
/** @const {!number} */ MathInterface.E;
/** @const {!number} */ MathInterface.PI;
/** @const {!number} */ MathInterface.SQRT1_2;
/** @const {!number} */ MathInterface.SQRT2;
/**
 * @param {!number} x
 * @return {!number}
 */
MathInterface.prototype.abs = function(x) {}
/**
 * @const
 * @type {MathInterface}
 */
var Math;
