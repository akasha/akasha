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
    name = "UnionByteOrString"
)
public interface UnionByteOrString {
  @JsOverlay
  @Nonnull
  static UnionByteOrString of(final byte value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static UnionByteOrString of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isByte() {
    return ( (Object) this ) instanceof Double;
  }

  @JsOverlay
  default byte asByte() {
    return Js.asByte( this );
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
