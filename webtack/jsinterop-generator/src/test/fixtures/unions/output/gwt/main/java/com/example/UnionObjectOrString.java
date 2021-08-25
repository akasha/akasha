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
public interface UnionObjectOrString {
  @JsOverlay
  @Nonnull
  static UnionObjectOrString of(@Nonnull final JsObject value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static UnionObjectOrString of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isObject() {
    return ( (Object) this ) instanceof JsObject;
  }

  @JsOverlay
  default JsObject asObject() {
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
