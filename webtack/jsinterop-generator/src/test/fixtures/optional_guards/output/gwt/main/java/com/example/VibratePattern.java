package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface VibratePattern {
  @JsOverlay
  @Nonnull
  static VibratePattern of(final int value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static VibratePattern of(@Nonnull final JsArray<Double> value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static VibratePattern of(@Nonnull final double... value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isArray() {
    return ( (Object) this ) instanceof JsArray;
  }

  @JsOverlay
  default JsArray<Double> asArray() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isInt() {
    return ( (Object) this ) instanceof Double;
  }

  @JsOverlay
  default int asInt() {
    return Js.asInt( this );
  }
}
