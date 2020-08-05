partial interface Window {
  event DeviceOrientationEvent deviceorientation;
};

partial interface Window {
  [SecureContext]
  attribute EventHandler ondeviceorientation;
};

partial interface Window {
  event DeviceOrientationEvent deviceorientation;
};

[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface Window : EventTarget {
  [SecureContext]
  readonly attribute ApplicationCache applicationCache;
  readonly attribute boolean closed;
};
