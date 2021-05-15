package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Documentation for SpeechRecognitionErrorCode.
 *
 * @see <a href="http://example.com/API/SpeechRecognitionErrorCode">SpeechRecognitionErrorCode - MDN</a>
 */
@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = SpeechRecognitionErrorCode.class
)
public @interface SpeechRecognitionErrorCode {
  /**
   * Documentation for SpeechRecognitionErrorCode.aborted with a link ala {@link com.example.SpeechRecognitionErrorCode}.
   *
   * @see <a href="http://example.com/API/SpeechRecognitionErrorCode/aborted">SpeechRecognitionErrorCode.aborted - MDN</a>
   */
  @Nonnull
  String aborted = "aborted";

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
      return SpeechRecognitionErrorCode.aborted.equals( value );
    }
  }
}
