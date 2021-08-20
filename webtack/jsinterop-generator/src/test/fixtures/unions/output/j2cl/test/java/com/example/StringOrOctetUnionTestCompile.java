package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class StringOrOctetUnionTestCompile {
  public static StringOrOctetUnion of(final StringOrOctetUnion $instance, final String value) {
    return StringOrOctetUnion.of( value );
  }

  public static StringOrOctetUnion of(final StringOrOctetUnion $instance, final short value) {
    return StringOrOctetUnion.of( value );
  }

  public static boolean isShort(final StringOrOctetUnion $instance) {
    return $instance.isShort();
  }

  public static short asShort(final StringOrOctetUnion $instance) {
    return $instance.asShort();
  }

  public static boolean isString(final StringOrOctetUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final StringOrOctetUnion $instance) {
    return $instance.asString();
  }
}
