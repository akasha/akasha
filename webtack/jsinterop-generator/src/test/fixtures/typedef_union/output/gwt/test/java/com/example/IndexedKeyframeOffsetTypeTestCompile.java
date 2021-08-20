package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("org.realityforge.webtack")
public final class IndexedKeyframeOffsetTypeTestCompile {
  @Nullable
  public static IndexedKeyframeOffsetType of(final IndexedKeyframeOffsetType $instance,
      @Nullable final Double value) {
    return IndexedKeyframeOffsetType.of( value );
  }

  @Nonnull
  public static IndexedKeyframeOffsetType of(final IndexedKeyframeOffsetType $instance,
      @Nonnull final JsArray<Double> value) {
    return IndexedKeyframeOffsetType.of( value );
  }

  @Nonnull
  public static IndexedKeyframeOffsetType of(final IndexedKeyframeOffsetType $instance,
      @Nonnull final double[] value) {
    return IndexedKeyframeOffsetType.of( value );
  }

  public static boolean isDouble(final IndexedKeyframeOffsetType $instance) {
    return $instance.isDouble();
  }

  public static Double asDouble(final IndexedKeyframeOffsetType $instance) {
    return $instance.asDouble();
  }

  public static boolean isArray(final IndexedKeyframeOffsetType $instance) {
    return $instance.isArray();
  }

  public static JsArray<Double> asArray(final IndexedKeyframeOffsetType $instance) {
    return $instance.asArray();
  }
}
