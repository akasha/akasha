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
  double clientX = 0.0;
};
