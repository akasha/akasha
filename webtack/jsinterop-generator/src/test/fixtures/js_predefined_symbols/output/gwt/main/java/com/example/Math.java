package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(
    isNative = true,
    name = "JsMath",
    namespace = JsPackage.GLOBAL
)
@Generated("org.realityforge.webtack")
public final class Math {
  @JsOverlay
  public static final double E = 2.7182818284590452354;

  @JsOverlay
  public static final double E2 = 2.7182818284590452354;

  @JsOverlay
  public static final double PI = Constants.PI;

  @JsOverlay
  public static final double PI2 = 3.1415926535897932;

  private Math() {
  }

  @JsType(
      isNative = true,
      name = "JsMath",
      namespace = JsPackage.GLOBAL
  )
  private static final class Constants {
    @JsProperty(
        name = "JsPI"
    )
    private static double PI;
  }
}
