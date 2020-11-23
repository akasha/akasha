package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;

@Generated("org.realityforge.webtack")
public final class JsMath {
  @JsOverlay
  public static final double E = JsMathNamespace.E;

  @JsOverlay
  public static final double LN10 = JsMathNamespace.LN10;

  private JsMath() {
  }

  public static double abs(double x) {
    return namespace().abs(x);
  }

  /**
   * Return the 'Math' namespace object.
   *
   * @return the 'Math' namespace object
   */
  @Nonnull
  public static JsMathNamespace namespace() {
    return Global.math();
  }
}
