enum MyEnumA {
  "a",
  "b"
};

enum MyEnumB {
  "p",
  "q"
};

enum MyEnumC {
  "r",
  "s"
};

typedef ( RenderingContextA or RenderingContextP ) RenderingContext;

typedef long XRint;

typedef short XRint16;

[Exposed=(Window,Worker,Worklet)]
namespace NamespaceA {
  Promise<Module> methodA( BufferSource bytes );
  boolean methodB( BufferSource bytes );
};

namespace NamespaceB {
  void methodP( BufferSource? data );
  void methodQ( boolean flag );
};

namespace NamespaceC {
  void methodR( BufferSource? data );
  void methodS( boolean flag );
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

partial namespace PartialNamespaceC {
  void methodR( BufferSource? data );
  void methodS( boolean flag );
};

callback CallbackA = HTMLElement ();

callback CallbackB = DOMString ();

callback CallbackC = DOMString ();

callback interface MyEventListenerA {
  const unsigned short MYCONST_A = 7;
  const unsigned short MYCONST_B = 8;
  void handleEvent( Event event );
};

callback interface MyEventListenerB {
  const unsigned short MYCONST_P = 7;
  const unsigned short MYCONST_Q = 8;
  void doStuff( Event event );
};

callback interface MyEventListenerC {
  const unsigned short MYCONST_R = 7;
  const unsigned short MYCONST_S = 8;
  void handleIt( Event event );
};

dictionary MyDictionaryA : EventInit {
  USVString a = "";
  USVString b = "";
};

dictionary MyDictionaryB {
  USVString p = "";
  USVString q = "";
};

dictionary MyDictionaryC {
  USVString r = "";
  USVString s = "";
};

partial dictionary MyPartialDictionaryA {
  USVString a = "";
  USVString b = "";
};

partial dictionary MyPartialDictionaryB {
  USVString p = "";
  USVString q = "";
};

partial dictionary MyPartialDictionaryC {
  USVString r = "";
  USVString s = "";
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

interface mixin MyMixinC {
  const unsigned short MYCONST_R = 7;
  const unsigned short MYCONST_S = 8;
  [SameObject, B]
  readonly attribute SVGPointList r;
  readonly attribute SVGPointList s;
  [CEReactions]
  boolean myMethodR();
  boolean myMethodS();
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

partial interface mixin MyPartialMixinC {
  const unsigned short MYCONST_R = 7;
  const unsigned short MYCONST_S = 8;
  [SameObject]
  readonly attribute SVGPointList r;
  [SameObject]
  readonly attribute SVGPointList s;
  [CEReactions]
  boolean myMethodR();
  boolean myMethodS();
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

[Exposed=(Window,Worker)]
interface MyInterfaceC : Event {
  const unsigned short MYCONST_R = 7;
  const unsigned short MYCONST_S = 8;
  readonly attribute any r;
  readonly attribute any s;
  [CEReactions]
  boolean myMethodR();
  boolean myMethodS();
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

partial interface MyPartialInterfaceC {
  const unsigned short MYCONST_R = 7;
  const unsigned short MYCONST_S = 8;
  readonly attribute any r;
  readonly attribute any s;
  [CEReactions]
  boolean myMethodR();
  boolean myMethodS();
};

MyElementA includes MyElementB;

MyElementB includes MyElementP;

MyElementC includes MyElementR;
