namespace NamespaceC {
  readonly attribute DOMString v1;
  void myMethod();
};

namespace NamespaceD {
};

partial namespace PartialNamespaceC {
  readonly attribute DOMString v1;
  void myMethod();
};

partial namespace PartialNamespaceD {
  void sharedMethod();
};
