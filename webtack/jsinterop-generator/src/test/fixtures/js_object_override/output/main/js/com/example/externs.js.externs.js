/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {!number}
 */
var Timestamp;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function MyDate() {}
/**
 * @return {!Timestamp}
 * @override
 */
MyDate.prototype.valueOf = function() {}
/**
 * @return {!string}
 * @override
 */
MyDate.prototype.toString = function() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function MyBoolean() {}
/**
 * @return {!boolean}
 * @override
 */
MyBoolean.prototype.valueOf = function() {}
/**
 * @return {!string}
 * @override
 */
MyBoolean.prototype.toString = function() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function MyString() {}
/**
 * @return {!string}
 * @override
 */
MyString.prototype.valueOf = function() {}
/**
 * @return {!string}
 * @override
 */
MyString.prototype.toString = function() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function WebAssemblyGlobal() {}
/** @type {*} */ WebAssemblyGlobal.prototype.value;
/**
 * @return {*}
 * @override
 */
WebAssemblyGlobal.prototype.valueOf = function() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function ReportBody() {}
/**
 * @return {!Object}
 * @override
 */
ReportBody.prototype.toJSON = function() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function MyNumber() {}
/**
 * @return {!number}
 * @override
 */
MyNumber.prototype.valueOf = function() {}
/**
 * @param {!number=} radix
 * @return {!string}
 * @override
 */
MyNumber.prototype.toString = function(radix) {}
