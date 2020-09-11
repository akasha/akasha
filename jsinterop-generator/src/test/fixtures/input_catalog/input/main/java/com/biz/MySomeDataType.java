package com.biz;

import elemental2.core.Int8Array;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "?" )
public interface MySomeDataType {
  @JsOverlay
  @Nonnull
  static MySomeDataType of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static MySomeDataType of(@Nonnull final Int8Array value) {
    return Js.cast( value );
  }
}
