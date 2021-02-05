package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = TxMode.class
)
public @interface TxMode {
  @Nonnull
  String not_allowed = "not-allowed";

  @Nonnull
  String requires = "requires";

  @Nonnull
  String requires_new = "requires_new";

  final class Validator {
    private Validator() {
    }

    @TxMode
    public static String cast(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@Nonnull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@Nonnull final String value) {
      return TxMode.not_allowed.equals( value ) || TxMode.requires.equals( value ) || TxMode.requires_new.equals( value );
    }
  }
}
