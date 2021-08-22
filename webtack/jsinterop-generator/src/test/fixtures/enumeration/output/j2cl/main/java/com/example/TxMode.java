package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import org.intellij.lang.annotations.MagicConstant;

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = TxMode.class
)
public @interface TxMode {
  @JsNonNull
  String not_allowed = "not-allowed";

  @JsNonNull
  String requires = "requires";

  @JsNonNull
  String requires_new = "requires_new";

  final class Util {
    private Util() {
    }

    @TxMode
    public static String requireValid(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@JsNonNull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@JsNonNull final String value) {
      return TxMode.not_allowed.equals( value ) || TxMode.requires.equals( value ) || TxMode.requires_new.equals( value );
    }
  }
}
