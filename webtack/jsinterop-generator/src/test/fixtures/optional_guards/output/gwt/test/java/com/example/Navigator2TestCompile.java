package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class Navigator2TestCompile {
  static Navigator2 $typeReference$;

  public static boolean isWebGPUSupported(final Navigator2 type) {
    return type.isWebGPUSupported();
  }

  public static GPU gpu(final Navigator2 type) {
    return type.gpu();
  }

  public static boolean isGetGamepadsSupported(final Navigator2 type) {
    return type.isGetGamepadsSupported();
  }

  public static JsArray<Gamepad> getGamepads(final Navigator2 $instance) {
    return $instance.getGamepads();
  }
}
