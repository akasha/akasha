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
  /**
   * Constant is inlined...
   */
  @JsOverlay
  public static final double E = 2.7182818284590452354;

  @JsOverlay
  public static final double PI = Constants.PI;

  @JsOverlay
  public static final double SQRT1_2 = Constants.SQRT1_2;

  /**
   * Constant not inlined...
   */
  @JsOverlay
  public static final double SQRT2 = Constants.SQRT2;

  private JsMathNamespace() {
  }

  public native double abs(double x);

  @JsType(
      isNative = true,
      name = "Math",
      namespace = JsPackage.GLOBAL
  )
  private static final class Constants {
    private static double PI;

    private static double SQRT1_2;

    private static double SQRT2;
  }
}
