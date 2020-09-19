package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

/**
 * This tests scenario where enum values start with number.
 */
@Generated("org.realityforge.webtack")
@MagicConstant(
    valuesFromClass = OverSampleType.class
)
public @interface OverSampleType {
  @Nonnull
  String _2x = "2x";

  @Nonnull
  String _4x = "4x";

  @Nonnull
  String none = "none";
}
