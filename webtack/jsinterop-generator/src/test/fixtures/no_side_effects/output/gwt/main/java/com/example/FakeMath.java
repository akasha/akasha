package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(
    isNative = true,
    name = "FakeMath",
    namespace = JsPackage.GLOBAL
)
@Generated("org.realityforge.webtack")
public final class FakeMath {
  @JsOverlay
  public static final double SQRT2 = 1.4142135623730951;

  private FakeMath() {
  }

  public static native double abs(double x);

  @HasNoSideEffects
  public static native double acos(double x);
}
