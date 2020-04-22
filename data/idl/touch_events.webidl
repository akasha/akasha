enum TouchType {
  "direct",
  "stylus"
};

dictionary TouchEventInit : EventModifierInit {
  sequence<Touch> changedTouches = [];
  sequence<Touch> targetTouches = [];
  sequence<Touch> touches = [];
};

dictionary TouchInit {
  double altitudeAngle = 0;
  double azimuthAngle = 0;
  double clientX = 0;
  double clientY = 0;
  float force = 0;
  required long identifier;
  double pageX = 0;
  double pageY = 0;
  float radiusX = 0;
  float radiusY = 0;
  float rotationAngle = 0;
  double screenX = 0;
  double screenY = 0;
  required EventTarget target;
  TouchType touchType = "direct";
};

partial interface mixin GlobalEventHandlers {
  attribute EventHandler ontouchcancel;
  attribute EventHandler ontouchend;
  attribute EventHandler ontouchmove;
  attribute EventHandler ontouchstart;
};

[Exposed=Window]
interface TouchList {
  readonly attribute unsigned long length;
  getter Touch? item( unsigned long index );
};

[Exposed=Window]
interface TouchEvent : UIEvent {
  readonly attribute boolean altKey;
  readonly attribute TouchList changedTouches;
  readonly attribute boolean ctrlKey;
  readonly attribute boolean metaKey;
  readonly attribute boolean shiftKey;
  readonly attribute TouchList targetTouches;
  readonly attribute TouchList touches;
  constructor( DOMString type, optional TouchEventInit eventInitDict = {} );
};

[Exposed=Window]
interface Touch {
  readonly attribute float altitudeAngle;
  readonly attribute float azimuthAngle;
  readonly attribute double clientX;
  readonly attribute double clientY;
  readonly attribute float force;
  readonly attribute long identifier;
  readonly attribute double pageX;
  readonly attribute double pageY;
  readonly attribute float radiusX;
  readonly attribute float radiusY;
  readonly attribute float rotationAngle;
  readonly attribute double screenX;
  readonly attribute double screenY;
  readonly attribute EventTarget target;
  readonly attribute TouchType touchType;
  constructor( TouchInit touchInitDict );
};
