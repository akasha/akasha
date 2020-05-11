[Exposed=(Window,Worker,Worklet)]
interface InterfaceA {
  const unsigned short VAL_SHARED = 7;
  [Exposed=Worker]
  const unsigned short VAL_WORKER = 7;
  readonly attribute DOMString sharedVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  void sharedMethod();
  [Exposed=Worker]
  void workerMethod();
};

interface InterfaceC {
  readonly attribute DOMString v1;
  void myMethod();
};

interface InterfaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
};

[Exposed=(Window,Worker)]
partial interface PartialInterfaceA {
  const unsigned short VAL_SHARED = 7;
  [Exposed=Worker]
  const unsigned short VAL_WORKER = 7;
  readonly attribute DOMString sharedVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  void sharedMethod();
  [Exposed=Worker]
  void workerMethod();
};

partial interface PartialInterfaceC {
  readonly attribute DOMString v1;
  void myMethod();
};

partial interface PartialInterfaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
  void sharedMethod();
  [Exposed=Worker]
  void workerMethod();
};
