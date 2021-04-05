/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {function(!Event): undefined}
 */
var EventHandler;
/**
 * @typedef {function(!SpeechSynthesisEvent): undefined}
 */
var SpeechSynthesisEventHandler;
/**
 * @constructor
 */
function SpeechSynthesisEventListener() {};
/**
 * @param {!SpeechSynthesisEvent} event
 * @return {undefined}
 */
SpeechSynthesisEventListener.prototype.handleEvent = function(event) {};
/**
 * @constructor
 */
function EventListener() {};
/**
 * @param {!Event} event
 * @return {undefined}
 */
EventListener.prototype.handleEvent = function(event) {};
