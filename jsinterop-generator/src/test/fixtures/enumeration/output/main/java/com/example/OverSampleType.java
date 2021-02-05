package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

/**
 * This tests scenario where enum values start with number.
 */
@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = OverSampleType.class
)
public @interface OverSampleType {
  @Nonnull
  String _2x = "2x";

  @Nonnull
  String _4x = "4x";

  @Nonnull
  String none = "none";

  final class Validator {
    private Validator() {
    }

    @OverSampleType
    public static String cast(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@Nonnull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@Nonnull final String value) {
      return OverSampleType._2x.equals( value ) || OverSampleType._4x.equals( value ) || OverSampleType.none.equals( value );
    }
  }
}
