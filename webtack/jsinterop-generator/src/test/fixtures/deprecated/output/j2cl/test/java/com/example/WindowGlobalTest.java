package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WindowGlobalTest {
  @Deprecated
  public static boolean isSecureContext() {
    return WindowGlobal.isSecureContext();
  }

  @Deprecated
  public static String name() {
    return WindowGlobal.name;
  }

  @Deprecated
  public static void name(final String value) {
    WindowGlobal.name = value;
  }

  public static void addEventListener(final String type, final EventListener callback,
      final AddEventListenerOptions options) {
    WindowGlobal.addEventListener( type, callback, options );
  }

  public static void addEventListener(final String type, final EventListener callback,
      final boolean options) {
    WindowGlobal.addEventListener( type, callback, options );
  }

  public static void addEventListener(final String type, final EventListener callback) {
    WindowGlobal.addEventListener( type, callback );
  }

  public static boolean dispatchEvent(final Event event) {
    return WindowGlobal.dispatchEvent( event );
  }

  public static void removeEventListener(final String type, final EventListener callback,
      final EventListenerOptions options) {
    WindowGlobal.removeEventListener( type, callback, options );
  }

  public static void removeEventListener(final String type, final EventListener callback,
      final boolean options) {
    WindowGlobal.removeEventListener( type, callback, options );
  }

  public static void removeEventListener(final String type, final EventListener callback) {
    WindowGlobal.removeEventListener( type, callback );
  }
}
