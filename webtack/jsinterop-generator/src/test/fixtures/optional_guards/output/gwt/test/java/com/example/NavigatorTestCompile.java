package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class NavigatorTestCompile {
  static Navigator $typeReference$;

  public static boolean isVibrateSupported(final Navigator type) {
    return type.isVibrateSupported();
  }

  public static boolean vibrate(final Navigator $instance, final VibratePattern pattern) {
    return $instance.vibrate( pattern );
  }

  public static boolean vibrate(final Navigator $instance, final int pattern) {
    return $instance.vibrate( pattern );
  }

  public static boolean vibrate(final Navigator $instance, final JsArray<Double> pattern) {
    return $instance.vibrate( pattern );
  }

  public static boolean vibrate(final Navigator $instance, final double[] pattern) {
    return $instance.vibrate( pattern );
  }
}
