package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class MyTypedefedUnionTestCompile {
  @Nonnull
  public static MyTypedefedUnion of(final MyTypedefedUnion $instance, @Nonnull final String value) {
    return MyTypedefedUnion.of( value );
  }

  @Nonnull
  public static MyTypedefedUnion of(final MyTypedefedUnion $instance, final double value) {
    return MyTypedefedUnion.of( value );
  }

  public static boolean isString(final MyTypedefedUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final MyTypedefedUnion $instance) {
    return $instance.asString();
  }

  public static boolean isDouble(final MyTypedefedUnion $instance) {
    return $instance.isDouble();
  }

  public static double asDouble(final MyTypedefedUnion $instance) {
    return $instance.asDouble();
  }
}
