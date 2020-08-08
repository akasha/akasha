typedef EventHandler? NullableEventHandler;

/**
 * This is event handler documentation.
 *
 * @param event the event.
 * @version 1.2.3
 */
[LegacyTreatNonObjectAsNull]
callback EventHandler = void ( Event event );

/**
 * Handle events of type SpeechSynthesisEvent
 *
 * @param event the event
 */
callback SpeechSynthesisEventHandler = void ( SpeechSynthesisEvent event );

callback interface EventListener {
  void handleEvent( Event event );
};

/**
 * Listener for events of type SpeechSynthesisEvent
 */
callback interface SpeechSynthesisEventListener {
  /**
   * Handle event of type SpeechSynthesisEvent
   *
   * @param event the event
   */
  void handleEvent( SpeechSynthesisEvent event );
};

dictionary AddEventListenerOptions : EventListenerOptions {
  boolean once = false;
  boolean passive = false;
};

dictionary EventListenerOptions {
  boolean capture = false;
};

interface Event {
};

[Exposed=(Window,Worker,AudioWorklet)]
interface EventTarget {
  constructor();
  void addEventListener( DOMString type, EventListener? callback, optional ( AddEventListenerOptions or boolean ) options = {} );
  boolean dispatchEvent( Event event );
  void removeEventListener( DOMString type, EventListener? callback, optional ( EventListenerOptions or boolean ) options = {} );
};

/**
 * A test for a read-only maplike.
 */
[Exposed=Window]
interface RTCStatsReport {
  readonly maplike<DOMString, object>;
};

/**
 * A test for a read-write maplike.
 * Also uses a value type that has a different boxed type non-boxed type.
 */
[Exposed=Window]
interface SomeMapLikeDefiningOverrides {
  maplike<DOMString, long>;
  void clear();
  boolean delete( DOMString key );
  void set( DOMString key, long value );
};

/**
 * A test for a read-write maplike.
 * Also uses types that have a different boxed type and non-boxed type.
 */
[Exposed=Window]
interface SomeOtherType {
  maplike<long, long>;
};

interface SpeechSynthesisErrorEvent : SpeechSynthesisEvent {
};

interface SpeechSynthesisEvent : Event {
};

interface SpeechSynthesisUtterance : EventTarget {
  attribute NullableEventHandler onend;
  attribute SpeechSynthesisEventHandler? onpause;
  attribute NullableEventHandler onresume;
  attribute SpeechSynthesisEventHandler? onstart;
  event SpeechSynthesisEvent end;
  event SpeechSynthesisEvent resume;
  event SpeechSynthesisEvent start;
};
