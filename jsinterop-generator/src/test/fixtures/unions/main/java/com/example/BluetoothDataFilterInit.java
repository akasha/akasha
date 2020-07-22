package com.example;

import elemental2.core.ArrayBuffer;
import elemental2.core.DataView;
import elemental2.core.Float32Array;
import elemental2.core.Float64Array;
import elemental2.core.Int16Array;
import elemental2.core.Int32Array;
import elemental2.core.Int8Array;
import elemental2.core.Uint16Array;
import elemental2.core.Uint32Array;
import elemental2.core.Uint8Array;
import elemental2.core.Uint8ClampedArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface BluetoothDataFilterInit {
  @JsOverlay
  @Nonnull
  static BluetoothDataFilterInit create(@Nonnull final BufferSource dataPrefix) {
    return Js.<BluetoothDataFilterInit>uncheckedCast( JsPropertyMap.of() ).dataPrefix( dataPrefix );
  }

  @JsProperty
  @Nonnull
  BufferSource getDataPrefix();

  @JsProperty
  void setDataPrefix(@Nonnull BufferSource dataPrefix);

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final BufferSource dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final ArrayBufferView dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final ArrayBufferView dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Int8Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final Int8Array dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Int16Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final Int16Array dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Int32Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final Int32Array dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Uint8Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final Uint8Array dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Uint16Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final Uint16Array dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Uint32Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final Uint32Array dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Uint8ClampedArray dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final Uint8ClampedArray dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Float32Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final Float32Array dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final Float64Array dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final Float64Array dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final DataView dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final DataView dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsOverlay
  default void setDataPrefix(@Nonnull final ArrayBuffer dataPrefix) {
    setDataPrefix( BufferSource.of( dataPrefix ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit dataPrefix(@Nonnull final ArrayBuffer dataPrefix) {
    setDataPrefix( dataPrefix );
    return this;
  }

  @JsProperty
  BufferSource getMask();

  @JsProperty
  void setMask(@Nonnull BufferSource mask);

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final BufferSource mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final ArrayBufferView mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final ArrayBufferView mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final Int8Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final Int8Array mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final Int16Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final Int16Array mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final Int32Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final Int32Array mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final Uint8Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final Uint8Array mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final Uint16Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final Uint16Array mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final Uint32Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final Uint32Array mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final Uint8ClampedArray mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final Uint8ClampedArray mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final Float32Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final Float32Array mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final Float64Array mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final Float64Array mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final DataView mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final DataView mask) {
    setMask( mask );
    return this;
  }

  @JsOverlay
  default void setMask(@Nonnull final ArrayBuffer mask) {
    setMask( BufferSource.of( mask ) );
  }

  @JsOverlay
  @Nonnull
  default BluetoothDataFilterInit mask(@Nonnull final ArrayBuffer mask) {
    setMask( mask );
    return this;
  }
}
