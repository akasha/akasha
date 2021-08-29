/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {!Window}
 */
var WindowProxy;
/**
 * @typedef {(!AudioNode|undefined)}
 */
var AudioNodeOrUndefinedUnion;
/**
 * @typedef {(!Document|!Window)}
 */
var DocumentOrWindowUnion;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function Window() {}
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
function AudioNode() {}
/**
 * @param {(!AudioNode|!AudioParam)} arg0
 * @param {!number=} arg1
 * @param {!number=} arg2
 * @return {AudioNodeOrUndefinedUnion}
 */
AudioNode.prototype.connect = function(arg0,arg1,arg2) {}
/**
 * @typedef {(!Document|?WindowProxy)}
 */
var DocumentOrWindowProxyUnion;
