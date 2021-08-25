package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionBooleanOrStringTestCompile {
  public static UnionBooleanOrString of(final UnionBooleanOrString $instance, final boolean value) {
    return UnionBooleanOrString.of( value );
  }

  public static UnionBooleanOrString of(final UnionBooleanOrString $instance, final String value) {
    return UnionBooleanOrString.of( value );
  }

  public static boolean isBoolean(final UnionBooleanOrString $instance) {
    return $instance.isBoolean();
  }

  public static boolean asBoolean(final UnionBooleanOrString $instance) {
    return $instance.asBoolean();
  }

  public static boolean isString(final UnionBooleanOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionBooleanOrString $instance) {
    return $instance.asString();
  }
}
