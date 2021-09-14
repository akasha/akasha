package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class Navigator4TestCompile {
  static Navigator4 $typeReference$;

  public static boolean isWebGPUSupported(final Navigator4 type) {
    return type.isWebGPUSupported();
  }

  public static GPU gpu(final Navigator4 type) {
    return type.gpu();
  }

  public static boolean isGetGamepadsSupported(final Navigator4 type) {
    return type.isGetGamepadsSupported();
  }

  public static JsArray<Gamepad> getGamepads(final Navigator4 $instance) {
    return $instance.getGamepads();
  }
}
