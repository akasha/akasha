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
public interface PermissionDescriptor {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final String name1, @Nonnull final String name2) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).name1( name1 ).name2( name2 );
  }

  @JsProperty(
      name = "name1"
  )
  @Nonnull
  String name1();

  @JsProperty
  void setName1(@Nonnull String name1);

  @JsProperty(
      name = "name2"
  )
  @Nonnull
  String name2();

  @JsProperty
  void setName2(@Nonnull String name2);

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

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends PermissionDescriptor {
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
