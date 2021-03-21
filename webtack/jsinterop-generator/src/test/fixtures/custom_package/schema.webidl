[JavaSubPackage=myenumerations]
enum PermissionState {
  "denied",
  "granted",
  "prompt"
};

[JavaSubPackage=mytypedefs]
typedef ( DOMString or double ) MyTypedefedUnion;

[JavaSubPackage=mynamespaces]
namespace CSS {
  DOMString escape( DOMString ident );
};

[JavaSubPackage=mycallbacks]
callback MyEventHandler = undefined ( Event event );

[JavaSubPackage=mycallbackinterfaces]
callback interface EventListener {
  undefined handleEvent( Event event );
};

[JavaSubPackage=mydictionaries]
dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

[JavaSubPackage=myinterfaces]
interface Event {
};
