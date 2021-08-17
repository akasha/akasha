package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WindowTestCompile {
  static Window $typeReference$;

  public static boolean isGpuSupported(final Window type) {
    return type.isGpuSupported();
  }

  public static GPU gpu(final Window type) {
    return type.gpu();
  }

  public static boolean isGetGamepadsSupported(final Window type) {
    return type.isGetGamepadsSupported();
  }

  public static JsArray<Gamepad> getGamepads(final Window $instance) {
    return $instance.getGamepads();
  }
}
