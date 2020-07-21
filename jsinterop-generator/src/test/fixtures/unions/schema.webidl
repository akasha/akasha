typedef ( Int8Array or Int16Array or Int32Array or Uint8Array or Uint16Array or Uint32Array or Uint8ClampedArray or Float32Array or Float64Array or DataView ) ArrayBufferView;

typedef ( DOMString or unsigned long ) BluetoothCharacteristicUUID;

typedef ( DOMString or unsigned long ) BluetoothDescriptorUUID;

typedef ( ArrayBufferView or ArrayBuffer ) BufferSource;

dictionary AllowedBluetoothDevice {
  required ( DOMString or sequence<DOMString> ) allowedServices;
  ( DOMString or sequence<DOMString> ) otherServices;
  required sequence<( DOMString or long long )> requiredUuids;
  sequence<( DOMString or octet )> uuids;
};

dictionary EventListenerOptions {
  boolean capture = false;
};

interface EventTarget {
  void removeEventListener( DOMString type, optional ( EventListenerOptions or boolean ) options = {} );
};

interface SomeInterface {
  ( DOMString or unsigned long ) getUuid();
};
