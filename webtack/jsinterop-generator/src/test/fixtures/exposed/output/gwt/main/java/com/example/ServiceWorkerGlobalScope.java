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
    name = "ServiceWorkerGlobalScope"
)
public class ServiceWorkerGlobalScope extends WorkerGlobalScope {
  protected ServiceWorkerGlobalScope() {
  }

  @JsProperty(
      name = "serviceWorkerGlobalScopeAttribute"
  )
  @Nonnull
  public native String serviceWorkerGlobalScopeAttribute();
}
