package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionByteOrStringTestCompile {
  public static UnionByteOrString of(final byte value) {
    return UnionByteOrString.of( value );
  }

  public static UnionByteOrString of(final String value) {
    return UnionByteOrString.of( value );
  }

  public static boolean isByte(final UnionByteOrString $instance) {
    return $instance.isByte();
  }

  public static byte asByte(final UnionByteOrString $instance) {
    return $instance.asByte();
  }

  public static boolean isString(final UnionByteOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionByteOrString $instance) {
    return $instance.asString();
  }
}
