package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class StringifySpaceUnionTypeTestCompile {
  @Nonnull
  public static StringifySpaceUnionType of(final StringifySpaceUnionType $instance,
      @Nonnull final String value) {
    return StringifySpaceUnionType.of( value );
  }

  @Nonnull
  public static StringifySpaceUnionType of(final StringifySpaceUnionType $instance,
      final int value) {
    return StringifySpaceUnionType.of( value );
  }

  public static boolean isString(final StringifySpaceUnionType $instance) {
    return $instance.isString();
  }

  public static String asString(final StringifySpaceUnionType $instance) {
    return $instance.asString();
  }

  public static boolean isInt(final StringifySpaceUnionType $instance) {
    return $instance.isInt();
  }

  public static int asInt(final StringifySpaceUnionType $instance) {
    return $instance.asInt();
  }
}
