[Exposed=(Window,Worker,Worklet)]
interface InterfaceA {
  const unsigned short VAL_SHARED = 7;
  [Exposed=Window]
  const unsigned short VAL_WINDOW = 7;
  readonly attribute DOMString sharedVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  undefined sharedMethod();
  [Exposed=Window]
  undefined windowMethod();
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
};

[Exposed=(Window,Worker)]
partial interface PartialInterfaceA {
  const unsigned short VAL_SHARED = 7;
  [Exposed=Window]
  const unsigned short VAL_WINDOW = 7;
  readonly attribute DOMString sharedVar;
  [Exposed=Window]
  readonly attribute DOMString windowVar;
  undefined sharedMethod();
  [Exposed=Window]
  undefined windowMethod();
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
  undefined sharedMethod();
  [Exposed=Window]
  undefined windowMethod();
};
