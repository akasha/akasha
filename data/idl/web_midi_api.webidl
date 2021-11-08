enum MIDIPortConnectionState {
  "closed",
  "open",
  "pending"
};

enum MIDIPortDeviceState {
  "connected",
  "disconnected"
};

enum MIDIPortType {
  "input",
  "output"
};

dictionary MIDIConnectionEventInit : EventInit {
  MIDIPort port;
};

dictionary MIDIMessageEventInit : EventInit {
  Uint8Array data;
};

dictionary MIDIOptions {
  boolean software;
  boolean sysex;
};

dictionary MidiPermissionDescriptor : PermissionDescriptor {
  boolean sysex = false;
};

[SecureContext, Exposed=Window]
interface MIDIAccess : EventTarget {
  readonly attribute MIDIInputMap inputs;
  readonly attribute MIDIOutputMap outputs;
  readonly attribute boolean sysexEnabled;
  attribute EventHandler onstatechange;
};

[SecureContext, Exposed=Window]
interface MIDIConnectionEvent : Event {
  readonly attribute MIDIPort port;
  constructor( DOMString type, optional MIDIConnectionEventInit eventInitDict = {} );
};

[SecureContext, Exposed=Window]
interface MIDIInput : MIDIPort {
  attribute EventHandler onmidimessage;
};

[SecureContext, Exposed=Window]
interface MIDIInputMap {
  readonly maplike<DOMString, MIDIInput>;
};

[SecureContext, Exposed=Window]
interface MIDIMessageEvent : Event {
  readonly attribute Uint8Array data;
  constructor( DOMString type, optional MIDIMessageEventInit eventInitDict = {} );
};

[SecureContext, Exposed=Window]
interface MIDIOutput : MIDIPort {
  undefined clear();
  undefined send( sequence<octet> data, optional DOMHighResTimeStamp timestamp = 0 );
};

[SecureContext, Exposed=Window]
interface MIDIOutputMap {
  readonly maplike<DOMString, MIDIOutput>;
};

[SecureContext, Exposed=Window]
interface MIDIPort : EventTarget {
  readonly attribute MIDIPortConnectionState connection;
  readonly attribute DOMString id;
  readonly attribute DOMString? manufacturer;
  readonly attribute DOMString? name;
  readonly attribute MIDIPortDeviceState state;
  readonly attribute MIDIPortType type;
  readonly attribute DOMString? version;
  attribute EventHandler onstatechange;
  Promise<MIDIPort> close();
  Promise<MIDIPort> open();
};

partial interface Navigator {
  [SecureContext]
  Promise<MIDIAccess> requestMIDIAccess( optional MIDIOptions options = {} );
};
