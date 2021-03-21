[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface Window : EventTarget {
  [SecureContext]
  readonly attribute ApplicationCache applicationCache;
  readonly attribute boolean closed;
  event Event orientationchange;
};

partial interface Window {
  [SameObject]
  readonly attribute SpeechSynthesis speechSynthesis;
};

partial interface Window {
  [SecureContext]
  attribute EventHandler ondeviceorientation;
  event DeviceOrientationEvent deviceorientation;
};

partial interface Window {
  [SecureContext]
  attribute EventHandler ondeviceorientationabsolute;
};

partial interface Window {
  attribute EventHandler oncompassneedscalibration;
};
