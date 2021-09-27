package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
public interface IndexedKeyframeOffsetType {
  @JsOverlay
  @Nullable
  static IndexedKeyframeOffsetType of(@Nullable final Double value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static IndexedKeyframeOffsetType of(@Nonnull final JsArray<Double> value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static IndexedKeyframeOffsetType of(@Nonnull final double... value) {
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
  default boolean isDouble() {
    return ( (Object) this ) instanceof Double;
  }

  @JsOverlay
  default Double asDouble() {
    return Js.cast( this );
  }
}
