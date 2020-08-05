/**
 * This is event handler documentation.
 *
 * @param event the event.
 * @version 1.2.3
 */
[LegacyTreatNonObjectAsNull]
callback EventHandler = void ( Event event );

callback SpeechSynthesisErrorEvent = void ( SpeechSynthesisErrorEvent event );

callback SpeechSynthesisEvent = void ( SpeechSynthesisEvent event );

interface Event {
};

interface SpeechSynthesisErrorEvent : SpeechSynthesisEvent {
};

interface SpeechSynthesisEvent : Event {
};
