package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface LongOrTxModeUnion {
  @JsOverlay
  @Nonnull
  static LongOrTxModeUnion of(final int value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static LongOrTxModeUnion of(
      @MagicConstant(valuesFromClass = TxMode.class) @Nonnull final String value) {
    return Js.cast( value );
  }
}
