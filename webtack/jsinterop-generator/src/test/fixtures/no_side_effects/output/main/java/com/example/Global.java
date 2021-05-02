package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
public final class Global {
  private Global() {
  }

  @HasNoSideEffects
  @Nonnull
  public static native String escape(@Nonnull String str);

  @HasNoSideEffects
  public static native boolean isFinite(double num);

  @HasNoSideEffects
  public static native boolean isNaN(double value);

  public static native int parseInt(@Nonnull String string, int radix);

  @Nonnull
  public static native String unescape(@Nonnull String str);
}
