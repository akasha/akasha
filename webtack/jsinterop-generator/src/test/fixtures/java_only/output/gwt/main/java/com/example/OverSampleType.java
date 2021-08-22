package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = OverSampleType.class
)
public @interface OverSampleType {
  @JsNonNull
  String _2x = "2x";

  @JsNonNull
  String _4x = "4x";

  @JsNonNull
  String none = "none";

  final class Util {
    private Util() {
    }

    @OverSampleType
    public static String requireValid(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@JsNonNull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@JsNonNull final String value) {
      return OverSampleType._2x.equals( value ) || OverSampleType._4x.equals( value ) || OverSampleType.none.equals( value );
    }
  }
}
