package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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

  @JsNonNull
  public static native JsPromise<WebAssemblyInstantiatedSource> instantiate(
      @Nonnull BufferSource bytes, @Nonnull Object importObject);

  @JsNonNull
  public static native JsPromise<WebAssemblyInstantiatedSource> instantiate(
      @Nonnull BufferSource bytes);

  @JsNonNull
  public static native JsPromise<Instance> instantiate(@Nonnull Module moduleObject,
      @Nonnull Object importObject);

  @JsNonNull
  public static native JsPromise<Instance> instantiate(@Nonnull Module moduleObject);
}
