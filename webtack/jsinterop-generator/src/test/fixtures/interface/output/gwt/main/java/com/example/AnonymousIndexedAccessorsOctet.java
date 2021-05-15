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
    name = "AnonymousIndexedAccessorsOctet"
)
public class AnonymousIndexedAccessorsOctet {
  protected AnonymousIndexedAccessorsOctet() {
  }

  @JsOverlay
  public final short getAt(final int index) {
    return Js.<JsArrayLike<Any>>cast( this ).getAt( index ).asShort();
  }

  @JsOverlay
  public final void setAt(final int index, final short value) {
    Js.<JsArrayLike<Short>>cast( this ).setAt( index, value );
  }
}
