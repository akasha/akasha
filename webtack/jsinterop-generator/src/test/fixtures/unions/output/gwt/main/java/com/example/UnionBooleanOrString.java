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
public interface UnionBooleanOrString {
  @JsOverlay
  @Nonnull
  static UnionBooleanOrString of(final boolean value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static UnionBooleanOrString of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isBoolean() {
    return ( (Object) this ) instanceof Boolean;
  }

  @JsOverlay
  default boolean asBoolean() {
    return Js.asBoolean( this );
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
