package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionUnsignedLongOrStringTestCompile {
  static UnionUnsignedLongOrString $typeReference$;

  public static UnionUnsignedLongOrString of(final int value) {
    return UnionUnsignedLongOrString.of( value );
  }

  public static UnionUnsignedLongOrString of(final String value) {
    return UnionUnsignedLongOrString.of( value );
  }

  public static boolean isInt(final UnionUnsignedLongOrString $instance) {
    return $instance.isInt();
  }

  public static int asInt(final UnionUnsignedLongOrString $instance) {
    return $instance.asInt();
  }

  public static boolean isString(final UnionUnsignedLongOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionUnsignedLongOrString $instance) {
    return $instance.asString();
  }
}
