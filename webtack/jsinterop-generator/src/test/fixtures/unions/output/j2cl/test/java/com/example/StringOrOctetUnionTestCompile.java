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

  public static boolean isString(final StringOrOctetUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final StringOrOctetUnion $instance) {
    return $instance.asString();
  }

  public static boolean isShort(final StringOrOctetUnion $instance) {
    return $instance.isShort();
  }

  public static short asShort(final StringOrOctetUnion $instance) {
    return $instance.asShort();
  }
}
