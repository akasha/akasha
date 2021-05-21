/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {function(!RTCSessionDescriptionInit): undefined}
 */
var RTCSessionDescriptionCallback;
/**
 * @typedef {function(!DOMException): undefined}
 */
var RTCPeerConnectionErrorCallback;
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function DOMException() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function RTCOfferOptions() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function RTCSessionDescriptionInit() {}
/**
 * @constructor
 * @private
 * @nosideeffects
 */
function RTCPeerConnection() {}
/**
 * @param {(!RTCOfferOptions|!RTCSessionDescriptionCallback)=} arg0
 * @param {!RTCPeerConnectionErrorCallback=} arg1
 * @param {!RTCOfferOptions=} arg2
 * @return {(!Promise<!RTCSessionDescriptionInit>|!Promise<undefined>)}
 */
RTCPeerConnection.prototype.createOffer = function(arg0,arg1,arg2) {}
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
function WindowProxy() {}
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
 * @return {(!Document|?WindowProxy)}
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
 * @return {(!AudioNode|undefined)}
 */
AudioNode.prototype.connect = function(arg0,arg1,arg2) {}
