package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionBooleanSequenceOrStringTestCompile {
  public static UnionBooleanSequenceOrString of(final UnionBooleanSequenceOrString $instance,
      final JsArray<Boolean> value) {
    return UnionBooleanSequenceOrString.of( value );
  }

  public static UnionBooleanSequenceOrString of(final UnionBooleanSequenceOrString $instance,
      final Boolean[] value) {
    return UnionBooleanSequenceOrString.of( value );
  }

  public static UnionBooleanSequenceOrString of(final UnionBooleanSequenceOrString $instance,
      final String value) {
    return UnionBooleanSequenceOrString.of( value );
  }

  public static boolean isArray(final UnionBooleanSequenceOrString $instance) {
    return $instance.isArray();
  }

  public static JsArray<Boolean> asArray(final UnionBooleanSequenceOrString $instance) {
    return $instance.asArray();
  }

  public static boolean isString(final UnionBooleanSequenceOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionBooleanSequenceOrString $instance) {
    return $instance.asString();
  }
}
