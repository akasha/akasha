package com.example;

import elemental2.core.JsIterator;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

/**
 * A test for a read-only maplike.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "RTCStatsReport"
)
public class RTCStatsReport {
  RTCStatsReport() {
  }

  @JsProperty(
      name = "size"
  )
  public native int size();

  public native boolean has(@Nonnull String key);

  @Nullable
  public native Object get(@Nonnull String key);

  @Nonnull
  public native JsIterator<String> keys();

  @Nonnull
  public native JsIterator<Object> values();

  @Nonnull
  public native JsIterator<Entry> entries();

  @JsType(
      isNative = true,
      name = "?",
      namespace = JsPackage.GLOBAL
  )
  interface Entry {
    @JsOverlay
    default String key() {
      return Js.asArray( this )[ 0 ].cast();
    }

    @JsOverlay
    default Object value() {
      return Js.asArray( this )[ 1 ].cast();
    }
  }
}
