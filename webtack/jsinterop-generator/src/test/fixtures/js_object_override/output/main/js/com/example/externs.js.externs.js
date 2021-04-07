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
 */
function WebAssemblyGlobal() {}
/**
 * @return {*}
 * @override
 */
WebAssemblyGlobal.prototype.valueOf = function() {}
/**
 * @constructor
 * @private
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
