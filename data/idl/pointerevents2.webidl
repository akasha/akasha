dictionary PointerEventInit : MouseEventInit {
  double height = 1;
  boolean isPrimary = false;
  long pointerId = 0;
  DOMString pointerType = "";
  float pressure = 0;
  float tangentialPressure = 0;
  long tiltX = 0;
  long tiltY = 0;
  long twist = 0;
  double width = 1;
};

partial interface mixin GlobalEventHandlers {
  attribute EventHandler ongotpointercapture;
  attribute EventHandler onlostpointercapture;
  attribute EventHandler onpointercancel;
  attribute EventHandler onpointerdown;
  attribute EventHandler onpointerenter;
  attribute EventHandler onpointerleave;
  attribute EventHandler onpointermove;
  attribute EventHandler onpointerout;
  attribute EventHandler onpointerover;
  attribute EventHandler onpointerup;
};

[Constructor( DOMString type, optional PointerEventInit eventInitDict ), Exposed=Window]
interface PointerEvent : MouseEvent {
  readonly attribute double height;
  readonly attribute boolean isPrimary;
  readonly attribute long pointerId;
  readonly attribute DOMString pointerType;
  readonly attribute float pressure;
  readonly attribute float tangentialPressure;
  readonly attribute long tiltX;
  readonly attribute long tiltY;
  readonly attribute long twist;
  readonly attribute double width;
};

partial interface Navigator {
  readonly attribute long maxTouchPoints;
};

partial interface Element {
  boolean hasPointerCapture( long pointerId );
  void releasePointerCapture( long pointerId );
  void setPointerCapture( long pointerId );
};
