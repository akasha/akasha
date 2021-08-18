typedef ( Int8Array or Int16Array or Int32Array or Uint8Array or Uint16Array or Uint32Array or Uint8ClampedArray or Float32Array or Float64Array or DataView ) ArrayBufferView;

typedef ( DOMString or unsigned long ) BluetoothCharacteristicUUID;

typedef ( DOMString or unsigned long ) BluetoothDescriptorUUID;

typedef ( DOMString or unsigned long ) BluetoothServiceUUID;

typedef ( ArrayBufferView or ArrayBuffer ) BufferSource;

typedef BufferSource MyNamedBufferSource;

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
typedef ( DOMString or unsigned long ) txCode;

callback OnBufferSourceHandler = undefined ( optional BufferSource buffer );

[LegacyTreatNonObjectAsNull]
callback OnErrorEventHandler = any ( ( Event or DOMString ) event, optional DOMString source, optional unsigned long lineno, optional unsigned long colno, optional any error );

callback interface EventListener2 {
  undefined handleUuid( ( DOMString or unsigned long ) event );
};

callback interface EventListener3 {
  undefined handleServiceUuid( BluetoothServiceUUID event );
};

dictionary AllowedBluetoothDevice {
  required ( DOMString or sequence<DOMString> ) allowedServices;
  ( DOMString or sequence<DOMString> ) otherServices;
  required sequence<( DOMString or long long )> requiredUuids;
  sequence<( DOMString or octet )> uuids;
};

dictionary BluetoothDataFilterInit {
  required BufferSource dataPrefix;
  BufferSource mask;
};

dictionary BluetoothDataFilterInit2 {
  required MyNamedBufferSource dataPrefix;
  MyNamedBufferSource mask;
};

dictionary EventListenerOptions {
  boolean capture = false;
};

interface ArrayBuffer {
};

[SecureContext]
interface BluetoothRemoteGATTCharacteristic : EventTarget {
  Promise<undefined> writeValue( BufferSource value );
  Promise<undefined> writeValueWithResponse( BufferSource value );
  Promise<undefined> writeValueWithoutResponse( BufferSource value );
};

[SecureContext]
interface BluetoothRemoteGATTServer {
  Promise<BluetoothRemoteGATTService> getPrimaryService( BluetoothServiceUUID service );
  Promise<sequence<BluetoothRemoteGATTService>> getPrimaryServices( optional BluetoothServiceUUID service );
};

[SecureContext]
interface BluetoothRemoteGATTService : EventTarget {
  Promise<BluetoothRemoteGATTService> getIncludedService( BluetoothServiceUUID service );
  Promise<sequence<BluetoothRemoteGATTService>> getIncludedServices( optional BluetoothServiceUUID service );
};

interface DataView {
};

interface Event {
};

interface EventTarget {
  undefined removeEventListener( DOMString type, optional ( EventListenerOptions or boolean ) options = {} );
};

interface Float32Array {
};

interface Float64Array {
};

interface Int16Array {
};

interface Int32Array {
};

interface Int8Array {
};

interface SomeDataContainer {
  static undefined myStaticMethodWithUnionArg( BluetoothDescriptorUUID name );
  static BluetoothDescriptorUUID myStaticMethodWithUnionReturn();
  constructor( BufferSource data );
};

interface SomeInterface {
  static undefined myStaticMethodWithUnionArg( ( DOMString or unsigned long ) serviceUuid );
  static ( DOMString or unsigned long ) myStaticMethodWithUnionReturn();
  constructor( ( DOMString or unsigned long ) serviceUuid );
  ( DOMString or unsigned long ) getUuid();
};

interface SomeServiceContainer {
  static undefined myStaticMethodWithUnionArg( optional BluetoothDescriptorUUID name );
  static BluetoothDescriptorUUID? myStaticMethodWithUnionReturn();
  constructor( optional BluetoothServiceUUID service );
};

interface Uint16Array {
};

interface Uint32Array {
};

interface Uint8Array {
};

interface Uint8ClampedArray {
};
