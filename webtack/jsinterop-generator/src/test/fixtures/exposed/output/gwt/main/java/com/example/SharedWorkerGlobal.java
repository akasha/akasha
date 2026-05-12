package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = "<window>",
    name = "$wnd"
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
  public static native int requestAnimationFrame(@DoNotAutobox @JsNullable Object callback);

  /**
   * Operation also appears in Window scope with different typing
   */
  public static native int requestAnimationFrame2(@JsNonNull String callbackId);

  @JsProperty(
      name = "workerGlobalScopeAttribute"
  )
  @JsNonNull
  public static native String workerGlobalScopeAttribute();
}
