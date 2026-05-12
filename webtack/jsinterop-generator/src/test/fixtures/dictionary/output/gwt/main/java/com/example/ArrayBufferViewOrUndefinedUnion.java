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
public interface ArrayBufferViewOrUndefinedUnion {
  @JsOverlay
  @Nonnull
  static ArrayBufferViewOrUndefinedUnion of(@Nonnull final ArrayBufferView value) {
    return Js.cast( value );
  }

  @JsOverlay
  static ArrayBufferViewOrUndefinedUnion of() {
    return Js.cast( Js.undefined() );
  }

  @JsOverlay
  default boolean isArrayBufferView() {
    return ( (Object) this ) instanceof ArrayBufferView;
  }

  @JsOverlay
  default ArrayBufferView asArrayBufferView() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isVoid() {
    return Js.isTripleEqual( Js.undefined(), this );
  }
}
