package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionUnsignedShortOrStringTestCompile {
  public static UnionUnsignedShortOrString of(final UnionUnsignedShortOrString $instance,
      final int value) {
    return UnionUnsignedShortOrString.of( value );
  }

  public static UnionUnsignedShortOrString of(final UnionUnsignedShortOrString $instance,
      final String value) {
    return UnionUnsignedShortOrString.of( value );
  }

  public static boolean isInt(final UnionUnsignedShortOrString $instance) {
    return $instance.isInt();
  }

  public static int asInt(final UnionUnsignedShortOrString $instance) {
    return $instance.asInt();
  }

  public static boolean isString(final UnionUnsignedShortOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionUnsignedShortOrString $instance) {
    return $instance.asString();
  }
}
