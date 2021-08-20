package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class Int32ListTestCompile {
  public static Int32List of(final Int32List $instance, final Int32Array value) {
    return Int32List.of( value );
  }

  public static Int32List of(final Int32List $instance, final JsArray<Double> value) {
    return Int32List.of( value );
  }

  public static Int32List of(final Int32List $instance, final double[] value) {
    return Int32List.of( value );
  }

  public static boolean isInt32Array(final Int32List $instance) {
    return $instance.isInt32Array();
  }

  public static Int32Array asInt32Array(final Int32List $instance) {
    return $instance.asInt32Array();
  }

  public static boolean isArray(final Int32List $instance) {
    return $instance.isArray();
  }

  public static JsArray<Double> asArray(final Int32List $instance) {
    return $instance.asArray();
  }
}
