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
 * Also uses types that have a different boxed type and non-boxed type.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SomeOtherType"
)
public class SomeOtherType {
  SomeOtherType() {
  }

  @JsProperty(
      name = "size"
  )
  public native int size();

  public native boolean has(int key);

  @Nullable
  public native Double get(int key);

  @Nonnull
  public native JsIterator<Double> keys();

  @Nonnull
  public native JsIterator<Double> values();

  public native void set(int key, int value);

  public native boolean delete(int key);

  public native void clear();
}
