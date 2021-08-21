package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SharedWorkerGlobalScope"
)
public class SharedWorkerGlobalScope extends WorkerGlobalScope {
  protected SharedWorkerGlobalScope() {
  }

  @JsProperty(
      name = "name"
  )
  @Nonnull
  public native String name();
}
