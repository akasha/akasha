package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WindowGlobalTestCompile {
  static WindowGlobal $typeReference$;

  public static boolean isGpuSupported() {
    return WindowGlobal.isGpuSupported();
  }

  public static GPU gpu() {
    return WindowGlobal.gpu();
  }

  public static boolean isGetGamepadsSupported() {
    return WindowGlobal.isGetGamepadsSupported();
  }

  public static JsArray<Gamepad> getGamepads() {
    return WindowGlobal.getGamepads();
  }
}
