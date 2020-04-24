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

[Constructor]
interface MediaSource : EventTarget {
  readonly attribute SourceBufferList activeSourceBuffers;
  readonly attribute ReadyState readyState;
  readonly attribute SourceBufferList sourceBuffers;
  attribute unrestricted double duration;
  attribute EventHandler onsourceclose;
  attribute EventHandler onsourceended;
  attribute EventHandler onsourceopen;
  static boolean isTypeSupported( DOMString type );
  SourceBuffer addSourceBuffer( DOMString type );
  void clearLiveSeekableRange();
  void endOfStream( optional EndOfStreamError error );
  void removeSourceBuffer( SourceBuffer sourceBuffer );
  void setLiveSeekableRange( double start, double end );
};

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
  void abort();
  void appendBuffer( BufferSource data );
  void remove( double start, unrestricted double end );
};

interface SourceBufferList : EventTarget {
  readonly attribute unsigned long length;
  attribute EventHandler onaddsourcebuffer;
  attribute EventHandler onremovesourcebuffer;
  getter SourceBuffer ( unsigned long index );
};

partial interface AudioTrack {
  readonly attribute SourceBuffer? sourceBuffer;
};

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
