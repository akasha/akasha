/**
 * This is event handler documentation.
 *
 * @param event the event.
 * @version 1.2.3
 */
[LegacyTreatNonObjectAsNull]
callback EventHandler = any ( Event event );

interface Event {
};

interface SpeechSynthesisEvent : Event {
};

interface SpeechSynthesisErrorEvent : SpeechSynthesisEvent {
};

interface SpeechSynthesisUtterance {
  attribute NullableEventHandler onstart;
  attribute NullableEventHandler onend;
};

partial interface SpeechSynthesisUtterance {
  attribute NullableEventHandler onpause;
  attribute NullableEventHandler onresume;
};

interface EventSource {
    attribute NullableEventHandler onerror;
};
