package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class StringOrFloatUnionTestCompile {
  @Nonnull
  public static StringOrFloatUnion of(final StringOrFloatUnion $instance,
      @Nonnull final String value) {
    return StringOrFloatUnion.of( value );
  }

  @Nonnull
  public static StringOrFloatUnion of(final StringOrFloatUnion $instance, final float value) {
    return StringOrFloatUnion.of( value );
  }
}
