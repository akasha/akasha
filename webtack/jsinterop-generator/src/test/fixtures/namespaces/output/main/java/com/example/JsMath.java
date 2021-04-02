package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class JsMath {
  public static final double E = JsMathNamespace.E;

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
