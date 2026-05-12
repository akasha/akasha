package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SharedWorkerGlobalScope"
)
public class SharedWorkerGlobalScope extends WorkerGlobalScope {
  /**
   * Operation appears in Window scope with different typing
   */
  @JsNullable
  public MessageEventHandler onmessageerror;

  /**
   * Operation appears in Window scope with same typing
   */
  @JsNullable
  public EventHandler onstuff;

  protected SharedWorkerGlobalScope() {
  }

  @JsProperty(
      name = "sharedWorkerGlobalScopeAttribute"
  )
  @Nonnull
  public native String sharedWorkerGlobalScopeAttribute();

  /**
   * Operation also appears in Window scope with same typing
   */
  public native int requestAnimationFrame(@DoNotAutobox @JsNullable Object callback);

  /**
   * Operation also appears in Window scope with different typing
   */
  public native int requestAnimationFrame2(@JsNonNull String callbackId);
}
