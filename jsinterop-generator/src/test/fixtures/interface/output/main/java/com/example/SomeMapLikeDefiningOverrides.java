package com.example;

import elemental2.core.JsIterator;
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
public class SomeMapLikeDefiningOverrides {
  SomeMapLikeDefiningOverrides() {
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
      name = "?",
      namespace = JsPackage.GLOBAL
  )
  public interface Entry {
    @JsOverlay
    default String key() {
      return Js.asArray( this )[ 0 ].cast();
    }

    @JsOverlay
    default int value() {
      return Js.asArray( this )[ 1 ].cast();
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
