package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class EventTargetTest {
  static EventTarget $typeReference$;

  public static String id(final EventTarget type) {
    return type.id;
  }

  public static void id(final EventTarget type, final String value) {
    type.id = value;
  }

  public static boolean open(final EventTarget type) {
    return type.open();
  }

  public static void addEventListener(final EventTarget $instance, final String type,
      final EventListener callback, final AddEventListenerOptions options) {
    $instance.addEventListener( type, callback, options );
  }

  public static void addEventListener(final EventTarget $instance, final String type,
      final EventListener callback, final boolean options) {
    $instance.addEventListener( type, callback, options );
  }

  public static void addEventListener(final EventTarget $instance, final String type,
      final EventListener callback) {
    $instance.addEventListener( type, callback );
  }

  public static boolean dispatchEvent(final EventTarget $instance, final Event event) {
    return $instance.dispatchEvent( event );
  }

  public static void removeEventListener(final EventTarget $instance, final String type,
      final EventListener callback, final EventListenerOptions options) {
    $instance.removeEventListener( type, callback, options );
  }

  public static void removeEventListener(final EventTarget $instance, final String type,
      final EventListener callback, final boolean options) {
    $instance.removeEventListener( type, callback, options );
  }

  public static void removeEventListener(final EventTarget $instance, final String type,
      final EventListener callback) {
    $instance.removeEventListener( type, callback );
  }
}
