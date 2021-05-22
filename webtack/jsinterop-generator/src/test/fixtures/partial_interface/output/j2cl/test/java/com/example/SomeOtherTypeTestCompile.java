package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class SomeOtherTypeTestCompile {
  public static int size(SomeOtherType $instance) {
    return $instance.size();
  }

  public static boolean has(int key, SomeOtherType $instance) {
    return $instance.has( key );
  }

  public static Double get(SomeOtherType $instance, int key) {
    return $instance.get( key );
  }

  public static JsIterator<Double> keys(SomeOtherType $instance) {
    return $instance.keys();
  }

  public static JsIterator<Double> values(SomeOtherType $instance) {
    return $instance.values();
  }

  public static JsIterator<SomeOtherType.Entry> entries(SomeOtherType $instance) {
    return $instance.entries();
  }

  public static void forEach(SomeOtherType $instance, SomeOtherType.ForEachCallback callback) {
    $instance.forEach( callback );
  }

  public static void forEach(SomeOtherType $instance, SomeOtherType.ForEachCallback2 callback) {
    $instance.forEach( callback );
  }

  public static void forEach(SomeOtherType $instance, SomeOtherType.ForEachCallback3 callback) {
    $instance.forEach( callback );
  }

  public static void set(SomeOtherType $instance, int key, int value) {
    $instance.set( key, value );
  }

  public static boolean delete(SomeOtherType $instance, int key) {
    return $instance.delete( key );
  }

  public static void clear(SomeOtherType $instance) {
    $instance.clear();
  }
}
