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
