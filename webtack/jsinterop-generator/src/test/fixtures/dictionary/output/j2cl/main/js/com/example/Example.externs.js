/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {{promise:!Promise<*>,reason:(*|undefined),bubbles:(!boolean|undefined),cancelable:(!boolean|undefined),composed:(!boolean|undefined)}}
 */
var PromiseRejectionEventInit;
/**
 * @typedef {{bubbles:(!boolean|undefined),cancelable:(!boolean|undefined),composed:(!boolean|undefined)}}
 */
var EventInit;
/**
 * @typedef {{colorAttachments:!Array<!GPURenderPassColorAttachment>,occlusionQuerySet:(!GPUQuerySet|undefined)}}
 */
var GPURenderPassDescriptor;
/**
 * @typedef {{elapsedTime:(!number|undefined),propertyName:(!string|undefined),pseudoElement:(!string|undefined),bubbles:(!boolean|undefined),cancelable:(!boolean|undefined),composed:(!boolean|undefined)}}
 */
var TransitionEventInit;
/**
 * @typedef {{anotherValue:(*|undefined),someValue:*}}
 */
var OptionalAnyDict;
/**
 * @record
 */
var RTCOfferAnswerOptions;
/**
 * @typedef {{r:!number,g:!number,b:!number,a:!number}}
 */
var GPUColorDict;
/**
 * @typedef {{iceRestart:(!boolean|undefined)}}
 */
var RTCOfferOptions;
/**
 * @typedef {{contentType:!string}}
 */
var txAuthGenericArg;
/**
 * @record
 */
var GPURenderPassColorAttachment;
/**
 * @typedef {{done:(!boolean|undefined),value:(!ArrayBufferViewOrUndefinedUnion|undefined)}}
 */
var ReadableStreamBYOBReadResult;
/**
 * @typedef {{someValue:*}}
 */
var RequiredAnyDict;
/**
 * @typedef {{key:(?string|undefined),newValue:(?string|undefined),oldValue:(?string|undefined),storageArea:(?Storage|undefined),url:(!string|undefined),bubbles:(!boolean|undefined),cancelable:(!boolean|undefined),composed:(!boolean|undefined)}}
 */
var StorageEventInit;
/**
 * @record
 */
var RTCAnswerOptions;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Storage() {}
/** @type {!number} */ Storage.prototype.length;
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
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function GPUQuerySet() {}
/**
 * @typedef {(!ArrayBufferView|undefined)}
 */
var ArrayBufferViewOrUndefinedUnion;
