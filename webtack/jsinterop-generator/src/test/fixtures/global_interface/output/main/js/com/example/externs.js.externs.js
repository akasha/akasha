/**
 * @fileoverview
 * @externs
 */
/**
 * @interface
 */
function FocusEventListener() {}
/**
 * @param {!FocusEvent} event
 * @return {undefined}
 */
FocusEventListener.prototype.handleEvent = function(event) {}
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
 * @constructor
 * @extends {EventTarget}
 * @private
 */
function Window() {}
/**
 * @param {!string} name
 * @return {!Object}
 */
Window.prototype.get = function(name) {}
/**
 * @param {(!number|!ScrollToOptions)=} arg0
 * @param {!number=} arg1
 * @return {undefined}
 */
Window.prototype.scroll = function(arg0,arg1) {}
/**
 * @constructor
 * @private
 */
function Event() {}
/**
 * @constructor
 * @extends {Event}
 * @private
 */
function FocusEvent() {}
/**
 * @constructor
 * @private
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
