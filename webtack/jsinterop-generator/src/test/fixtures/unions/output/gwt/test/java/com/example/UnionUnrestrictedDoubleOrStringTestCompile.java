package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionUnrestrictedDoubleOrStringTestCompile {
  static UnionUnrestrictedDoubleOrString $typeReference$;

  public static UnionUnrestrictedDoubleOrString of(final double value) {
    return UnionUnrestrictedDoubleOrString.of( value );
  }

  public static UnionUnrestrictedDoubleOrString of(final String value) {
    return UnionUnrestrictedDoubleOrString.of( value );
  }

  public static boolean isDouble(final UnionUnrestrictedDoubleOrString $instance) {
    return $instance.isDouble();
  }

  public static double asDouble(final UnionUnrestrictedDoubleOrString $instance) {
    return $instance.asDouble();
  }

  public static boolean isString(final UnionUnrestrictedDoubleOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionUnrestrictedDoubleOrString $instance) {
    return $instance.asString();
  }
}
