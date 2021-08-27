package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = "<window>",
    name = "$wnd"
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
