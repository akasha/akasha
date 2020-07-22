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
public interface OtherPushPermissionDescriptor extends PushPermissionDescriptor {
  @JsOverlay
  @Nonnull
  static OtherPushPermissionDescriptor create(@Nonnull final String name, final boolean safe) {
    return Js.<OtherPushPermissionDescriptor>uncheckedCast( JsPropertyMap.of() ).name( name ).safe( safe );
  }

  @JsProperty
  boolean isSafe();

  @JsProperty
  void setSafe(boolean safe);

  @JsOverlay
  @Nonnull
  default OtherPushPermissionDescriptor safe(final boolean safe) {
    setSafe( safe );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default OtherPushPermissionDescriptor userVisibleOnly(final boolean userVisibleOnly) {
    setUserVisibleOnly( userVisibleOnly );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default OtherPushPermissionDescriptor name(@Nonnull final String name) {
    setName( name );
    return this;
  }
}
