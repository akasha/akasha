package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class TransitionEventInitTestCompile {
  static TransitionEventInit $typeReference$;

  public static TransitionEventInit.Builder create() {
    return TransitionEventInit.create();
  }

  public static String pseudoElement(final TransitionEventInit $instance) {
    return $instance.pseudoElement();
  }

  public static void setPseudoElement(final TransitionEventInit $instance, String pseudoElement) {
    $instance.setPseudoElement( pseudoElement );
  }

  public static TransitionEventInit.Builder pseudoElement(
      final TransitionEventInit.Builder $instance, final String pseudoElement) {
    return $instance.pseudoElement( pseudoElement );
  }

  public static TransitionEventInit.Builder elapsedTime(final TransitionEventInit.Builder $instance,
      final double elapsedTime) {
    return $instance.elapsedTime( elapsedTime );
  }

  public static TransitionEventInit.Builder propertyName(
      final TransitionEventInit.Builder $instance, final String propertyName) {
    return $instance.propertyName( propertyName );
  }
}
