package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class TxCodeTestCompile {
  @Nonnull
  public static TxCode of(final TxCode $instance, @Nonnull final String value) {
    return TxCode.of( value );
  }

  @Nonnull
  public static TxCode of(final TxCode $instance, final int value) {
    return TxCode.of( value );
  }

  public static boolean isString(final TxCode $instance) {
    return $instance.isString();
  }

  public static String asString(final TxCode $instance) {
    return $instance.asString();
  }

  public static boolean isInt(final TxCode $instance) {
    return $instance.isInt();
  }

  public static int asInt(final TxCode $instance) {
    return $instance.asInt();
  }
}
