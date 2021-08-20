package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class StrOrNumberUnionTestCompile {
  @Nonnull
  public static StrOrNumberUnion of(final StrOrNumberUnion $instance, @Nonnull final String value) {
    return StrOrNumberUnion.of( value );
  }

  @Nonnull
  public static StrOrNumberUnion of(final StrOrNumberUnion $instance, final double value) {
    return StrOrNumberUnion.of( value );
  }
}
