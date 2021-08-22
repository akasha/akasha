package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
public final class ServiceWorkerGlobal {
  private ServiceWorkerGlobal() {
  }

  @JsProperty(
      name = "serviceWorkerGlobalScopeAttribute"
  )
  @JsNonNull
  public static native String serviceWorkerGlobalScopeAttribute();

  @JsProperty(
      name = "workerGlobalScopeAttribute"
  )
  @JsNonNull
  public static native String workerGlobalScopeAttribute();
}
