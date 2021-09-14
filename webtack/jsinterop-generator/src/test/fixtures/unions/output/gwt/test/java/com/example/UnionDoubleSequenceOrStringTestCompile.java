package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionDoubleSequenceOrStringTestCompile {
  static UnionDoubleSequenceOrString $typeReference$;

  public static UnionDoubleSequenceOrString of(final JsArray<Double> value) {
    return UnionDoubleSequenceOrString.of( value );
  }

  public static UnionDoubleSequenceOrString of(final double[] value) {
    return UnionDoubleSequenceOrString.of( value );
  }

  public static UnionDoubleSequenceOrString of(final String value) {
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
