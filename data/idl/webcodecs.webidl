enum AudioSampleFormat {
  "FLT",
  "FLTP",
  "S16",
  "S16P",
  "S24",
  "S24P",
  "S32",
  "S32P",
  "U8",
  "U8P"
};

enum CodecState {
  "closed",
  "configured",
  "unconfigured"
};

enum EncodedAudioChunkType {
  "delta",
  "key"
};

enum EncodedVideoChunkType {
  "delta",
  "key"
};

enum HardwareAcceleration {
  "allow",
  "deny",
  "require"
};

enum PixelFormat {
  "I420"
};

typedef ( BufferSource or ReadableStream ) ImageBufferSource;

callback AudioDataOutputCallback = undefined ( AudioData output );

callback EncodedAudioChunkOutputCallback = undefined ( EncodedAudioChunk output, optional EncodedAudioChunkMetadata metadata = {} );

callback EncodedVideoChunkOutputCallback = undefined ( EncodedVideoChunk chunk, optional EncodedVideoChunkMetadata metadata = {} );

callback VideoFrameOutputCallback = undefined ( VideoFrame output );

callback WebCodecsErrorCallback = undefined ( DOMException error );

dictionary AudioDataCopyToOptions {
  unsigned long frameCount;
  unsigned long frameOffset = 0;
  required unsigned long planeIndex;
};

dictionary AudioDataInit {
  required BufferSource data;
  required AudioSampleFormat format;
  [EnforceRange]
  required unsigned long numberOfChannels;
  [EnforceRange]
  required unsigned long numberOfFrames;
  [EnforceRange]
  required float sampleRate;
  [EnforceRange]
  required long long timestamp;
};

dictionary AudioDecoderConfig {
  required DOMString codec;
  BufferSource description;
  [EnforceRange]
  required unsigned long numberOfChannels;
  [EnforceRange]
  required unsigned long sampleRate;
};

dictionary AudioDecoderInit {
  required WebCodecsErrorCallback error;
  required AudioDataOutputCallback output;
};

dictionary AudioDecoderSupport {
  AudioDecoderConfig config;
  boolean supported;
};

dictionary AudioEncoderConfig {
  [EnforceRange]
  unsigned long long bitrate;
  required DOMString codec;
  [EnforceRange]
  unsigned long numberOfChannels;
  [EnforceRange]
  unsigned long sampleRate;
};

dictionary AudioEncoderInit {
  required WebCodecsErrorCallback error;
  required EncodedAudioChunkOutputCallback output;
};

dictionary AudioEncoderSupport {
  AudioEncoderConfig config;
  boolean supported;
};

dictionary EncodedAudioChunkInit {
  required BufferSource data;
  [EnforceRange]
  required long long timestamp;
  required EncodedAudioChunkType type;
};

dictionary EncodedAudioChunkMetadata {
  AudioDecoderConfig decoderConfig;
};

dictionary EncodedVideoChunkInit {
  required BufferSource data;
  [EnforceRange]
  unsigned long long duration;
  [EnforceRange]
  required long long timestamp;
  required EncodedVideoChunkType type;
};

dictionary EncodedVideoChunkMetadata {
  VideoDecoderConfig decoderConfig;
  unsigned long temporalLayerId;
};

dictionary ImageDecodeOptions {
  boolean completeFramesOnly = true;
  [EnforceRange]
  unsigned long frameIndex = 0;
};

dictionary ImageDecodeResult {
  required boolean complete;
  required VideoFrame image;
};

dictionary ImageDecoderInit {
  ColorSpaceConversion colorSpaceConversion = "default";
  required ImageBufferSource data;
  [EnforceRange]
  unsigned long desiredHeight;
  [EnforceRange]
  unsigned long desiredWidth;
  boolean preferAnimation;
  PremultiplyAlpha premultiplyAlpha = "default";
  required DOMString type;
};

dictionary PlaneInit {
  required BufferSource data;
  [EnforceRange]
  unsigned long offset = 0;
  [EnforceRange]
  required unsigned long stride;
};

