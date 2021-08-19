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
    name = "$wnd"
)
public final class DedicatedWorkerGlobal {
  private DedicatedWorkerGlobal() {
  }

  @JsProperty(
      name = "dedicatedWorkerGlobalScopeAttribute"
  )
  @Nonnull
  public static native String dedicatedWorkerGlobalScopeAttribute();

  @JsProperty(
      name = "workerGlobalScopeAttribute"
  )
  @Nonnull
  public static native String workerGlobalScopeAttribute();
}
