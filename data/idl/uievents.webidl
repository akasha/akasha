dictionary CompositionEventInit : UIEventInit {
  DOMString data = "";
};

dictionary EventModifierInit : UIEventInit {
  boolean altKey = false;
  boolean ctrlKey = false;
  boolean metaKey = false;
  boolean modifierAltGraph = false;
  boolean modifierCapsLock = false;
  boolean modifierFn = false;
  boolean modifierFnLock = false;
  boolean modifierHyper = false;
  boolean modifierNumLock = false;
  boolean modifierScrollLock = false;
  boolean modifierSuper = false;
  boolean modifierSymbol = false;
  boolean modifierSymbolLock = false;
  boolean shiftKey = false;
};

dictionary FocusEventInit : UIEventInit {
  EventTarget? relatedTarget = null;
};

dictionary InputEventInit : UIEventInit {
  DOMString? data = "";
  DOMString inputType = "";
  boolean isComposing = false;
};

dictionary KeyboardEventInit : EventModifierInit {
  DOMString code = "";
  boolean isComposing = false;
  DOMString key = "";
  unsigned long location = 0;
  boolean repeat = false;
};

dictionary MouseEventInit : EventModifierInit {
  short button = 0;
  unsigned short buttons = 0;
  long clientX = 0;
  long clientY = 0;
  EventTarget? relatedTarget = null;
  long screenX = 0;
  long screenY = 0;
};

dictionary UIEventInit : EventInit {
  long detail = 0;
  Window? view = null;
};

dictionary WheelEventInit : MouseEventInit {
  unsigned long deltaMode = 0;
  double deltaX = 0.0;
  double deltaY = 0.0;
  double deltaZ = 0.0;
};

[Exposed=Window]
interface CompositionEvent : UIEvent {
  readonly attribute DOMString data;
  constructor( DOMString type, optional CompositionEventInit eventInitDict = {} );
};

[Exposed=Window]
interface FocusEvent : UIEvent {
  readonly attribute EventTarget? relatedTarget;
  constructor( DOMString type, optional FocusEventInit eventInitDict = {} );
};

[Exposed=Window]
interface InputEvent : UIEvent {
  readonly attribute DOMString? data;
  readonly attribute DOMString inputType;
  readonly attribute boolean isComposing;
  constructor( DOMString type, optional InputEventInit eventInitDict = {} );
};

[Exposed=Window]
interface KeyboardEvent : UIEvent {
  const unsigned long DOM_KEY_LOCATION_LEFT = 0x01;
  const unsigned long DOM_KEY_LOCATION_NUMPAD = 0x03;
  const unsigned long DOM_KEY_LOCATION_RIGHT = 0x02;
  const unsigned long DOM_KEY_LOCATION_STANDARD = 0x00;
  readonly attribute boolean altKey;
  readonly attribute DOMString code;
  readonly attribute boolean ctrlKey;
  readonly attribute boolean isComposing;
  readonly attribute DOMString key;
  readonly attribute unsigned long location;
  readonly attribute boolean metaKey;
  readonly attribute boolean repeat;
  readonly attribute boolean shiftKey;
  constructor( DOMString type, optional KeyboardEventInit eventInitDict = {} );
  boolean getModifierState( DOMString keyArg );
};

[Exposed=Window]
interface MouseEvent : UIEvent {
  readonly attribute boolean altKey;
  readonly attribute short button;
  readonly attribute unsigned short buttons;
  readonly attribute long clientX;
  readonly attribute long clientY;
  readonly attribute boolean ctrlKey;
  readonly attribute boolean metaKey;
  readonly attribute EventTarget? relatedTarget;
  readonly attribute long screenX;
  readonly attribute long screenY;
  readonly attribute boolean shiftKey;
  constructor( DOMString type, optional MouseEventInit eventInitDict = {} );
  boolean getModifierState( DOMString keyArg );
};

[Exposed=Window]
interface UIEvent : Event {
  readonly attribute long detail;
  readonly attribute Window? view;
  constructor( DOMString type, optional UIEventInit eventInitDict = {} );
};

[Exposed=Window]
interface WheelEvent : MouseEvent {
  const unsigned long DOM_DELTA_LINE = 0x01;
  const unsigned long DOM_DELTA_PAGE = 0x02;
  const unsigned long DOM_DELTA_PIXEL = 0x00;
  readonly attribute unsigned long deltaMode;
  readonly attribute double deltaX;
  readonly attribute double deltaY;
  readonly attribute double deltaZ;
  constructor( DOMString type, optional WheelEventInit eventInitDict = {} );
};

partial interface KeyboardEvent {
  readonly attribute unsigned long charCode;
  readonly attribute unsigned long keyCode;
};

partial interface UIEvent {
  readonly attribute unsigned long which;
};
