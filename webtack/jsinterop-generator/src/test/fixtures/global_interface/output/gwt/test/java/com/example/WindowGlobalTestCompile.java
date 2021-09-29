package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WindowGlobalTestCompile {
  public static boolean closed() {
    return WindowGlobal.closed();
  }

  public static boolean isSecureContext() {
    return WindowGlobal.isSecureContext();
  }

  public static String name() {
    return WindowGlobal.name;
  }

  public static void name(final String value) {
    WindowGlobal.name = value;
  }

  public static Navigator navigator() {
    return WindowGlobal.navigator();
  }

  public static void postMessage(@DoNotAutobox final java.lang.Object message,
      final String targetOrigin, final JsArray<Transferable> transfer) {
    WindowGlobal.postMessage( message, targetOrigin, transfer );
  }

  public static void postMessage(@DoNotAutobox final java.lang.Object message,
      final String targetOrigin, final Transferable[] transfer) {
    WindowGlobal.postMessage( message, targetOrigin, transfer );
  }

  public static void postMessage(@DoNotAutobox final java.lang.Object message,
      final String targetOrigin) {
    WindowGlobal.postMessage( message, targetOrigin );
  }

  public static void scroll(final double x, final double y) {
    WindowGlobal.scroll( x, y );
  }

  public static void scroll(final ScrollToOptions options) {
    WindowGlobal.scroll( options );
  }

  public static void scroll() {
    WindowGlobal.scroll();
  }

  public static Object get(final String name) {
    return WindowGlobal.get( name );
  }

  public static String id() {
    return WindowGlobal.id;
  }

  public static void id(final String value) {
    WindowGlobal.id = value;
  }

  public static boolean open() {
    return WindowGlobal.open();
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
