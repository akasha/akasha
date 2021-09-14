package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionUnrestrictedFloatOrStringTestCompile {
  static UnionUnrestrictedFloatOrString $typeReference$;

  public static UnionUnrestrictedFloatOrString of(final float value) {
    return UnionUnrestrictedFloatOrString.of( value );
  }

  public static UnionUnrestrictedFloatOrString of(final String value) {
    return UnionUnrestrictedFloatOrString.of( value );
  }

  public static boolean isFloat(final UnionUnrestrictedFloatOrString $instance) {
    return $instance.isFloat();
  }

  public static float asFloat(final UnionUnrestrictedFloatOrString $instance) {
    return $instance.asFloat();
  }

  public static boolean isString(final UnionUnrestrictedFloatOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionUnrestrictedFloatOrString $instance) {
    return $instance.asString();
  }
}
