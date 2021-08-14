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
    name = "Navigator3"
)
public final class Navigator3 {
  private Navigator3() {
  }

  @JsOverlay
  @Nonnull
  public static Navigator3 of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  @JsOverlay
  public final boolean isGpuSupported() {
    return "true".equals( System.getProperty( "com.example.is__Navigator3_gpu__supported" ) ) ? true : "false".equals( System.getProperty( "com.example.is__Navigator3_gpu__supported" ) ) ? false : Js.asPropertyMap( this ).has( "gpu" );
  }

  @JsProperty(
      name = "gpu"
  )
  @Nonnull
  public native GPU gpu();
}
