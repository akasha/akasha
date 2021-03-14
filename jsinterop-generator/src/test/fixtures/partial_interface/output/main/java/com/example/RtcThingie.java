package com.example;

import akasha.lang.JsArray;
import akasha.lang.JsIterator;
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
 * This tests that lowercase name converted to uppercase when converted into java.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "rtcThingie"
)
public final class RtcThingie {
  private RtcThingie() {
  }

  @JsOverlay
  @Nonnull
  public static RtcThingie of(@Nonnull final Object object) {
    return Js.cast( object );
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
    void item(@Nonnull Object value, @Nonnull String key, @Nonnull RtcThingie map);
  }
}
