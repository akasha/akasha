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
    name = "UnionDoubleSequenceOrString"
)
public interface UnionDoubleSequenceOrString {
  @JsOverlay
  @Nonnull
  static UnionDoubleSequenceOrString of(@Nonnull final JsArray<Double> value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static UnionDoubleSequenceOrString of(@Nonnull final double[] value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static UnionDoubleSequenceOrString of(@Nonnull final String value) {
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
  default boolean isString() {
    return ( (Object) this ) instanceof String;
  }

  @JsOverlay
  default String asString() {
    return Js.asString( this );
  }
}
