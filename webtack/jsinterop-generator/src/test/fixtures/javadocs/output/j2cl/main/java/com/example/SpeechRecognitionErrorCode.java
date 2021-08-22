package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
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
  @JsNonNull
  String aborted = "aborted";

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
      return SpeechRecognitionErrorCode.aborted.equals( value );
    }
  }
}
