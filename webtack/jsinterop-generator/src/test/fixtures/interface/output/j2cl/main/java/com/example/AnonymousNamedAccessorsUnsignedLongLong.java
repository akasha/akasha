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
    name = "AnonymousNamedAccessorsUnsignedLongLong"
)
public class AnonymousNamedAccessorsUnsignedLongLong {
  protected AnonymousNamedAccessorsUnsignedLongLong() {
  }

  @JsOverlay
  public final int get(final @JsNonNull String name) {
    return Js.<JsPropertyMap<Any>>cast( this ).get( name ).asInt();
  }

  @JsOverlay
  public final void set(final @JsNonNull String name, final int value) {
    Js.<JsPropertyMap<Integer>>cast( this ).set( name, value );
  }

  @JsOverlay
  public final void delete(final @JsNonNull String name) {
    Js.<JsPropertyMap<?>>cast( this ).delete( name );
  }
}
