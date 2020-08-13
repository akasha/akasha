[Exposed=(Window,Worker,Worklet)]
namespace NamespaceA {
  readonly attribute DOMString sharedVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  void sharedMethod();
  [Exposed=Window]
  void windowMethod();
  [Exposed=Worker]
  void workerMethod();
};

[Exposed=Window]
namespace NamespaceB {
  readonly attribute DOMString v1;
  void myMethod();
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
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  void sharedMethod();
  [Exposed=Window]
  void windowMethod();
  [Exposed=Worker]
  void workerMethod();
};

[Exposed=Window]
partial namespace PartialNamespaceB {
  readonly attribute DOMString v1;
  void myMethod();
};

partial namespace PartialNamespaceC {
  readonly attribute DOMString v1;
  void myMethod();
};

partial namespace PartialNamespaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
  void sharedMethod();
  [Exposed=Window]
  void windowMethod();
  [Exposed=Worker]
  void workerMethod();
};
