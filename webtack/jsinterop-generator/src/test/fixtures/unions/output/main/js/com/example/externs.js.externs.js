/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {function(!BufferSource=): undefined}
 */
var OnBufferSourceHandler;
/**
 * @typedef {function(!(!Event|!string),!string=,!number=,!number=,*=): *}
 */
var OnErrorEventHandler;
/**
 * @constructor
 */
function EventListener2() {};
/**
 * @param {!(!string|!number)} event
 * @return {undefined}
 */
EventListener2.prototype.handleUuid = function(event) {};
/**
 * @constructor
 */
function EventListener3() {};
/**
 * @param {!BluetoothServiceUUID} event
 * @return {undefined}
 */
EventListener3.prototype.handleServiceUuid = function(event) {};
