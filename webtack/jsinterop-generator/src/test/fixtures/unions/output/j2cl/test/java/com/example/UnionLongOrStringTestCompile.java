package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionLongOrStringTestCompile {
  public static UnionLongOrString of(final UnionLongOrString $instance, final int value) {
    return UnionLongOrString.of( value );
  }

  public static UnionLongOrString of(final UnionLongOrString $instance, final String value) {
    return UnionLongOrString.of( value );
  }

  public static boolean isInt(final UnionLongOrString $instance) {
    return $instance.isInt();
  }

  public static int asInt(final UnionLongOrString $instance) {
    return $instance.asInt();
  }

  public static boolean isString(final UnionLongOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionLongOrString $instance) {
    return $instance.asString();
  }
}
