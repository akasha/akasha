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
  static Step1 name1(@Nonnull final String name1) {
    final Builder $permissionDescriptor = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $permissionDescriptor.setName1( name1 );
    return Js.uncheckedCast( $permissionDescriptor );
  }

  @JsProperty(
      name = "name1"
  )
  @JsNonNull
  String name1();

  @JsProperty
  void setName1(@JsNonNull String name1);

  @JsProperty(
      name = "name2"
  )
  @JsNonNull
  String name2();

  @JsProperty
  void setName2(@JsNonNull String name2);

  @JsProperty(
      name = "userVisibleOnly1"
  )
  boolean userVisibleOnly1();

  @JsProperty
  void setUserVisibleOnly1(boolean userVisibleOnly1);

  @JsProperty(
      name = "userVisibleOnly2"
  )
  boolean userVisibleOnly2();

  @JsProperty
  void setUserVisibleOnly2(boolean userVisibleOnly2);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "PermissionDescriptor"
  )
  interface Step1 {
    @JsOverlay
    @Nonnull
    default Builder name2(@Nonnull String name2) {
      Js.<PermissionDescriptor>uncheckedCast( this ).setName2( name2 );
      return Js.uncheckedCast( this );
    }
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "PermissionDescriptor"
  )
  interface Builder extends PermissionDescriptor {
    @JsOverlay
    @Nonnull
    default Builder userVisibleOnly1(final boolean userVisibleOnly1) {
      setUserVisibleOnly1( userVisibleOnly1 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder userVisibleOnly2(final boolean userVisibleOnly2) {
      setUserVisibleOnly2( userVisibleOnly2 );
      return this;
    }
  }
}
