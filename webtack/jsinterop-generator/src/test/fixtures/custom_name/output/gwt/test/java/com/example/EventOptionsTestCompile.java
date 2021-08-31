package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class EventOptionsTestCompile {
  static EventOptions $typeReference$;

  public static EventOptions.Builder create() {
    return EventOptions.create();
  }

  public static boolean bubbles(final EventOptions $instance) {
    return $instance.bubbles();
  }

  public static void setBubbles(final EventOptions $instance, boolean bubbles) {
    $instance.setBubbles( bubbles );
  }

  public static boolean cancelable(final EventOptions $instance) {
    return $instance.cancelable();
  }

  public static void setCancelable(final EventOptions $instance, boolean cancelable) {
    $instance.setCancelable( cancelable );
  }

  public static boolean composed(final EventOptions $instance) {
    return $instance.composed();
  }

  public static void setComposed(final EventOptions $instance, boolean composed) {
    $instance.setComposed( composed );
  }

  public static EventOptions.Builder bubbles(final EventOptions.Builder $instance,
      final boolean bubbles) {
    return $instance.bubbles( bubbles );
  }

  public static EventOptions.Builder cancelable(final EventOptions.Builder $instance,
      final boolean cancelable) {
    return $instance.cancelable( cancelable );
  }

  public static EventOptions.Builder composed(final EventOptions.Builder $instance,
      final boolean composed) {
    return $instance.composed( composed );
  }
}
