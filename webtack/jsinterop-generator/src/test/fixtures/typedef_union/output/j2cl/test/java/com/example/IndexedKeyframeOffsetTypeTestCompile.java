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
}
