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
public interface WebAssemblyInstantiatedSource {
  @JsOverlay
  @Nonnull
  static WebAssemblyInstantiatedSource create(@Nonnull final Instance instance,
      @Nonnull final Module module) {
    return Js.<WebAssemblyInstantiatedSource>uncheckedCast( JsPropertyMap.of() ).instance( instance ).module( module );
  }

  @JsProperty(
      name = "instance"
  )
  @Nonnull
  Instance instance();

  @JsProperty
  void setInstance(@Nonnull Instance instance);

  @JsOverlay
  @Nonnull
  default WebAssemblyInstantiatedSource instance(@Nonnull final Instance instance) {
    setInstance( instance );
    return this;
  }

  @JsProperty(
      name = "module"
  )
  @Nonnull
  Module module();

  @JsProperty
  void setModule(@Nonnull Module module);

  @JsOverlay
  @Nonnull
  default WebAssemblyInstantiatedSource module(@Nonnull final Module module) {
    setModule( module );
    return this;
  }
}
