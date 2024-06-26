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
public interface UnionUnrestrictedDoubleOrString {
  @JsOverlay
  @Nonnull
  static UnionUnrestrictedDoubleOrString of(final double value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static UnionUnrestrictedDoubleOrString of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isDouble() {
    return ( (Object) this ) instanceof Double;
  }

  @JsOverlay
  default double asDouble() {
    return Js.asDouble( this );
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
