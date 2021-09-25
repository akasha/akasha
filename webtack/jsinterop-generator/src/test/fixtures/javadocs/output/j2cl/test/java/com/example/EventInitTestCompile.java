package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class EventInitTestCompile {
  static EventInit $typeReference$;

  public static EventInit.Builder cancelable(final boolean cancelable) {
    return EventInit.cancelable( cancelable );
  }

  public static boolean cancelable(final EventInit $instance) {
    return $instance.cancelable();
  }

  public static void setCancelable(final EventInit $instance, boolean cancelable) {
    $instance.setCancelable( cancelable );
  }

  public static boolean bubbles(final EventInit $instance) {
    return $instance.bubbles();
  }

  public static void setBubbles(final EventInit $instance, boolean bubbles) {
    $instance.setBubbles( bubbles );
  }

  public static EventInit.Builder cancelable(final EventInit.Builder $instance,
      final boolean cancelable) {
    return $instance.cancelable( cancelable );
  }

  public static EventInit.Builder bubbles(final EventInit.Builder $instance,
      final boolean bubbles) {
    return $instance.bubbles( bubbles );
  }
}
