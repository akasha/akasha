typedef EventHandler? NullableEventHandler;

/**
 * This is event handler documentation.
 *
 * @param event the event.
 * @version 1.2.3
 */
[LegacyTreatNonObjectAsNull]
callback EventHandler = undefined ( Event event );

/**
 * Handle events of type SpeechSynthesisEvent
 *
 * @param event the event
 */
callback SpeechSynthesisEventHandler = undefined ( SpeechSynthesisEvent event );

callback interface EventListener {
  undefined handleEvent( Event event );
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
  undefined handleEvent( SpeechSynthesisEvent event );
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

interface EventTarget {
  constructor();
  undefined addEventListener( DOMString type, EventListener? callback, optional ( AddEventListenerOptions or boolean ) options = {} );
  boolean dispatchEvent( Event event );
  undefined removeEventListener( DOMString type, EventListener? callback, optional ( EventListenerOptions or boolean ) options = {} );
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