dictionary PlaneLayout {
  [EnforceRange]
  required unsigned long offset;
  [EnforceRange]
  required unsigned long stride;
};

dictionary VideoDecoderConfig {
  required DOMString codec;
  [EnforceRange]
  unsigned long codedHeight;
  [EnforceRange]
  unsigned long codedWidth;
  BufferSource description;
  [EnforceRange]
  unsigned long displayAspectHeight;
  [EnforceRange]
  unsigned long displayAspectWidth;
  HardwareAcceleration hardwareAcceleration = "allow";
};

dictionary VideoDecoderInit {
  required WebCodecsErrorCallback error;
  required VideoFrameOutputCallback output;
};

dictionary VideoDecoderSupport {
  VideoDecoderConfig config;
  boolean supported;
};

dictionary VideoEncoderConfig {
  [EnforceRange]
  unsigned long long bitrate;
  BitrateMode bitrateMode = "variable";
  required DOMString codec;
  [EnforceRange]
  unsigned long displayHeight;
  [EnforceRange]
  unsigned long displayWidth;
  HardwareAcceleration hardwareAcceleration = "allow";
  [EnforceRange]
  required unsigned long height;
  DOMString scalabilityMode;
  [EnforceRange]
  required unsigned long width;
};

dictionary VideoEncoderEncodeOptions {
  boolean keyFrame = false;
};

dictionary VideoEncoderInit {
  required WebCodecsErrorCallback error;
  required EncodedVideoChunkOutputCallback output;
};

dictionary VideoEncoderSupport {
  VideoEncoderConfig config;
  boolean supported;
};

dictionary VideoFrameCopyToOptions {
  sequence<PlaneLayout> layout;
  VideoFrameRect rect;
};

dictionary VideoFrameInit {
  unsigned long long duration;
  long long timestamp;
};

dictionary VideoFramePlaneInit {
  [EnforceRange]
  required unsigned long codedHeight;
  [EnforceRange]
  required unsigned long codedWidth;
  [EnforceRange]
  unsigned long displayHeight;
  [EnforceRange]
  unsigned long displayWidth;
  [EnforceRange]
  unsigned long long duration;
  required PixelFormat format;
  [EnforceRange]
  long long timestamp;
  VideoFrameRect visibleRect;
};

dictionary VideoFrameRect {
  [EnforceRange]
  required unsigned long height;
  [EnforceRange]
  required unsigned long left;
  [EnforceRange]
  required unsigned long top;
  [EnforceRange]
  required unsigned long width;
};

[Exposed=(Window,DedicatedWorker)]
interface AudioData {
  readonly attribute unsigned long long duration;
  readonly attribute AudioSampleFormat format;
  readonly attribute unsigned long numberOfChannels;
  readonly attribute unsigned long numberOfFrames;
  readonly attribute float sampleRate;
  readonly attribute long long timestamp;
  constructor( AudioDataInit init );
  unsigned long allocationSize( AudioDataCopyToOptions options );
  AudioData clone();
  undefined close();
  undefined copyTo( [AllowShared] BufferSource destination, AudioDataCopyToOptions options );
};

[Exposed=(Window,DedicatedWorker)]
interface AudioDecoder {
  readonly attribute long decodeQueueSize;
  readonly attribute CodecState state;
  static Promise<AudioDecoderSupport> isConfigSupported( AudioDecoderConfig config );
  constructor( AudioDecoderInit init );
  undefined close();
  undefined configure( AudioDecoderConfig config );
  undefined decode( EncodedAudioChunk chunk );
  Promise<undefined> flush();
  undefined reset();
};

[Exposed=(Window,DedicatedWorker)]
interface AudioEncoder {
  readonly attribute long encodeQueueSize;
  readonly attribute CodecState state;
  static Promise<AudioEncoderSupport> isConfigSupported( AudioEncoderConfig config );
  constructor( AudioEncoderInit init );
  undefined close();
  undefined configure( AudioEncoderConfig config );
  undefined encode( AudioData data );
  Promise<undefined> flush();
  undefined reset();
};

