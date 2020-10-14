const enum KeyboardEventLocation {
  KeyboardEvent.DOM_KEY_LOCATION_STANDARD,
  KeyboardEvent.DOM_KEY_LOCATION_LEFT,
  KeyboardEvent.DOM_KEY_LOCATION_RIGHT,
  KeyboardEvent.DOM_KEY_LOCATION_NUMPAD
};

partial interface KeyboardEvent {
  readonly attribute KeyboardEventLocation location;
};

const enum WheelEventDeltaMode {
  WheelEvent.DOM_DELTA_PIXEL,
  WheelEvent.DOM_DELTA_LINE,
  WheelEvent.DOM_DELTA_PAGE
};

partial interface WheelEvent {
  readonly attribute WheelEventDeltaMode deltaMode;
};
