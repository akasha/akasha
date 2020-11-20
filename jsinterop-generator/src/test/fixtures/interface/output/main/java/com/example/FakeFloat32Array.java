package com.example;

import elemental2.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * This tests that values that map to boxed double arrays are transformed into primitive double arrays
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "FakeFloat32Array"
)
public class FakeFloat32Array {
  public FakeFloat32Array(@Nonnull final JsArray<Double> array) {
  }

  public FakeFloat32Array(@Nonnull final double[] array) {
  }

  @Nonnull
  public native JsArray<Double> get(int start, int end);

  public native void set(@Nonnull JsArray<Double> array);

  public native void set(@Nonnull double[] array);
}
