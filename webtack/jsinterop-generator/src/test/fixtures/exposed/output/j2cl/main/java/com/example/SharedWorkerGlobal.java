package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
public final class SharedWorkerGlobal {
  /**
   * Operation appears in Window scope with different typing
   */
  @JsNullable
  public static MessageEventHandler onmessageerror;

  /**
   * Operation appears in Window scope with same typing
   */
  @JsNullable
  public static EventHandler onstuff;

  private SharedWorkerGlobal() {
  }

  @JsProperty(
      name = "sharedWorkerGlobalScopeAttribute"
  )
  @JsNonNull
  public static native String sharedWorkerGlobalScopeAttribute();

  /**
   * Operation also appears in Window scope with same typing
   */
  public static native int requestAnimationFrame(@DoNotAutobox @Nullable Object callback);

  /**
   * Operation also appears in Window scope with different typing
   */
  public static native int requestAnimationFrame2(@Nonnull String callbackId);

  @JsProperty(
      name = "workerGlobalScopeAttribute"
  )
  @JsNonNull
  public static native String workerGlobalScopeAttribute();
}
