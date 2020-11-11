package com.example;

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
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SomeDataContainer"
)
public class SomeDataContainer {
  public SomeDataContainer(@Nonnull final BufferSource data) {
  }

  public SomeDataContainer(@Nonnull final ArrayBufferView data) {
  }

  public SomeDataContainer(@Nonnull final Int8Array data) {
  }

  public SomeDataContainer(@Nonnull final Int16Array data) {
  }

  public SomeDataContainer(@Nonnull final Int32Array data) {
  }

  public SomeDataContainer(@Nonnull final Uint8Array data) {
  }

  public SomeDataContainer(@Nonnull final Uint16Array data) {
  }

  public SomeDataContainer(@Nonnull final Uint32Array data) {
  }

  public SomeDataContainer(@Nonnull final Uint8ClampedArray data) {
  }

  public SomeDataContainer(@Nonnull final Float32Array data) {
  }

  public SomeDataContainer(@Nonnull final Float64Array data) {
  }

  public SomeDataContainer(@Nonnull final DataView data) {
  }

  public SomeDataContainer(@Nonnull final ArrayBuffer data) {
  }

  public static native void myStaticMethodWithUnionArg(@Nonnull BluetoothDescriptorUUID name);

  public static native void myStaticMethodWithUnionArg(@Nonnull String name);

  public static native void myStaticMethodWithUnionArg(int name);

  @Nonnull
  public static native BluetoothDescriptorUUID myStaticMethodWithUnionReturn();
}
