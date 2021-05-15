package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class StorageTest {
  static Storage $typeReference$;

  public static int length(final Storage type) {
    return type.length();
  }

  public static void clear(final Storage $instance) {
    $instance.clear();
  }

  public static String key(final Storage $instance, final int index) {
    return $instance.key( index );
  }

  public static String getItem(final Storage $instance, final String key) {
    return $instance.getItem( key );
  }

  public static void setItem(final Storage $instance, final String key, final String value) {
    $instance.setItem( key, value );
  }

  public static void removeItem(final Storage $instance, final String key) {
    $instance.removeItem( key );
  }
}
