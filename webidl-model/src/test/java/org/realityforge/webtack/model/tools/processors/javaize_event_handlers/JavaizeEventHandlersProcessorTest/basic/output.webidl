/**
 * This is event handler documentation.
 *
 * @param event the event.
 * @version 1.2.3
 */
[LegacyTreatNonObjectAsNull]
callback EventHandler = void ( Event event );

/**
 * Handle events of type MouseEvent
 *
 * @param event the event
 */
[JavaSubPackage=mouse]
callback MouseEventHandler = void ( MouseEvent event );

/**
 * Handle events of type SpeechSynthesisEvent
 *
 * @param event the event
 */
callback SpeechSynthesisEventHandler = void ( SpeechSynthesisEvent event );

/**
 * Listener for events of type FocusEvent
 */
callback interface FocusEventListener {
  /**
   * Handle event of type FocusEvent
   *
   * @param event the event
   */
  void handleEvent( FocusEvent event );
};

/**
 * Listener for events of type MouseEvent
 */
[JavaSubPackage=mouse]
callback interface MouseEventListener {
  /**
   * Handle event of type MouseEvent
   *
   * @param event the event
   */
  void handleEvent( MouseEvent event );
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

/**
 * This interface defines events which subtypes define event handlers for.
 */
interface Element {
  attribute NullableEventHandler oncancel;
  /**
   * blur has no handler property and thus no handler type but should have a listener as we will
   * create a helper method to subscribe.
   */
  event FocusEvent blur;
  /**
   * cancel is of type event so no new handler or listener will be created.
   */
  [NoCancel]
  event Event cancel;
  /**
   * click event handlers are present in subtypes so will have a listener and subtypes handler properties will be updated.
   */
  [NoBubble, NoCancel]
  event MouseEvent click;
};

interface Event {
};

interface EventSource {
  attribute NullableEventHandler onerror;
};

interface FocusEvent : Event {
};

interface HTMLElement : Element {
  attribute MouseEventHandler? onclick;
};

/**
 * This event and thus the generated event handlers and event listeners should be in a "mouse" subpackage.
 */
[JavaSubPackage=mouse]
interface MouseEvent : Event {
};

interface SVGElement : Element {
  attribute MouseEventHandler? onclick;
};

interface SpeechSynthesisErrorEvent : SpeechSynthesisEvent {
};

interface SpeechSynthesisEvent : Event {
};

interface SpeechSynthesisUtterance {
  attribute NullableEventHandler onend;
  attribute SpeechSynthesisEventHandler? onstart;
  event SpeechSynthesisEvent end;
  event SpeechSynthesisEvent start;
};

partial interface SpeechSynthesisUtterance {
  attribute SpeechSynthesisEventHandler? onpause;
  attribute NullableEventHandler onresume;
  event SpeechSynthesisEvent resume;
};
