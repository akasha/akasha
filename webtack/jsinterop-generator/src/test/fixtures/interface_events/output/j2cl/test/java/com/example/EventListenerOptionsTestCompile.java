package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class EventListenerOptionsTestCompile {
  static EventListenerOptions $typeReference$;

  public static EventListenerOptions.Builder of() {
    return EventListenerOptions.of();
  }

  public static boolean capture(final EventListenerOptions $instance) {
    return $instance.capture();
  }

  public static void setCapture(final EventListenerOptions $instance, boolean capture) {
    $instance.setCapture( capture );
  }

  public static EventListenerOptions.Builder capture(final EventListenerOptions.Builder $instance,
      final boolean capture) {
    return $instance.capture( capture );
  }
}
