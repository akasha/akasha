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
    name = "?"
)
public interface BufferSource {
  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final ArrayBufferView value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final Int8Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final Int16Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final Int32Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final Uint8Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final Uint16Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final Uint32Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final Uint8ClampedArray value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final Float32Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final Float64Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final DataView value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static BufferSource of(@Nonnull final ArrayBuffer value) {
    return Js.cast( value );
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
  default boolean isArrayBuffer() {
    return ( (Object) this ) instanceof ArrayBuffer;
  }

  @JsOverlay
  default ArrayBuffer asArrayBuffer() {
    return Js.cast( this );
  }
}
