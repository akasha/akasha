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
    final PushPermissionDescriptor $instance$ = Js.uncheckedCast( JsPropertyMap.of() );
    $instance$.setName( name );
    return $instance$;
  }

  @JsProperty
  boolean isUserVisibleOnly();

  @JsProperty
  void setUserVisibleOnly(boolean userVisibleOnly);
}
