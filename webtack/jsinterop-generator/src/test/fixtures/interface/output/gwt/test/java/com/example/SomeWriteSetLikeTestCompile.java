package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class SomeWriteSetLikeTestCompile {
  static SomeWriteSetLike $typeReference$;

  public static int size(SomeWriteSetLike $instance) {
    return $instance.size();
  }

  public static boolean has(String key, SomeWriteSetLike $instance) {
    return $instance.has( key );
  }

  public static JsIterator<String> keys(SomeWriteSetLike $instance) {
    return $instance.keys();
  }

  public static JsIterator<String> values(SomeWriteSetLike $instance) {
    return $instance.values();
  }

  public static JsIterator<SomeWriteSetLike.Entry> entries(SomeWriteSetLike $instance) {
    return $instance.entries();
  }

  public static void forEach(SomeWriteSetLike $instance,
      SomeWriteSetLike.ForEachCallback callback) {
    $instance.forEach( callback );
  }

  public static void forEach(SomeWriteSetLike $instance,
      SomeWriteSetLike.ForEachCallback2 callback) {
    $instance.forEach( callback );
  }

  public static void forEach(SomeWriteSetLike $instance,
      SomeWriteSetLike.ForEachCallback3 callback) {
    $instance.forEach( callback );
  }

  public static void add(SomeWriteSetLike $instance, String value) {
    $instance.add( value );
  }

  public static boolean delete(SomeWriteSetLike $instance, String value) {
    return $instance.delete( value );
  }

  public static void clear(SomeWriteSetLike $instance) {
    $instance.clear();
  }
}
