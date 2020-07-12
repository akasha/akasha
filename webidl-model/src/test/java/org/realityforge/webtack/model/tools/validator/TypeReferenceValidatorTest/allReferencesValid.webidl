callback BasicCallback = void ();

callback interface BasicCallbackInterface { void myCallback(); };

enum BasicEnumeration { "A" };

dictionary BasicDictionary {};

interface BasicInterface {};

typedef long long BasicTypeDef;

// The above are just used for testing the types below

typedef BasicTypeDef TypeDefA;
typedef BasicCallback TypeDefB;
typedef BasicCallbackInterface TypeDefC;
typedef BasicEnumeration TypeDefD;
typedef BasicDictionary TypeDefE;
typedef BasicInterface TypeDefF;
typedef sequence<sequence<sequence<BasicTypeDef>>> TypeDefG;
typedef record<ByteString, BasicTypeDef> TypeDefH;
typedef FrozenArray<BasicTypeDef> TypeDefI;

callback CallbackUnderTest = BasicTypeDef (
  sequence<BasicTypeDef> arg1,
  BasicDictionary arg2,
  BasicCallback arg3,
  BasicCallbackInterface arg4,
  record<ByteString, BasicCallbackInterface> arg5,
  ( sequence<sequence<BasicTypeDef>> or record<ByteString, BasicTypeDef> ) arg6,
  FrozenArray<BasicTypeDef> arg7,
  Promise<sequence<BasicTypeDef>> arg8
);

callback interface CallbackInterfaceUnderTest {
  const BasicTypeDef CONST_A = 3;

  BasicInterface myCallback();
};

dictionary DictionaryUnderTest {
  sequence<BasicDictionary> changedTouches = [];
  sequence<BasicTypeDef> targetTouches = [];
  sequence<BasicTypeDef> touches = [];
};

partial dictionary DictionaryUnderTest {
  sequence<BasicEnumeration> enums;
};

namespace NamespaceUnderTest {
  readonly attribute Promise<BasicEnumeration> enumResolver;
  BasicTypeDef doStuff(Promise<sequence<BasicTypeDef>> arg);
};

partial namespace NamespaceUnderTest {
  readonly attribute Promise<BasicEnumeration> enumResolver2;
  BasicTypeDef doStuff2(Promise<sequence<BasicTypeDef>> arg);
};

interface mixin MixinUnderTest {
  const BasicTypeDef CONST_A = 3;

  readonly attribute BasicEnumeration enumvalue;

  BasicTypeDef doStuff(Promise<sequence<BasicTypeDef>> arg);
};

partial interface mixin MixinUnderTest {
  const BasicTypeDef CONST_A2 = 3;

  readonly attribute BasicEnumeration enumvalue2;

  BasicTypeDef doStuff2(Promise<sequence<BasicTypeDef>> arg);
};

interface InterfaceUnderTest {
  const BasicTypeDef CONST_A = 3;

  readonly attribute BasicEnumeration enumvalue;

  BasicTypeDef doStuff(Promise<sequence<BasicTypeDef>> arg);
};

partial interface InterfaceUnderTest {
  const BasicTypeDef CONST_A2 = 3;

  readonly attribute BasicEnumeration enumvalue2;

  BasicTypeDef doStuff2(Promise<sequence<BasicTypeDef>> arg);
};
