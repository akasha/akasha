package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class Int32ListTestCompile {
  @Nonnull
  public static Int32List of(final Int32List $instance, @Nonnull final Int32Array value) {
    return Int32List.of( value );
  }

  @Nonnull
  public static Int32List of(final Int32List $instance, @Nonnull final JsArray<Double> value) {
    return Int32List.of( value );
  }

  @Nonnull
  public static Int32List of(final Int32List $instance, @Nonnull final double[] value) {
    return Int32List.of( value );
  }

  public static boolean isInt32Array(final Int32List $instance) {
    return $instance.isInt32Array();
  }

  public static Int32Array asInt32Array(final Int32List $instance) {
    return $instance.asInt32Array();
  }
}
