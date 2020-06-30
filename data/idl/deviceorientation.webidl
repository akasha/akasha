enum PermissionState {
  "denied",
  "granted"
};

dictionary DeviceMotionEventAccelerationInit {
  double? x = null;
  double? y = null;
  double? z = null;
};

dictionary DeviceMotionEventInit : EventInit {
  DeviceMotionEventAccelerationInit acceleration;
  DeviceMotionEventAccelerationInit accelerationIncludingGravity;
  double interval = 0;
  DeviceMotionEventRotationRateInit rotationRate;
};

dictionary DeviceMotionEventRotationRateInit {
  double? alpha = null;
  double? beta = null;
  double? gamma = null;
};

dictionary DeviceOrientationEventInit : EventInit {
  boolean absolute = false;
  double? alpha = null;
  double? beta = null;
  double? gamma = null;
};

[Exposed=Window, SecureContext]
interface DeviceMotionEvent : Event {
  readonly attribute DeviceMotionEventAcceleration? acceleration;
  readonly attribute DeviceMotionEventAcceleration? accelerationIncludingGravity;
  readonly attribute double interval;
  readonly attribute DeviceMotionEventRotationRate? rotationRate;
  static Promise<PermissionState> requestPermission();
  constructor( DOMString type, optional DeviceMotionEventInit eventInitDict = {} );
};

[Exposed=Window, SecureContext]
interface DeviceMotionEventAcceleration {
  readonly attribute double? x;
  readonly attribute double? y;
  readonly attribute double? z;
};

[Exposed=Window, SecureContext]
interface DeviceMotionEventRotationRate {
  readonly attribute double? alpha;
  readonly attribute double? beta;
  readonly attribute double? gamma;
};

[Exposed=Window, SecureContext]
interface DeviceOrientationEvent : Event {
  readonly attribute boolean absolute;
  readonly attribute double? alpha;
  readonly attribute double? beta;
  readonly attribute double? gamma;
  static Promise<PermissionState> requestPermission();
  constructor( DOMString type, optional DeviceOrientationEventInit eventInitDict = {} );
};

partial interface Window {
  [SecureContext]
  attribute EventHandler ondeviceorientation;
};

partial interface Window {
  [SecureContext]
  attribute EventHandler ondeviceorientationabsolute;
};

partial interface Window {
  attribute EventHandler oncompassneedscalibration;
};

partial interface Window {
  [SecureContext]
  attribute EventHandler ondevicemotion;
};
