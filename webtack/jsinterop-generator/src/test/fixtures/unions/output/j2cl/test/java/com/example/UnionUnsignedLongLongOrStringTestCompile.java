package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionUnsignedLongLongOrStringTestCompile {
  public static UnionUnsignedLongLongOrString of(final int value) {
    return UnionUnsignedLongLongOrString.of( value );
  }

  public static UnionUnsignedLongLongOrString of(final String value) {
    return UnionUnsignedLongLongOrString.of( value );
  }

  public static boolean isInt(final UnionUnsignedLongLongOrString $instance) {
    return $instance.isInt();
  }

  public static int asInt(final UnionUnsignedLongLongOrString $instance) {
    return $instance.asInt();
  }

  public static boolean isString(final UnionUnsignedLongLongOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionUnsignedLongLongOrString $instance) {
    return $instance.asString();
  }
}
