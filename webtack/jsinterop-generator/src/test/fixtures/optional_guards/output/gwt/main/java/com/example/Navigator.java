package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
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
    return "true" == System.getProperty( "com.example.is__Navigator_vibrate__supported" ) ? true : "false" == System.getProperty( "com.example.is__Navigator_vibrate__supported" ) ? false : Js.asPropertyMap( this ).has( "vibrate" );
  }

  /**
   * This method is exploded into multiple methods. However we should only have one feature detection method created.
   */
  public native boolean vibrate(@JsNonNull VibratePattern pattern);

  /**
   * This method is exploded into multiple methods. However we should only have one feature detection method created.
   */
  public native boolean vibrate(int pattern);

  /**
   * This method is exploded into multiple methods. However we should only have one feature detection method created.
   */
  public native boolean vibrate(@JsNonNull JsArray<Double> pattern);

  /**
   * This method is exploded into multiple methods. However we should only have one feature detection method created.
   */
  @JsOverlay
  public final boolean vibrate(final double @JsNonNull ... pattern) {
    return _vibrate( pattern );
  }

  @JsMethod(
      name = "vibrate"
  )
  private native boolean _vibrate(double @JsNonNull [] pattern);
}
