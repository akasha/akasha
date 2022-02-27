partial dictionary MouseEventInit {
  double movementX = 0;
  double movementY = 0;
};

partial interface mixin DocumentOrShadowRoot {
  readonly attribute Element? pointerLockElement;
};

partial interface Document {
  attribute EventHandler onpointerlockchange;
  attribute EventHandler onpointerlockerror;
  undefined exitPointerLock();
};

partial interface Element {
  undefined requestPointerLock();
};

partial interface MouseEvent {
  readonly attribute double movementX;
  readonly attribute double movementY;
};
