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
  DOMString? data = null;
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

partial dictionary KeyboardEventInit {
  unsigned long charCode = 0;
  unsigned long keyCode = 0;
};

partial dictionary UIEventInit {
  unsigned long which = 0;
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
interface MutationEvent : Event {
  const unsigned short ADDITION = 2;
  const unsigned short MODIFICATION = 1;
  const unsigned short REMOVAL = 3;
  readonly attribute unsigned short attrChange;
  readonly attribute DOMString attrName;
  readonly attribute DOMString newValue;
  readonly attribute DOMString prevValue;
  readonly attribute Node? relatedNode;
  undefined initMutationEvent( DOMString typeArg, optional boolean bubblesArg = false, optional boolean cancelableArg = false, optional Node? relatedNodeArg = null, optional DOMString prevValueArg = "", optional DOMString newValueArg = "", optional DOMString attrNameArg = "", optional unsigned short attrChangeArg = 0 );
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

partial interface CompositionEvent {
  undefined initCompositionEvent( DOMString typeArg, optional boolean bubblesArg = false, optional boolean cancelableArg = false, optional WindowProxy? viewArg = null, optional DOMString dataArg = "" );
};

partial interface KeyboardEvent {
  undefined initKeyboardEvent( DOMString typeArg, optional boolean bubblesArg = false, optional boolean cancelableArg = false, optional Window? viewArg = null, optional DOMString keyArg = "", optional unsigned long locationArg = 0, optional boolean ctrlKey = false, optional boolean altKey = false, optional boolean shiftKey = false, optional boolean metaKey = false );
};

partial interface KeyboardEvent {
  readonly attribute unsigned long charCode;
  readonly attribute unsigned long keyCode;
};

partial interface MouseEvent {
  undefined initMouseEvent( DOMString typeArg, optional boolean bubblesArg = false, optional boolean cancelableArg = false, optional Window? viewArg = null, optional long detailArg = 0, optional long screenXArg = 0, optional long screenYArg = 0, optional long clientXArg = 0, optional long clientYArg = 0, optional boolean ctrlKeyArg = false, optional boolean altKeyArg = false, optional boolean shiftKeyArg = false, optional boolean metaKeyArg = false, optional short buttonArg = 0, optional EventTarget? relatedTargetArg = null );
};

partial interface UIEvent {
  undefined initUIEvent( DOMString typeArg, optional boolean bubblesArg = false, optional boolean cancelableArg = false, optional Window? viewArg = null, optional long detailArg = 0 );
};

partial interface UIEvent {
  readonly attribute unsigned long which;
};
