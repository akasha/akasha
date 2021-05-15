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
    name = "BluetoothServiceUUID"
)
public interface BluetoothServiceUUID {
  @JsOverlay
  @Nonnull
  static BluetoothServiceUUID of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BluetoothServiceUUID of(final int value) {
    return Js.cast( value );
  }
}
