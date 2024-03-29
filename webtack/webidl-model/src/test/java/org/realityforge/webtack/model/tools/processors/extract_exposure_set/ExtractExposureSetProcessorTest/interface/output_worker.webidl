[Exposed=(Window,Worker,Worklet)]
interface InterfaceA {
  const unsigned short VAL_SHARED = 7;
  [Exposed=Worker]
  const unsigned short VAL_WORKER = 7;
  readonly attribute DOMString sharedVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  undefined sharedMethod();
  [Exposed=Worker]
  undefined workerMethod();
};

interface InterfaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

interface InterfaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
};

[Exposed=*]
interface MyGPU {
  readonly attribute DOMString version;
  undefined myMethod();
};

[Exposed=(Window,Worker)]
partial interface PartialInterfaceA {
  const unsigned short VAL_SHARED = 7;
  [Exposed=Worker]
  const unsigned short VAL_WORKER = 7;
  readonly attribute DOMString sharedVar;
  [Exposed=Worker]
  readonly attribute DOMString workerVar;
  undefined sharedMethod();
  [Exposed=Worker]
  undefined workerMethod();
};

partial interface PartialInterfaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

partial interface PartialInterfaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
  undefined sharedMethod();
  [Exposed=Worker]
  undefined workerMethod();
};
