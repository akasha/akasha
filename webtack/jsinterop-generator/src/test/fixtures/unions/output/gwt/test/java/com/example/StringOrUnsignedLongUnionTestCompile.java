package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class StringOrUnsignedLongUnionTestCompile {
  static StringOrUnsignedLongUnion $typeReference$;

  public static StringOrUnsignedLongUnion of(final String value) {
    return StringOrUnsignedLongUnion.of( value );
  }

  public static StringOrUnsignedLongUnion of(final int value) {
    return StringOrUnsignedLongUnion.of( value );
  }

  public static boolean isInt(final StringOrUnsignedLongUnion $instance) {
    return $instance.isInt();
  }

  public static int asInt(final StringOrUnsignedLongUnion $instance) {
    return $instance.asInt();
  }

  public static boolean isString(final StringOrUnsignedLongUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final StringOrUnsignedLongUnion $instance) {
    return $instance.asString();
  }
}
