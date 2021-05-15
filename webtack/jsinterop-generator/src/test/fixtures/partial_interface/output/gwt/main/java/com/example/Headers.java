package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

/**
 * This type contains anonymous paired iterable.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Headers"
)
public final class Headers implements JsIterable<Headers.Entry> {
  private Headers() {
  }

  @JsOverlay
  @Nonnull
  public static Headers of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  public native void append(@Nonnull String name, @Nonnull String value);

  public native void delete(@Nonnull String name);

  @Nullable
  public native String get(@Nonnull String name);

  public native boolean has(@Nonnull String name);

  public native void set(@Nonnull String name, @Nonnull String value);

  @HasNoSideEffects
  @Nonnull
  public native JsIterator<String> keys();

  @HasNoSideEffects
  @Nonnull
  public native JsIterator<String> values();

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
    public String value() {
      return getAtAsAny( 1 ).asString();
    }
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback {
    void item(@Nonnull String value);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2 {
    void item(@Nonnull String value, String key);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3 {
    void item(@Nonnull String value, String key, @Nonnull Headers iterable);
  }
}
