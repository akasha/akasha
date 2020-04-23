enum MyEnumC {
  "r",
  "s"
};

enum MyEnumA {
  "a",
  "b"
};

enum MyEnumB {
  "p",
  "q"
};

typedef ( RenderingContextA or RenderingContextP ) RenderingContext;

typedef short XRint16;

typedef long XRint;

namespace NamespaceC {
  void methodR( BufferSource? data );
  void methodS( boolean flag );
};

namespace NamespaceB {
  void methodP( BufferSource? data );
  void methodQ( boolean flag );
};

[Exposed=(Window,Worker,Worklet)]
namespace NamespaceA {
  Promise<Module> methodA( BufferSource bytes );
  boolean methodB( BufferSource bytes );
};

callback CallbackC = DOMString ();

callback CallbackA = HTMLElement ();

callback CallbackB = DOMString ();

callback interface MyEventListenerC {
  const unsigned short MYCONST_R = 7;
  const unsigned short MYCONST_S = 8;
  void handleIt( Event event );
};

callback interface MyEventListenerB {
  const unsigned short MYCONST_P = 7;
  const unsigned short MYCONST_Q = 8;
  void doStuff( Event event );
};

callback interface MyEventListenerA {
  const unsigned short MYCONST_A = 7;
  const unsigned short MYCONST_B = 8;
  void handleEvent( Event event );
};

dictionary MyDictionaryB {
  USVString p = "";
  USVString q = "";
};

dictionary MyDictionaryC {
  USVString r = "";
  USVString s = "";
};

dictionary MyDictionaryA : EventInit {
  USVString a = "";
  USVString b = "";
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

[Exposed=Window, Constructor( DOMString type, optional PopStateEventInit eventInitDict = {} )]
interface MyInterfaceA : Event {
  readonly attribute any a;
  readonly attribute any b;
  [CEReactions]
  boolean myMethodA();
  boolean myMethodB();
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

MyElementA includes MyElementB;

MyElementB includes MyElementP;

MyElementC includes MyElementR;
