package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class StrOrNumberUnionTestCompile {
  public static StrOrNumberUnion of(final StrOrNumberUnion $instance, @Nonnull final String value) {
    return StrOrNumberUnion.of( value );
  }

  public static StrOrNumberUnion of(final StrOrNumberUnion $instance, final double value) {
    return StrOrNumberUnion.of( value );
  }

  public static boolean isString(final StrOrNumberUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final StrOrNumberUnion $instance) {
    return $instance.asString();
  }

  public static boolean isDouble(final StrOrNumberUnion $instance) {
    return $instance.isDouble();
  }

  public static double asDouble(final StrOrNumberUnion $instance) {
    return $instance.asDouble();
  }
}
