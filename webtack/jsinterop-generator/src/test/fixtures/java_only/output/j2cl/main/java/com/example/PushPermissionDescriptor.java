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
  static Builder create(@Nonnull final String name1, @Nonnull final String name2) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).name1( name1 ).name2( name2 );
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
  interface Builder extends PushPermissionDescriptor {
    @JsOverlay
    @Nonnull
    default Builder userVisibleOnly3(final boolean userVisibleOnly3) {
      setUserVisibleOnly3( userVisibleOnly3 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder name1(@Nonnull final String name1) {
      setName1( name1 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder name2(@Nonnull final String name2) {
      setName2( name2 );
      return this;
    }

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
