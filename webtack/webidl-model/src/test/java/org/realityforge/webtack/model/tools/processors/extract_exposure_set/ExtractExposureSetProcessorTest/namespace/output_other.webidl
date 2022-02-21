namespace NamespaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

namespace NamespaceD {
};

[Exposed=*]
namespace NamespaceE {
  readonly attribute DOMString sharedVar;
};

partial namespace PartialNamespaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

partial namespace PartialNamespaceD {
  undefined sharedMethod();
};

[Exposed=*]
partial namespace PartialNamespaceE {
  readonly attribute DOMString sharedVar;
};
