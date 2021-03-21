enum DevicePermissionState {
  "denied",
  "granted"
};

dictionary DeviceMotionEventAccelerationInit {
  double? x = null;
  double? y = null;
  double? z = null;
};

[Exposed=Window, SecureContext]
interface DeviceMotionEvent : Event {
  static Promise<DevicePermissionState> requestPermission();
  constructor( DOMString type, optional DevicePermissionState eventInitDict = {} );
  undefined someMethod( sequence<DevicePermissionState> perms );
};
