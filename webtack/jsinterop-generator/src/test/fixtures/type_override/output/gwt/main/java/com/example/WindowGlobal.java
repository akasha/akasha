package com.example;

import javax.annotation.Generated;
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
  @JsNullable
  public static MessageEventHandler onmessage;

  private WindowGlobal() {
  }

  @JsProperty(
      name = "location"
  )
  @JsNonNull
  public static native Location location();

  @JsProperty(
      name = "navigator"
  )
  @JsNonNull
  public static native Navigator navigator();

  @JsProperty(
      name = "self"
  )
  @JsNonNull
  public static native Window self();
}
