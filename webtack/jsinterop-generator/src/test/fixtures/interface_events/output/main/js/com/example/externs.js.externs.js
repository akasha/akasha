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
 * @interface
 */
function () {}
/**
 * @param {!SpeechSynthesisEvent} event
 * @return {undefined}
 */
SpeechSynthesisEventListener.prototype.handleEvent = function(event) {}
/**
 * @interface
 */
function () {}
/**
 * @param {!Event} event
 * @return {undefined}
 */
EventListener.prototype.handleEvent = function(event) {}
/**
 * @constructor
 * @extends {Event}
 * @private
 */
function SpeechSynthesisEvent() {}
/**
 * @constructor
 * @extends {SpeechSynthesisEvent}
 * @private
 */
function SpeechSynthesisErrorEvent() {}
/**
 * @constructor
 * @private
 */
function Event() {}
/**
 * @constructor
 * @extends {EventTarget}
 * @private
 */
function SpeechSynthesisUtterance() {}
/**
 * @constructor
 */
function EventTarget() {}
/**
 * @param {!string} type
 * @param {?EventListener} callback
 * @param {!(EventListenerOptions|boolean)=} options
 * @return {undefined}
 */
EventTarget.prototype.removeEventListener = function(type,callback,options) {}
/**
 * @param {!Event} event
 * @return {!boolean}
 */
EventTarget.prototype.dispatchEvent = function(event) {}
/**
 * @param {!string} type
 * @param {?EventListener} callback
 * @param {!(AddEventListenerOptions|boolean)=} options
 * @return {undefined}
 */
EventTarget.prototype.addEventListener = function(type,callback,options) {}
