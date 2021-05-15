package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsArrayLike;

/**
 * This type contains anonymous indexed property operations.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "AnonymousIndexedAccessorsLong"
)
public class AnonymousIndexedAccessorsLong {
  protected AnonymousIndexedAccessorsLong() {
  }

  @JsOverlay
  public final int getAt(final int index) {
    return Js.<JsArrayLike<Any>>cast( this ).getAt( index ).asInt();
  }

  @JsOverlay
  public final void setAt(final int index, final int value) {
    Js.<JsArrayLike<Integer>>cast( this ).setAt( index, value );
  }
}
