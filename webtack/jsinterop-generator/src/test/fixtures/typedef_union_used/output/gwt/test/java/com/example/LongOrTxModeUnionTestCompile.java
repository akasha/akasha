package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class LongOrTxModeUnionTestCompile {
  public static LongOrTxModeUnion of(final LongOrTxModeUnion $instance, final int value) {
    return LongOrTxModeUnion.of( value );
  }

  public static LongOrTxModeUnion of(final LongOrTxModeUnion $instance,
      @TxMode final String value) {
    return LongOrTxModeUnion.of( value );
  }

  public static boolean isInt(final LongOrTxModeUnion $instance) {
    return $instance.isInt();
  }

  public static int asInt(final LongOrTxModeUnion $instance) {
    return $instance.asInt();
  }

  public static boolean isTxMode(final LongOrTxModeUnion $instance) {
    return $instance.isTxMode();
  }

  public static String asTxMode(final LongOrTxModeUnion $instance) {
    return $instance.asTxMode();
  }
}