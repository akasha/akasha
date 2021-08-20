package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class LongOrTxModeUnionTestCompile {
  @Nonnull
  public static LongOrTxModeUnion of(final LongOrTxModeUnion $instance, final int value) {
    return LongOrTxModeUnion.of( value );
  }

  @Nonnull
  public static LongOrTxModeUnion of(final LongOrTxModeUnion $instance,
      @TxMode @Nonnull final String value) {
    return LongOrTxModeUnion.of( value );
  }

  public static boolean isTxMode(final LongOrTxModeUnion $instance) {
    return $instance.isTxMode();
  }

  public static String asTxMode(final LongOrTxModeUnion $instance) {
    return $instance.asTxMode();
  }
}
