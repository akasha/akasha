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
    name = "PermissionStateOrLong"
)
public interface PermissionStateOrLong {
  @JsOverlay
  @Nonnull
  static PermissionStateOrLong of(@PermissionState @Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static PermissionStateOrLong of(final int value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isInt() {
    return ( (Object) this ) instanceof Double;
  }

  @JsOverlay
  default int asInt() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isPermissionState() {
    return ( (Object) this ) instanceof String;
  }

  @JsOverlay
  @PermissionState
  default String asPermissionState() {
    return Js.cast( this );
  }
}
