namespace NamespaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

namespace NamespaceD {
};

partial namespace PartialNamespaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

partial namespace PartialNamespaceD {
  undefined sharedMethod();
};
