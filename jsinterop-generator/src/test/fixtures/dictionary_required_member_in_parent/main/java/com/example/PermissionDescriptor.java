package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface PermissionDescriptor {
  @JsOverlay
  @Nonnull
  static PermissionDescriptor create(@Nonnull final String name) {
    final PermissionDescriptor $instance$ = Js.uncheckedCast( JsPropertyMap.of() );
    $instance$.setName( name );
    return $instance$;
  }

  @JsProperty
  @Nonnull
  String getName();

  @JsProperty
  void setName(@Nonnull String name);

  @JsOverlay
  @Nonnull
  default PermissionDescriptor name(@Nonnull String name) {
    setName( name );
    return this;
  }
}
