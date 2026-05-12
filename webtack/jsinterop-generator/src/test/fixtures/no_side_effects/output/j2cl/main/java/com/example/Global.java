package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
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
  @JsNonNull
  public static native String escape(@JsNonNull String str);

  @HasNoSideEffects
  public static native boolean isFinite(double num);

  @HasNoSideEffects
  public static native boolean isNaN(double value);

  public static native int parseInt(@JsNonNull String string, int radix);

  @JsNonNull
  public static native String unescape(@JsNonNull String str);
}
