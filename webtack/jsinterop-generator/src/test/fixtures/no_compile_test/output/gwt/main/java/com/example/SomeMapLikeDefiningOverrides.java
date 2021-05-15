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

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SomeMapLikeDefiningOverrides"
)
public class SomeMapLikeDefiningOverrides implements JsIterable<SomeMapLikeDefiningOverrides.Entry> {
  protected SomeMapLikeDefiningOverrides() {
  }

  public native void clear();

  public native boolean delete(@Nonnull String key);

  public native void set(@Nonnull String key, int value);

  @JsProperty(
      name = "size"
  )
  public native int size();

  @HasNoSideEffects
  public native boolean has(@Nonnull String key);

  @HasNoSideEffects
  @Nullable
  public native Double get(@Nonnull String key);

  @HasNoSideEffects
  @Nonnull
  public native JsIterator<String> keys();

  @HasNoSideEffects
  @Nonnull
  public native JsIterator<Double> values();

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
