package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionUnsignedShortOrStringTestCompile {
  static UnionUnsignedShortOrString $typeReference$;

  public static UnionUnsignedShortOrString of(final int value) {
    return UnionUnsignedShortOrString.of( value );
  }

  public static UnionUnsignedShortOrString of(final String value) {
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
