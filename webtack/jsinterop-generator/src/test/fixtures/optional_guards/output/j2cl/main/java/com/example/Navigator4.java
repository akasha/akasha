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
    name = "Navigator4"
)
public final class Navigator4 {
  private Navigator4() {
  }

  @JsOverlay
  @Nonnull
  public static Navigator4 of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  @JsOverlay
  public final boolean isWebGPUSupported() {
    return "true".equals( System.getProperty( "com.example.is__Navigator4_WebGPU__supported" ) ) ? true : "false".equals( System.getProperty( "com.example.is__Navigator4_WebGPU__supported" ) ) ? false : Js.asPropertyMap( this ).has( "gpu" );
  }

  @JsProperty(
      name = "gpu"
  )
  @Nonnull
  public native GPU gpu();

  @JsOverlay
  public final boolean isGetGamepadsSupported() {
    return "true".equals( System.getProperty( "com.example.is__Navigator4_getGamepads__supported" ) ) ? true : "false".equals( System.getProperty( "com.example.is__Navigator4_getGamepads__supported" ) ) ? false : Js.asPropertyMap( this ).has( "getGamepads" );
  }

  @JsNonNull
  public native JsArray<Gamepad> getGamepads();
}
