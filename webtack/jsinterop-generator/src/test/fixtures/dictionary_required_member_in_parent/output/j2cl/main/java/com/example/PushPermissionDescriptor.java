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
  static Builder name(@Nonnull final String name) {
    final Builder $pushPermissionDescriptor = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $pushPermissionDescriptor.setName( name );
    return Js.uncheckedCast( $pushPermissionDescriptor );
  }

  @JsProperty(
      name = "userVisibleOnly"
  )
  boolean userVisibleOnly();

  @JsProperty
  void setUserVisibleOnly(boolean userVisibleOnly);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "PushPermissionDescriptor"
  )
  interface Builder extends PushPermissionDescriptor {
    @JsOverlay
    @Nonnull
    default Builder userVisibleOnly(final boolean userVisibleOnly) {
      setUserVisibleOnly( userVisibleOnly );
      return this;
    }
  }
}
