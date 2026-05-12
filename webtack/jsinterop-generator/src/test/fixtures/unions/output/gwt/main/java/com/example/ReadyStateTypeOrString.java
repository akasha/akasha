package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
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
public interface ReadyStateTypeOrString {
  @JsOverlay
  @Nonnull
  static ReadyStateTypeOrString of(@ReadyStateType final int value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ReadyStateTypeOrString of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isReadyStateType() {
    return ( (Object) this ) instanceof Double;
  }

  @JsOverlay
  @ReadyStateType
  default int asReadyStateType() {
    return Js.asInt( this );
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
