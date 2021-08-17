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
    name = "$wnd"
)
public final class WindowGlobal {
  @Nonnull
  public static String name;

  private WindowGlobal() {
  }

  @JsProperty(
      name = "isSecureContext"
  )
  public static native boolean isSecureContext();
}
