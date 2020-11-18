package com.example;

import elemental2.core.JsArray;
import elemental2.core.JsIterator;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

/**
 * An indexed iterable.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "DOMTokenList"
)
public final class DOMTokenList {
  private DOMTokenList() {
  }

  @JsOverlay
  @Nonnull
  public static DOMTokenList of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  @Nonnull
  public native JsIterator<Double> keys();

  @Nonnull
  public native JsIterator<String> values();

  @Nonnull
  public native JsIterator<Entry> entries();

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Array"
  )
  public static final class Entry extends JsArray<Object> {
    @JsOverlay
    public final int index() {
      return getAtAsAny( 0 ).asInt();
    }

    @JsOverlay
    @Nonnull
    public final String value() {
      return getAtAsAny( 0 ).cast();
    }
  }
}
