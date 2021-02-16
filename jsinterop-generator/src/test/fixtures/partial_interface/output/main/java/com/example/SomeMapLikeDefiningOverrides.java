package com.example;

import elemental3.lang.JsArray;
import elemental3.lang.JsIterator;
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
 * A test for a read-write maplike.
 * Also uses a value type that has a different boxed type non-boxed type.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SomeMapLikeDefiningOverrides"
)
public final class SomeMapLikeDefiningOverrides {
  private SomeMapLikeDefiningOverrides() {
  }

  @JsOverlay
  @Nonnull
  public static SomeMapLikeDefiningOverrides of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  public native void clear();

  public native boolean delete(@Nonnull String key);

  public native void set(@Nonnull String key, int value);

  @JsProperty(
      name = "size"
  )
  public native int size();

  public native boolean has(@Nonnull String key);

  @Nullable
  public native Double get(@Nonnull String key);

  @Nonnull
  public native JsIterator<String> keys();

  @Nonnull
  public native JsIterator<Double> values();

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
    public int value() {
      return getAtAsAny( 1 ).asInt();
    }
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback {
    void item(int value);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2 {
    void item(int value, @Nonnull String key);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3 {
    void item(int value, @Nonnull String key, @Nonnull SomeMapLikeDefiningOverrides map);
  }
}
