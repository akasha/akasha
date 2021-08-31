package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WebAssemblyInstantiatedSourceTestCompile {
  static WebAssemblyInstantiatedSource $typeReference$;

  public static WebAssemblyInstantiatedSource.Builder create(final Instance instance,
      final Module module) {
    return WebAssemblyInstantiatedSource.create( instance, module );
  }

  public static Instance instance(final WebAssemblyInstantiatedSource $instance) {
    return $instance.instance();
  }

  public static void setInstance(final WebAssemblyInstantiatedSource $instance, Instance instance) {
    $instance.setInstance( instance );
  }

  public static Module module(final WebAssemblyInstantiatedSource $instance) {
    return $instance.module();
  }

  public static void setModule(final WebAssemblyInstantiatedSource $instance, Module module) {
    $instance.setModule( module );
  }

  public static WebAssemblyInstantiatedSource.Builder instance(
      final WebAssemblyInstantiatedSource.Builder $instance, final Instance instance) {
    return $instance.instance( instance );
  }

  public static WebAssemblyInstantiatedSource.Builder module(
      final WebAssemblyInstantiatedSource.Builder $instance, final Module module) {
    return $instance.module( module );
  }
}
