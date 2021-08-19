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
public final class SharedWorkerGlobalScopeGlobal {
  private SharedWorkerGlobalScopeGlobal() {
  }

  @JsProperty(
      name = "sharedWorkerGlobalScopeAttribute"
  )
  @Nonnull
  public static native String sharedWorkerGlobalScopeAttribute();

  @JsProperty(
      name = "workerGlobalScopeAttribute"
  )
  @Nonnull
  public static native String workerGlobalScopeAttribute();
}
