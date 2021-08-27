package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nullable;
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
public final class WindowGlobal {
  /**
   * Operation appears in SharedWorker scope with different typing
   */
  @JsNullable
  public static EventHandler onmessageerror;

  /**
   * Operation appears in SharedWorker scope with same typing
   */
  @JsNullable
  public static EventHandler onstuff;

  private WindowGlobal() {
  }

  @JsProperty(
      name = "windowAttribute"
  )
  @JsNonNull
  public static native String windowAttribute();

  /**
   * Operation also appears in SharedWorker scope with same typing
   */
  public static native int requestAnimationFrame(@DoNotAutobox @Nullable Object callback);

  /**
   * Operation also appears in SharedWorker scope with different typing
   */
  public static native int requestAnimationFrame2(int callbackId);
}
