package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Window"
)
public class Window {
  protected Window() {
  }

  @JsOverlay
  public final boolean isGpuSupported() {
    return "true" == System.getProperty( "com.example.is__Window_gpu__supported" ) ? true : "false" == System.getProperty( "com.example.is__Window_gpu__supported" ) ? false : Js.asPropertyMap( this ).has( "gpu" );
  }

  @JsProperty(
      name = "gpu"
  )
  @Nonnull
  public native GPU gpu();

  @JsOverlay
  public final boolean isGetGamepadsSupported() {
    return "true" == System.getProperty( "com.example.is__Window_getGamepads__supported" ) ? true : "false" == System.getProperty( "com.example.is__Window_getGamepads__supported" ) ? false : Js.asPropertyMap( this ).has( "getGamepads" );
  }

  @JsNonNull
  public native JsArray<Gamepad> getGamepads();
}
