package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionShortOrStringTestCompile {
  static UnionShortOrString $typeReference$;

  public static UnionShortOrString of(final short value) {
    return UnionShortOrString.of( value );
  }

  public static UnionShortOrString of(final String value) {
    return UnionShortOrString.of( value );
  }

  public static boolean isShort(final UnionShortOrString $instance) {
    return $instance.isShort();
  }

  public static short asShort(final UnionShortOrString $instance) {
    return $instance.asShort();
  }

  public static boolean isString(final UnionShortOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionShortOrString $instance) {
    return $instance.asString();
  }
}
