package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class StringOrStringArrayUnionTestCompile {
  @Nonnull
  public static StringOrStringArrayUnion of(final StringOrStringArrayUnion $instance,
      @Nonnull final String value) {
    return StringOrStringArrayUnion.of( value );
  }

  @Nonnull
  public static StringOrStringArrayUnion of(final StringOrStringArrayUnion $instance,
      @Nonnull final JsArray<String> value) {
    return StringOrStringArrayUnion.of( value );
  }

  @Nonnull
  public static StringOrStringArrayUnion of(final StringOrStringArrayUnion $instance,
      @Nonnull final String[] value) {
    return StringOrStringArrayUnion.of( value );
  }

  public static boolean isString(final StringOrStringArrayUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final StringOrStringArrayUnion $instance) {
    return $instance.asString();
  }

  public static boolean isArray(final StringOrStringArrayUnion $instance) {
    return $instance.isArray();
  }

  public static JsArray<String> asArray(final StringOrStringArrayUnion $instance) {
    return $instance.asArray();
  }
}
