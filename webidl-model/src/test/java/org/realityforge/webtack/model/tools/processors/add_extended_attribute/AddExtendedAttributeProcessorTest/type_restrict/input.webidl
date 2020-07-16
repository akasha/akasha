interface MyElementA {
  readonly attribute unsigned long charIndex;
};

callback interface MyElementB {
  void handleEvent( Event event );
};

dictionary MyElementC {
  boolean once = false;
};

dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};
