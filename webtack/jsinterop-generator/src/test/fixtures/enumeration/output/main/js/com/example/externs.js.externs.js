/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {function(!txMode): !SpeechRecognitionErrorCode}
 */
var SomeCallbackHandler;
/**
 * @typedef {{oversample:(!OverSampleType|undefined)}}
 */
var WaveShaperOptions;
/**
 * @typedef {{error:!SpeechRecognitionErrorCode}}
 */
var SpeechRecognitionErrorEventInit;
/**
 * @constructor
 * @param {!OverSampleType} sample
 */
function WaveShaperNode(sample) {}
/**
 * @return {!OverSampleType}
 */
WaveShaperNode.prototype.getSample = function() {}
/**
 * @param {!OverSampleType} sample
 * @return {undefined}
 */
WaveShaperNode.prototype.setSample = function(sample) {}
/**
 * @constructor
 * @private
 */
function PermissionStatus() {}
