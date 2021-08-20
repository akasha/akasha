package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class VibratePatternTestCompile {
  @Nonnull
  public static VibratePattern of(final VibratePattern $instance, final int value) {
    return VibratePattern.of( value );
  }

  @Nonnull
  public static VibratePattern of(final VibratePattern $instance,
      @Nonnull final JsArray<Double> value) {
    return VibratePattern.of( value );
  }

  @Nonnull
  public static VibratePattern of(final VibratePattern $instance, @Nonnull final double[] value) {
    return VibratePattern.of( value );
  }

  public static boolean isInt(final VibratePattern $instance) {
    return $instance.isInt();
  }

  public static int asInt(final VibratePattern $instance) {
    return $instance.asInt();
  }

  public static boolean isArray(final VibratePattern $instance) {
    return $instance.isArray();
  }

  public static JsArray<Double> asArray(final VibratePattern $instance) {
    return $instance.asArray();
  }
}
