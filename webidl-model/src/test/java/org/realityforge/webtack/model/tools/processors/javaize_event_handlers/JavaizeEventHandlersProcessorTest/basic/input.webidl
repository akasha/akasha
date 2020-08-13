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

interface EventSource {
  attribute NullableEventHandler onerror;
};

interface SpeechSynthesisErrorEvent : SpeechSynthesisEvent {
};

interface SpeechSynthesisEvent : Event {
};

interface SpeechSynthesisUtterance {
  attribute NullableEventHandler onend;
  attribute NullableEventHandler onstart;
  event SpeechSynthesisEvent end;
  event SpeechSynthesisEvent start;
};

partial interface SpeechSynthesisUtterance {
  attribute NullableEventHandler onpause;
  attribute NullableEventHandler onresume;
  event SpeechSynthesisEvent resume;
};
