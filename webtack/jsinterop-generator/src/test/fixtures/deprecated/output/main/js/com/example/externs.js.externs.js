/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {function(!Event): undefined}
 */
var MyEventHandler;
/**
 * @interface
 */
function () {}
/**
 * @param {!Event} event
 * @return {undefined}
 */
OtherEventListener.prototype.handleEvent = function(event) {}
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
 * @extends {EventTarget}
 * @private
 */
function Window() {}
/**
 * @constructor
 * @private
 */
function Event() {}
/**
 * @constructor
 * @private
 */
function OtherType() {}
/**
 * @constructor
 * @private
 */
function EventTarget() {}
/**
 * @param {!string} type
 * @param {?EventListener} callback
 * @param {!(!EventListenerOptions|!boolean)=} options
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
 * @param {!(!AddEventListenerOptions|!boolean)=} options
 * @return {undefined}
 */
EventTarget.prototype.addEventListener = function(type,callback,options) {}
