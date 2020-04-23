enum MyEnumA {
  "a",
  "b"
};

enum MyEnumB {
  "p",
  "q"
};

dictionary MyDictionaryA : EventInit {
  USVString a = "";
  USVString b = "";
};

dictionary MyDictionaryB {
  USVString p = "";
  USVString q = "";
};


partial dictionary MyPartialDictionaryA {
  USVString a = "";
  USVString b = "";
};

partial dictionary MyPartialDictionaryB {
  USVString p = "";
  USVString q = "";
};

[Exposed=Window, Constructor( DOMString type, optional PopStateEventInit eventInitDict = {} )]
interface MyInterfaceA : Event {
  readonly attribute any a;
  readonly attribute any b;

  [CEReactions]
  boolean myMethodA();
  boolean myMethodB();
};

[Exposed=(Window,Worker)]
interface MyInterfaceB : Event {
  const unsigned short MYCONST_A = 7;
  const unsigned short MYCONST_B = 8;

  readonly attribute any a;
  readonly attribute any b;

  [CEReactions]
  boolean myMethodP();
  boolean myMethodQ();
};


partial interface MyPartialInterfaceA {
  readonly attribute any a;
  readonly attribute any b;

  [CEReactions]
  boolean myMethodA();
  boolean myMethodB();
};

partial interface MyPartialInterfaceB {
  const unsigned short MYCONST_A = 7;
  const unsigned short MYCONST_B = 8;

  readonly attribute any a;
  readonly attribute any b;

  [CEReactions]
  boolean myMethodP();
  boolean myMethodQ();
};

callback CallbackA = HTMLElement ();

callback CallbackB = DOMString ();

[Exposed=(Window,Worker,Worklet)]
namespace NamespaceA {
  Promise<Module> methodA( BufferSource bytes );
  boolean methodB( BufferSource bytes );
};

namespace NamespaceB {
  void methodP( BufferSource? data );
  void methodQ( boolean flag );
};

[Exposed=(Window,Worker,Worklet)]
partial namespace PartialNamespaceA {
  Promise<Module> methodA( BufferSource bytes );
  boolean methodB( BufferSource bytes );
};

partial namespace PartialNamespaceB {
  void methodP( BufferSource? data );
  void methodQ( boolean flag );
};

callback interface MyEventListenerA {
  const unsigned short MYCONST_A = 7;
  const unsigned short MYCONST_B = 8;

  void handleEvent(Event event);
};

callback interface MyEventListenerB {
  const unsigned short MYCONST_P = 7;
  const unsigned short MYCONST_Q = 8;

  void doStuff(Event event);
};

interface mixin MyMixinA {
  const unsigned short MYCONST_A = 7;
  const unsigned short MYCONST_B = 8;

  [SameObject, A, Input1]
  readonly attribute SVGPointList a;
  [SameObject]
  readonly attribute SVGPointList b;

  [CEReactions]
  boolean myMethodA();
  boolean myMethodB();
};

interface mixin MyMixinB {
  const unsigned short MYCONST_P = 7;
  const unsigned short MYCONST_Q = 8;

  [SameObject, B]
  readonly attribute SVGPointList a;
  [SameObject]
  readonly attribute SVGPointList c;

  [CEReactions]
  boolean myMethodA();
  boolean myMethodB();
};


partial interface mixin MyPartialMixinA {
  const unsigned short MYCONST_A = 7;
  const unsigned short MYCONST_B = 8;

  [SameObject, A, Input1]
  readonly attribute SVGPointList a;
  [SameObject]
  readonly attribute SVGPointList b;

  [CEReactions]
  boolean myMethodA();
  boolean myMethodB();
};

partial interface mixin MyPartialMixinB {
  const unsigned short MYCONST_P = 7;
  const unsigned short MYCONST_Q = 8;

  [SameObject, B]
  readonly attribute SVGPointList a;
  [SameObject]
  readonly attribute SVGPointList c;

  [CEReactions]
  boolean myMethodA();
  boolean myMethodB();
};

MyElementA includes MyElementB;

MyElementB includes MyElementP;

typedef ( RenderingContextA or RenderingContextP ) RenderingContext;

typedef long XRint;
