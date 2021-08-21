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
  default boolean isDataView() {
    return ( (Object) this ) instanceof DataView;
  }

  @JsOverlay
  default DataView asDataView() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isFloat32Array() {
    return ( (Object) this ) instanceof Float32Array;
  }

  @JsOverlay
  default Float32Array asFloat32Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isFloat64Array() {
    return ( (Object) this ) instanceof Float64Array;
  }

  @JsOverlay
  default Float64Array asFloat64Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isInt16Array() {
    return ( (Object) this ) instanceof Int16Array;
  }

  @JsOverlay
  default Int16Array asInt16Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isInt32Array() {
    return ( (Object) this ) instanceof Int32Array;
  }

  @JsOverlay
  default Int32Array asInt32Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isInt8Array() {
    return ( (Object) this ) instanceof Int8Array;
  }

  @JsOverlay
  default Int8Array asInt8Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isUint16Array() {
    return ( (Object) this ) instanceof Uint16Array;
  }

  @JsOverlay
  default Uint16Array asUint16Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isUint32Array() {
    return ( (Object) this ) instanceof Uint32Array;
  }

  @JsOverlay
  default Uint32Array asUint32Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isUint8Array() {
    return ( (Object) this ) instanceof Uint8Array;
  }

  @JsOverlay
  default Uint8Array asUint8Array() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isUint8ClampedArray() {
    return ( (Object) this ) instanceof Uint8ClampedArray;
  }

  @JsOverlay
  default Uint8ClampedArray asUint8ClampedArray() {
    return Js.cast( this );
  }
}
