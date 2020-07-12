enum MyEnumC {
  "r",
  "s"
};

dictionary MyDictionaryC {
  USVString r = "";
  USVString s = "";
};


partial dictionary MyPartialDictionaryC {
  USVString r = "";
  USVString s = "";
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

partial interface MyPartialInterfaceC {
  const unsigned short MYCONST_R = 7;
  const unsigned short MYCONST_S = 8;

  readonly attribute any r;
  readonly attribute any s;

  [CEReactions]
  boolean myMethodR();
  boolean myMethodS();
};

callback CallbackC = DOMString ();

namespace NamespaceC {
  void methodR( BufferSource? data );
  void methodS( boolean flag );
};

partial namespace PartialNamespaceC {
  void methodR( BufferSource? data );
  void methodS( boolean flag );
};

callback interface MyEventListenerC {
  const unsigned short MYCONST_R = 7;
  const unsigned short MYCONST_S = 8;

  void handleIt(Event event);
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

MyElementC includes MyElementR;

typedef short XRint16;
