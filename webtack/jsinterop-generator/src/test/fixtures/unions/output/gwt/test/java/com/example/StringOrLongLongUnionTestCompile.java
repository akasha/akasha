package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class StringOrLongLongUnionTestCompile {
  @Nonnull
  public static StringOrLongLongUnion of(final StringOrLongLongUnion $instance,
      @Nonnull final String value) {
    return StringOrLongLongUnion.of( value );
  }

  @Nonnull
  public static StringOrLongLongUnion of(final StringOrLongLongUnion $instance, final int value) {
    return StringOrLongLongUnion.of( value );
  }
}
