enum AlphaOption {
  "discard",
  "keep"
};

enum AudioSampleFormat {
  "f32",
  "f32-planar",
  "s16",
  "s16-planar",
  "s32",
  "s32-planar",
  "u8",
  "u8-planar"
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
  "no-preference",
  "prefer-hardware",
  "prefer-software"
};

enum LatencyMode {
  "quality",
  "realtime"
};

enum VideoColorPrimaries {
  "bt470bg",
  "bt709",
  "smpte170m"
};

enum VideoMatrixCoefficients {
  "bt470bg",
  "bt709",
  "rgb",
  "smpte170m"
};

enum VideoPixelFormat {
  "BGRA",
  "BGRX",
  "I420",
  "I420A",
  "I422",
  "I444",
  "NV12",
  "RGBA",
  "RGBX"
};

enum VideoTransferCharacteristics {
  "bt709",
  "iec61966-2-1",
  "smpte170m"
};

typedef ( BufferSource or ReadableStream ) ImageBufferSource;

callback AudioDataOutputCallback = undefined ( AudioData output );

callback EncodedAudioChunkOutputCallback = undefined ( EncodedAudioChunk output, optional EncodedAudioChunkMetadata metadata = {} );

callback EncodedVideoChunkOutputCallback = undefined ( EncodedVideoChunk chunk, optional EncodedVideoChunkMetadata metadata = {} );

callback VideoFrameOutputCallback = undefined ( VideoFrame output );

callback WebCodecsErrorCallback = undefined ( DOMException error );

dictionary AudioDataCopyToOptions {
  [EnforceRange]
  required unsigned long planeIndex;
  AudioSampleFormat format;
  [EnforceRange]
  unsigned long frameCount;
  [EnforceRange]
  unsigned long frameOffset = 0;
};

dictionary AudioDataInit {
  required AudioSampleFormat format;
  required float sampleRate;
  [EnforceRange]
  required unsigned long numberOfFrames;
  [EnforceRange]
  required unsigned long numberOfChannels;
  [EnforceRange]
  required long long timestamp;
  required BufferSource data;
};

dictionary AudioDecoderConfig {
  required DOMString codec;
  [EnforceRange]
  required unsigned long sampleRate;
  [EnforceRange]
  required unsigned long numberOfChannels;
  BufferSource description;
};

dictionary AudioDecoderInit {
  required AudioDataOutputCallback output;
  required WebCodecsErrorCallback error;
};

dictionary AudioDecoderSupport {
  AudioDecoderConfig config;
  boolean supported;
};

dictionary AudioEncoderConfig {
  required DOMString codec;
  [EnforceRange]
  unsigned long long bitrate;
  [EnforceRange]
  unsigned long numberOfChannels;
  [EnforceRange]
  unsigned long sampleRate;
};

dictionary AudioEncoderInit {
  required EncodedAudioChunkOutputCallback output;
  required WebCodecsErrorCallback error;
};

dictionary AudioEncoderSupport {
  AudioEncoderConfig config;
  boolean supported;
};

dictionary EncodedAudioChunkInit {
  required EncodedAudioChunkType type;
  [EnforceRange]
  required long long timestamp;
  required BufferSource data;
  [EnforceRange]
  unsigned long long duration;
};

dictionary EncodedAudioChunkMetadata {
  AudioDecoderConfig decoderConfig;
};

dictionary EncodedVideoChunkInit {
  required EncodedVideoChunkType type;
  [EnforceRange]
  required long long timestamp;
  required BufferSource data;
  [EnforceRange]
  unsigned long long duration;
};

dictionary EncodedVideoChunkMetadata {
  BufferSource alphaSideData;
  VideoDecoderConfig decoderConfig;
  SvcOutputMetadata svc;
};

dictionary ImageDecodeOptions {
  boolean completeFramesOnly = true;
  [EnforceRange]
  unsigned long frameIndex = 0;
};

dictionary ImageDecodeResult {
  required VideoFrame image;
  required boolean complete;
};

dictionary ImageDecoderInit {
  required DOMString type;
  required ImageBufferSource data;
  ColorSpaceConversion colorSpaceConversion = "default";
  [EnforceRange]
  unsigned long desiredHeight;
  [EnforceRange]
  unsigned long desiredWidth;
  boolean preferAnimation;
  PremultiplyAlpha premultiplyAlpha = "default";
};

dictionary PlaneLayout {
  [EnforceRange]
  required unsigned long offset;
  [EnforceRange]
  required unsigned long stride;
};

dictionary SvcOutputMetadata {
  unsigned long temporalLayerId;
};

dictionary VideoColorSpaceInit {
  boolean fullRange;
  VideoMatrixCoefficients matrix;
  VideoColorPrimaries primaries;
  VideoTransferCharacteristics transfer;
};

