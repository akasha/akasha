package com.example;

import javax.annotation.processing.Generated;
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
  public final String get(final @JsNonNull String name) {
    return Js.<JsPropertyMap<String>>cast( this ).get( name );
  }

  @JsOverlay
  public final void set(final @JsNonNull String name, final @JsNonNull String value) {
    Js.<JsPropertyMap<String>>cast( this ).set( name, value );
  }

  @JsOverlay
  public final void delete(final @JsNonNull String name) {
    Js.<JsPropertyMap<?>>cast( this ).delete( name );
  }
}
