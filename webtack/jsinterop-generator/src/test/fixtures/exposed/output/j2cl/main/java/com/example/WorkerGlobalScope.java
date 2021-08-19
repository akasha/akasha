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
    name = "WorkerGlobalScope"
)
public class WorkerGlobalScope extends EventTarget {
  protected WorkerGlobalScope() {
  }

  @JsProperty(
      name = "workerGlobalScopeAttribute"
  )
  @Nonnull
  public native String workerGlobalScopeAttribute();
}
