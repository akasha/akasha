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
 * @typedef {{capture:(!boolean|undefined)}}
 */
var EventListenerOptions;
/**
 * @typedef {{left:(!number|undefined),top:(!number|undefined)}}
 */
var ScrollToOptions;
/**
 * @typedef {{once:(!boolean|undefined),passive:(!boolean|undefined),capture:(!boolean|undefined)}}
 */
var AddEventListenerOptions;
/**
 * @constructor
 * @private
 * @extends {EventTarget}
 * @nosideeffects
 */
function Window() {}
/** @type {!boolean} */ Window.prototype.closed;
/** @type {!boolean} */ Window.prototype.isSecureContext;
/** @type {!string} */ Window.prototype.name;
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
 * @nosideeffects
 */
function Event() {}
/**
 * @constructor
 * @private
 * @extends {Event}
 * @nosideeffects
 */
function FocusEvent() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function EventTarget() {}
/** @type {!boolean} */ EventTarget.prototype.open;
/** @type {!string} */ EventTarget.prototype.id;
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
/** @type {!string} */ var name;
/** @type {!boolean} */ var closed;
/** @type {!boolean} */ var isSecureContext;
/**
 * @param {!string} name
 * @return {!Object}
 */
function get(name) {}
/**
 * @param {(!number|!ScrollToOptions)=} arg0
 * @param {!number=} arg1
 * @return {undefined}
 */
function scroll(arg0,arg1) {}
