package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionOctetOrStringTestCompile {
  public static UnionOctetOrString of(final UnionOctetOrString $instance, final short value) {
    return UnionOctetOrString.of( value );
  }

  public static UnionOctetOrString of(final UnionOctetOrString $instance, final String value) {
    return UnionOctetOrString.of( value );
  }

  public static boolean isShort(final UnionOctetOrString $instance) {
    return $instance.isShort();
  }

  public static short asShort(final UnionOctetOrString $instance) {
    return $instance.asShort();
  }

  public static boolean isString(final UnionOctetOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionOctetOrString $instance) {
    return $instance.asString();
  }
}
