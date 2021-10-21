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
    name = "PushPermissionDescriptor"
)
public interface PushPermissionDescriptor extends PermissionDescriptor {
  @JsOverlay
  @Nonnull
  static PushPermissionDescriptor name(@Nonnull final String name) {
    final PushPermissionDescriptor $pushPermissionDescriptor = Js.<PushPermissionDescriptor>uncheckedCast( JsPropertyMap.of() );
    $pushPermissionDescriptor.setName( name );
    return Js.uncheckedCast( $pushPermissionDescriptor );
  }

  @JsProperty(
      name = "userVisibleOnly"
  )
  boolean userVisibleOnly();

  @JsProperty
  void setUserVisibleOnly(boolean userVisibleOnly);
}
