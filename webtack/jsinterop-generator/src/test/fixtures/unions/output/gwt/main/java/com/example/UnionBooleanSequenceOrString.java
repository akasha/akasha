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
public interface UnionBooleanSequenceOrString {
  @JsOverlay
  @Nonnull
  static UnionBooleanSequenceOrString of(@Nonnull final JsArray<Boolean> value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static UnionBooleanSequenceOrString of(@Nonnull final Boolean... value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static UnionBooleanSequenceOrString of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isArray() {
    return ( (Object) this ) instanceof JsArray;
  }

  @JsOverlay
  default JsArray<Boolean> asArray() {
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
