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
    name = "AnonymousIndexedAccessorsByte"
)
public class AnonymousIndexedAccessorsByte {
  protected AnonymousIndexedAccessorsByte() {
  }

  @JsOverlay
  public final byte getAt(final int index) {
    return Js.<JsArrayLike<Any>>cast( this ).getAt( index ).asByte();
  }

  @JsOverlay
  public final void setAt(final int index, final byte value) {
    Js.<JsArrayLike<Byte>>cast( this ).setAt( index, value );
  }
}
