partial interface Window {
  [SameObject]
  readonly attribute SpeechSynthesis speechSynthesis;
};

partial interface Window {
  [SecureContext]
  attribute EventHandler ondeviceorientation;
};

partial interface Window {
  [SameObject]
  readonly attribute SpeechSynthesis speechSynthesis;
};

[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface Window : EventTarget {
  [SecureContext]
  readonly attribute ApplicationCache applicationCache;
  readonly attribute boolean closed;
};
