package com.example;

import elemental3.MyAnnotation;
import elemental3.MyAnnotation2;
import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@MyAnnotation
@Documented
@MagicConstant(
    valuesFromClass = PermissionState.class
)
public @interface PermissionState {
  @Nonnull
  String denied = "denied";

  @Nonnull
  @MyAnnotation2
  String granted = "granted";

  @Nonnull
  String prompt = "prompt";

  final class Validator {
    private Validator() {
    }

    @PermissionState
    public static String cast(final String value) {
      assertValid( value );
      return value;
    }

    public static void assertValid(@Nonnull final String value) {
      assert isValid( value );
    }

    public static boolean isValid(@Nonnull final String value) {
      return PermissionState.denied.equals( value ) || PermissionState.granted.equals( value ) || PermissionState.prompt.equals( value );
    }
  }
}
