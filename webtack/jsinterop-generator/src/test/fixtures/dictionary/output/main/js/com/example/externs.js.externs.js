/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {{anotherValue:(*|undefined),someValue:*}}
 */
var OptionalAnyDict;
/**
 * @typedef {{promise:!Promise<*>,reason:(*|undefined),bubbles:(!boolean|undefined),cancelable:(!boolean|undefined),composed:(!boolean|undefined)}}
 */
var PromiseRejectionEventInit;
/**
 * @typedef {{contentType:!string}}
 */
var txAuthGenericArg;
/**
 * @typedef {{bubbles:(!boolean|undefined),cancelable:(!boolean|undefined),composed:(!boolean|undefined)}}
 */
var EventInit;
/**
 * @typedef {{elapsedTime:(!number|undefined),propertyName:(!string|undefined),pseudoElement:(!string|undefined),bubbles:(!boolean|undefined),cancelable:(!boolean|undefined),composed:(!boolean|undefined)}}
 */
var TransitionEventInit;
/**
 * @typedef {{someValue:*}}
 */
var RequiredAnyDict;
/**
 * @typedef {{key:(?string|undefined),newValue:(?string|undefined),oldValue:(?string|undefined),storageArea:(?Storage|undefined),url:(!string|undefined),bubbles:(!boolean|undefined),cancelable:(!boolean|undefined),composed:(!boolean|undefined)}}
 */
var StorageEventInit;
/**
 * @constructor
 * @private
 */
function Storage() {}
/**
 * @param {!string} key
 * @return {undefined}
 */
Storage.prototype.removeItem = function(key) {}
/**
 * @return {undefined}
 */
Storage.prototype.clear = function() {}
/**
 * @param {!string} key
 * @return {?string}
 */
Storage.prototype.getItem = function(key) {}
/**
 * @param {!string} key
 * @param {!string} value
 * @return {undefined}
 */
Storage.prototype.setItem = function(key,value) {}
/**
 * @param {!number} index
 * @return {?string}
 */
Storage.prototype.key = function(index) {}
