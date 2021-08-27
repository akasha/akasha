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
 * @typedef {function(!MessageEvent): undefined}
 */
var MessageEventHandler;
/**
 * @constructor
 * @private
 * @extends {EventTarget}
 * @nosideeffects
 */
function Window() {}
/** @type {!string} */ Window.prototype.windowAttribute;
/** @type {!NullableEventHandler} */ Window.prototype.onmessageerror;
/** @type {?EventHandler} */ Window.prototype.onstuff;
/**
 * @param {*} callback
 * @return {!number}
 */
Window.prototype.requestAnimationFrame = function(callback) {}
/**
 * @param {!number} callbackId
 * @return {!number}
 */
Window.prototype.requestAnimationFrame2 = function(callbackId) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function WorkletGlobalScope() {}
/** @type {!string} */ WorkletGlobalScope.prototype.workletGlobalScopeAttribute;
/**
 * @constructor
 * @private
 * @extends {WorkletGlobalScope}
 * @nosideeffects
 */
function AudioWorkletGlobalScope() {}
/** @type {!string} */ AudioWorkletGlobalScope.prototype.audioWorkletGlobalScopeAttribute;
/**
 * @constructor
 * @private
 * @extends {EventTarget}
 * @nosideeffects
 */
function WorkerGlobalScope() {}
/** @type {!string} */ WorkerGlobalScope.prototype.workerGlobalScopeAttribute;
/**
 * @constructor
 * @private
 * @extends {WorkerGlobalScope}
 * @nosideeffects
 */
function DedicatedWorkerGlobalScope() {}
/** @type {!string} */ DedicatedWorkerGlobalScope.prototype.dedicatedWorkerGlobalScopeAttribute;
/**
 * @constructor
 * @private
 * @extends {Event}
 * @nosideeffects
 */
function MessageEvent() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Event() {}
/**
 * @constructor
 * @private
 * @extends {WorkerGlobalScope}
 * @nosideeffects
 */
function ServiceWorkerGlobalScope() {}
/** @type {!string} */ ServiceWorkerGlobalScope.prototype.serviceWorkerGlobalScopeAttribute;
/**
 * @constructor
 * @private
 * @extends {WorkerGlobalScope}
 * @nosideeffects
 */
function SharedWorkerGlobalScope() {}
/** @type {!string} */ SharedWorkerGlobalScope.prototype.sharedWorkerGlobalScopeAttribute;
/** @type {?MessageEventHandler} */ SharedWorkerGlobalScope.prototype.onmessageerror;
/** @type {?EventHandler} */ SharedWorkerGlobalScope.prototype.onstuff;
/**
 * @param {*} callback
 * @return {!number}
 */
SharedWorkerGlobalScope.prototype.requestAnimationFrame = function(callback) {}
/**
 * @param {!string} callbackId
 * @return {!number}
 */
SharedWorkerGlobalScope.prototype.requestAnimationFrame2 = function(callbackId) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function EventTarget() {}
/** @type {NullableEventHandlerOrMessageEventHandlerUnion} */ var onmessageerror;
/** @type {!string} */ var windowAttribute;
/** @type {!string} */ var sharedWorkerGlobalScopeAttribute;
/** @type {?EventHandler} */ var onstuff;
/** @type {!string} */ var workerGlobalScopeAttribute;
/** @type {!string} */ var dedicatedWorkerGlobalScopeAttribute;
/** @type {!string} */ var workletGlobalScopeAttribute;
/** @type {!string} */ var audioWorkletGlobalScopeAttribute;
/** @type {!string} */ var serviceWorkerGlobalScopeAttribute;
/**
 * @param {*} arg0
 * @return {!number}
 */
function requestAnimationFrame(arg0) {}
/**
 * @param {(!number|!string)} arg0
 * @return {!number}
 */
function requestAnimationFrame2(arg0) {}
/**
 * @typedef {(!NullableEventHandler|?MessageEventHandler)}
 */
var NullableEventHandlerOrMessageEventHandlerUnion;
