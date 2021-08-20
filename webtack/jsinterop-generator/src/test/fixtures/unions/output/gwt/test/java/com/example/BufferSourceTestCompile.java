package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class BufferSourceTestCompile {
  @Nonnull
  public static BufferSource of(final BufferSource $instance,
      @Nonnull final ArrayBufferView value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance, @Nonnull final Int8Array value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance, @Nonnull final Int16Array value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance, @Nonnull final Int32Array value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance, @Nonnull final Uint8Array value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance, @Nonnull final Uint16Array value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance, @Nonnull final Uint32Array value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance,
      @Nonnull final Uint8ClampedArray value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance, @Nonnull final Float32Array value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance, @Nonnull final Float64Array value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance, @Nonnull final DataView value) {
    return BufferSource.of( value );
  }

  @Nonnull
  public static BufferSource of(final BufferSource $instance, @Nonnull final ArrayBuffer value) {
    return BufferSource.of( value );
  }

  public static boolean isArrayBufferView(final BufferSource $instance) {
    return $instance.isArrayBufferView();
  }

  public static ArrayBufferView asArrayBufferView(final BufferSource $instance) {
    return $instance.asArrayBufferView();
  }

  public static boolean isArrayBuffer(final BufferSource $instance) {
    return $instance.isArrayBuffer();
  }

  public static ArrayBuffer asArrayBuffer(final BufferSource $instance) {
    return $instance.asArrayBuffer();
  }
}
