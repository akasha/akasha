typedef ( DOMString or unsigned long ) BluetoothCharacteristicUUID;

typedef ( DOMString or unsigned long ) BluetoothDescriptorUUID;

typedef ( DOMString or unsigned long ) BluetoothServiceUUID;

typedef DOMString UUID;

dictionary AllowedBluetoothDevice {
  required sequence<unsigned short> allowedManufacturerData;
  required ( DOMString or sequence<UUID> ) allowedServices;
  required DOMString deviceId;
  required boolean mayUseGATT;
};

dictionary BluetoothAdvertisingEventInit : EventInit {
  unsigned short appearance;
  required BluetoothDevice device;
  BluetoothManufacturerDataMap manufacturerData;
  DOMString name;
  byte rssi;
  BluetoothServiceDataMap serviceData;
  byte txPower;
  sequence<( DOMString or unsigned long )> uuids;
};

dictionary BluetoothDataFilterInit {
  BufferSource dataPrefix;
  BufferSource mask;
};

dictionary BluetoothLEScanFilterInit {
  sequence<BluetoothManufacturerDataFilterInit> manufacturerData;
  DOMString name;
  DOMString namePrefix;
  sequence<BluetoothServiceDataFilterInit> serviceData;
  sequence<BluetoothServiceUUID> services;
};

dictionary BluetoothManufacturerDataFilterInit : BluetoothDataFilterInit {
  required [EnforceRange] unsigned short companyIdentifier;
};

dictionary BluetoothPermissionDescriptor : PermissionDescriptor {
  boolean acceptAllDevices = false;
  DOMString deviceId;
  sequence<BluetoothLEScanFilterInit> filters;
  sequence<unsigned short> optionalManufacturerData = [];
  sequence<BluetoothServiceUUID> optionalServices = [];
};

dictionary BluetoothPermissionStorage {
  required sequence<AllowedBluetoothDevice> allowedDevices;
};

dictionary BluetoothServiceDataFilterInit : BluetoothDataFilterInit {
  required BluetoothServiceUUID service;
};

dictionary RequestDeviceOptions {
  boolean acceptAllDevices = false;
  sequence<BluetoothLEScanFilterInit> filters;
  sequence<unsigned short> optionalManufacturerData = [];
  sequence<BluetoothServiceUUID> optionalServices = [];
};

dictionary ValueEventInit : EventInit {
  any value = null;
};

dictionary WatchAdvertisementsOptions {
  AbortSignal signal;
};

[SecureContext]
interface mixin BluetoothDeviceEventHandlers {
  attribute EventHandler onadvertisementreceived;
  attribute EventHandler ongattserverdisconnected;
};

[SecureContext]
interface mixin CharacteristicEventHandlers {
  attribute EventHandler oncharacteristicvaluechanged;
};

[SecureContext]
interface mixin ServiceEventHandlers {
  attribute EventHandler onserviceadded;
  attribute EventHandler onservicechanged;
  attribute EventHandler onserviceremoved;
};

[Exposed=Window, SecureContext]
interface Bluetooth : EventTarget {
  [SameObject]
  readonly attribute BluetoothDevice? referringDevice;
  attribute EventHandler onavailabilitychanged;
  Promise<boolean> getAvailability();
  Promise<sequence<BluetoothDevice>> getDevices();
  Promise<BluetoothDevice> requestDevice( optional RequestDeviceOptions options = {} );
};

[Exposed=Window, SecureContext]
interface BluetoothAdvertisingEvent : Event {
  readonly attribute unsigned short? appearance;
  [SameObject]
  readonly attribute BluetoothDevice device;
  [SameObject]
  readonly attribute BluetoothManufacturerDataMap manufacturerData;
  readonly attribute DOMString? name;
  readonly attribute byte? rssi;
  [SameObject]
  readonly attribute BluetoothServiceDataMap serviceData;
  readonly attribute byte? txPower;
  readonly attribute FrozenArray<UUID> uuids;
  constructor( DOMString type, BluetoothAdvertisingEventInit init );
};

[Exposed=Window, SecureContext]
interface BluetoothCharacteristicProperties {
  readonly attribute boolean authenticatedSignedWrites;
  readonly attribute boolean broadcast;
  readonly attribute boolean indicate;
  readonly attribute boolean notify;
  readonly attribute boolean read;
  readonly attribute boolean reliableWrite;
  readonly attribute boolean writableAuxiliaries;
  readonly attribute boolean write;
  readonly attribute boolean writeWithoutResponse;
};

