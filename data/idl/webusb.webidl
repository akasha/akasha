enum USBDirection {
  "in",
  "out"
};

enum USBEndpointType {
  "bulk",
  "interrupt",
  "isochronous"
};

enum USBRecipient {
  "device",
  "endpoint",
  "interface",
  "other"
};

enum USBRequestType {
  "class",
  "standard",
  "vendor"
};

enum USBTransferStatus {
  "babble",
  "ok",
  "stall"
};

dictionary AllowedUSBDevice {
  required octet vendorId;
  required octet productId;
  DOMString serialNumber;
};

dictionary USBConnectionEventInit : EventInit {
  required USBDevice device;
};

dictionary USBControlTransferParameters {
  required USBRequestType requestType;
  required USBRecipient recipient;
  required octet request;
  required unsigned short value;
  required unsigned short index;
};

dictionary USBDeviceFilter {
  octet classCode;
  unsigned short productId;
  octet protocolCode;
  DOMString serialNumber;
  octet subclassCode;
  unsigned short vendorId;
};

dictionary USBDeviceRequestOptions {
  required sequence<USBDeviceFilter> filters;
};

dictionary USBPermissionDescriptor : PermissionDescriptor {
  sequence<USBDeviceFilter> filters;
};

dictionary USBPermissionStorage {
  sequence<AllowedUSBDevice> allowedDevices = [];
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USB : EventTarget {
  attribute EventHandler onconnect;
  attribute EventHandler ondisconnect;
  Promise<sequence<USBDevice>> getDevices();
  [Exposed=Window]
  Promise<USBDevice> requestDevice( USBDeviceRequestOptions options );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBAlternateInterface {
  readonly attribute octet alternateSetting;
  readonly attribute FrozenArray<USBEndpoint> endpoints;
  readonly attribute octet interfaceClass;
  readonly attribute DOMString? interfaceName;
  readonly attribute octet interfaceProtocol;
  readonly attribute octet interfaceSubclass;
  constructor( USBInterface deviceInterface, octet alternateSetting );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBConfiguration {
  readonly attribute DOMString? configurationName;
  readonly attribute octet configurationValue;
  readonly attribute FrozenArray<USBInterface> interfaces;
  constructor( USBDevice device, octet configurationValue );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBConnectionEvent : Event {
  [SameObject]
  readonly attribute USBDevice device;
  constructor( DOMString type, USBConnectionEventInit eventInitDict );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBDevice {
  readonly attribute USBConfiguration? configuration;
  readonly attribute FrozenArray<USBConfiguration> configurations;
  readonly attribute octet deviceClass;
  readonly attribute octet deviceProtocol;
  readonly attribute octet deviceSubclass;
  readonly attribute octet deviceVersionMajor;
  readonly attribute octet deviceVersionMinor;
  readonly attribute octet deviceVersionSubminor;
  readonly attribute DOMString? manufacturerName;
  readonly attribute boolean opened;
  readonly attribute unsigned short productId;
  readonly attribute DOMString? productName;
  readonly attribute DOMString? serialNumber;
  readonly attribute octet usbVersionMajor;
  readonly attribute octet usbVersionMinor;
  readonly attribute octet usbVersionSubminor;
  readonly attribute unsigned short vendorId;
  Promise<undefined> claimInterface( octet interfaceNumber );
  Promise<undefined> clearHalt( USBDirection direction, octet endpointNumber );
  Promise<undefined> close();
  Promise<USBInTransferResult> controlTransferIn( USBControlTransferParameters setup, unsigned short length );
  Promise<USBOutTransferResult> controlTransferOut( USBControlTransferParameters setup, optional BufferSource data );
  Promise<USBIsochronousInTransferResult> isochronousTransferIn( octet endpointNumber, sequence<unsigned long> packetLengths );
  Promise<USBIsochronousOutTransferResult> isochronousTransferOut( octet endpointNumber, BufferSource data, sequence<unsigned long> packetLengths );
  Promise<undefined> open();
  Promise<undefined> releaseInterface( octet interfaceNumber );
  Promise<undefined> reset();
  Promise<undefined> selectAlternateInterface( octet interfaceNumber, octet alternateSetting );
  Promise<undefined> selectConfiguration( octet configurationValue );
  Promise<USBInTransferResult> transferIn( octet endpointNumber, unsigned long length );
  Promise<USBOutTransferResult> transferOut( octet endpointNumber, BufferSource data );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBEndpoint {
  readonly attribute USBDirection direction;
  readonly attribute octet endpointNumber;
  readonly attribute unsigned long packetSize;
  readonly attribute USBEndpointType type;
  constructor( USBAlternateInterface alternate, octet endpointNumber, USBDirection direction );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBInTransferResult {
  readonly attribute DataView? data;
  readonly attribute USBTransferStatus status;
  constructor( USBTransferStatus status, optional DataView? data );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBInterface {
  readonly attribute USBAlternateInterface alternate;
  readonly attribute FrozenArray<USBAlternateInterface> alternates;
  readonly attribute boolean claimed;
  readonly attribute octet interfaceNumber;
  constructor( USBConfiguration configuration, octet interfaceNumber );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBIsochronousInTransferPacket {
  readonly attribute DataView? data;
  readonly attribute USBTransferStatus status;
  constructor( USBTransferStatus status, optional DataView? data );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBIsochronousInTransferResult {
  readonly attribute DataView? data;
  readonly attribute FrozenArray<USBIsochronousInTransferPacket> packets;
  constructor( sequence<USBIsochronousInTransferPacket> packets, optional DataView? data );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBIsochronousOutTransferPacket {
  readonly attribute unsigned long bytesWritten;
  readonly attribute USBTransferStatus status;
  constructor( USBTransferStatus status, optional unsigned long bytesWritten = 0 );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBIsochronousOutTransferResult {
  readonly attribute FrozenArray<USBIsochronousOutTransferPacket> packets;
  constructor( sequence<USBIsochronousOutTransferPacket> packets );
};

[Exposed=(DedicatedWorker,SharedWorker,Window), SecureContext]
interface USBOutTransferResult {
  readonly attribute unsigned long bytesWritten;
  readonly attribute USBTransferStatus status;
  constructor( USBTransferStatus status, optional unsigned long bytesWritten = 0 );
};

[Exposed=(DedicatedWorker,SharedWorker,Window)]
interface USBPermissionResult : PermissionStatus {
  attribute FrozenArray<USBDevice> devices;
};

[Exposed=Window, SecureContext]
partial interface Navigator {
  [SameObject]
  readonly attribute USB usb;
};

[Exposed=(DedicatedWorker,SharedWorker), SecureContext]
partial interface WorkerNavigator {
  [SameObject]
  readonly attribute USB usb;
};
