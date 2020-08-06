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

  event SpeechSynthesisEvent start;
  event SpeechSynthesisEvent end;
};

partial interface SpeechSynthesisUtterance {
  attribute NullableEventHandler onpause;
  attribute NullableEventHandler onresume;

  event SpeechSynthesisEvent resume;
};

interface EventSource {
    attribute NullableEventHandler onerror;
};
