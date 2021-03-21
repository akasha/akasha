callback CallbackA = void ();
callback CallbackB = void ();
callback CallbackC = void ();

callback interface CallbackInterfaceA { void handleEvent(Event event); };
callback interface CallbackInterfaceB { void handleEvent(Event event); };
callback interface CallbackInterfaceC { void handleEvent(Event event); };

enum EnumerationA { "A" };
enum EnumerationB { "A" };
enum EnumerationC { "A" };

dictionary DictionaryA {};
dictionary DictionaryB {};
dictionary DictionaryC {};

interface InterfaceA {};
interface InterfaceB {};
interface InterfaceC {};

const enum ConstEnumerationA { EnumContainer.A };
const enum ConstEnumerationB { EnumContainer.A };
const enum ConstEnumerationC { EnumContainer.A };

interface EnumContainer {
  const unsigned short A = 4;
};

typedef long long CallbackA;
typedef long long CallbackInterfaceA;
typedef long long EnumerationA;
typedef long long DictionaryA;
typedef long long InterfaceA;
typedef long long ConstEnumerationA;
