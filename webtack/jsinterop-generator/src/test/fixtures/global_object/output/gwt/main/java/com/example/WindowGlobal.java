package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
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
  @JsNonNull
  public static String name;

  private WindowGlobal() {
  }

  @JsProperty(
      name = "isSecureContext"
  )
  public static native boolean isSecureContext();
}
