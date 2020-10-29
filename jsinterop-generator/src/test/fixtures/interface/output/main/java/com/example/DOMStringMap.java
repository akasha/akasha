package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
  @Nonnull
  public final String get(@Nonnull final String name) {
    return Js.<JsPropertyMap<String>>cast( this ).get( name );
  }
}
