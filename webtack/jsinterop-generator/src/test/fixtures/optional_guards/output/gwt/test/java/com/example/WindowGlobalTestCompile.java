package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WindowGlobalTestCompile {
  public static boolean isGpuSupported() {
    return WindowGlobal.isGpuSupported();
  }

  public static GPU gpu() {
    return WindowGlobal.gpu();
  }
}
