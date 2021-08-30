package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNullable;
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
  @JsNullable
  public MessageEventHandler onmessage;

  protected Window() {
  }

  @JsProperty(
      name = "location"
  )
  @Nonnull
  public native Location location();

  @JsProperty(
      name = "navigator"
  )
  @Nonnull
  public native Navigator navigator();

  @JsProperty(
      name = "self"
  )
  @Nonnull
  public native Window self();
}
