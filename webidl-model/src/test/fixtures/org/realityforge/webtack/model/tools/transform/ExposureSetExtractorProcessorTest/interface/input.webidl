[Exposed=(Window,Worker,Worklet)]
interface InterfaceA {
  const unsigned short VAL_SHARED = 7;
  [Exposed=Worker]
  const unsigned short VAL_WORKER = 7;
  [Exposed=Window]
  const unsigned short VAL_WINDOW = 7;

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
interface InterfaceB {
  readonly attribute DOMString v1;
  void myMethod();
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
  [Exposed=Window]
  const unsigned short VAL_WINDOW = 7;

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
partial interface PartialInterfaceB {
  readonly attribute DOMString v1;
  void myMethod();
};

partial interface PartialInterfaceC {
  readonly attribute DOMString v1;
  void myMethod();
};

partial interface PartialInterfaceD {
  [Exposed=Worker]
  readonly attribute DOMString v1;
  [Exposed=Worker]
  void workerMethod();
  [Exposed=Window]
  void windowMethod();
  void sharedMethod();
};

