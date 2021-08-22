package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * This type contains anonymous named property operations.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "DOMStringMap"
)
public class DOMStringMap {
  protected DOMStringMap() {
  }

  @JsOverlay
  @JsNonNull
  public final String get(@Nonnull final String name) {
    return Js.<JsPropertyMap<String>>cast( this ).get( name );
  }

  @JsOverlay
  public final void set(@Nonnull final String name, @Nonnull final String value) {
    Js.<JsPropertyMap<String>>cast( this ).set( name, value );
  }

  @JsOverlay
  public final void delete(@Nonnull final String name) {
    Js.<JsPropertyMap<?>>cast( this ).delete( name );
  }
}
