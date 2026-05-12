package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
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
