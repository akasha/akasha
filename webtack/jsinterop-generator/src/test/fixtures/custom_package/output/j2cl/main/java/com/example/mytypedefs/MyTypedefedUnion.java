package com.example.mytypedefs;

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
    name = "MyTypedefedUnion"
)
public interface MyTypedefedUnion {
  @JsOverlay
  @Nonnull
  static MyTypedefedUnion of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static MyTypedefedUnion of(final double value) {
    return Js.cast( value );
  }
}
