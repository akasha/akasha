package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class StringOrOctetUnionTestCompile {
  @Nonnull
  public static StringOrOctetUnion of(final StringOrOctetUnion $instance,
      @Nonnull final String value) {
    return StringOrOctetUnion.of( value );
  }

  @Nonnull
  public static StringOrOctetUnion of(final StringOrOctetUnion $instance, final short value) {
    return StringOrOctetUnion.of( value );
  }
}
