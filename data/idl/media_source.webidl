enum AppendMode {
  "segments",
  "sequence"
};

enum EndOfStreamError {
  "decode",
  "network"
};

enum ReadyState {
  "closed",
  "ended",
  "open"
};

[Exposed=(Window,DedicatedWorker)]
interface MediaSource : EventTarget {
  readonly attribute SourceBufferList activeSourceBuffers;
  readonly attribute ReadyState readyState;
  readonly attribute SourceBufferList sourceBuffers;
  attribute unrestricted double duration;
  attribute EventHandler onsourceclose;
  attribute EventHandler onsourceended;
  attribute EventHandler onsourceopen;
  static boolean isTypeSupported( DOMString type );
  constructor();
  SourceBuffer addSourceBuffer( DOMString type );
  undefined clearLiveSeekableRange();
  undefined endOfStream( optional EndOfStreamError error );
  undefined removeSourceBuffer( SourceBuffer sourceBuffer );
  undefined setLiveSeekableRange( double start, double end );
};

[Exposed=(Window,DedicatedWorker)]
interface SourceBuffer : EventTarget {
  readonly attribute AudioTrackList audioTracks;
  readonly attribute TimeRanges buffered;
  readonly attribute TextTrackList textTracks;
  readonly attribute boolean updating;
  readonly attribute VideoTrackList videoTracks;
  attribute unrestricted double appendWindowEnd;
  attribute double appendWindowStart;
  attribute AppendMode mode;
  attribute EventHandler onabort;
  attribute EventHandler onerror;
  attribute EventHandler onupdate;
  attribute EventHandler onupdateend;
  attribute EventHandler onupdatestart;
  attribute double timestampOffset;
  undefined abort();
  undefined appendBuffer( BufferSource data );
  undefined remove( double start, unrestricted double end );
};

[Exposed=(Window,DedicatedWorker)]
interface SourceBufferList : EventTarget {
  readonly attribute unsigned long length;
  attribute EventHandler onaddsourcebuffer;
  attribute EventHandler onremovesourcebuffer;
  getter SourceBuffer ( unsigned long index );
};

[Exposed=(Window,DedicatedWorker)]
partial interface AudioTrack {
  readonly attribute SourceBuffer? sourceBuffer;
};

[Exposed=(Window,DedicatedWorker)]
partial interface TextTrack {
  readonly attribute SourceBuffer? sourceBuffer;
};

[Exposed=Window]
partial interface URL {
  static DOMString createObjectURL( MediaSource mediaSource );
};

partial interface VideoTrack {
  readonly attribute SourceBuffer? sourceBuffer;
};
