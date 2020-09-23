[JavaName=MyPermissionState]
enum PermissionState {
  "denied",
  "granted",
  "prompt"
};

[JavaName=StrOrNumberUnion]
typedef ( DOMString or double ) MyTypedefedUnion;

[JavaName=CascadingStyleSheeto]
namespace CSS {
  DOMString escape( DOMString ident );
};

[JavaName=IncomingEvent]
callback MyEventHandler = void ( Event event );

[JavaName=EventEar]
callback interface EventListener {
  void handleEvent( Event event );
};

[JavaName=EventOptions]
dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

[JavaName=MyEvent]
interface Event {
};
