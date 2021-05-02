package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
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
public final class RTCStatsReport {
  private RTCStatsReport() {
  }

  @JsOverlay
  @Nonnull
  public static RTCStatsReport of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  @JsProperty(
      name = "size"
  )
  public native int size();

  @HasNoSideEffects
  public native boolean has(@Nonnull String key);

  @HasNoSideEffects
  @Nullable
  public native Object get(@Nonnull String key);

  @HasNoSideEffects
  @Nonnull
  public native JsIterator<String> keys();

  @HasNoSideEffects
  @Nonnull
  public native JsIterator<Object> values();

  @HasNoSideEffects
  @Nonnull
  public native JsIterator<Entry> entries();

  public native void forEach(@Nonnull ForEachCallback callback);

  public native void forEach(@Nonnull ForEachCallback2 callback);

  public native void forEach(@Nonnull ForEachCallback3 callback);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Array"
  )
  public static final class Entry extends JsArray<Object> {
    @JsOverlay
    @Nonnull
    public String key() {
      return getAtAsAny( 0 ).asString();
    }

    @JsOverlay
    @Nonnull
    public Object value() {
      return getAtAsAny( 1 ).cast();
    }
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback {
    void item(@Nonnull Object value);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2 {
    void item(@Nonnull Object value, @Nonnull String key);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3 {
    void item(@Nonnull Object value, @Nonnull String key, @Nonnull RTCStatsReport map);
  }
}
