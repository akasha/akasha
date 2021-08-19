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
    name = "goog.global"
)
public final class ServiceWorkerGlobalScopeGlobal {
  private ServiceWorkerGlobalScopeGlobal() {
  }

  @JsProperty(
      name = "serviceWorkerGlobalScopeAttribute"
  )
  @Nonnull
  public static native String serviceWorkerGlobalScopeAttribute();

  @JsProperty(
      name = "workerGlobalScopeAttribute"
  )
  @Nonnull
  public static native String workerGlobalScopeAttribute();
}
