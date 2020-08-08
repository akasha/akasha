package com.example;

import elemental2.core.JsIterator;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

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
}
