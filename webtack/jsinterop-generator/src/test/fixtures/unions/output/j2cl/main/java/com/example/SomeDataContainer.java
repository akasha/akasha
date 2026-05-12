package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SomeDataContainer"
)
public class SomeDataContainer {
  public SomeDataContainer(final @JsNonNull BufferSource data) {
  }

  public SomeDataContainer(final @JsNonNull ArrayBufferView data) {
  }

  public SomeDataContainer(final @JsNonNull Int8Array data) {
  }

  public SomeDataContainer(final @JsNonNull Int16Array data) {
  }

  public SomeDataContainer(final @JsNonNull Int32Array data) {
  }

  public SomeDataContainer(final @JsNonNull Uint8Array data) {
  }

  public SomeDataContainer(final @JsNonNull Uint16Array data) {
  }

  public SomeDataContainer(final @JsNonNull Uint32Array data) {
  }

  public SomeDataContainer(final @JsNonNull Uint8ClampedArray data) {
  }

  public SomeDataContainer(final @JsNonNull Float32Array data) {
  }

  public SomeDataContainer(final @JsNonNull Float64Array data) {
  }

  public SomeDataContainer(final @JsNonNull DataView data) {
  }

  public SomeDataContainer(final @JsNonNull ArrayBuffer data) {
  }

  public static native void myStaticMethodWithUnionArg(@JsNonNull BluetoothDescriptorUUID name);

  public static native void myStaticMethodWithUnionArg(@JsNonNull String name);

  public static native void myStaticMethodWithUnionArg(int name);

  @JsNonNull
  public static native BluetoothDescriptorUUID myStaticMethodWithUnionReturn();
}
