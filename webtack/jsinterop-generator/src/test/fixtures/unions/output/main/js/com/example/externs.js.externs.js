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
 * @interface
 */
function () {};
/**
 * @param {!(!string|!number)} event
 * @return {undefined}
 */
EventListener2.prototype.handleUuid = function(event) {};
/**
 * @interface
 */
function () {};
/**
 * @param {!BluetoothServiceUUID} event
 * @return {undefined}
 */
EventListener3.prototype.handleServiceUuid = function(event) {};
/**
 * @constructor
 * @extends {EventTarget}
 * @private
 */
function BluetoothRemoteGATTService() {};
/**
 * @param {!BluetoothServiceUUID} service
 * @return {!Promise<!BluetoothRemoteGATTService>}
 */
BluetoothRemoteGATTService.prototype.getIncludedService = function(service) {};
/**
 * @param {!BluetoothServiceUUID=} service
 * @return {!Promise<!Array<!BluetoothRemoteGATTService>>}
 */
BluetoothRemoteGATTService.prototype.getIncludedServices = function(service) {};
/**
 * @constructor
 * @private
 */
function Int8Array() {};
/**
 * @constructor
 * @private
 */
function Int16Array() {};
/**
 * @constructor
 * @private
 */
function Uint16Array() {};
/**
 * @constructor
 * @private
 */
function BluetoothRemoteGATTServer() {};
/**
 * @param {!BluetoothServiceUUID=} service
 * @return {!Promise<!Array<!BluetoothRemoteGATTService>>}
 */
BluetoothRemoteGATTServer.prototype.getPrimaryServices = function(service) {};
/**
 * @param {!BluetoothServiceUUID} service
 * @return {!Promise<!BluetoothRemoteGATTService>}
 */
BluetoothRemoteGATTServer.prototype.getPrimaryService = function(service) {};
/**
 * @constructor
 */
function SomeInterface() {};
/**
 * @return {!(!string|!number)}
 */
SomeInterface.myStaticMethodWithUnionReturn = function() {};
/**
 * @return {!(!string|!number)}
 */
SomeInterface.prototype.getUuid = function() {};
/**
 * @param {!(!string|!number)} serviceUuid
 * @return {undefined}
 */
SomeInterface.myStaticMethodWithUnionArg = function(serviceUuid) {};
/**
 * @constructor
 */
function SomeDataContainer() {};
/**
 * @return {!BluetoothDescriptorUUID}
 */
SomeDataContainer.myStaticMethodWithUnionReturn = function() {};
/**
 * @param {!BluetoothDescriptorUUID} name
 * @return {undefined}
 */
SomeDataContainer.myStaticMethodWithUnionArg = function(name) {};
/**
 * @constructor
 * @private
 */
function Float32Array() {};
/**
 * @constructor
 * @extends {EventTarget}
 * @private
 */
function BluetoothRemoteGATTCharacteristic() {};
/**
 * @param {!BufferSource} value
 * @return {!Promise<undefined>}
 */
BluetoothRemoteGATTCharacteristic.prototype.writeValueWithoutResponse = function(value) {};
/**
 * @param {!BufferSource} value
 * @return {!Promise<undefined>}
 */
BluetoothRemoteGATTCharacteristic.prototype.writeValueWithResponse = function(value) {};
/**
 * @param {!BufferSource} value
 * @return {!Promise<undefined>}
 */
BluetoothRemoteGATTCharacteristic.prototype.writeValue = function(value) {};
/**
 * @constructor
 * @private
 */
function Float64Array() {};
/**
 * @constructor
 * @private
 */
function DataView() {};
/**
 * @constructor
 * @private
 */
function Int32Array() {};
/**
 * @constructor
 * @private
 */
function Uint32Array() {};
/**
 * @constructor
 * @private
 */
function Event() {};
/**
 * @constructor
 * @private
 */
function ArrayBuffer() {};
/**
 * @constructor
 */
function SomeServiceContainer() {};
/**
 * @return {?BluetoothDescriptorUUID}
 */
SomeServiceContainer.myStaticMethodWithUnionReturn = function() {};
/**
 * @param {!BluetoothDescriptorUUID=} name
 * @return {undefined}
 */
SomeServiceContainer.myStaticMethodWithUnionArg = function(name) {};
/**
 * @constructor
 * @private
 */
function Uint8Array() {};
/**
 * @constructor
 * @private
 */
function EventTarget() {};
/**
 * @param {!string} type
 * @param {!(!EventListenerOptions|!boolean)=} options
 * @return {undefined}
 */
EventTarget.prototype.removeEventListener = function(type,options) {};
/**
 * @constructor
 * @private
 */
function Uint8ClampedArray() {};
