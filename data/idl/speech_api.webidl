enum SpeechRecognitionErrorCode {
  "aborted",
  "audio-capture",
  "bad-grammar",
  "language-not-supported",
  "network",
  "no-speech",
  "not-allowed",
  "service-not-allowed"
};

enum SpeechSynthesisErrorCode {
  "audio-busy",
  "audio-hardware",
  "canceled",
  "interrupted",
  "invalid-argument",
  "language-unavailable",
  "network",
  "not-allowed",
  "synthesis-failed",
  "synthesis-unavailable",
  "text-too-long",
  "voice-unavailable"
};

dictionary SpeechRecognitionErrorEventInit : EventInit {
  required SpeechRecognitionErrorCode error;
  DOMString message = "";
};

dictionary SpeechRecognitionEventInit : EventInit {
  unsigned long resultIndex = 0;
  required SpeechRecognitionResultList results;
};

dictionary SpeechSynthesisErrorEventInit : SpeechSynthesisEventInit {
  required SpeechSynthesisErrorCode error;
};

dictionary SpeechSynthesisEventInit : EventInit {
  unsigned long charIndex = 0;
  unsigned long charLength = 0;
  float elapsedTime = 0;
  DOMString name = "";
  required SpeechSynthesisUtterance utterance;
};

[Exposed=Window]
interface SpeechGrammar {
  attribute DOMString src;
  attribute float weight;
};

[Exposed=Window]
interface SpeechGrammarList {
  readonly attribute unsigned long length;
  constructor();
  void addFromString( DOMString string, optional float weight = 1.0 );
  void addFromURI( DOMString src, optional float weight = 1.0 );
  getter SpeechGrammar item( unsigned long index );
};

[Exposed=Window]
interface SpeechRecognition : EventTarget {
  attribute boolean continuous;
  attribute SpeechGrammarList grammars;
  attribute boolean interimResults;
  attribute DOMString lang;
  attribute unsigned long maxAlternatives;
  attribute EventHandler onaudioend;
  attribute EventHandler onaudiostart;
  attribute EventHandler onend;
  attribute EventHandler onerror;
  attribute EventHandler onnomatch;
  attribute EventHandler onresult;
  attribute EventHandler onsoundend;
  attribute EventHandler onsoundstart;
  attribute EventHandler onspeechend;
  attribute EventHandler onspeechstart;
  attribute EventHandler onstart;
  constructor();
  void abort();
  void start();
  void stop();
};

[Exposed=Window]
interface SpeechRecognitionAlternative {
  readonly attribute float confidence;
  readonly attribute DOMString transcript;
};

[Exposed=Window]
interface SpeechRecognitionErrorEvent : Event {
  readonly attribute SpeechRecognitionErrorCode error;
  readonly attribute DOMString message;
  constructor( DOMString type, SpeechRecognitionErrorEventInit eventInitDict );
};

[Exposed=Window]
interface SpeechRecognitionEvent : Event {
  readonly attribute unsigned long resultIndex;
  readonly attribute SpeechRecognitionResultList results;
  constructor( DOMString type, SpeechRecognitionEventInit eventInitDict );
};

[Exposed=Window]
interface SpeechRecognitionResult {
  readonly attribute boolean isFinal;
  readonly attribute unsigned long length;
  getter SpeechRecognitionAlternative item( unsigned long index );
};

[Exposed=Window]
interface SpeechRecognitionResultList {
  readonly attribute unsigned long length;
  getter SpeechRecognitionResult item( unsigned long index );
};

[Exposed=Window]
interface SpeechSynthesis : EventTarget {
  readonly attribute boolean paused;
  readonly attribute boolean pending;
  readonly attribute boolean speaking;
  attribute EventHandler onvoiceschanged;
  void cancel();
  sequence<SpeechSynthesisVoice> getVoices();
  void pause();
  void resume();
  void speak( SpeechSynthesisUtterance utterance );
};

[Exposed=Window]
interface SpeechSynthesisErrorEvent : SpeechSynthesisEvent {
  readonly attribute SpeechSynthesisErrorCode error;
  constructor( DOMString type, SpeechSynthesisErrorEventInit eventInitDict );
};

[Exposed=Window]
interface SpeechSynthesisEvent : Event {
  readonly attribute unsigned long charIndex;
  readonly attribute unsigned long charLength;
  readonly attribute float elapsedTime;
  readonly attribute DOMString name;
  readonly attribute SpeechSynthesisUtterance utterance;
  constructor( DOMString type, SpeechSynthesisEventInit eventInitDict );
};

[Exposed=Window]
interface SpeechSynthesisUtterance : EventTarget {
  attribute DOMString lang;
  attribute EventHandler onboundary;
  attribute EventHandler onend;
  attribute EventHandler onerror;
  attribute EventHandler onmark;
  attribute EventHandler onpause;
  attribute EventHandler onresume;
  attribute EventHandler onstart;
  attribute float pitch;
  attribute float rate;
  attribute DOMString text;
  attribute SpeechSynthesisVoice? voice;
  attribute float volume;
  constructor( optional DOMString text );
};

[Exposed=Window]
interface SpeechSynthesisVoice {
  readonly attribute boolean default;
  readonly attribute DOMString lang;
  readonly attribute boolean localService;
  readonly attribute DOMString name;
  readonly attribute DOMString voiceURI;
};

partial interface Window {
  [SameObject]
  readonly attribute SpeechSynthesis speechSynthesis;
};
