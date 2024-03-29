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
public final class DedicatedWorkerGlobal {
  private DedicatedWorkerGlobal() {
  }

  @JsProperty(
      name = "dedicatedWorkerGlobalScopeAttribute"
  )
  @JsNonNull
  public static native String dedicatedWorkerGlobalScopeAttribute();

  @JsProperty(
      name = "workerGlobalScopeAttribute"
  )
  @JsNonNull
  public static native String workerGlobalScopeAttribute();
}
