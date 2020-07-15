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

[Constructor( DOMString type, optional MouseEventInit eventInitDict ), Exposed=Window]
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
  boolean getModifierState( DOMString keyArg );
};

[Constructor( DOMString type, optional UIEventInit eventInitDict ), Exposed=Window]
interface UIEvent : Event {
  readonly attribute long detail;
  readonly attribute Window? view;
};
