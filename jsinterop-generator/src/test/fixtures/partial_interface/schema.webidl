[Exposed=Window]
interface SpeechSynthesis {
  readonly attribute boolean paused;
  readonly attribute boolean pending;
  readonly attribute boolean speaking;
  stringifier void customToString();
};

partial interface Window {
  [SameObject]
  readonly attribute SpeechSynthesis speechSynthesis;
};
