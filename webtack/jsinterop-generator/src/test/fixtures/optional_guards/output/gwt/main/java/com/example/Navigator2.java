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
    name = "Navigator2"
)
public class Navigator2 {
  protected Navigator2() {
  }

  @JsOverlay
  public final boolean isWebGPUSupported() {
    return "true" == System.getProperty( "com.example.is__Navigator2_WebGPU__supported" ) ? true : "false" == System.getProperty( "com.example.is__Navigator2_WebGPU__supported" ) ? false : Js.asPropertyMap( this ).has( "gpu" );
  }

  @JsProperty(
      name = "gpu"
  )
  @Nonnull
  public native GPU gpu();

  @JsOverlay
  public final boolean isGetGamepadsSupported() {
    return "true" == System.getProperty( "com.example.is__Navigator2_getGamepads__supported" ) ? true : "false" == System.getProperty( "com.example.is__Navigator2_getGamepads__supported" ) ? false : Js.asPropertyMap( this ).has( "getGamepads" );
  }

  @Nonnull
  public native JsArray<Gamepad> getGamepads();
}