dictionary VideoDecoderConfig {
  required DOMString codec;
  [EnforceRange]
  unsigned long codedHeight;
  [EnforceRange]
  unsigned long codedWidth;
  VideoColorSpaceInit colorSpace;
  BufferSource description;
  [EnforceRange]
  unsigned long displayAspectHeight;
  [EnforceRange]
  unsigned long displayAspectWidth;
  HardwareAcceleration hardwareAcceleration = "no-preference";
  boolean optimizeForLatency;
};

dictionary VideoDecoderInit {
  required VideoFrameOutputCallback output;
  required WebCodecsErrorCallback error;
};

dictionary VideoDecoderSupport {
  VideoDecoderConfig config;
  boolean supported;
};

dictionary VideoEncoderConfig {
  required DOMString codec;
  [EnforceRange]
  required unsigned long width;
  [EnforceRange]
  required unsigned long height;
  AlphaOption alpha = "discard";
  [EnforceRange]
  unsigned long long bitrate;
  BitrateMode bitrateMode = "variable";
  [EnforceRange]
  unsigned long displayHeight;
  [EnforceRange]
  unsigned long displayWidth;
  [EnforceRange]
  double framerate;
  HardwareAcceleration hardwareAcceleration = "no-preference";
  LatencyMode latencyMode = "quality";
  DOMString scalabilityMode;
};

dictionary VideoEncoderEncodeOptions {
  boolean keyFrame = false;
};

dictionary VideoEncoderInit {
  required EncodedVideoChunkOutputCallback output;
  required WebCodecsErrorCallback error;
};

dictionary VideoEncoderSupport {
  VideoEncoderConfig config;
  boolean supported;
};

dictionary VideoFrameBufferInit {
  required VideoPixelFormat format;
  required [EnforceRange] unsigned long codedWidth;
  required [EnforceRange] unsigned long codedHeight;
  required [EnforceRange] long long timestamp;
  VideoColorSpaceInit colorSpace;
  [EnforceRange]
  unsigned long displayHeight;
  [EnforceRange]
  unsigned long displayWidth;
  [EnforceRange]
  unsigned long long duration;
  sequence<PlaneLayout> layout;
  DOMRectInit visibleRect;
};

dictionary VideoFrameCopyToOptions {
  sequence<PlaneLayout> layout;
  DOMRectInit rect;
};

dictionary VideoFrameInit {
  AlphaOption alpha = "keep";
  [EnforceRange]
  unsigned long displayHeight;
  [EnforceRange]
  unsigned long displayWidth;
  unsigned long long duration;
  long long timestamp;
  DOMRectInit visibleRect;
};

[Exposed=(Window,DedicatedWorker), Serializable, Transferable]
interface AudioData {
  readonly attribute unsigned long long duration;
  readonly attribute AudioSampleFormat? format;
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

[Exposed=(Window,DedicatedWorker), SecureContext]
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

[Exposed=(Window,DedicatedWorker), SecureContext]
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
  readonly attribute unsigned long long? duration;
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

[Exposed=(Window,DedicatedWorker), SecureContext]
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
interface VideoColorSpace {
  readonly attribute boolean? fullRange;
  readonly attribute VideoMatrixCoefficients? matrix;
  readonly attribute VideoColorPrimaries? primaries;
  readonly attribute VideoTransferCharacteristics? transfer;
  constructor( optional VideoColorSpaceInit init = {} );
  [Default]
  VideoColorSpaceInit toJSON();
};

[Exposed=(Window,DedicatedWorker), SecureContext]
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

[Exposed=(Window,DedicatedWorker), SecureContext]
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

[Exposed=(Window,DedicatedWorker), Serializable, Transferable]
interface VideoFrame {
  readonly attribute unsigned long codedHeight;
  readonly attribute DOMRectReadOnly? codedRect;
  readonly attribute unsigned long codedWidth;
  readonly attribute VideoColorSpace colorSpace;
  readonly attribute unsigned long displayHeight;
  readonly attribute unsigned long displayWidth;
  readonly attribute unsigned long long? duration;
  readonly attribute VideoPixelFormat? format;
  readonly attribute long long? timestamp;
  readonly attribute DOMRectReadOnly? visibleRect;
  constructor( CanvasImageSource image, optional VideoFrameInit init = {} );
  constructor( [AllowShared] BufferSource data, VideoFrameBufferInit init );
  unsigned long allocationSize( optional VideoFrameCopyToOptions options = {} );
  VideoFrame clone();
  undefined close();
  Promise<sequence<PlaneLayout>> copyTo( [AllowShared] BufferSource destination, optional VideoFrameCopyToOptions options = {} );
};
