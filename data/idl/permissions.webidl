enum PermissionName {
  "accelerometer",
  "ambient-light-sensor",
  "background-sync",
  "bluetooth",
  "camera",
  "clipboard",
  "device-info",
  "geolocation",
  "gyroscope",
  "magnetometer",
  "microphone",
  "midi",
  "notifications",
  "persistent-storage",
  "push",
  "speaker"
};

enum PermissionState {
  "denied",
  "granted",
  "prompt"
};

dictionary DevicePermissionDescriptor : PermissionDescriptor {
  DOMString deviceId;
};

dictionary MidiPermissionDescriptor : PermissionDescriptor {
  boolean sysex = false;
};

dictionary PermissionDescriptor {
  required PermissionName name;
};

dictionary PushPermissionDescriptor : PermissionDescriptor {
  boolean userVisibleOnly = false;
};

[Exposed=(Window,Worker)]
interface PermissionStatus : EventTarget {
  readonly attribute PermissionState state;
  attribute EventHandler onchange;
};

[Exposed=(Window,Worker)]
interface Permissions {
  Promise<PermissionStatus> query( object permissionDesc );
};

[Exposed=(Window)]
partial interface Navigator {
  readonly attribute Permissions permissions;
};

[Exposed=(Worker)]
partial interface WorkerNavigator {
  readonly attribute Permissions permissions;
};
