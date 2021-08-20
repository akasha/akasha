package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "DocumentOrWindowProxyUnion"
)
public interface DocumentOrWindowProxyUnion {
  @JsOverlay
  @Nonnull
  static DocumentOrWindowProxyUnion of(@Nonnull final Document value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nullable
  static DocumentOrWindowProxyUnion of(@Nullable final WindowProxy value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isDocument() {
    return ( (Object) this ) instanceof Document;
  }

  @JsOverlay
  default Document asDocument() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isWindowProxy() {
    return ( (Object) this ) instanceof WindowProxy;
  }

  @JsOverlay
  default WindowProxy asWindowProxy() {
    return Js.cast( this );
  }
}
