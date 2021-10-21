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
  static Step1 name1(@Nonnull final String name1) {
    final Builder $pushPermissionDescriptor = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $pushPermissionDescriptor.setName1( name1 );
    return Js.uncheckedCast( $pushPermissionDescriptor );
  }

  @JsProperty(
      name = "userVisibleOnly3"
  )
  boolean userVisibleOnly3();

  @JsProperty
  void setUserVisibleOnly3(boolean userVisibleOnly3);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "PushPermissionDescriptor"
  )
  interface Step1 {
    @JsOverlay
    @Nonnull
    default Builder name2(@Nonnull String name2) {
      Js.<PushPermissionDescriptor>uncheckedCast( this ).setName2( name2 );
      return Js.uncheckedCast( this );
    }
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "PushPermissionDescriptor"
  )
  interface Builder extends PushPermissionDescriptor {
    @JsOverlay
    @Nonnull
    default Builder userVisibleOnly3(final boolean userVisibleOnly3) {
      setUserVisibleOnly3( userVisibleOnly3 );
      return this;
    }
  }
}
