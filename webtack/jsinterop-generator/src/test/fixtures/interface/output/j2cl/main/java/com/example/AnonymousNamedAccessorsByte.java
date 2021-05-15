package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
    name = "AnonymousNamedAccessorsByte"
)
public class AnonymousNamedAccessorsByte {
  protected AnonymousNamedAccessorsByte() {
  }

  @JsOverlay
  public final byte get(@Nonnull final String name) {
    return Js.<JsPropertyMap<Any>>cast( this ).get( name ).asByte();
  }

  @JsOverlay
  public final void set(@Nonnull final String name, final byte value) {
    Js.<JsPropertyMap<Byte>>cast( this ).set( name, value );
  }

  @JsOverlay
  public final void delete(@Nonnull final String name) {
    Js.<JsPropertyMap<?>>cast( this ).delete( name );
  }
}
