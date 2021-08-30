package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class StrOrNumberUnionTestCompile {
  public static StrOrNumberUnion of(final String value) {
    return StrOrNumberUnion.of( value );
  }

  public static StrOrNumberUnion of(final double value) {
    return StrOrNumberUnion.of( value );
  }

  public static boolean isDouble(final StrOrNumberUnion $instance) {
    return $instance.isDouble();
  }

  public static double asDouble(final StrOrNumberUnion $instance) {
    return $instance.asDouble();
  }

  public static boolean isString(final StrOrNumberUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final StrOrNumberUnion $instance) {
    return $instance.asString();
  }
}
