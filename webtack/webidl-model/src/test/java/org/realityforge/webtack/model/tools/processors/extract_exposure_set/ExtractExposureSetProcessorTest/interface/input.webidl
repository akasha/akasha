[Exposed=(Window,Worker,Worklet)]
interface InterfaceA {
  const unsigned short VAL_SHARED = 7;
  [Exposed=Window]
  const unsigned short VAL_WINDOW = 7;
  [Exposed=Worker]
  const unsigned short VAL_WORKER = 7;
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
interface InterfaceB {
  readonly attribute DOMString v1;
  undefined myMethod();
};

interface InterfaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

interface InterfaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
};

[Exposed=(Window,Worker)]
partial interface PartialInterfaceA {
  const unsigned short VAL_SHARED = 7;
  [Exposed=Window]
  const unsigned short VAL_WINDOW = 7;
  [Exposed=Worker]
  const unsigned short VAL_WORKER = 7;
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
partial interface PartialInterfaceB {
  readonly attribute DOMString v1;
  undefined myMethod();
};

partial interface PartialInterfaceC {
  readonly attribute DOMString v1;
  undefined myMethod();
};

partial interface PartialInterfaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
  undefined sharedMethod();
  [Exposed=Window]
  undefined windowMethod();
  [Exposed=Worker]
  undefined workerMethod();
};
