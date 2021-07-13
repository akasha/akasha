package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class SomeReadOnlySetLikeTestCompile {
  static SomeReadOnlySetLike $typeReference$;

  public static int size(SomeReadOnlySetLike $instance) {
    return $instance.size();
  }

  public static boolean has(String key, SomeReadOnlySetLike $instance) {
    return $instance.has( key );
  }

  public static JsIterator<String> keys(SomeReadOnlySetLike $instance) {
    return $instance.keys();
  }

  public static JsIterator<String> values(SomeReadOnlySetLike $instance) {
    return $instance.values();
  }

  public static JsIterator<SomeReadOnlySetLike.Entry> entries(SomeReadOnlySetLike $instance) {
    return $instance.entries();
  }

  public static void forEach(SomeReadOnlySetLike $instance,
      SomeReadOnlySetLike.ForEachCallback callback) {
    $instance.forEach( callback );
  }

  public static void forEach(SomeReadOnlySetLike $instance,
      SomeReadOnlySetLike.ForEachCallback2 callback) {
    $instance.forEach( callback );
  }

  public static void forEach(SomeReadOnlySetLike $instance,
      SomeReadOnlySetLike.ForEachCallback3 callback) {
    $instance.forEach( callback );
  }
}
