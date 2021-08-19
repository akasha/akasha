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
    name = "DedicatedWorkerGlobalScope"
)
public class DedicatedWorkerGlobalScope extends WorkerGlobalScope {
  protected DedicatedWorkerGlobalScope() {
  }

  @JsProperty(
      name = "dedicatedWorkerGlobalScopeAttribute"
  )
  @Nonnull
  public native String dedicatedWorkerGlobalScopeAttribute();
}
