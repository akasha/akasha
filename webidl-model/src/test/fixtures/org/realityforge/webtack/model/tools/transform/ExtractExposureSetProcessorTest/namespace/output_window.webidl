[Exposed=(Window,Worker,Worklet)]
namespace NamespaceA {
  readonly attribute DOMString sharedVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  void sharedMethod();
  [Exposed=Window]
  void windowMethod();
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
};

[Exposed=(Window,Worker)]
partial namespace PartialNamespaceA {
  readonly attribute DOMString sharedVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  void sharedMethod();
  [Exposed=Window]
  void windowMethod();
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
  void sharedMethod();
  [Exposed=Window]
  void windowMethod();
};
