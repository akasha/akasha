package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Overloaded operator return values.
 */
@JsType(
    isNative = true,
    name = "WebAssembly",
    namespace = JsPackage.GLOBAL
)
@Generated("org.realityforge.webtack")
public final class WebAssembly {
  private WebAssembly() {
  }

  @Nonnull
  public static native JsPromise<WebAssemblyInstantiatedSource> instantiate(
      @Nonnull BufferSource bytes, @Nonnull Object importObject);

  @Nonnull
  public static native JsPromise<WebAssemblyInstantiatedSource> instantiate(
      @Nonnull BufferSource bytes);

  @Nonnull
  public static native JsPromise<Instance> instantiate(@Nonnull Module moduleObject,
      @Nonnull Object importObject);

  @Nonnull
  public static native JsPromise<Instance> instantiate(@Nonnull Module moduleObject);
}
