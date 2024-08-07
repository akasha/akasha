package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = "<window>",
    name = "$wnd"
)
public final class WindowGlobal {
  private WindowGlobal() {
  }

  @JsOverlay
  public static boolean isGpuSupported() {
    return "true" == System.getProperty( "com.example.is__Window_gpu__supported" ) ? true : "false" == System.getProperty( "com.example.is__Window_gpu__supported" ) ? false : Js.global().has( "gpu" );
  }

  @JsProperty(
      name = "gpu"
  )
  @JsNonNull
  public static native GPU gpu();

  @JsOverlay
  public static boolean isGetGamepadsSupported() {
    return "true" == System.getProperty( "com.example.is__Window_getGamepads__supported" ) ? true : "false" == System.getProperty( "com.example.is__Window_getGamepads__supported" ) ? false : Js.global().has( "getGamepads" );
  }

  @JsNonNull
  public static native JsArray<Gamepad> getGamepads();
}
