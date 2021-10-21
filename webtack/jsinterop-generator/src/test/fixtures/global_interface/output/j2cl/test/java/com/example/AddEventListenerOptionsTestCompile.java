package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class AddEventListenerOptionsTestCompile {
  static AddEventListenerOptions $typeReference$;

  public static AddEventListenerOptions.Builder of() {
    return AddEventListenerOptions.of();
  }

  public static boolean once(final AddEventListenerOptions $instance) {
    return $instance.once();
  }

  public static void setOnce(final AddEventListenerOptions $instance, boolean once) {
    $instance.setOnce( once );
  }

  public static boolean passive(final AddEventListenerOptions $instance) {
    return $instance.passive();
  }

  public static void setPassive(final AddEventListenerOptions $instance, boolean passive) {
    $instance.setPassive( passive );
  }

  public static AddEventListenerOptions.Builder once(
      final AddEventListenerOptions.Builder $instance, final boolean once) {
    return $instance.once( once );
  }

  public static AddEventListenerOptions.Builder passive(
      final AddEventListenerOptions.Builder $instance, final boolean passive) {
    return $instance.passive( passive );
  }

  public static AddEventListenerOptions.Builder capture(
      final AddEventListenerOptions.Builder $instance, final boolean capture) {
    return $instance.capture( capture );
  }
}
