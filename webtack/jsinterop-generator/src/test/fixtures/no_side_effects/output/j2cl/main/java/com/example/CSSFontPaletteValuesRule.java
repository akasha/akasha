package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "CSSFontPaletteValuesRule"
)
public class CSSFontPaletteValuesRule implements JsIterable<CSSFontPaletteValuesRule.Entry> {
  @JsNonNull
  public String basePalette;

  @JsNonNull
  public String fontFamily;

  protected CSSFontPaletteValuesRule() {
  }

  @JsProperty(
      name = "size"
  )
  public native int size();

  @HasNoSideEffects
  public native boolean has(int key);

  @HasNoSideEffects
  @JsNullable
  public native String get(int key);

  @HasNoSideEffects
  @JsNonNull
  public native JsIterator<Double> keys();

  @HasNoSideEffects
  @JsNonNull
  public native JsIterator<String> values();

  @HasNoSideEffects
  @JsNonNull
  public native JsIterator<Entry> entries();

  public native void forEach(@JsNonNull ForEachCallback callback);

  public native void forEach(@JsNonNull ForEachCallback2 callback);

  public native void forEach(@JsNonNull ForEachCallback3 callback);

  public native void set(int key, @JsNonNull String value);

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
    @Nonnull
    public String value() {
      return getAtAsAny( 1 ).asString();
    }
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback {
    void item(@JsNonNull String value);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2 {
    void item(@JsNonNull String value, int key);
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3 {
    void item(@JsNonNull String value, int key, @JsNonNull CSSFontPaletteValuesRule map);
  }
}
