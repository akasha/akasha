enum AnimationPlayState {
  "finished",
  "idle",
  "paused",
  "running"
};

enum CompositeOperation {
  "accumulate",
  "add",
  "replace"
};

enum CompositeOperationOrAuto {
  "accumulate",
  "add",
  "auto",
  "replace"
};

enum FillMode {
  "auto",
  "backwards",
  "both",
  "forwards",
  "none"
};

enum IterationCompositeOperation {
  "accumulate",
  "replace"
};

enum PlaybackDirection {
  "alternate",
  "alternate-reverse",
  "normal",
  "reverse"
};

dictionary AnimationPlaybackEventInit : EventInit {
  double? currentTime = null;
  double? timelineTime = null;
};

dictionary BaseComputedKeyframe {
  CompositeOperationOrAuto composite = "auto";
  double computedOffset;
  DOMString easing = "linear";
  double? offset = null;
};

dictionary BaseKeyframe {
  CompositeOperationOrAuto composite = "auto";
  DOMString easing = "linear";
  double? offset = null;
};

dictionary BasePropertyIndexedKeyframe {
  ( CompositeOperationOrAuto or sequence<CompositeOperationOrAuto> ) composite = [];
  ( DOMString or sequence<DOMString> ) easing = [];
  ( double? or sequence<double?> ) offset = [];
};

dictionary ComputedEffectTiming : EffectTiming {
  unrestricted double activeDuration;
  unrestricted double? currentIteration;
  unrestricted double endTime;
  double? localTime;
  double? progress;
};

dictionary DocumentTimelineOptions {
  DOMHighResTimeStamp originTime = 0;
};

dictionary EffectTiming {
  double delay = 0;
  PlaybackDirection direction = "normal";
  ( unrestricted double or DOMString ) duration = "auto";
  DOMString easing = "linear";
  double endDelay = 0;
  FillMode fill = "auto";
  double iterationStart = 0.0;
  unrestricted double iterations = 1.0;
};

dictionary KeyframeAnimationOptions : KeyframeEffectOptions {
  DOMString id = "";
};

dictionary KeyframeEffectOptions : EffectTiming {
  CompositeOperation composite = "replace";
  IterationCompositeOperation iterationComposite = "replace";
};

dictionary OptionalEffectTiming {
  double delay;
  PlaybackDirection direction;
  ( unrestricted double or DOMString ) duration;
  DOMString easing;
  double endDelay;
  FillMode fill;
  double iterationStart;
  unrestricted double iterations;
};

interface mixin Animatable {
  Animation animate( object? keyframes, optional ( unrestricted double or KeyframeAnimationOptions ) options );
  sequence<Animation> getAnimations();
};

[Exposed=Window, Constructor( optional AnimationEffect? effect = null, optional AnimationTimeline? timeline )]
interface Animation : EventTarget {
  readonly attribute Promise<Animation> finished;
  readonly attribute boolean pending;
  readonly attribute AnimationPlayState playState;
  readonly attribute Promise<Animation> ready;
  attribute double? currentTime;
  attribute AnimationEffect? effect;
  attribute DOMString id;
  attribute EventHandler oncancel;
  attribute EventHandler onfinish;
  attribute double playbackRate;
  attribute double? startTime;
  attribute AnimationTimeline? timeline;
  void cancel();
  void finish();
  void pause();
  void play();
  void reverse();
  void updatePlaybackRate( double playbackRate );
};

[Exposed=Window]
interface AnimationEffect {
  ComputedEffectTiming getComputedTiming();
  EffectTiming getTiming();
  void updateTiming( optional OptionalEffectTiming timing );
};

[Exposed=Window, Constructor( DOMString type, optional AnimationPlaybackEventInit eventInitDict )]
interface AnimationPlaybackEvent : Event {
  readonly attribute double? currentTime;
  readonly attribute double? timelineTime;
};

[Exposed=Window]
interface AnimationTimeline {
  readonly attribute double? currentTime;
};

[Exposed=Window, Constructor( optional DocumentTimelineOptions options )]
interface DocumentTimeline : AnimationTimeline {
};

[Exposed=Window, Constructor( ( Element or CSSPseudoElement )? target, object? keyframes, optional ( unrestricted double or KeyframeEffectOptions ) options ), Constructor( KeyframeEffect source )]
interface KeyframeEffect : AnimationEffect {
  attribute CompositeOperation composite;
  attribute IterationCompositeOperation iterationComposite;
  attribute ( Element or CSSPseudoElement )? target;
  sequence<object> getKeyframes();
  void setKeyframes( object? keyframes );
};

partial interface Document {
  readonly attribute DocumentTimeline timeline;
  sequence<Animation> getAnimations();
};

CSSPseudoElement includes Animatable;

Element includes Animatable;
