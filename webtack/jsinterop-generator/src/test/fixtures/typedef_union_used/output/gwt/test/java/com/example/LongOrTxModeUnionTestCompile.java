package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class LongOrTxModeUnionTestCompile {
  static LongOrTxModeUnion $typeReference$;

  public static LongOrTxModeUnion of(final int value) {
    return LongOrTxModeUnion.of( value );
  }

  public static LongOrTxModeUnion of(@TxMode final String value) {
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
