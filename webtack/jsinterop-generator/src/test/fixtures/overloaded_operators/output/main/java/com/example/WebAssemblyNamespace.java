package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Overloaded operator return values.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "WebAssembly"
)
public final class WebAssemblyNamespace {
  private WebAssemblyNamespace() {
  }

  @Nonnull
  public native JsPromise<Instance> instantiate(@Nonnull Module moduleObject,
      @Nonnull Object importObject);

  @Nonnull
  public native JsPromise<Instance> instantiate(@Nonnull Module moduleObject);

  @Nonnull
  public native JsPromise<WebAssemblyInstantiatedSource> instantiate(@Nonnull BufferSource bytes,
      @Nonnull Object importObject);

  @Nonnull
  public native JsPromise<WebAssemblyInstantiatedSource> instantiate(@Nonnull BufferSource bytes);
}
