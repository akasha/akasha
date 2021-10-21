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
    name = "Object"
)
public interface OtherPushPermissionDescriptor extends PushPermissionDescriptor {
  @JsOverlay
  @Nonnull
  static Step1 name(@Nonnull final String name) {
    final Builder $otherPushPermissionDescriptor = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $otherPushPermissionDescriptor.setName( name );
    return Js.uncheckedCast( $otherPushPermissionDescriptor );
  }

  @JsProperty(
      name = "safe"
  )
  boolean safe();

  @JsProperty
  void setSafe(boolean safe);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Step1 {
    @JsOverlay
    @Nonnull
    default Builder safe(boolean safe) {
      Js.<OtherPushPermissionDescriptor>uncheckedCast( this ).setSafe( safe );
      return Js.uncheckedCast( this );
    }
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends OtherPushPermissionDescriptor {
  }
}
