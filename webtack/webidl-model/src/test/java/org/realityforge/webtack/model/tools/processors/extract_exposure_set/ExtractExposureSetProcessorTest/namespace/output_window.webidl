[Exposed=(Window,Worker,Worklet)]
namespace NamespaceA {
  readonly attribute DOMString sharedVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  undefined sharedMethod();
  [Exposed=Window]
  undefined windowMethod();
};

[Exposed=Window]
namespace NamespaceB {
  readonly attribute DOMString v1;
  undefined myMethod();
};

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

[Exposed=(Window,Worker)]
partial namespace PartialNamespaceA {
  readonly attribute DOMString sharedVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  undefined sharedMethod();
  [Exposed=Window]
  undefined windowMethod();
};

[Exposed=Window]
partial namespace PartialNamespaceB {
  readonly attribute DOMString v1;
  undefined myMethod();
};

partial namespace PartialNamespaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

partial namespace PartialNamespaceD {
  undefined sharedMethod();
  [Exposed=Window]
  undefined windowMethod();
};

[Exposed=*]
partial namespace PartialNamespaceE {
  readonly attribute DOMString sharedVar;
};
