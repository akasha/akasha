package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = KeyType.class
)
public @interface KeyType {
  @Nonnull
  String private_ = "private";

  @Nonnull
  String public_ = "public";

  @Nonnull
  String secret = "secret";

  final class Validator {
    private Validator() {
    }

    public static void assertValid(@Nonnull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@Nonnull final String value) {
      return KeyType.private_.equals( value ) || KeyType.public_.equals( value ) || KeyType.secret.equals( value );
    }
  }
}
