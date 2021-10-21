package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class TransitionEventInitTestCompile {
  static TransitionEventInit $typeReference$;

  public static TransitionEventInit.Builder of() {
    return TransitionEventInit.of();
  }

  public static double elapsedTime(final TransitionEventInit $instance) {
    return $instance.elapsedTime();
  }

  public static void setElapsedTime(final TransitionEventInit $instance, double elapsedTime) {
    $instance.setElapsedTime( elapsedTime );
  }

  public static String propertyName(final TransitionEventInit $instance) {
    return $instance.propertyName();
  }

  public static void setPropertyName(final TransitionEventInit $instance, String propertyName) {
    $instance.setPropertyName( propertyName );
  }

  public static String pseudoElement(final TransitionEventInit $instance) {
    return $instance.pseudoElement();
  }

  public static void setPseudoElement(final TransitionEventInit $instance, String pseudoElement) {
    $instance.setPseudoElement( pseudoElement );
  }

  public static TransitionEventInit.Builder elapsedTime(final TransitionEventInit.Builder $instance,
      final double elapsedTime) {
    return $instance.elapsedTime( elapsedTime );
  }

  public static TransitionEventInit.Builder propertyName(
      final TransitionEventInit.Builder $instance, final String propertyName) {
    return $instance.propertyName( propertyName );
  }

  public static TransitionEventInit.Builder pseudoElement(
      final TransitionEventInit.Builder $instance, final String pseudoElement) {
    return $instance.pseudoElement( pseudoElement );
  }
}
