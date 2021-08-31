package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class EventInitTestCompile {
  static EventInit $typeReference$;

  public static EventInit.Builder create() {
    return EventInit.create();
  }

  public static double elapsedTime(final EventInit $instance) {
    return $instance.elapsedTime();
  }

  public static void setElapsedTime(final EventInit $instance, double elapsedTime) {
    $instance.setElapsedTime( elapsedTime );
  }

  public static String propertyName(final EventInit $instance) {
    return $instance.propertyName();
  }

  public static void setPropertyName(final EventInit $instance, String propertyName) {
    $instance.setPropertyName( propertyName );
  }

  public static EventInit.Builder elapsedTime(final EventInit.Builder $instance,
      final double elapsedTime) {
    return $instance.elapsedTime( elapsedTime );
  }

  public static EventInit.Builder propertyName(final EventInit.Builder $instance,
      final String propertyName) {
    return $instance.propertyName( propertyName );
  }
}
