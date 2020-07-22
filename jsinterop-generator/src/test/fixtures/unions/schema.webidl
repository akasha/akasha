typedef ( Int8Array or Int16Array or Int32Array or Uint8Array or Uint16Array or Uint32Array or Uint8ClampedArray or Float32Array or Float64Array or DataView ) ArrayBufferView;

typedef ( DOMString or unsigned long ) BluetoothCharacteristicUUID;

typedef ( DOMString or unsigned long ) BluetoothDescriptorUUID;

typedef ( DOMString or unsigned long ) BluetoothServiceUUID;

typedef ( ArrayBufferView or ArrayBuffer ) BufferSource;

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

interface EventTarget {
  void removeEventListener( DOMString type, optional ( EventListenerOptions or boolean ) options = {} );
};

interface SomeInterface {
  ( DOMString or unsigned long ) getUuid();
};
