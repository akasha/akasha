package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class StringOrFloatUnionTestCompile {
  public static StringOrFloatUnion of(final String value) {
    return StringOrFloatUnion.of( value );
  }

  public static StringOrFloatUnion of(final float value) {
    return StringOrFloatUnion.of( value );
  }

  public static boolean isFloat(final StringOrFloatUnion $instance) {
    return $instance.isFloat();
  }

  public static float asFloat(final StringOrFloatUnion $instance) {
    return $instance.asFloat();
  }

  public static boolean isString(final StringOrFloatUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final StringOrFloatUnion $instance) {
    return $instance.asString();
  }
}
