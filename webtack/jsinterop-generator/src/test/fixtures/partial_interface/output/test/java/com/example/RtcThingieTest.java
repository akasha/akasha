package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class RtcThingieTest {
  public static int size(RtcThingie $instance) {
    return $instance.size();
  }

  public static boolean has(@Nonnull String key, RtcThingie $instance) {
    return $instance.has( key );
  }

  public static Object get(RtcThingie $instance, @Nonnull String key) {
    return $instance.get( key );
  }

  public static JsIterator<String> keys(RtcThingie $instance) {
    return $instance.keys();
  }

  public static JsIterator<Object> values(RtcThingie $instance) {
    return $instance.values();
  }

  public static JsIterator<RtcThingie.Entry> entries(RtcThingie $instance) {
    return $instance.entries();
  }

  public static void forEach(RtcThingie $instance, RtcThingie.ForEachCallback callback) {
    $instance.forEach( callback );
  }

  public static void forEach(RtcThingie $instance, RtcThingie.ForEachCallback2 callback) {
    $instance.forEach( callback );
  }

  public static void forEach(RtcThingie $instance, RtcThingie.ForEachCallback3 callback) {
    $instance.forEach( callback );
  }
}
