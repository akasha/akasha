package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = SpeechRecognitionErrorCode.class
)
public @interface SpeechRecognitionErrorCode {
  @JsNonNull
  String aborted = "aborted";

  @JsNonNull
  String audio_capture = "audio-capture";

  @JsNonNull
  String bad_grammar = "bad-grammar";

  @JsNonNull
  String language_not_supported = "language-not-supported";

  @JsNonNull
  String network = "network";

  @JsNonNull
  String no_speech = "no-speech";

  @JsNonNull
  String not_allowed = "not-allowed";

  @JsNonNull
  String service_not_allowed = "service-not-allowed";

  final class Util {
    private Util() {
    }

    @SpeechRecognitionErrorCode
    public static String requireValid(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@JsNonNull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@JsNonNull final String value) {
      return SpeechRecognitionErrorCode.aborted.equals( value ) || SpeechRecognitionErrorCode.audio_capture.equals( value ) || SpeechRecognitionErrorCode.bad_grammar.equals( value ) || SpeechRecognitionErrorCode.language_not_supported.equals( value ) || SpeechRecognitionErrorCode.network.equals( value ) || SpeechRecognitionErrorCode.no_speech.equals( value ) || SpeechRecognitionErrorCode.not_allowed.equals( value ) || SpeechRecognitionErrorCode.service_not_allowed.equals( value );
    }
  }
}
