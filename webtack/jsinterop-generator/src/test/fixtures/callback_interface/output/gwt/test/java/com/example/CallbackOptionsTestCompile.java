package com.example;

import javax.annotation.processing.Generated;

@Generated("org.realityforge.webtack")
public final class CallbackOptionsTestCompile {
  static CallbackOptions $typeReference$;

  public static CallbackOptions.Builder of() {
    return CallbackOptions.of();
  }

  public static String label(final CallbackOptions $instance) {
    return $instance.label();
  }

  public static void setLabel(final CallbackOptions $instance, String label) {
    $instance.setLabel( label );
  }

  public static CallbackOptions.Builder label(final CallbackOptions.Builder $instance,
      final String label) {
    return $instance.label( label );
  }
}
