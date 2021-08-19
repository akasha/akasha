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
public final class WindowGlobal {
  /**
   * Operation appears in SharedWorker scope with different typing
   */
  @Nullable
  public static EventHandler onmessageerror;

  /**
   * Operation appears in SharedWorker scope with same typing
   */
  @Nullable
  public static EventHandler onstuff;

  private WindowGlobal() {
  }

  @JsProperty(
      name = "windowAttribute"
  )
  @Nonnull
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
