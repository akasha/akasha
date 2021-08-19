/**
 * @fileoverview
 * @externs
 */
/**
 * @constructor
 * @private
 * @extends {EventTarget}
 * @nosideeffects
 */
function Window() {}
/** @type {!string} */ Window.prototype.windowAttribute;
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
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function EventTarget() {}
/** @type {!string} */ var windowAttribute;
/** @type {!string} */ var audioWorkletGlobalScopeAttribute;
/** @type {!string} */ var dedicatedWorkerGlobalScopeAttribute;
/** @type {!string} */ var serviceWorkerGlobalScopeAttribute;
/** @type {!string} */ var sharedWorkerGlobalScopeAttribute;
