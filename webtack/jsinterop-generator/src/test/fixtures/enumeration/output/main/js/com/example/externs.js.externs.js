/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {function(!string): !string}
 */
var SomeCallbackHandler;
/**
 * @typedef {{oversample:(!string|undefined)}}
 */
var WaveShaperOptions;
/**
 * @typedef {{error:!string}}
 */
var SpeechRecognitionErrorEventInit;
/**
 * @constructor
 * @param {!string} sample
 */
function WaveShaperNode(sample) {}
/**
 * @return {!string}
 */
WaveShaperNode.prototype.getSample = function() {}
/**
 * @param {!string} sample
 * @return {undefined}
 */
WaveShaperNode.prototype.setSample = function(sample) {}
/**
 * @constructor
 * @private
 */
function PermissionStatus() {}
