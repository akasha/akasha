/**
 * @fileoverview
 * @externs
 */
/**
 * @typedef {(!string|!number)}
 */
var BluetoothDescriptorUUID;
/**
 * @typedef {(!number|!string)}
 */
var UnionFloatOrString;
/**
 * @typedef {(!number|!string)}
 */
var UnionUnsignedLongLongOrString;
/**
 * @typedef {(!number|!string)}
 */
var ReadyStateTypeOrString;
/**
 * @typedef {(!number|!string)}
 */
var UnionUnsignedLongOrString;
/**
 * @typedef {(!boolean|!string)}
 */
var UnionBooleanOrString;
/**
 * @typedef {(!Array<!number>|!string)}
 */
var UnionDoubleSequenceOrString;
/**
 * @typedef {(!number|!string)}
 */
var UnionUnrestrictedDoubleOrString;
/**
 * @typedef {!BufferSource}
 */
var MyNamedBufferSource;
/**
 * @typedef {(!MyDictionary|!string)}
 */
var MyDictionaryOrString;
/**
 * @typedef {(!string|!number)}
 */
var PermissionStateOrLong;
/**
 * @typedef {(!Array<!boolean>|!string)}
 */
var UnionBooleanSequenceOrString;
/**
 * @typedef {(!number|!string)}
 */
var UnionShortOrString;
/**
 * @typedef {(!string|!number)}
 */
var BluetoothServiceUUID;
/**
 * @typedef {(!number|!string)}
 */
var UnionUnrestrictedFloatOrString;
/**
 * @typedef {(!number|!string)}
 */
var UnionDoubleOrString;
/**
 * @typedef {(!number|!string)}
 */
var UnionByteOrString;
/**
 * @typedef {(!number|!string)}
 */
var UnionOctetOrString;
/**
 * @typedef {(!number|!string)}
 */
var UnionUnsignedShortOrString;
/**
 * @typedef {(!number|!string)}
 */
var UnionLongOrString;
/**
 * @typedef {(!string|!number)}
 */
var txCode;
/**
 * @typedef {(!string|!number)}
 */
var BluetoothCharacteristicUUID;
/**
 * @typedef {(!number|!string)}
 */
var UnionLongLongOrString;
/**
 * @typedef {(!Object|!string)}
 */
var UnionObjectOrString;
/**
 * @typedef {function(!BufferSource=): undefined}
 */
var OnBufferSourceHandler;
/**
 * @typedef {function(EventOrStringUnion,!string=,!number=,!number=,*=): *}
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
 * @typedef {{name:!string,description:(!string|undefined)}}
 */
var MyDictionary;
/**
 * @typedef {{allowedServices:StringOrStringArrayUnion,otherServices:(!StringOrStringArrayUnion|undefined),requiredUuids:!Array<StringOrLongLongUnion>,uuids:(!Array<StringOrOctetUnion>|undefined)}}
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
 * @return {StringOrUnsignedLongUnion}
 */
SomeInterface.myStaticMethodWithUnionReturn = function() {}
/**
 * @return {StringOrUnsignedLongUnion}
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
 * @private
 * @nosideeffects
 */
function GPUTextureUsage() {}
/** @const {!number} */ GPUTextureUsage.COPY_DST;
/** @const {!number} */ GPUTextureUsage.prototype.COPY_DST;
/** @const {!number} */ GPUTextureUsage.COPY_SRC;
/** @const {!number} */ GPUTextureUsage.prototype.COPY_SRC;
/** @const {!number} */ GPUTextureUsage.RENDER_ATTACHMENT;
/** @const {!number} */ GPUTextureUsage.prototype.RENDER_ATTACHMENT;
/** @const {!number} */ GPUTextureUsage.STORAGE_BINDING;
/** @const {!number} */ GPUTextureUsage.prototype.STORAGE_BINDING;
/** @const {!number} */ GPUTextureUsage.TEXTURE_BINDING;
/** @const {!number} */ GPUTextureUsage.prototype.TEXTURE_BINDING;
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
function XMLHttpRequest() {}
/** @const {!number} */ XMLHttpRequest.DONE;
/** @const {!number} */ XMLHttpRequest.prototype.DONE;
/** @const {!number} */ XMLHttpRequest.HEADERS_RECEIVED;
/** @const {!number} */ XMLHttpRequest.prototype.HEADERS_RECEIVED;
/** @const {!number} */ XMLHttpRequest.LOADING;
/** @const {!number} */ XMLHttpRequest.prototype.LOADING;
/** @const {!number} */ XMLHttpRequest.OPENED;
/** @const {!number} */ XMLHttpRequest.prototype.OPENED;
/** @const {!number} */ XMLHttpRequest.UNSENT;
/** @const {!number} */ XMLHttpRequest.prototype.UNSENT;
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
/**
 * @typedef {(!Event|!string)}
 */
var EventOrStringUnion;
/**
 * @typedef {(!string|!number)}
 */
var StringOrUnsignedLongUnion;
/**
 * @typedef {(!string|!number)}
 */
var StringOrOctetUnion;
/**
 * @typedef {(!string|!Array<!string>)}
 */
var StringOrStringArrayUnion;
/**
 * @typedef {(!string|!number)}
 */
var StringOrLongLongUnion;
