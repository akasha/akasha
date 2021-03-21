callback interface MyElementB {
  undefined handleEvent( Event event );
};

dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

[SomeRandomAttribute]
dictionary MyElementC {
  boolean once = false;
};

interface MyElementA {
  readonly attribute unsigned long charIndex;
};
