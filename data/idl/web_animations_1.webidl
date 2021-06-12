enum AnimationPlayState {
  "finished",
  "idle",
  "paused",
  "running"
};

enum AnimationReplaceState {
  "active",
  "persisted",
  "removed"
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

enum PlaybackDirection {
  "alternate",
  "alternate-reverse",
  "normal",
  "reverse"
};

enum TimelinePhase {
  "active",
  "after",
  "before",
  "inactive"
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

dictionary GetAnimationsOptions {
  boolean subtree = false;
};

dictionary KeyframeAnimationOptions : KeyframeEffectOptions {
  DOMString id = "";
  AnimationTimeline? timeline;
};

dictionary KeyframeEffectOptions : EffectTiming {
  CompositeOperation composite = "replace";
  CSSOMString? pseudoElement = null;
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
  Animation animate( object? keyframes, optional ( unrestricted double or KeyframeAnimationOptions ) options = {} );
  sequence<Animation> getAnimations( optional GetAnimationsOptions options = {} );
};

partial interface mixin DocumentOrShadowRoot {
  sequence<Animation> getAnimations();
};

[Exposed=Window]
interface Animation : EventTarget {
  readonly attribute Promise<Animation> finished;
  readonly attribute boolean pending;
  readonly attribute AnimationPlayState playState;
  readonly attribute Promise<Animation> ready;
  readonly attribute AnimationReplaceState replaceState;
  attribute double? currentTime;
  attribute AnimationEffect? effect;
  attribute DOMString id;
  attribute EventHandler oncancel;
  attribute EventHandler onfinish;
  attribute EventHandler onremove;
  attribute double playbackRate;
  attribute double? startTime;
  attribute AnimationTimeline? timeline;
  constructor( optional AnimationEffect? effect = null, optional AnimationTimeline? timeline );
  undefined cancel();
  undefined commitStyles();
  undefined finish();
  undefined pause();
  undefined persist();
  undefined play();
  undefined reverse();
  undefined updatePlaybackRate( double playbackRate );
};

[Exposed=Window]
interface AnimationEffect {
  ComputedEffectTiming getComputedTiming();
  EffectTiming getTiming();
  undefined updateTiming( optional OptionalEffectTiming timing = {} );
};

[Exposed=Window]
interface AnimationPlaybackEvent : Event {
  readonly attribute double? currentTime;
  readonly attribute double? timelineTime;
  constructor( DOMString type, optional AnimationPlaybackEventInit eventInitDict = {} );
};

[Exposed=Window]
interface AnimationTimeline {
  readonly attribute double? currentTime;
  readonly attribute TimelinePhase phase;
};

[Exposed=Window]
interface DocumentTimeline : AnimationTimeline {
  constructor( optional DocumentTimelineOptions options = {} );
};

[Exposed=Window]
interface KeyframeEffect : AnimationEffect {
  attribute CompositeOperation composite;
  attribute CSSOMString? pseudoElement;
  attribute Element? target;
  constructor( Element? target, object? keyframes, optional ( unrestricted double or KeyframeEffectOptions ) options = {} );
  constructor( KeyframeEffect source );
  sequence<object> getKeyframes();
  undefined setKeyframes( object? keyframes );
};

partial interface Document {
  readonly attribute DocumentTimeline timeline;
};

Element includes Animatable;
