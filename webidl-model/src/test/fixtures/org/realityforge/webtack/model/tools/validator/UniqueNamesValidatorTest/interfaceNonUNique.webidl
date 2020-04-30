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

interface CallbackA {};
interface CallbackInterfaceA {};
interface EnumerationA {};
interface DictionaryA {};
interface TypedefA {};

typedef long long TypedefA;
typedef long long TypedefB;
typedef long long TypedefC;