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
  static Builder create(@Nonnull final String name, final boolean safe) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).name( name ).safe( safe );
  }

  @JsProperty(
      name = "safe"
  )
  boolean safe();

  @JsProperty
  void setSafe(boolean safe);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends OtherPushPermissionDescriptor {
    @JsOverlay
    @Nonnull
    default Builder safe(final boolean safe) {
      setSafe( safe );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder userVisibleOnly(final boolean userVisibleOnly) {
      setUserVisibleOnly( userVisibleOnly );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder name(@Nonnull final String name) {
      setName( name );
      return this;
    }
  }
}
