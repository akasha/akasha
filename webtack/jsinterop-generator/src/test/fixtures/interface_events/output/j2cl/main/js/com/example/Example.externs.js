/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {?EventHandler}
 */
var NullableEventHandler;
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
function SpeechSynthesisEventListener() {}
/**
 * @param {!SpeechSynthesisEvent} event
 * @return {undefined}
 */
SpeechSynthesisEventListener.prototype.handleEvent = function(event) {}
/**
 * @interface
 */
function EventListener() {}
/**
 * @param {!Event} event
 * @return {undefined}
 */
EventListener.prototype.handleEvent = function(event) {}
/**
 * @typedef {{capture:(!boolean|undefined)}}
 */
var EventListenerOptions;
/**
 * @typedef {{once:(!boolean|undefined),passive:(!boolean|undefined),capture:(!boolean|undefined)}}
 */
var AddEventListenerOptions;
/**
 * @constructor
 * @private
 * @extends {Event}
 * @nosideeffects
 */
function SpeechSynthesisEvent() {}
/**
 * @constructor
 * @private
 * @extends {SpeechSynthesisEvent}
 * @nosideeffects
 */
function SpeechSynthesisErrorEvent() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Event() {}
/**
 * @constructor
 * @private
 * @extends {EventTarget}
 * @nosideeffects
 */
function SpeechSynthesisUtterance() {}
/** @type {!NullableEventHandler} */ SpeechSynthesisUtterance.prototype.onend;
/** @type {?SpeechSynthesisEventHandler} */ SpeechSynthesisUtterance.prototype.onpause;
/** @type {!NullableEventHandler} */ SpeechSynthesisUtterance.prototype.onresume;
/** @type {?SpeechSynthesisEventHandler} */ SpeechSynthesisUtterance.prototype.onstart;
/**
 * @constructor
 */
function EventTarget() {}
/**
 * @param {!string} type
 * @param {?EventListener} callback
 * @param {(!EventListenerOptions|!boolean)=} options
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
 * @param {(!AddEventListenerOptions|!boolean)=} options
 * @return {undefined}
 */
EventTarget.prototype.addEventListener = function(type,callback,options) {}
