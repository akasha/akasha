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
    name = "Navigator1"
)
public class Navigator1 {
  protected Navigator1() {
  }

  @JsOverlay
  public final boolean isGpuSupported() {
    return "true" == System.getProperty( "com.example.is__Navigator1_gpu__supported" ) ? true : "false" == System.getProperty( "com.example.is__Navigator1_gpu__supported" ) ? false : Js.asPropertyMap( this ).has( "gpu" );
  }

  @JsProperty(
      name = "gpu"
  )
  @Nonnull
  public native GPU gpu();
}
