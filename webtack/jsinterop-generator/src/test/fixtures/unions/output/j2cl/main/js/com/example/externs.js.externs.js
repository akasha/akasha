/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {(!string|!number)}
 */
var BluetoothDescriptorUUID;
/**
 * @typedef {(!string|!number)}
 */
var BluetoothServiceUUID;
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
 * @typedef {{capture:(!boolean|undefined)}}
 */
var EventListenerOptions;
/**
 * @typedef {{dataPrefix:!MyNamedBufferSource,mask:(!MyNamedBufferSource|undefined)}}
 */
var BluetoothDataFilterInit2;
/**
 * @typedef {{allowedServices:(!string|!Array<!string>),otherServices:(!string|!Array<!string>|undefined),requiredUuids:!Array<(!string|!number)>,uuids:(!Array<(!string|!number)>|undefined)}}
 */
var AllowedBluetoothDevice;
/**
 * @typedef {{dataPrefix:!BufferSource,mask:(!BufferSource|undefined)}}
 */
var BluetoothDataFilterInit;
/**
 * @constructor
 * @private
 * @extends {EventTarget}
 * @nosideeffects
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
 * @nosideeffects
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
 * @extends {EventTarget}
 * @nosideeffects
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
 * @nosideeffects
 */
function Event() {}
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
 * @nosideeffects
 */
function EventTarget() {}
/**
 * @param {!string} type
 * @param {(!EventListenerOptions|!boolean)=} options
 * @return {undefined}
 */
EventTarget.prototype.removeEventListener = function(type,options) {}
