interface InterfaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

interface InterfaceD {
};

[Exposed=*]
interface MyGPU {
  readonly attribute DOMString version;
  undefined myMethod();
};

partial interface PartialInterfaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

partial interface PartialInterfaceD {
  undefined sharedMethod();
};
