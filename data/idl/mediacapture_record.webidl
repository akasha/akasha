enum BitrateMode {
  "cbr",
  "vbr"
};

enum RecordingState {
  "inactive",
  "recording",
  "paused"
};

dictionary BlobEventInit {
  required Blob data;
  DOMHighResTimeStamp timecode;
};

dictionary MediaRecorderErrorEventInit : EventInit {
  required DOMException error;
};

dictionary MediaRecorderOptions {
  BitrateMode audioBitrateMode = "vbr";
  unsigned long audioBitsPerSecond;
  unsigned long bitsPerSecond;
  DOMString mimeType = "";
  unsigned long videoBitsPerSecond;
};

[Exposed=Window, Constructor( DOMString type, BlobEventInit eventInitDict )]
interface BlobEvent : Event {
  [SameObject]
  readonly attribute Blob data;
  readonly attribute DOMHighResTimeStamp timecode;
};

[Exposed=Window, Constructor( MediaStream stream, optional MediaRecorderOptions options = {} )]
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
  void pause();
  void requestData();
  void resume();
  void start( optional unsigned long timeslice );
  void stop();
};

[Exposed=Window, Constructor( DOMString type, MediaRecorderErrorEventInit eventInitDict )]
interface MediaRecorderErrorEvent : Event {
  [SameObject]
  readonly attribute DOMException error;
};
