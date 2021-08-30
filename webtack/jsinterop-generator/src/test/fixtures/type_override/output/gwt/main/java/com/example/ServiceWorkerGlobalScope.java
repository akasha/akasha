package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "ServiceWorkerGlobalScope"
)
public class ServiceWorkerGlobalScope extends WorkerGlobalScope {
  @JsNullable
  public ExtendableMessageEventHandler onmessage;

  protected ServiceWorkerGlobalScope() {
  }
}
