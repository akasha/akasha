package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Math"
)
public final class JsMathNamespace {
  @JsOverlay
  public static final double E = 2.7182818284590452354;

  @JsOverlay
  public static final double LN10 = 2.302585092994046;

  private JsMathNamespace() {
  }

  public native double abs(double x);
}
