package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WindowTestCompile {
  static Window $typeReference$;

  public static boolean closed(final Window type) {
    return type.closed();
  }

  public static boolean isSecureContext(final Window type) {
    return type.isSecureContext();
  }

  public static String name(final Window type) {
    return type.name;
  }

  public static void name(final Window type, final String value) {
    type.name = value;
  }

  public static Navigator navigator(final Window type) {
    return type.navigator();
  }

  public static void postMessage(final Window $instance,
      @DoNotAutobox final java.lang.Object message, final String targetOrigin,
      final JsArray<Transferable> transfer) {
    $instance.postMessage( message, targetOrigin, transfer );
  }

  public static void postMessage(final Window $instance,
      @DoNotAutobox final java.lang.Object message, final String targetOrigin,
      final Transferable[] transfer) {
    $instance.postMessage( message, targetOrigin, transfer );
  }

  public static void postMessage(final Window $instance,
      @DoNotAutobox final java.lang.Object message, final String targetOrigin) {
    $instance.postMessage( message, targetOrigin );
  }

  public static void scroll(final Window $instance, final double x, final double y) {
    $instance.scroll( x, y );
  }

  public static void scroll(final Window $instance, final ScrollToOptions options) {
    $instance.scroll( options );
  }

  public static void scroll(final Window $instance) {
    $instance.scroll();
  }

  public static Object get(final Window $instance, final String name) {
    return $instance.get( name );
  }
}
