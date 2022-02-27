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
 * @nosideeffects
 */
function AnonymousNamedAccessorsOctet() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function MyThingCollection() {}
/**
 * @constructor
 * @private
 * @implements {Iterable<!Array<!number|!string>>}
 * @nosideeffects
 */
function DOMTokenList() {}
/**
 * @return {!Iterator<!number>}
 * @nosideeffects
 */
DOMTokenList.prototype.keys = function() {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
DOMTokenList.prototype.values = function() {}
/**
 * @return {!Iterator<!Array<!number|!string>>}
 * @nosideeffects
 */
DOMTokenList.prototype.entries = function() {};
/**
 * @return {!Iterator<!Array<!number|!string>>}
 * @nosideeffects
 */
DOMTokenList.prototype[Symbol.iterator] = function() {};
/**
 * @param {function(!string, !number, MAP)} callback
 * @this {MAP}
 * @template MAP
 */
DOMTokenList.prototype.forEach = function(callback) {};
/**
 * @constructor
 * @private
 * @implements {Iterable<!Array<!string|!string>>}
 * @nosideeffects
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
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
Headers.prototype.keys = function() {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
Headers.prototype.values = function() {}
/**
 * @return {!Iterator<!Array<!string|!string>>}
 * @nosideeffects
 */
Headers.prototype.entries = function() {};
/**
 * @return {!Iterator<!Array<!string|!string>>}
 * @nosideeffects
 */
Headers.prototype[Symbol.iterator] = function() {};
/**
 * @param {function(!string, !string, MAP)} callback
 * @this {MAP}
 * @template MAP
 */
Headers.prototype.forEach = function(callback) {};
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function SomeReadOnlySetLike() {}
/** @const {number} */ SomeReadOnlySetLike.prototype.size;
/**
 * @param {!string} value
 * @return {!boolean}
 * @nosideeffects
 */
SomeReadOnlySetLike.prototype.has = function(value) {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
SomeReadOnlySetLike.prototype.keys = function() {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
SomeReadOnlySetLike.prototype.values = function() {}
/**
 * @return {!Iterator<!Array<!string|!string>>}
 * @nosideeffects
 */
SomeReadOnlySetLike.prototype.entries = function() {};
/**
 * @return {!Iterator<!Array<!string|!string>>}
 * @nosideeffects
 */
SomeReadOnlySetLike.prototype[Symbol.iterator] = function() {};
/**
 * @param {function(!string, !string, MAP)} callback
 * @this {MAP}
 * @template MAP
 */
SomeReadOnlySetLike.prototype.forEach = function(callback) {};
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function VarargsType() {}
/**
 * @param {!Array<!string>} tokens
 * @return {undefined}
 */
VarargsType.prototype.myOperation2 = function(tokens) {}
/**
 * @param {!Array<!string>} tokens
 * @return {undefined}
 */
VarargsType.myOperation1 = function(tokens) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousNamedAccessorsFloat() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function MyThing() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function DOMStringMap() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsUnsignedShort() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsByte() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousNamedAccessorsLongLong() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousNamedAccessorsUnsignedLong() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsLongLong() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousNamedAccessorsLong() {}
/**
 * @constructor
 * @extends {Event}
 * @param {!string} type
 */
function SpeechRecognitionErrorEvent(type) {}
/** @type {!string} */ SpeechRecognitionErrorEvent.prototype.message;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsUnsignedLong() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousNamedAccessorsUnrestrictedFloat() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsUnsignedLongLong() {}
/**
 * @constructor
 */
function EventTarget() {}
/**
 * @param {!Event} event
 * @return {!boolean}
 */
EventTarget.prototype.dispatchEvent = function(event) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsShort() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousNamedAccessorsBoolean() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsFloat() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousNamedAccessorsUnsignedShort() {}
/**
 * @constructor
 * @private
 * @implements {Iterable<!Array<!number|!number>>}
 * @nosideeffects
 */
function SomeOtherType() {}
/** @const {number} */ SomeOtherType.prototype.size;
/**
 * @param {!number} key
 * @return {!boolean}
 * @nosideeffects
 */
SomeOtherType.prototype.has = function(key) {}
/**
 * @param {!number} key
 * @return {?number}
 * @nosideeffects
 */
SomeOtherType.prototype.get = function(key) {}
/**
 * @return {!Iterator<!number>}
 * @nosideeffects
 */
SomeOtherType.prototype.keys = function() {}
/**
 * @return {!Iterator<!number>}
 * @nosideeffects
 */
SomeOtherType.prototype.values = function() {}
/**
 * @return {!Iterator<!Array<!number|!number>>}
 * @nosideeffects
 */
SomeOtherType.prototype.entries = function() {};
/**
 * @return {!Iterator<!Array<!number|!number>>}
 * @nosideeffects
 */
SomeOtherType.prototype[Symbol.iterator] = function() {};
/**
 * @param {function(!number, !number, MAP)} callback
 * @this {MAP}
 * @template MAP
 */
SomeOtherType.prototype.forEach = function(callback) {};
/**
 * @param {!number} key
 * @param {!number} value
 * @return {undefined}
 */
SomeOtherType.prototype.set = function(key,value) {}
/**
 * @param {!number} key
 * @return {!boolean}
 */
SomeOtherType.prototype.delete = function(key) {}
/**
 * @return {undefined}
 */
SomeOtherType.prototype.clear = function() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsLong() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousNamedAccessorsUnsignedLongLong() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousNamedAccessorsByte() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function SomeWriteSetLike() {}
/** @const {number} */ SomeWriteSetLike.prototype.size;
/**
 * @param {!string} value
 * @return {!boolean}
 * @nosideeffects
 */
SomeWriteSetLike.prototype.has = function(value) {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
SomeWriteSetLike.prototype.keys = function() {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
SomeWriteSetLike.prototype.values = function() {}
/**
 * @return {!Iterator<!Array<!string|!string>>}
 * @nosideeffects
 */
SomeWriteSetLike.prototype.entries = function() {};
/**
 * @return {!Iterator<!Array<!string|!string>>}
 * @nosideeffects
 */
SomeWriteSetLike.prototype[Symbol.iterator] = function() {};
/**
 * @param {function(!string, !string, MAP)} callback
 * @this {MAP}
 * @template MAP
 */
SomeWriteSetLike.prototype.forEach = function(callback) {};
/**
 * @param {!string} value
 * @return {undefined}
 */
SomeWriteSetLike.prototype.add = function(value) {}
/**
 * @param {!string} value
 * @return {!boolean}
 */
SomeWriteSetLike.prototype.delete = function(value) {}
/**
 * @return {undefined}
 */
SomeWriteSetLike.prototype.clear = function() {}
/**
 * @constructor
 * @private
 * @implements {Iterable<!Array<!string|!number>>}
 * @nosideeffects
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
/** @const {number} */ SomeMapLikeDefiningOverrides.prototype.size;
/**
 * @param {!string} key
 * @return {!boolean}
 * @nosideeffects
 */
SomeMapLikeDefiningOverrides.prototype.has = function(key) {}
/**
 * @param {!string} key
 * @return {?number}
 * @nosideeffects
 */
SomeMapLikeDefiningOverrides.prototype.get = function(key) {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
SomeMapLikeDefiningOverrides.prototype.keys = function() {}
/**
 * @return {!Iterator<!number>}
 * @nosideeffects
 */
SomeMapLikeDefiningOverrides.prototype.values = function() {}
/**
 * @return {!Iterator<!Array<!string|!number>>}
 * @nosideeffects
 */
SomeMapLikeDefiningOverrides.prototype.entries = function() {};
/**
 * @return {!Iterator<!Array<!string|!number>>}
 * @nosideeffects
 */
SomeMapLikeDefiningOverrides.prototype[Symbol.iterator] = function() {};
/**
 * @param {function(!number, !string, MAP)} callback
 * @this {MAP}
 * @template MAP
 */
SomeMapLikeDefiningOverrides.prototype.forEach = function(callback) {};
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function txStorage() {}
/** @type {!number} */ txStorage.prototype.length;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Storage() {}
/** @type {!number} */ Storage.prototype.length;
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
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsUnrestrictedFloat() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsBoolean() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousNamedAccessorsShort() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AnonymousIndexedAccessorsOctet() {}
/**
 * @constructor
 * @param {!string} type
 * @param {!EventInit=} eventInitDict
 */
function Event(type,eventInitDict) {}
/** @const {!number} */ Event.AT_TARGET;
/** @const {!number} */ Event.prototype.AT_TARGET;
/** @const {!number} */ Event.BUBBLING_PHASE;
/** @const {!number} */ Event.prototype.BUBBLING_PHASE;
/** @const {!number} */ Event.CAPTURING_PHASE;
/** @const {!number} */ Event.prototype.CAPTURING_PHASE;
/** @const {!number} */ Event.NONE;
/** @const {!number} */ Event.prototype.NONE;
/** @type {!boolean} */ Event.prototype.bubbles;
/** @type {!boolean} */ Event.prototype.cancelable;
/** @type {!boolean} */ Event.prototype.composed;
/** @type {?EventTarget} */ Event.prototype.currentTarget;
/** @type {!boolean} */ Event.prototype.defaultPrevented;
/** @type {!number} */ Event.prototype.eventPhase;
/** @type {!boolean} */ Event.prototype.isTrusted;
/** @type {*} */ Event.prototype.readonlyAny;
/** @type {?EventTarget} */ Event.prototype.srcElement;
/** @type {?EventTarget} */ Event.prototype.target;
/** @type {!string} */ Event.prototype.type;
/** @type {!boolean} */ Event.prototype.cancelBubble;
/** @type {*} */ Event.prototype.mutableAny;
/** @type {!boolean} */ Event.prototype.returnValue;
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
 * @implements {Iterable<!Array<!string|!Object>>}
 * @nosideeffects
 */
function RTCStatsReport() {}
/** @const {number} */ RTCStatsReport.prototype.size;
/**
 * @param {!string} key
 * @return {!boolean}
 * @nosideeffects
 */
RTCStatsReport.prototype.has = function(key) {}
/**
 * @param {!string} key
 * @return {?Object}
 * @nosideeffects
 */
RTCStatsReport.prototype.get = function(key) {}
/**
 * @return {!Iterator<!string>}
 * @nosideeffects
 */
RTCStatsReport.prototype.keys = function() {}
/**
 * @return {!Iterator<!Object>}
 * @nosideeffects
 */
RTCStatsReport.prototype.values = function() {}
/**
 * @return {!Iterator<!Array<!string|!Object>>}
 * @nosideeffects
 */
RTCStatsReport.prototype.entries = function() {};
/**
 * @return {!Iterator<!Array<!string|!Object>>}
 * @nosideeffects
 */
RTCStatsReport.prototype[Symbol.iterator] = function() {};
/**
 * @param {function(!Object, !string, MAP)} callback
 * @this {MAP}
 * @template MAP
 */
RTCStatsReport.prototype.forEach = function(callback) {};
