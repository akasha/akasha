package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class HeadersTestCompile {
  public static void append(final Headers $instance, final String name, final String value) {
    $instance.append( name, value );
  }

  public static void delete(final Headers $instance, final String name) {
    $instance.delete( name );
  }

  public static String get(final Headers $instance, final String name) {
    return $instance.get( name );
  }

  public static boolean has(final Headers $instance, final String name) {
    return $instance.has( name );
  }

  public static void set(final Headers $instance, final String name, final String value) {
    $instance.set( name, value );
  }

  public static JsIterator<String> keys(Headers $instance) {
    return $instance.keys();
  }

  public static JsIterator<String> values(Headers $instance) {
    return $instance.values();
  }

  public static JsIterator<Headers.Entry> entries(Headers $instance) {
    return $instance.entries();
  }

  public static void forEach(Headers $instance, Headers.ForEachCallback callback) {
    $instance.forEach( callback );
  }

  public static void forEach(Headers $instance, Headers.ForEachCallback2 callback) {
    $instance.forEach( callback );
  }

  public static void forEach(Headers $instance, Headers.ForEachCallback3 callback) {
    $instance.forEach( callback );
  }
}
