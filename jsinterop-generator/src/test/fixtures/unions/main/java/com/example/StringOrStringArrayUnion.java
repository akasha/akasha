package com.example;

import elemental2.core.JsArray;
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
public interface StringOrStringArrayUnion {
  @JsOverlay
  @Nonnull
  static StringOrStringArrayUnion of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static StringOrStringArrayUnion of(@Nonnull final JsArray<String> value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static StringOrStringArrayUnion of(@Nonnull final String[] value) {
    return Js.cast( value );
  }
}
