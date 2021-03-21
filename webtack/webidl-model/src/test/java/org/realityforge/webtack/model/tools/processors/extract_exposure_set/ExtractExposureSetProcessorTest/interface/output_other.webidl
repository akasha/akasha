interface InterfaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

interface InterfaceD {
};

partial interface PartialInterfaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

partial interface PartialInterfaceD {
  undefined sharedMethod();
};
