[Exposed=(Window,Worker,Worklet)]
namespace NamespaceA {
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  readonly attribute DOMString sharedVar;
  [Exposed=Worker]
  void workerMethod();
  [Exposed=Window]
  void windowMethod();
  void sharedMethod();
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
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  readonly attribute DOMString sharedVar;
  [Exposed=Worker]
  void workerMethod();
  [Exposed=Window]
  void windowMethod();
  void sharedMethod();
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
  [Exposed=Worker]
  void workerMethod();
  [Exposed=Window]
  void windowMethod();
  void sharedMethod();
};

