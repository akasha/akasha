package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WaveShaperOptionsTestCompile {
  static WaveShaperOptions $typeReference$;

  public static WaveShaperOptions.Builder of() {
    return WaveShaperOptions.of();
  }

  public static String oversample(final WaveShaperOptions $instance) {
    return $instance.oversample();
  }

  public static void setOversample(final WaveShaperOptions $instance, String oversample) {
    $instance.setOversample( oversample );
  }

  public static WaveShaperOptions.Builder oversample(final WaveShaperOptions.Builder $instance,
      final String oversample) {
    return $instance.oversample( oversample );
  }
}
