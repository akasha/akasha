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

callback OnBufferSourceHandler = void ( optional BufferSource buffer );

[LegacyTreatNonObjectAsNull]
callback OnErrorEventHandler = any ( ( Event or DOMString ) event, optional DOMString source, optional unsigned long lineno, optional unsigned long colno, optional any error );

callback interface EventListener2 {
  void handleUuid( ( DOMString or unsigned long ) event );
};

callback interface EventListener3 {
  void handleServiceUuid( BluetoothServiceUUID event );
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

[Exposed=Window, SecureContext]
interface BluetoothRemoteGATTCharacteristic : EventTarget {
  Promise<void> writeValue( BufferSource value );
  Promise<void> writeValueWithResponse( BufferSource value );
  Promise<void> writeValueWithoutResponse( BufferSource value );
};

[Exposed=Window, SecureContext]
interface BluetoothRemoteGATTServer {
  Promise<BluetoothRemoteGATTService> getPrimaryService( BluetoothServiceUUID service );
  Promise<sequence<BluetoothRemoteGATTService>> getPrimaryServices( optional BluetoothServiceUUID service );
};

[Exposed=Window, SecureContext]
interface BluetoothRemoteGATTService : EventTarget {
  Promise<BluetoothRemoteGATTService> getIncludedService( BluetoothServiceUUID service );
  Promise<sequence<BluetoothRemoteGATTService>> getIncludedServices( optional BluetoothServiceUUID service );
};

interface Event {
};

interface EventTarget {
  void removeEventListener( DOMString type, optional ( EventListenerOptions or boolean ) options = {} );
};

interface SomeDataContainer {
  static void myStaticMethodWithUnionArg( BluetoothDescriptorUUID name );
  static BluetoothDescriptorUUID myStaticMethodWithUnionReturn();
  constructor( BufferSource data );
};

interface SomeInterface {
  static void myStaticMethodWithUnionArg( ( DOMString or unsigned long ) serviceUuid );
  static ( DOMString or unsigned long ) myStaticMethodWithUnionReturn();
  constructor( ( DOMString or unsigned long ) serviceUuid );
  ( DOMString or unsigned long ) getUuid();
};

interface SomeServiceContainer {
  static void myStaticMethodWithUnionArg( optional BluetoothDescriptorUUID name );
  static BluetoothDescriptorUUID? myStaticMethodWithUnionReturn();
  constructor( optional BluetoothServiceUUID service );
};
