enum PermissionState {
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
  static Promise<PermissionState> requestPermission();
  constructor( DOMString type, optional PermissionState eventInitDict = {} );
  undefined someMethod( sequence<PermissionState> perms );
};
