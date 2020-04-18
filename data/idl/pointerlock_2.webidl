partial interface Element {
  void requestPointerLock();
};

partial interface Document {
  attribute EventHandler onpointerlockchange;
  attribute EventHandler onpointerlockerror;
  void exitPointerLock();
};

partial interface mixin DocumentOrShadowRoot {
  readonly attribute Element ? pointerLockElement;
};

partial interface MouseEvent {
  readonly attribute long movementX;
  readonly attribute long movementY;
};

partial dictionary MouseEventInit {
  long movementX = 0;
  long movementY = 0;
};