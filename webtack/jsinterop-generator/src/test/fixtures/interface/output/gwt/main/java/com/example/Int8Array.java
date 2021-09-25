package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * An indexed iterable where the type needs to be boxed.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Int8Array"
)
public class Int8Array implements JsIterable<Int8Array.Entry> {
  protected Int8Array() {
  }

  @HasNoSideEffects
  @JsNonNull
  public native JsIterator<Double> keys();

  @HasNoSideEffects
  @JsNonNull
  public native JsIterator<Double> values();

  @HasNoSideEffects
  @JsNonNull
  public native JsIterator<Entry> entries();

  public native void forEach(@JsNonNull ForEachCallback callback);

  public native void forEach(@JsNonNull ForEachCallback2 callback);

  public native void forEach(@JsNonNull ForEachCallback3 callback);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Array"
  )
  public static final class Entry extends JsArray<Object> {
    @JsOverlay
    public int index() {
      return getAtAsAny( 0 ).asInt();
    }

    @JsOverlay
    public byte value() {
      return getAtAsAny( 1 ).asByte();
    }
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback {
    void item(byte value);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2 {
    void item(byte value, int index);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3 {
    void item(byte value, int index, @JsNonNull Int8Array iterable);
  }
}
