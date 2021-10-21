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
  static Step1 instance(@Nonnull final Instance instance) {
    final WebAssemblyInstantiatedSource $webAssemblyInstantiatedSource = Js.<WebAssemblyInstantiatedSource>uncheckedCast( JsPropertyMap.of() );
    $webAssemblyInstantiatedSource.setInstance( instance );
    return Js.uncheckedCast( $webAssemblyInstantiatedSource );
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

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "WebAssemblyInstantiatedSource"
  )
  interface Step1 {
    @JsOverlay
    @Nonnull
    default WebAssemblyInstantiatedSource module(@Nonnull Module module) {
      Js.<WebAssemblyInstantiatedSource>uncheckedCast( this ).setModule( module );
      return Js.uncheckedCast( this );
    }
  }
}
