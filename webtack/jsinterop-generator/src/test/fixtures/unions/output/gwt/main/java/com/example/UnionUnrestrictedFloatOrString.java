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
public interface UnionUnrestrictedFloatOrString {
  @JsOverlay
  @Nonnull
  static UnionUnrestrictedFloatOrString of(final float value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static UnionUnrestrictedFloatOrString of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isFloat() {
    return ( (Object) this ) instanceof Double;
  }

  @JsOverlay
  default float asFloat() {
    return Js.asFloat( this );
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
