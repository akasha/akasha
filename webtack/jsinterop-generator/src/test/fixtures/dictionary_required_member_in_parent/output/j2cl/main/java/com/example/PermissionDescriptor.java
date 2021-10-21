package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
    name = "PermissionDescriptor"
)
public interface PermissionDescriptor {
  @JsOverlay
  @Nonnull
  static PermissionDescriptor name(@Nonnull final String name) {
    final PermissionDescriptor $permissionDescriptor = Js.<PermissionDescriptor>uncheckedCast( JsPropertyMap.of() );
    $permissionDescriptor.setName( name );
    return Js.uncheckedCast( $permissionDescriptor );
  }

  @JsProperty(
      name = "name"
  )
  @JsNonNull
  String name();

  @JsProperty
  void setName(@JsNonNull String name);
}
