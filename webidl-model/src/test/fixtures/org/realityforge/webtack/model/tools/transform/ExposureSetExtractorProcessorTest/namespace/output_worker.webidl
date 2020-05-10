[Exposed=(Window,Worker,Worklet)]
namespace NamespaceA {
  readonly attribute DOMString sharedVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  void sharedMethod();
  [Exposed=Worker]
  void workerMethod();
};

namespace NamespaceC {
  readonly attribute DOMString v1;
  void myMethod();
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
  void sharedMethod();
  [Exposed=Worker]
  void workerMethod();
};

partial namespace PartialNamespaceC {
  readonly attribute DOMString v1;
  void myMethod();
};

partial namespace PartialNamespaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
  void sharedMethod();
  [Exposed=Worker]
  void workerMethod();
};
