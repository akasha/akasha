package com.example;

import javax.annotation.processing.Generated;
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
      @JsNonNull BufferSource bytes, @JsNonNull Object importObject);

  @JsNonNull
  public static native JsPromise<WebAssemblyInstantiatedSource> instantiate(
      @JsNonNull BufferSource bytes);

  @JsNonNull
  public static native JsPromise<Instance> instantiate(@JsNonNull Module moduleObject,
      @JsNonNull Object importObject);

  @JsNonNull
  public static native JsPromise<Instance> instantiate(@JsNonNull Module moduleObject);
}
