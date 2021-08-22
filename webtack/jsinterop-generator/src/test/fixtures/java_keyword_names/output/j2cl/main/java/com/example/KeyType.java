package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = KeyType.class
)
public @interface KeyType {
  @JsNonNull
  String private_ = "private";

  @JsNonNull
  String public_ = "public";

  @JsNonNull
  String secret = "secret";

  final class Util {
    private Util() {
    }

    @KeyType
    public static String requireValid(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@JsNonNull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@JsNonNull final String value) {
      return KeyType.private_.equals( value ) || KeyType.public_.equals( value ) || KeyType.secret.equals( value );
    }
  }
}
