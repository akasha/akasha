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
    final OtherPushPermissionDescriptor $instance$ = Js.uncheckedCast( JsPropertyMap.of() );
    $instance$.setName( name );
    $instance$.setSafe( safe );
    return $instance$;
  }

  @JsProperty
  boolean isSafe();

  @JsProperty
  void setSafe(boolean safe);

  @JsOverlay
  @Nonnull
  default OtherPushPermissionDescriptor safe(boolean safe) {
    setSafe( safe );
    return this;
  }
}
