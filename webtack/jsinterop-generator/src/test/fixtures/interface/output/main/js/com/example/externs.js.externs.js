/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {{bubbles:(!boolean|undefined),cancelable:(!boolean|undefined),composed:(!boolean|undefined)}}
 */
var EventInit;
/**
 * @constructor
 * @private
 */
function MyThingCollection() {}
/**
 * @constructor
 * @private
 */
function DOMTokenList() {}
/**
 * @constructor
 * @private
 */
function SomeOtherType() {}
/**
 * @constructor
 * @private
 */
function Headers() {}
/**
 * @param {!string} name
 * @param {!string} value
 * @return {undefined}
 */
Headers.prototype.set = function(name,value) {}
/**
 * @param {!string} name
 * @return {?string}
 */
Headers.prototype.get = function(name) {}
/**
 * @param {!string} name
 * @return {!boolean}
 */
Headers.prototype.has = function(name) {}
/**
 * @param {!string} name
 * @return {undefined}
 */
Headers.prototype.delete = function(name) {}
/**
 * @param {!string} name
 * @param {!string} value
 * @return {undefined}
 */
Headers.prototype.append = function(name,value) {}
/**
 * @constructor
 * @private
 */
function MyThing() {}
/**
 * @constructor
 * @private
 */
function DOMStringMap() {}
/**
 * @constructor
 * @private
 */
function SomeMapLikeDefiningOverrides() {}
/**
 * @param {!string} key
 * @param {!number} value
 * @return {undefined}
 */
SomeMapLikeDefiningOverrides.prototype.set = function(key,value) {}
/**
 * @return {undefined}
 */
SomeMapLikeDefiningOverrides.prototype.clear = function() {}
/**
 * @param {!string} key
 * @return {!boolean}
 */
SomeMapLikeDefiningOverrides.prototype.delete = function(key) {}
/**
 * @constructor
 * @private
 */
function txStorage() {}
/**
 * @constructor
 * @private
 */
function Storage() {}
/**
 * @param {!string} key
 * @return {undefined}
 */
Storage.prototype.removeItem = function(key) {}
/**
 * @return {undefined}
 */
Storage.prototype.clear = function() {}
/**
 * @param {!string} key
 * @return {?string}
 */
Storage.prototype.getItem = function(key) {}
/**
 * @param {!string} key
 * @param {!string} value
 * @return {undefined}
 */
Storage.prototype.setItem = function(key,value) {}
/**
 * @param {!number} index
 * @return {?string}
 */
Storage.prototype.key = function(index) {}
/**
 * @constructor
 * @extends {Event}
 * @param {!string} type
 */
function SpeechRecognitionErrorEvent(type) {}
/**
 * @return {!string}
 */
SpeechRecognitionErrorEvent.prototype.messageDescription = function() {}
/**
 * @constructor
 * @param {!string} type
 * @param {!EventInit=} eventInitDict
 */
function Event(type,eventInitDict) {}
/** @const {!number} */ Event.AT_TARGET;
/** @const {!number} */ Event.BUBBLING_PHASE;
/** @const {!number} */ Event.CAPTURING_PHASE;
/** @const {!number} */ Event.NONE;
/**
 * @return {undefined}
 */
Event.prototype.stopImmediatePropagation = function() {}
/**
 * @return {!Array<!EventTarget>}
 */
Event.prototype.composedPath = function() {}
/**
 * @param {*} value
 * @return {undefined}
 */
Event.prototype.anyParameter = function(value) {}
/**
 * @return {*}
 */
Event.prototype.anyReturning = function() {}
/**
 * @return {undefined}
 */
Event.prototype.stopPropagation = function() {}
/**
 * @param {!string} type
 * @param {!boolean=} bubbles
 * @param {!boolean=} cancelable
 * @return {undefined}
 */
Event.prototype.initEvent = function(type,bubbles,cancelable) {}
/**
 * @return {!Promise<*>}
 */
Event.prototype.anyInReturnedPromise = function() {}
/**
 * @return {undefined}
 */
Event.prototype.preventDefault = function() {}
/**
 * @constructor
 * @private
 */
function RTCStatsReport() {}
/**
 * @constructor
 */
function EventTarget() {}
/**
 * @param {!Event} event
 * @return {!boolean}
 */
EventTarget.prototype.dispatchEvent = function(event) {}
