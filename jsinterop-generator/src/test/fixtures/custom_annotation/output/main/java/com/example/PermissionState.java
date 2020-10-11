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
}
