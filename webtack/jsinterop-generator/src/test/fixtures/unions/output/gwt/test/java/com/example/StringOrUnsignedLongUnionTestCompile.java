package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class StringOrUnsignedLongUnionTestCompile {
  @Nonnull
  public static StringOrUnsignedLongUnion of(final StringOrUnsignedLongUnion $instance,
      @Nonnull final String value) {
    return StringOrUnsignedLongUnion.of( value );
  }

  @Nonnull
  public static StringOrUnsignedLongUnion of(final StringOrUnsignedLongUnion $instance,
      final int value) {
    return StringOrUnsignedLongUnion.of( value );
  }
}
