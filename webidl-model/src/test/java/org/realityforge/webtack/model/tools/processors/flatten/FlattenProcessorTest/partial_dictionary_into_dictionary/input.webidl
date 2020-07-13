dictionary MouseEventInit : EventModifierInit {
  short button = 0;
  unsigned short buttons = 0;
  long clientX = 0;
  long clientY = 0;
  EventTarget? relatedTarget = null;
  long screenX = 0;
  long screenY = 0;
};

partial dictionary MouseEventInit {
  double otherClientX = 0.0;
  double otherClientY = 0.0;
  double otherScreenX = 0.0;
  double otherScreenY = 0.0;
};

partial dictionary MouseEventInit {
  long movementX = 0;
  long movementY = 0;
};
