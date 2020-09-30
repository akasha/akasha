[Exposed=(Window,Worker,Worklet)]
namespace NamespaceA {
  readonly attribute DOMString sharedVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  undefined sharedMethod();
  [Exposed=Worker]
  undefined workerMethod();
};

namespace NamespaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

namespace NamespaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
};

[Exposed=(Window,Worker)]
partial namespace PartialNamespaceA {
  readonly attribute DOMString sharedVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  undefined sharedMethod();
  [Exposed=Worker]
  undefined workerMethod();
};

partial namespace PartialNamespaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

partial namespace PartialNamespaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
  undefined sharedMethod();
  [Exposed=Worker]
  undefined workerMethod();
};