[Exposed=Window, SecureContext]
interface BluetoothDevice : EventTarget {
  readonly attribute BluetoothRemoteGATTServer? gatt;
  readonly attribute DOMString id;
  readonly attribute DOMString? name;
  readonly attribute boolean watchingAdvertisements;
  Promise<undefined> watchAdvertisements( optional WatchAdvertisementsOptions options = {} );
};

[Exposed=Window, SecureContext]
interface BluetoothManufacturerDataMap {
  readonly maplike<unsigned short, DataView>;
};

[Exposed=Window]
interface BluetoothPermissionResult : PermissionStatus {
  attribute FrozenArray<BluetoothDevice> devices;
};

[Exposed=Window, SecureContext]
interface BluetoothRemoteGATTCharacteristic : EventTarget {
  readonly attribute BluetoothCharacteristicProperties properties;
  [SameObject]
  readonly attribute BluetoothRemoteGATTService service;
  readonly attribute UUID uuid;
  readonly attribute DataView? value;
  Promise<BluetoothRemoteGATTDescriptor> getDescriptor( BluetoothDescriptorUUID descriptor );
  Promise<sequence<BluetoothRemoteGATTDescriptor>> getDescriptors( optional BluetoothDescriptorUUID descriptor );
  Promise<DataView> readValue();
  Promise<BluetoothRemoteGATTCharacteristic> startNotifications();
  Promise<BluetoothRemoteGATTCharacteristic> stopNotifications();
  Promise<undefined> writeValue( BufferSource value );
  Promise<undefined> writeValueWithResponse( BufferSource value );
  Promise<undefined> writeValueWithoutResponse( BufferSource value );
};

[Exposed=Window, SecureContext]
interface BluetoothRemoteGATTDescriptor {
  [SameObject]
  readonly attribute BluetoothRemoteGATTCharacteristic characteristic;
  readonly attribute UUID uuid;
  readonly attribute DataView? value;
  Promise<DataView> readValue();
  Promise<undefined> writeValue( BufferSource value );
};

[Exposed=Window, SecureContext]
interface BluetoothRemoteGATTServer {
  readonly attribute boolean connected;
  [SameObject]
  readonly attribute BluetoothDevice device;
  Promise<BluetoothRemoteGATTServer> connect();
  undefined disconnect();
  Promise<BluetoothRemoteGATTService> getPrimaryService( BluetoothServiceUUID service );
  Promise<sequence<BluetoothRemoteGATTService>> getPrimaryServices( optional BluetoothServiceUUID service );
};

[Exposed=Window, SecureContext]
interface BluetoothRemoteGATTService : EventTarget {
  [SameObject]
  readonly attribute BluetoothDevice device;
  readonly attribute boolean isPrimary;
  readonly attribute UUID uuid;
  Promise<BluetoothRemoteGATTCharacteristic> getCharacteristic( BluetoothCharacteristicUUID characteristic );
  Promise<sequence<BluetoothRemoteGATTCharacteristic>> getCharacteristics( optional BluetoothCharacteristicUUID characteristic );
  Promise<BluetoothRemoteGATTService> getIncludedService( BluetoothServiceUUID service );
  Promise<sequence<BluetoothRemoteGATTService>> getIncludedServices( optional BluetoothServiceUUID service );
};

[Exposed=Window, SecureContext]
interface BluetoothServiceDataMap {
  readonly maplike<UUID, DataView>;
};

[Exposed=Window]
interface BluetoothUUID {
  static UUID canonicalUUID( [EnforceRange] unsigned long alias );
  static UUID getCharacteristic( ( DOMString or unsigned long ) name );
  static UUID getDescriptor( ( DOMString or unsigned long ) name );
  static UUID getService( ( DOMString or unsigned long ) name );
};

[Exposed=Window, SecureContext]
interface ValueEvent : Event {
  readonly attribute any value;
  constructor( DOMString type, optional ValueEventInit initDict = {} );
};

[SecureContext]
partial interface Navigator {
  [SameObject]
  readonly attribute Bluetooth bluetooth;
};

Bluetooth includes BluetoothDeviceEventHandlers;

Bluetooth includes CharacteristicEventHandlers;

Bluetooth includes ServiceEventHandlers;

BluetoothDevice includes BluetoothDeviceEventHandlers;

BluetoothDevice includes CharacteristicEventHandlers;

BluetoothDevice includes ServiceEventHandlers;

BluetoothRemoteGATTCharacteristic includes CharacteristicEventHandlers;

BluetoothRemoteGATTService includes CharacteristicEventHandlers;

BluetoothRemoteGATTService includes ServiceEventHandlers;
