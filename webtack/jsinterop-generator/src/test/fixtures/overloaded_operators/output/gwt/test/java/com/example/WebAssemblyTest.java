package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WebAssemblyTest {
  public static JsPromise<WebAssemblyInstantiatedSource> instantiate(final BufferSource bytes,
      final Object importObject) {
    return WebAssembly.instantiate( bytes, importObject );
  }

  public static JsPromise<WebAssemblyInstantiatedSource> instantiate(final BufferSource bytes) {
    return WebAssembly.instantiate( bytes );
  }

  public static JsPromise<Instance> instantiate(final Module moduleObject,
      final Object importObject) {
    return WebAssembly.instantiate( moduleObject, importObject );
  }

  public static JsPromise<Instance> instantiate(final Module moduleObject) {
    return WebAssembly.instantiate( moduleObject );
  }
}
