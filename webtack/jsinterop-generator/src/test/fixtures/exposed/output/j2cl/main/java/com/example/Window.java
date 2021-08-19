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
    name = "Window"
)
public class Window extends EventTarget {
  /**
   * Operation appears in SharedWorker scope with different typing
   */
  @Nullable
  public EventHandler onmessageerror;

  /**
   * Operation appears in SharedWorker scope with same typing
   */
  @Nullable
  public EventHandler onstuff;

  protected Window() {
  }

  @JsProperty(
      name = "windowAttribute"
  )
  @Nonnull
  public native String windowAttribute();

  /**
   * Operation also appears in SharedWorker scope with same typing
   */
  public native int requestAnimationFrame(@DoNotAutobox @Nullable Object callback);

  /**
   * Operation also appears in SharedWorker scope with different typing
   */
  public native int requestAnimationFrame2(int callbackId);
}
