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

const enum ConstEnumerationA { EnumContainer.A };
const enum ConstEnumerationB { EnumContainer.A };
const enum ConstEnumerationC { EnumContainer.A };

interface EnumContainer {
  const unsigned short A = 4;
};

interface CallbackA {};
interface CallbackInterfaceA {};
interface EnumerationA {};
interface DictionaryA {};
interface TypedefA {};
interface ConstEnumerationA {};

typedef long long TypedefA;
typedef long long TypedefB;
typedef long long TypedefC;
