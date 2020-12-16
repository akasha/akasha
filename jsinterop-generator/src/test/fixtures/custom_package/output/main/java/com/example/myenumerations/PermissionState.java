package com.example.myenumerations;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = PermissionState.class
)
public @interface PermissionState {
  @Nonnull
  String denied = "denied";

  @Nonnull
  String granted = "granted";

  @Nonnull
  String prompt = "prompt";

  final class Validator {
    private Validator() {
    }

    public static void assertValid(@Nonnull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@Nonnull final String value) {
      return PermissionState.denied.equals( value ) || PermissionState.granted.equals( value ) || PermissionState.prompt.equals( value );
    }
  }
}
