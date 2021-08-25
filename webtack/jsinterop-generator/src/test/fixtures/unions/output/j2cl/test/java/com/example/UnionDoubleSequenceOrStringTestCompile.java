package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionDoubleSequenceOrStringTestCompile {
  public static UnionDoubleSequenceOrString of(final UnionDoubleSequenceOrString $instance,
      final JsArray<Double> value) {
    return UnionDoubleSequenceOrString.of( value );
  }

  public static UnionDoubleSequenceOrString of(final UnionDoubleSequenceOrString $instance,
      final double[] value) {
    return UnionDoubleSequenceOrString.of( value );
  }

  public static UnionDoubleSequenceOrString of(final UnionDoubleSequenceOrString $instance,
      final String value) {
    return UnionDoubleSequenceOrString.of( value );
  }

  public static boolean isArray(final UnionDoubleSequenceOrString $instance) {
    return $instance.isArray();
  }

  public static JsArray<Double> asArray(final UnionDoubleSequenceOrString $instance) {
    return $instance.asArray();
  }

  public static boolean isString(final UnionDoubleSequenceOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionDoubleSequenceOrString $instance) {
    return $instance.asString();
  }
}
