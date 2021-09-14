package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionDoubleOrStringTestCompile {
  static UnionDoubleOrString $typeReference$;

  public static UnionDoubleOrString of(final double value) {
    return UnionDoubleOrString.of( value );
  }

  public static UnionDoubleOrString of(final String value) {
    return UnionDoubleOrString.of( value );
  }

  public static boolean isDouble(final UnionDoubleOrString $instance) {
    return $instance.isDouble();
  }

  public static double asDouble(final UnionDoubleOrString $instance) {
    return $instance.asDouble();
  }

  public static boolean isString(final UnionDoubleOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionDoubleOrString $instance) {
    return $instance.asString();
  }
}
