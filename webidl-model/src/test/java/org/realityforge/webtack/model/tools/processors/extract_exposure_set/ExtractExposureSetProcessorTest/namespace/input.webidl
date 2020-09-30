[Exposed=(Window,Worker,Worklet)]
namespace NamespaceA {
  readonly attribute DOMString sharedVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  undefined sharedMethod();
  [Exposed=Window]
  undefined windowMethod();
  [Exposed=Worker]
  undefined workerMethod();
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
  [Exposed=Worker]
  readonly attribute DOMString v1;
};

[Exposed=(Window,Worker)]
partial namespace PartialNamespaceA {
  readonly attribute DOMString sharedVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  undefined sharedMethod();
  [Exposed=Window]
  undefined windowMethod();
  [Exposed=Worker]
  undefined workerMethod();
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
  [Exposed=Worker]
  readonly attribute DOMString v1;
  undefined sharedMethod();
  [Exposed=Window]
  undefined windowMethod();
  [Exposed=Worker]
  undefined workerMethod();
};
