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

/**
 * A test for a read-write maplike.
 * Also uses types that have a different boxed type and non-boxed type.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SomeOtherType"
)
public class SomeOtherType implements JsIterable<SomeOtherType.Entry> {
  protected SomeOtherType() {
  }

  @JsProperty(
      name = "size"
  )
  public native int size();

  @HasNoSideEffects
  public native boolean has(int key);

  @HasNoSideEffects
  @Nullable
  public native Double get(int key);

  @HasNoSideEffects
  @Nonnull
  public native JsIterator<Double> keys();

  @HasNoSideEffects
  @Nonnull
  public native JsIterator<Double> values();

  @HasNoSideEffects
  @Nonnull
  public native JsIterator<Entry> entries();

  public native void forEach(@Nonnull ForEachCallback callback);

  public native void forEach(@Nonnull ForEachCallback2 callback);

  public native void forEach(@Nonnull ForEachCallback3 callback);

  public native void set(int key, int value);

  public native boolean delete(int key);

  public native void clear();

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Array"
  )
  public static final class Entry extends JsArray<Object> {
    @JsOverlay
    public int key() {
      return getAtAsAny( 0 ).asInt();
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
    void item(int value, int key);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3 {
    void item(int value, int key, @Nonnull SomeOtherType map);
  }
}
