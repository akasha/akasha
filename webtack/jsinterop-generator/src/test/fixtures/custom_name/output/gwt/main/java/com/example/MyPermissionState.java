package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = MyPermissionState.class
)
public @interface MyPermissionState {
  @JsNonNull
  String denied = "denied";

  @JsNonNull
  String granted = "granted";

  @JsNonNull
  String prompt = "prompt";

  final class Util {
    private Util() {
    }

    @MyPermissionState
    public static String requireValid(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@JsNonNull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@JsNonNull final String value) {
      return MyPermissionState.denied.equals( value ) || MyPermissionState.granted.equals( value ) || MyPermissionState.prompt.equals( value );
    }
  }
}
