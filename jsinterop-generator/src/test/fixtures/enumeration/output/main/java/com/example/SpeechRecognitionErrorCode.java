package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = SpeechRecognitionErrorCode.class
)
public @interface SpeechRecognitionErrorCode {
  @Nonnull
  String aborted = "aborted";

  @Nonnull
  String audio_capture = "audio-capture";

  @Nonnull
  String bad_grammar = "bad-grammar";

  @Nonnull
  String language_not_supported = "language-not-supported";

  @Nonnull
  String network = "network";

  @Nonnull
  String no_speech = "no-speech";

  @Nonnull
  String not_allowed = "not-allowed";

  @Nonnull
  String service_not_allowed = "service-not-allowed";

  final class Util {
    private Util() {
    }

    @SpeechRecognitionErrorCode
    public static String requireValid(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@Nonnull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@Nonnull final String value) {
      return SpeechRecognitionErrorCode.aborted.equals( value ) || SpeechRecognitionErrorCode.audio_capture.equals( value ) || SpeechRecognitionErrorCode.bad_grammar.equals( value ) || SpeechRecognitionErrorCode.language_not_supported.equals( value ) || SpeechRecognitionErrorCode.network.equals( value ) || SpeechRecognitionErrorCode.no_speech.equals( value ) || SpeechRecognitionErrorCode.not_allowed.equals( value ) || SpeechRecognitionErrorCode.service_not_allowed.equals( value );
    }
  }
}
