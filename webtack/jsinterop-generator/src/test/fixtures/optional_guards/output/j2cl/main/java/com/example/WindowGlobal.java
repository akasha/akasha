package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
public final class WindowGlobal {
  private WindowGlobal() {
  }

  @JsOverlay
  public static boolean isGpuSupported() {
    return "true".equals( System.getProperty( "com.example.is__Window_gpu__supported" ) ) ? true : "false".equals( System.getProperty( "com.example.is__Window_gpu__supported" ) ) ? false : Js.global().has( "gpu" );
  }

  @JsProperty(
      name = "gpu"
  )
  @Nonnull
  public static native GPU gpu();

  @JsOverlay
  public static boolean isGetGamepadsSupported() {
    return "true".equals( System.getProperty( "com.example.is__Window_getGamepads__supported" ) ) ? true : "false".equals( System.getProperty( "com.example.is__Window_getGamepads__supported" ) ) ? false : Js.global().has( "getGamepads" );
  }

  @Nonnull
  public static native JsArray<Gamepad> getGamepads();
}
