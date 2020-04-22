enum VideoResizeModeEnum {
  "crop-and-scale",
  "none"
};

enum VideoFacingModeEnum {
  "environment",
  "left",
  "right",
  "user"
};

enum MediaStreamTrackState {
  "ended",
  "live"
};

enum MediaDeviceKind {
  "audioinput",
  "audiooutput",
  "videoinput"
};

typedef ( double or ConstrainDoubleRange ) ConstrainDouble;

typedef ( DOMString or sequence<DOMString> or ConstrainDOMStringParameters ) ConstrainDOMString;

typedef object MediaStreamError;

typedef ( boolean or ConstrainBooleanParameters ) ConstrainBoolean;

typedef ( [Clamp] unsigned long or ConstrainULongRange ) ConstrainULong;

callback NavigatorUserMediaSuccessCallback = void ( MediaStream stream );

callback NavigatorUserMediaErrorCallback = void ( MediaStreamError error );

dictionary ConstrainDOMStringParameters {
  ( DOMString or sequence<DOMString> ) exact;
  ( DOMString or sequence<DOMString> ) ideal;
};

dictionary MediaTrackConstraintSet {
  ConstrainDouble aspectRatio;
  ConstrainBoolean autoGainControl;
  ConstrainULong channelCount;
  ConstrainDOMString deviceId;
  ConstrainBoolean echoCancellation;
  ConstrainDOMString facingMode;
  ConstrainDouble frameRate;
  ConstrainDOMString groupId;
  ConstrainULong height;
  ConstrainDouble latency;
  ConstrainBoolean noiseSuppression;
  ConstrainDOMString resizeMode;
  ConstrainULong sampleRate;
  ConstrainULong sampleSize;
  ConstrainULong width;
};

dictionary MediaTrackSettings {
  double aspectRatio;
  boolean autoGainControl;
  long channelCount;
  DOMString deviceId;
  boolean echoCancellation;
  DOMString facingMode;
  double frameRate;
  DOMString groupId;
  long height;
  double latency;
  boolean noiseSuppression;
  DOMString resizeMode;
  long sampleRate;
  long sampleSize;
  long width;
};

dictionary MediaTrackConstraints : MediaTrackConstraintSet {
  sequence<MediaTrackConstraintSet> advanced;
};

dictionary MediaStreamTrackEventInit : EventInit {
  required MediaStreamTrack track;
};

dictionary ConstrainULongRange : ULongRange {
  [Clamp]
  unsigned long exact;
  [Clamp]
  unsigned long ideal;
};

dictionary ConstraintSet {
};

dictionary MediaTrackCapabilities {
  DoubleRange aspectRatio;
  sequence<boolean> autoGainControl;
  ULongRange channelCount;
  DOMString deviceId;
  sequence<boolean> echoCancellation;
  sequence<DOMString> facingMode;
  DoubleRange frameRate;
  DOMString groupId;
  ULongRange height;
  DoubleRange latency;
  sequence<boolean> noiseSuppression;
  sequence<DOMString> resizeMode;
  ULongRange sampleRate;
  ULongRange sampleSize;
  ULongRange width;
};

dictionary MediaStreamConstraints {
  ( boolean or MediaTrackConstraints ) audio = false;
  ( boolean or MediaTrackConstraints ) video = false;
};

dictionary DoubleRange {
  double max;
  double min;
};

dictionary Constraints : ConstraintSet {
  sequence<ConstraintSet> advanced;
};

dictionary MediaTrackSupportedConstraints {
  boolean aspectRatio = true;
  boolean autoGainControl = true;
  boolean channelCount = true;
  boolean deviceId = true;
  boolean echoCancellation = true;
  boolean facingMode = true;
  boolean frameRate = true;
  boolean groupId = true;
  boolean height = true;
  boolean latency = true;
  boolean noiseSuppression = true;
  boolean resizeMode = true;
  boolean sampleRate = true;
  boolean sampleSize = true;
  boolean width = true;
};

dictionary ConstrainDoubleRange : DoubleRange {
  double exact;
  double ideal;
};

dictionary Capabilities {
};

dictionary ConstrainBooleanParameters {
  boolean exact;
  boolean ideal;
};

dictionary ULongRange {
  [Clamp]
  unsigned long max;
  [Clamp]
  unsigned long min;
};

dictionary Settings {
};

[Exposed=Window]
interface InputDeviceInfo : MediaDeviceInfo {
  MediaTrackCapabilities getCapabilities();
};

[Exposed=Window]
interface MediaStreamTrackEvent : Event {
  [SameObject]
  readonly attribute MediaStreamTrack track;
  constructor( DOMString type, MediaStreamTrackEventInit eventInitDict );
};

[Exposed=Window]
interface MediaStream : EventTarget {
  readonly attribute boolean active;
  readonly attribute DOMString id;
  attribute EventHandler onaddtrack;
  attribute EventHandler onremovetrack;
  constructor();
  constructor( MediaStream stream );
  constructor( sequence<MediaStreamTrack> tracks );
  void addTrack( MediaStreamTrack track );
  MediaStream clone();
  sequence<MediaStreamTrack> getAudioTracks();
  MediaStreamTrack? getTrackById( DOMString trackId );
  sequence<MediaStreamTrack> getTracks();
  sequence<MediaStreamTrack> getVideoTracks();
  void removeTrack( MediaStreamTrack track );
};

[Exposed=Window, SecureContext]
interface MediaDevices : EventTarget {
  attribute EventHandler ondevicechange;
  Promise<sequence<MediaDeviceInfo>> enumerateDevices();
};

[Exposed=Window, SecureContext]
interface MediaDeviceInfo {
  readonly attribute DOMString deviceId;
  readonly attribute DOMString groupId;
  readonly attribute MediaDeviceKind kind;
  readonly attribute DOMString label;
  [Default]
  object toJSON();
};

[Exposed=Window]
interface MediaStreamTrack : EventTarget {
  readonly attribute DOMString id;
  readonly attribute DOMString kind;
  readonly attribute DOMString label;
  readonly attribute boolean muted;
  readonly attribute MediaStreamTrackState readyState;
  attribute boolean enabled;
  attribute EventHandler onended;
  attribute EventHandler onmute;
  attribute EventHandler onunmute;
  Promise<void> applyConstraints( optional MediaTrackConstraints constraints = {} );
  MediaStreamTrack clone();
  MediaTrackCapabilities getCapabilities();
  MediaTrackConstraints getConstraints();
  MediaTrackSettings getSettings();
  void stop();
};

partial interface Navigator {
  [SameObject, SecureContext]
  readonly attribute MediaDevices mediaDevices;
};

partial interface Navigator {
  [SecureContext]
  void getUserMedia( MediaStreamConstraints constraints, NavigatorUserMediaSuccessCallback successCallback, NavigatorUserMediaErrorCallback errorCallback );
};

partial interface MediaDevices {
  MediaTrackSupportedConstraints getSupportedConstraints();
  Promise<MediaStream> getUserMedia( optional MediaStreamConstraints constraints = {} );
};
