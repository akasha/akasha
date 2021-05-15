package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(
    isNative = true,
    name = "Math1",
    namespace = JsPackage.GLOBAL
)
@Generated("org.realityforge.webtack")
public final class Math1 {
  @JsOverlay
  public static final double E = 2.7182818284590452354;

  @JsOverlay
  public static final double LN10 = 2.302585092994046;

  private Math1() {
  }

  public static native double abs(double x);

  public static native double abs2(double x);
}
