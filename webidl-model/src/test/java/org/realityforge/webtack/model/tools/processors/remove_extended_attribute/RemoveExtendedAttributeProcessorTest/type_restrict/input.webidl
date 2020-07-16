interface MyElementA {
  readonly attribute unsigned long charIndex;
};

[SomeRandomAttribute]
callback interface MyElementB {
  void handleEvent( Event event );
};

[SomeRandomAttribute, OtherAttr]
dictionary MyElementC {
  boolean once = false;
};

dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};
