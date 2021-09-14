package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class ReadyStateTypeOrStringTestCompile {
  static ReadyStateTypeOrString $typeReference$;

  public static ReadyStateTypeOrString of(@ReadyStateType final int value) {
    return ReadyStateTypeOrString.of( value );
  }

  public static ReadyStateTypeOrString of(final String value) {
    return ReadyStateTypeOrString.of( value );
  }

  public static boolean isReadyStateType(final ReadyStateTypeOrString $instance) {
    return $instance.isReadyStateType();
  }

  public static int asReadyStateType(final ReadyStateTypeOrString $instance) {
    return $instance.asReadyStateType();
  }

  public static boolean isString(final ReadyStateTypeOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final ReadyStateTypeOrString $instance) {
    return $instance.asString();
  }
}
