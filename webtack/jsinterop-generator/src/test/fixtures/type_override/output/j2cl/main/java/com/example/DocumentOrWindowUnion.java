package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.jetbrains.annotations.ApiStatus;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "DocumentOrWindowUnion"
)
@ApiStatus.Internal
interface DocumentOrWindowUnion {
  @JsOverlay
  @Nonnull
  static DocumentOrWindowUnion of(@Nonnull final Document value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static DocumentOrWindowUnion of(@Nonnull final Window value) {
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
  default boolean isWindow() {
    return ( (Object) this ) instanceof Window;
  }

  @JsOverlay
  default Window asWindow() {
    return Js.cast( this );
  }
}