[Exposed=(Window,DedicatedWorker)]
interface EncodedAudioChunk {
  readonly attribute unsigned long byteLength;
  readonly attribute unsigned long duration;
  readonly attribute long long timestamp;
  readonly attribute EncodedAudioChunkType type;
  constructor( EncodedAudioChunkInit init );
  undefined copyTo( [AllowShared] BufferSource destination );
};

[Exposed=(Window,DedicatedWorker)]
interface EncodedVideoChunk {
  readonly attribute unsigned long byteLength;
  readonly attribute unsigned long long? duration;
  readonly attribute long long timestamp;
  readonly attribute EncodedVideoChunkType type;
  constructor( EncodedVideoChunkInit init );
  undefined copyTo( [AllowShared] BufferSource destination );
};

[Exposed=(Window,DedicatedWorker)]
interface ImageDecoder {
  readonly attribute boolean complete;
  readonly attribute Promise<undefined> completed;
  readonly attribute ImageTrackList tracks;
  static Promise<boolean> isTypeSupported( DOMString type );
  constructor( ImageDecoderInit init );
  undefined close();
  Promise<ImageDecodeResult> decode( optional ImageDecodeOptions options = {} );
  undefined reset();
};

[Exposed=(Window,DedicatedWorker)]
interface ImageTrack : EventTarget {
  readonly attribute boolean animated;
  [EnforceRange]
  readonly attribute unsigned long frameCount;
  [EnforceRange]
  readonly attribute unrestricted float repetitionCount;
  attribute EventHandler onchange;
  attribute boolean selected;
};

[Exposed=(Window,DedicatedWorker)]
interface ImageTrackList {
  [EnforceRange]
  readonly attribute unsigned long length;
  readonly attribute Promise<undefined> ready;
  [EnforceRange]
  readonly attribute long selectedIndex;
  readonly attribute ImageTrack? selectedTrack;
  getter ImageTrack ( unsigned long index );
};

[Exposed=(Window,DedicatedWorker)]
interface VideoDecoder {
  readonly attribute long decodeQueueSize;
  readonly attribute CodecState state;
  static Promise<VideoDecoderSupport> isConfigSupported( VideoDecoderConfig config );
  constructor( VideoDecoderInit init );
  undefined close();
  undefined configure( VideoDecoderConfig config );
  undefined decode( EncodedVideoChunk chunk );
  Promise<undefined> flush();
  undefined reset();
};

[Exposed=(Window,DedicatedWorker)]
interface VideoEncoder {
  readonly attribute long encodeQueueSize;
  readonly attribute CodecState state;
  static Promise<boolean> isConfigSupported( VideoEncoderConfig config );
  constructor( VideoEncoderInit init );
  undefined close();
  undefined configure( VideoEncoderConfig config );
  undefined encode( VideoFrame frame, optional VideoEncoderEncodeOptions options = {} );
  Promise<undefined> flush();
  undefined reset();
};

[Exposed=(Window,DedicatedWorker)]
interface VideoFrame {
  readonly attribute unsigned long codedHeight;
  readonly attribute VideoFrameRect codedRect;
  readonly attribute unsigned long codedWidth;
  readonly attribute unsigned long displayHeight;
  readonly attribute unsigned long displayWidth;
  readonly attribute unsigned long long? duration;
  readonly attribute PixelFormat format;
  readonly attribute long long? timestamp;
  readonly attribute VideoFrameRect visibleRect;
  constructor( CanvasImageSource image, optional VideoFrameInit init = {} );
  constructor( sequence<PlaneInit> planes, VideoFramePlaneInit init );
  unsigned long allocationSize( optional VideoFrameCopyToOptions options = {} );
  VideoFrame clone();
  undefined close();
  Promise<sequence<PlaneLayout>> copyTo( [AllowShared] BufferSource destination, optional VideoFrameCopyToOptions options = {} );
};
