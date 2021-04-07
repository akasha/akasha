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
/** @type {!string} */ WaveShaperNode.prototype.oversample;
/** @type {!string} */ WaveShaperNode.prototype.static_oversample;
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
/** @type {!string} */ PermissionStatus.prototype.state;
