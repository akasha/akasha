/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {{transfer:(!Array<!Object>|undefined)}}
 */
var PostMessageOptions;
/**
 * @constructor
 * @private
 */
function MessagePort() {}
/**
 * @param {*} message
 * @param {!Array<!Object>} transfer
 * @return {undefined}
 */
MessagePort.prototype.postMessage = function(message,transfer) {}
/**
 * @return {undefined}
 */
MessagePort.prototype.start = function() {}
/**
 * @return {undefined}
 */
MessagePort.prototype.close = function() {}
/**
 * @constructor
 * @private
 */
function ImageBitmap() {}
/**
 * @return {undefined}
 */
ImageBitmap.prototype.close = function() {}
