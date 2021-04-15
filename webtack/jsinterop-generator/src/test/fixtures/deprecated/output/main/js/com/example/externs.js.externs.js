/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {(!string|!number)}
 */
var MyTypedefedUnion;
/**
 * @typedef {function(!Event): undefined}
 */
var MyEventHandler;
/**
 * @interface
 */
function OtherEventListener() {}
/**
 * @param {!Event} event
 * @return {undefined}
 */
OtherEventListener.prototype.handleEvent = function(event) {}
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
 * @typedef {{bubbles:(!boolean|undefined)}}
 */
var EventInit;
/**
 * @const
 */
var CSS;
/**
 * @param {!string} ident
 * @return {!string}
 */
CSS.escape = function(ident) {}
/**
 * @constructor
 * @extends {EventTarget}
 * @private
 */
function Window() {}
/** @type {!boolean} */ Window.prototype.isSecureContext;
/** @type {!string} */ Window.prototype.name;
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
/** @type {!boolean} */ var isSecureContext;
/** @type {!string} */ var name;
