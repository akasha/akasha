package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class SomeMapLikeDefiningOverridesTestCompile {
  public static void clear(final SomeMapLikeDefiningOverrides $instance) {
    $instance.clear();
  }

  public static boolean delete(final SomeMapLikeDefiningOverrides $instance, final String key) {
    return $instance.delete( key );
  }

  public static void set(final SomeMapLikeDefiningOverrides $instance, final String key,
      final int value) {
    $instance.set( key, value );
  }

  public static int size(SomeMapLikeDefiningOverrides $instance) {
    return $instance.size();
  }

  public static boolean has(String key, SomeMapLikeDefiningOverrides $instance) {
    return $instance.has( key );
  }

  public static Double get(SomeMapLikeDefiningOverrides $instance, String key) {
    return $instance.get( key );
  }

  public static JsIterator<String> keys(SomeMapLikeDefiningOverrides $instance) {
    return $instance.keys();
  }

  public static JsIterator<Double> values(SomeMapLikeDefiningOverrides $instance) {
    return $instance.values();
  }

  public static JsIterator<SomeMapLikeDefiningOverrides.Entry> entries(
      SomeMapLikeDefiningOverrides $instance) {
    return $instance.entries();
  }

  public static void forEach(SomeMapLikeDefiningOverrides $instance,
      SomeMapLikeDefiningOverrides.ForEachCallback callback) {
    $instance.forEach( callback );
  }

  public static void forEach(SomeMapLikeDefiningOverrides $instance,
      SomeMapLikeDefiningOverrides.ForEachCallback2 callback) {
    $instance.forEach( callback );
  }

  public static void forEach(SomeMapLikeDefiningOverrides $instance,
      SomeMapLikeDefiningOverrides.ForEachCallback3 callback) {
    $instance.forEach( callback );
  }
}
