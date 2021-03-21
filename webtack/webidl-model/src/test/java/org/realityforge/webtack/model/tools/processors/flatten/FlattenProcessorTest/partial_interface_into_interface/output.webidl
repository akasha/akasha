[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface Window : EventTarget {
  [SecureContext]
  readonly attribute ApplicationCache applicationCache;
  readonly attribute boolean closed;
  [SameObject]
  readonly attribute SpeechSynthesis speechSynthesis;
  attribute EventHandler oncompassneedscalibration;
  [SecureContext]
  attribute EventHandler ondeviceorientation;
  [SecureContext]
  attribute EventHandler ondeviceorientationabsolute;
  event DeviceOrientationEvent deviceorientation;
  event Event orientationchange;
};
