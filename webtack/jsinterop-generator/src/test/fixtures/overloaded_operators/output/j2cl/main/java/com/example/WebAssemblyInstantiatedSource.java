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
    name = "WebAssemblyInstantiatedSource"
)
public interface WebAssemblyInstantiatedSource {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Instance instance, @Nonnull final Module module) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).instance( instance ).module( module );
  }

  @JsProperty(
      name = "instance"
  )
  @JsNonNull
  Instance instance();

  @JsProperty
  void setInstance(@JsNonNull Instance instance);

  @JsProperty(
      name = "module"
  )
  @JsNonNull
  Module module();

  @JsProperty
  void setModule(@JsNonNull Module module);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "WebAssemblyInstantiatedSource"
  )
  interface Builder extends WebAssemblyInstantiatedSource {
    @JsOverlay
    @Nonnull
    default Builder instance(@Nonnull final Instance instance) {
      setInstance( instance );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder module(@Nonnull final Module module) {
      setModule( module );
      return this;
    }
  }
}
