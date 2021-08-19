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
    name = "ArrayBufferView"
)
public interface ArrayBufferView {
  @JsOverlay
  @Nonnull
  static ArrayBufferView of(@Nonnull final Int8Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ArrayBufferView of(@Nonnull final Int16Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ArrayBufferView of(@Nonnull final Int32Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ArrayBufferView of(@Nonnull final Uint8Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ArrayBufferView of(@Nonnull final Uint16Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ArrayBufferView of(@Nonnull final Uint32Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ArrayBufferView of(@Nonnull final Uint8ClampedArray value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ArrayBufferView of(@Nonnull final Float32Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ArrayBufferView of(@Nonnull final Float64Array value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ArrayBufferView of(@Nonnull final DataView value) {
    return Js.cast( value );
  }

  @JsOverlay
  default Int8Array asInt8Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default Int16Array asInt16Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default Int32Array asInt32Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default Uint8Array asUint8Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default Uint16Array asUint16Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default Uint32Array asUint32Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default Uint8ClampedArray asUint8ClampedArray() {
    return Js.cast( this );
  }

  @JsOverlay
  default Float32Array asFloat32Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default Float64Array asFloat64Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default DataView asDataView() {
    return Js.cast( this );
  }
}
