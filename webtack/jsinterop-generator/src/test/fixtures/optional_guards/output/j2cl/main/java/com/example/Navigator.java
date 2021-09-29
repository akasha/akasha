package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Navigator"
)
public final class Navigator {
  private Navigator() {
  }

  @JsOverlay
  @Nonnull
  public static Navigator of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  @JsOverlay
  public final boolean isVibrateSupported() {
    return "true".equals( System.getProperty( "com.example.is__Navigator_vibrate__supported" ) ) ? true : "false".equals( System.getProperty( "com.example.is__Navigator_vibrate__supported" ) ) ? false : Js.asPropertyMap( this ).has( "vibrate" );
  }

  /**
   * This method is exploded into multiple methods. However we should only have one feature detection method created.
   */
  public native boolean vibrate(@Nonnull VibratePattern pattern);

  /**
   * This method is exploded into multiple methods. However we should only have one feature detection method created.
   */
  public native boolean vibrate(int pattern);

  /**
   * This method is exploded into multiple methods. However we should only have one feature detection method created.
   */
  public native boolean vibrate(@Nonnull JsArray<Double> pattern);

  /**
   * This method is exploded into multiple methods. However we should only have one feature detection method created.
   */
  @JsOverlay
  public final boolean vibrate(@Nonnull final double... pattern) {
    return _vibrate( pattern );
  }

  @JsMethod(
      name = "vibrate"
  )
  private native boolean _vibrate(@Nonnull double[] pattern);
}
