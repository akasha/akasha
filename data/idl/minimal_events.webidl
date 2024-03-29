// A minimal set of types for the event system to be used in
// experiments and extracted from whatwg_dom

typedef double DOMHighResTimeStamp;

[LegacyTreatNonObjectAsNull]
callback EventHandlerNonNull = any ( Event event );

typedef EventHandlerNonNull? EventHandler;

dictionary AddEventListenerOptions : EventListenerOptions {
  boolean once = false;
  boolean passive = false;
};

dictionary EventListenerOptions {
  boolean capture = false;
};

dictionary EventInit {
  boolean bubbles = false;
  boolean cancelable = false;
  boolean composed = false;
};

const enum EventPhase {
  Event.NONE,
  Event.CAPTURING_PHASE,
  Event.AT_TARGET,
  Event.BUBBLING_PHASE
};

typedef ( boolean or DOMString or undefined ) ReturnValueType;

[Exposed=(Window,Worker,AudioWorklet)]
interface Event {
  const unsigned short AT_TARGET = 2;
  const unsigned short BUBBLING_PHASE = 3;
  const unsigned short CAPTURING_PHASE = 1;
  const unsigned short NONE = 0;
  readonly attribute boolean bubbles;
  readonly attribute boolean cancelable;
  readonly attribute boolean composed;
  readonly attribute EventTarget? currentTarget;
  readonly attribute boolean defaultPrevented;
  readonly attribute EventPhase eventPhase;
  [LegacyUnforgeable]
  readonly attribute boolean isTrusted;
  readonly attribute EventTarget? srcElement;
  readonly attribute EventTarget? target;
  readonly attribute DOMHighResTimeStamp timeStamp;
  readonly attribute DOMString type;
  attribute boolean cancelBubble;
  attribute ReturnValueType returnValue;
  constructor( DOMString type, optional EventInit eventInitDict = {} );
  sequence<EventTarget> composedPath();
  undefined initEvent( DOMString type, optional boolean bubbles = false, optional boolean cancelable = false );
  undefined preventDefault();
  undefined stopImmediatePropagation();
  undefined stopPropagation();
};

callback interface EventListener {
  undefined handleEvent( Event event );
};

[Exposed=(Window,Worker,AudioWorklet)]
interface EventTarget {
  constructor();
  undefined addEventListener( DOMString type, EventListener? callback, optional ( AddEventListenerOptions or boolean ) options = {} );
  boolean dispatchEvent( Event event );
  undefined removeEventListener( DOMString type, EventListener? callback, optional ( EventListenerOptions or boolean ) options = {} );
};
