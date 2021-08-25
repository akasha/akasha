package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionFloatOrStringTestCompile {
  public static UnionFloatOrString of(final UnionFloatOrString $instance, final float value) {
    return UnionFloatOrString.of( value );
  }

  public static UnionFloatOrString of(final UnionFloatOrString $instance, final String value) {
    return UnionFloatOrString.of( value );
  }

  public static boolean isFloat(final UnionFloatOrString $instance) {
    return $instance.isFloat();
  }

  public static float asFloat(final UnionFloatOrString $instance) {
    return $instance.asFloat();
  }

  public static boolean isString(final UnionFloatOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionFloatOrString $instance) {
    return $instance.asString();
  }
}
