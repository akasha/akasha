/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {!Window}
 */
var WindowProxy;
/**
 * @typedef {(!WorkerNavigator|!Navigator)}
 */
var WorkerNavigatorOrNavigatorUnion;
/**
 * @typedef {(!AudioNode|undefined)}
 */
var AudioNodeOrUndefinedUnion;
/**
 * @typedef {(!WorkerGlobalScope|!Window)}
 */
var WorkerGlobalScopeOrWindowUnion;
/**
 * @typedef {(!Document|!Window)}
 */
var DocumentOrWindowUnion;
/**
 * @typedef {(!WorkerLocation|!Location)}
 */
var WorkerLocationOrLocationUnion;
/**
 * @typedef {(!ExtendableMessageEventHandler|!MessageEventHandler)}
 */
var ExtendableMessageEventHandlerOrMessageEventHandlerUnion;
/**
 * @typedef {function(!ExtendableMessageEvent): undefined}
 */
var ExtendableMessageEventHandler;
/**
 * @typedef {function(!MessageEvent): undefined}
 */
var MessageEventHandler;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Window() {}
/** @type {!Location} */ Window.prototype.location;
/** @type {!Navigator} */ Window.prototype.navigator;
/** @type {!WindowProxy} */ Window.prototype.self;
/** @type {?MessageEventHandler} */ Window.prototype.onmessage;
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
function Navigator() {}
/**
 * @constructor
 * @private
 * @extends {WorkerGlobalScope}
 * @nosideeffects
 */
function ServiceWorkerGlobalScope() {}
/** @type {?ExtendableMessageEventHandler} */ ServiceWorkerGlobalScope.prototype.onmessage;
/**
 * @constructor
 * @private
 * @extends {WorkerGlobalScope}
 * @nosideeffects
 */
function SharedWorkerGlobalScope() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Document() {}
/**
 * @param {(!string|!string)=} arg0
 * @param {!string=} arg1
 * @param {!string=} arg2
 * @return {DocumentOrWindowProxyUnion}
 */
Document.prototype.open = function(arg0,arg1,arg2) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function WorkerLocation() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function WorkerNavigator() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function WorkerGlobalScope() {}
/** @type {!WorkerLocation} */ WorkerGlobalScope.prototype.location;
/** @type {!WorkerNavigator} */ WorkerGlobalScope.prototype.navigator;
/** @type {!WorkerGlobalScope} */ WorkerGlobalScope.prototype.self;
/**
 * @constructor
 * @private
 * @extends {Event}
 * @nosideeffects
 */
function ExtendableMessageEvent() {}
/**
 * @constructor
 * @private
 * @extends {WorkerGlobalScope}
 * @nosideeffects
 */
function DedicatedWorkerGlobalScope() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AudioParam() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Event() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function AudioNode() {}
/**
 * @param {(!AudioNode|!AudioParam)} arg0
 * @param {!number=} arg1
 * @param {!number=} arg2
 * @return {AudioNodeOrUndefinedUnion}
 */
AudioNode.prototype.connect = function(arg0,arg1,arg2) {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Location() {}
/** @type {MessageEventHandlerOrExtendableMessageEventHandlerUnion} */ var onmessage;
/** @type {NavigatorOrWorkerNavigatorUnion} */ var navigator;
/** @type {WindowProxyOrWorkerGlobalScopeUnion} */ var self;
/** @type {LocationOrWorkerLocationUnion} */ var location;
/**
 * @typedef {(?MessageEventHandler|?ExtendableMessageEventHandler)}
 */
var MessageEventHandlerOrExtendableMessageEventHandlerUnion;
/**
 * @typedef {(!Document|?WindowProxy)}
 */
var DocumentOrWindowProxyUnion;
/**
 * @typedef {(!WindowProxy|!WorkerGlobalScope)}
 */
var WindowProxyOrWorkerGlobalScopeUnion;
/**
 * @typedef {(!Location|!WorkerLocation)}
 */
var LocationOrWorkerLocationUnion;
/**
 * @typedef {(!Navigator|!WorkerNavigator)}
 */
var NavigatorOrWorkerNavigatorUnion;
