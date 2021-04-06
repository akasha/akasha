/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {(!Int8Array|!Int16Array|!Int32Array|!Uint8Array|!Uint16Array|!Uint32Array|!Uint8ClampedArray|!Float32Array|!Float64Array|!DataView)}
 */
var ArrayBufferView;
/**
 * @typedef {(!string|!number)}
 */
var BluetoothDescriptorUUID;
/**
 * @typedef {(!string|!number)}
 */
var BluetoothServiceUUID;
/**
 * @typedef {(!ArrayBufferView|!ArrayBuffer)}
 */
var BufferSource;
/**
 * @typedef {!BufferSource}
 */
var MyNamedBufferSource;
/**
 * @typedef {(!string|!number)}
 */
var txCode;
/**
 * @typedef {(!string|!number)}
 */
var BluetoothCharacteristicUUID;
/**
 * @typedef {function(!BufferSource=): undefined}
 */
var OnBufferSourceHandler;
/**
 * @typedef {function((!Event|!string),!string=,!number=,!number=,*=): *}
 */
var OnErrorEventHandler;
/**
 * @interface
 */
function EventListener2() {}
/**
 * @param {(!string|!number)} event
 * @return {undefined}
 */
EventListener2.prototype.handleUuid = function(event) {}
/**
 * @interface
 */
function EventListener3() {}
/**
 * @param {!BluetoothServiceUUID} event
 * @return {undefined}
 */
EventListener3.prototype.handleServiceUuid = function(event) {}
/**
 * @constructor
 * @extends {EventTarget}
 * @private
 */
function BluetoothRemoteGATTService() {}
/**
 * @param {!BluetoothServiceUUID} service
 * @return {!Promise<!BluetoothRemoteGATTService>}
 */
BluetoothRemoteGATTService.prototype.getIncludedService = function(service) {}
/**
 * @param {!BluetoothServiceUUID=} service
 * @return {!Promise<!Array<!BluetoothRemoteGATTService>>}
 */
BluetoothRemoteGATTService.prototype.getIncludedServices = function(service) {}
/**
 * @constructor
 * @private
 */
function Int8Array() {}
/**
 * @constructor
 * @private
 */
function Int16Array() {}
/**
 * @constructor
 * @private
 */
function Uint16Array() {}
/**
 * @constructor
 * @private
 */
function BluetoothRemoteGATTServer() {}
/**
 * @param {!BluetoothServiceUUID=} service
 * @return {!Promise<!Array<!BluetoothRemoteGATTService>>}
 */
BluetoothRemoteGATTServer.prototype.getPrimaryServices = function(service) {}
/**
 * @param {!BluetoothServiceUUID} service
 * @return {!Promise<!BluetoothRemoteGATTService>}
 */
BluetoothRemoteGATTServer.prototype.getPrimaryService = function(service) {}
/**
 * @constructor
 * @param {(!string|!number)} serviceUuid
 */
function SomeInterface(serviceUuid) {}
/**
 * @return {(!string|!number)}
 */
SomeInterface.myStaticMethodWithUnionReturn = function() {}
/**
 * @return {(!string|!number)}
 */
SomeInterface.prototype.getUuid = function() {}
/**
 * @param {(!string|!number)} serviceUuid
 * @return {undefined}
 */
SomeInterface.myStaticMethodWithUnionArg = function(serviceUuid) {}
/**
 * @constructor
 * @param {!BufferSource} data
 */
function SomeDataContainer(data) {}
/**
 * @return {!BluetoothDescriptorUUID}
 */
SomeDataContainer.myStaticMethodWithUnionReturn = function() {}
/**
 * @param {!BluetoothDescriptorUUID} name
 * @return {undefined}
 */
SomeDataContainer.myStaticMethodWithUnionArg = function(name) {}
/**
 * @constructor
 * @private
 */
function Float32Array() {}
/**
 * @constructor
 * @extends {EventTarget}
 * @private
 */
function BluetoothRemoteGATTCharacteristic() {}
/**
 * @param {!BufferSource} value
 * @return {!Promise<undefined>}
 */
BluetoothRemoteGATTCharacteristic.prototype.writeValueWithoutResponse = function(value) {}
/**
 * @param {!BufferSource} value
 * @return {!Promise<undefined>}
 */
BluetoothRemoteGATTCharacteristic.prototype.writeValueWithResponse = function(value) {}
/**
 * @param {!BufferSource} value
 * @return {!Promise<undefined>}
 */
BluetoothRemoteGATTCharacteristic.prototype.writeValue = function(value) {}
/**
 * @constructor
 * @private
 */
function Float64Array() {}
/**
 * @constructor
 * @private
 */
function DataView() {}
/**
 * @constructor
 * @private
 */
function Int32Array() {}
/**
 * @constructor
 * @private
 */
function Uint32Array() {}
/**
 * @constructor
 * @private
 */
function Event() {}
/**
 * @constructor
 * @private
 */
function ArrayBuffer() {}
/**
 * @constructor
 * @param {!BluetoothServiceUUID=} service
 */
function SomeServiceContainer(service) {}
/**
 * @return {?BluetoothDescriptorUUID}
 */
SomeServiceContainer.myStaticMethodWithUnionReturn = function() {}
/**
 * @param {!BluetoothDescriptorUUID=} name
 * @return {undefined}
 */
SomeServiceContainer.myStaticMethodWithUnionArg = function(name) {}
/**
 * @constructor
 * @private
 */
function Uint8Array() {}
/**
 * @constructor
 * @private
 */
function EventTarget() {}
/**
 * @param {!string} type
 * @param {(!EventListenerOptions|!boolean)=} options
 * @return {undefined}
 */
EventTarget.prototype.removeEventListener = function(type,options) {}
/**
 * @constructor
 * @private
 */
function Uint8ClampedArray() {}
