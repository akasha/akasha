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
    name = "Window"
)
public class Window {
  @Nonnull
  public String name;

  protected Window() {
  }

  @JsProperty(
      name = "isSecureContext"
  )
  public native boolean isSecureContext();
}
