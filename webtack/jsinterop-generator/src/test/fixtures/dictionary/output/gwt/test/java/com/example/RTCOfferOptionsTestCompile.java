package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class RTCOfferOptionsTestCompile {
  static RTCOfferOptions $typeReference$;

  public static RTCOfferOptions.Builder of() {
    return RTCOfferOptions.of();
  }

  public static boolean iceRestart(final RTCOfferOptions $instance) {
    return $instance.iceRestart();
  }

  public static void setIceRestart(final RTCOfferOptions $instance, boolean iceRestart) {
    $instance.setIceRestart( iceRestart );
  }

  public static RTCOfferOptions.Builder iceRestart(final RTCOfferOptions.Builder $instance,
      final boolean iceRestart) {
    return $instance.iceRestart( iceRestart );
  }
}
