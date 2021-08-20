package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class StringOrLongLongUnionTestCompile {
  public static StringOrLongLongUnion of(final StringOrLongLongUnion $instance,
      final String value) {
    return StringOrLongLongUnion.of( value );
  }

  public static StringOrLongLongUnion of(final StringOrLongLongUnion $instance, final int value) {
    return StringOrLongLongUnion.of( value );
  }

  public static boolean isInt(final StringOrLongLongUnion $instance) {
    return $instance.isInt();
  }

  public static int asInt(final StringOrLongLongUnion $instance) {
    return $instance.asInt();
  }

  public static boolean isString(final StringOrLongLongUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final StringOrLongLongUnion $instance) {
    return $instance.asString();
  }
}
