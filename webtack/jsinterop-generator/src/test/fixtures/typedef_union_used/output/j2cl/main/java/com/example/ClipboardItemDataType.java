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
    name = "ClipboardItemDataType"
)
public interface ClipboardItemDataType {
  @JsOverlay
  @Nonnull
  static ClipboardItemDataType of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ClipboardItemDataType of(@Nonnull final Blob value) {
    return Js.cast( value );
  }

  @JsOverlay
  default Blob asBlob() {
    return Js.cast( this );
  }
}
