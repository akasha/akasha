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
public interface PushPermissionDescriptor extends PermissionDescriptor {
  @JsOverlay
  @Nonnull
  static PushPermissionDescriptor create(@Nonnull final String name) {
    return Js.<PushPermissionDescriptor>uncheckedCast( JsPropertyMap.of() ).name( name );
  }

  @JsProperty(
      name = "userVisibleOnly"
  )
  boolean userVisibleOnly();

  @JsProperty
  void setUserVisibleOnly(boolean userVisibleOnly);

  @JsOverlay
  @Nonnull
  default PushPermissionDescriptor userVisibleOnly(final boolean userVisibleOnly) {
    setUserVisibleOnly( userVisibleOnly );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default PushPermissionDescriptor name(@Nonnull final String name) {
    setName( name );
    return this;
  }
}
