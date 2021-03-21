partial interface Window {
  [SameObject]
  readonly attribute SpeechSynthesis speechSynthesis;
  attribute EventHandler oncompassneedscalibration;
  [SecureContext]
  attribute EventHandler ondeviceorientation;
  [SecureContext]
  attribute EventHandler ondeviceorientationabsolute;
};
