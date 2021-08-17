package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class Navigator1TestCompile {
  static Navigator1 $typeReference$;

  public static boolean isGpuSupported(final Navigator1 type) {
    return type.isGpuSupported();
  }

  public static GPU gpu(final Navigator1 type) {
    return type.gpu();
  }

  public static boolean isGetGamepadsSupported(final Navigator1 type) {
    return type.isGetGamepadsSupported();
  }

  public static JsArray<Gamepad> getGamepads(final Navigator1 $instance) {
    return $instance.getGamepads();
  }
}
