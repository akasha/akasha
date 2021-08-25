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
    name = "LongOrTxModeUnion"
)
public interface LongOrTxModeUnion {
  @JsOverlay
  @Nonnull
  static LongOrTxModeUnion of(final int value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static LongOrTxModeUnion of(@TxMode @Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isInt() {
    return ( (Object) this ) instanceof Double;
  }

  @JsOverlay
  default int asInt() {
    return Js.asInt( this );
  }

  @JsOverlay
  default boolean isTxMode() {
    return ( (Object) this ) instanceof String;
  }

  @JsOverlay
  @TxMode
  default String asTxMode() {
    return Js.asString( this );
  }
}
