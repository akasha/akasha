interface InterfaceC {
  readonly attribute DOMString v1;
  void myMethod();
};

interface InterfaceD {
};

partial interface PartialInterfaceC {
  readonly attribute DOMString v1;
  void myMethod();
};

partial interface PartialInterfaceD {
  void sharedMethod();
};
