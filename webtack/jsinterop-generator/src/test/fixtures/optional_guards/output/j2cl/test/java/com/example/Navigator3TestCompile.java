package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class Navigator3TestCompile {
  static Navigator3 $typeReference$;

  public static boolean isGpuSupported(final Navigator3 type) {
    return type.isGpuSupported();
  }

  public static GPU gpu(final Navigator3 type) {
    return type.gpu();
  }

  public static boolean isGetGamepadsSupported(final Navigator3 type) {
    return type.isGetGamepadsSupported();
  }

  public static JsArray<Gamepad> getGamepads(final Navigator3 $instance) {
    return $instance.getGamepads();
  }
}
