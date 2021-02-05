package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = MyPermissionState.class
)
public @interface MyPermissionState {
  @Nonnull
  String denied = "denied";

  @Nonnull
  String granted = "granted";

  @Nonnull
  String prompt = "prompt";

  final class Validator {
    private Validator() {
    }

    @MyPermissionState
    public static String cast(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@Nonnull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@Nonnull final String value) {
      return MyPermissionState.denied.equals( value ) || MyPermissionState.granted.equals( value ) || MyPermissionState.prompt.equals( value );
    }
  }
}
