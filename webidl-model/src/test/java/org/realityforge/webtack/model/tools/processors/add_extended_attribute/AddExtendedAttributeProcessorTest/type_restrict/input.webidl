callback interface MyElementB {
  void handleEvent( Event event );
};

dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

dictionary MyElementC {
  boolean once = false;
};

interface MyElementA {
  readonly attribute unsigned long charIndex;
};
