package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * This type contains anonymous named property operations.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "AnonymousNamedAccessorsOctet"
)
public class AnonymousNamedAccessorsOctet {
  protected AnonymousNamedAccessorsOctet() {
  }

  @JsOverlay
  public final short get(final @JsNonNull String name) {
    return Js.<JsPropertyMap<Any>>cast( this ).get( name ).asShort();
  }

  @JsOverlay
  public final void set(final @JsNonNull String name, final short value) {
    Js.<JsPropertyMap<Short>>cast( this ).set( name, value );
  }

  @JsOverlay
  public final void delete(final @JsNonNull String name) {
    Js.<JsPropertyMap<?>>cast( this ).delete( name );
  }
}
