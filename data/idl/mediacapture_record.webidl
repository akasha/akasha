enum BitrateMode {
  "constant",
  "variable"
};

enum RecordingState {
  "inactive",
  "paused",
  "recording"
};

dictionary BlobEventInit {
  required Blob data;
  DOMHighResTimeStamp timecode;
};

dictionary MediaRecorderErrorEventInit : EventInit {
  required DOMException error;
};

dictionary MediaRecorderOptions {
  BitrateMode audioBitrateMode = "variable";
  unsigned long audioBitsPerSecond;
  unsigned long bitsPerSecond;
  DOMString mimeType = "";
  unsigned long videoBitsPerSecond;
};

[Exposed=Window]
interface BlobEvent : Event {
  [SameObject]
  readonly attribute Blob data;
  readonly attribute DOMHighResTimeStamp timecode;
  constructor( DOMString type, BlobEventInit eventInitDict );
};

[Exposed=Window]
interface MediaRecorder : EventTarget {
  readonly attribute BitrateMode audioBitrateMode;
  readonly attribute unsigned long audioBitsPerSecond;
  readonly attribute DOMString mimeType;
  readonly attribute RecordingState state;
  readonly attribute MediaStream stream;
  readonly attribute unsigned long videoBitsPerSecond;
  attribute EventHandler ondataavailable;
  attribute EventHandler onerror;
  attribute EventHandler onpause;
  attribute EventHandler onresume;
  attribute EventHandler onstart;
  attribute EventHandler onstop;
  static boolean isTypeSupported( DOMString type );
  constructor( MediaStream stream, optional MediaRecorderOptions options = {} );
  undefined pause();
  undefined requestData();
  undefined resume();
  undefined start( optional unsigned long timeslice );
  undefined stop();
};

[Exposed=Window]
interface MediaRecorderErrorEvent : Event {
  [SameObject]
  readonly attribute DOMException error;
  constructor( DOMString type, MediaRecorderErrorEventInit eventInitDict );
};
