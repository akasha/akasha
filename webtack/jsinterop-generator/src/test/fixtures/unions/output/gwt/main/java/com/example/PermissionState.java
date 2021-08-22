package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = PermissionState.class
)
public @interface PermissionState {
  @JsNonNull
  String denied = "denied";

  @JsNonNull
  String granted = "granted";

  @JsNonNull
  String prompt = "prompt";

  final class Util {
    private Util() {
    }

    @PermissionState
    public static String requireValid(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@JsNonNull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@JsNonNull final String value) {
      return PermissionState.denied.equals( value ) || PermissionState.granted.equals( value ) || PermissionState.prompt.equals( value );
    }
  }
}
