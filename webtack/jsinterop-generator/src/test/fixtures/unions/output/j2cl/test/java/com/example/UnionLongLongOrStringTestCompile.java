package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionLongLongOrStringTestCompile {
  public static UnionLongLongOrString of(final UnionLongLongOrString $instance, final int value) {
    return UnionLongLongOrString.of( value );
  }

  public static UnionLongLongOrString of(final UnionLongLongOrString $instance,
      final String value) {
    return UnionLongLongOrString.of( value );
  }

  public static boolean isInt(final UnionLongLongOrString $instance) {
    return $instance.isInt();
  }

  public static int asInt(final UnionLongLongOrString $instance) {
    return $instance.asInt();
  }

  public static boolean isString(final UnionLongLongOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionLongLongOrString $instance) {
    return $instance.asString();
  }
}
