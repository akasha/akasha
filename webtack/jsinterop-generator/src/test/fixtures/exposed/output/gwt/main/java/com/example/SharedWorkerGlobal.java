package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "$wnd"
)
public final class SharedWorkerGlobal {
  /**
   * Operation appears in Window scope with different typing
   */
  @Nullable
  public static MessageEventHandler onmessageerror;

  /**
   * Operation appears in Window scope with same typing
   */
  @Nullable
  public static EventHandler onstuff;

  private SharedWorkerGlobal() {
  }

  @JsProperty(
      name = "sharedWorkerGlobalScopeAttribute"
  )
  @Nonnull
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
  @Nonnull
  public static native String workerGlobalScopeAttribute();
}
