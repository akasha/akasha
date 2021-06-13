package com.example;

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