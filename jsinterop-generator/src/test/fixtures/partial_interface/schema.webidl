[Exposed=Window]
interface SpeechSynthesis {
  readonly attribute boolean paused;
  readonly attribute boolean pending;
  readonly attribute boolean speaking;
};

partial interface Window {
  [SameObject]
  readonly attribute SpeechSynthesis speechSynthesis;
};
