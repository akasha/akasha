enum PermissionName {
  "accelerometer",
  "ambient-light-sensor",
  "background-fetch",
  "background-sync",
  "bluetooth",
  "camera",
  "display-capture",
  "geolocation",
  "gyroscope",
  "magnetometer",
  "microphone",
  "midi",
  "nfc",
  "notifications",
  "persistent-storage",
  "push",
  "screen-wake-lock",
  "speaker-selection",
  "xr-spatial-tracking"
};

enum PermissionState {
  "denied",
  "granted",
  "prompt"
};

dictionary DevicePermissionDescriptor : PermissionDescriptor {
  DOMString deviceId;
};

dictionary PermissionDescriptor {
  required PermissionName name;
};

[Exposed=(Window,Worker)]
interface PermissionStatus : EventTarget {
  readonly attribute PermissionName name;
  readonly attribute PermissionState state;
  attribute EventHandler onchange;
};

[Exposed=(Window,Worker)]
interface Permissions {
  Promise<PermissionStatus> query( object permissionDesc );
};

[Exposed=(Window)]
partial interface Navigator {
  [SameObject]
  readonly attribute Permissions permissions;
};

[Exposed=(Worker)]
partial interface WorkerNavigator {
  [SameObject]
  readonly attribute Permissions permissions;
};
