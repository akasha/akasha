package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Overloaded operator arguments.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Window"
)
public class Window {
  protected Window() {
  }

  public native void scroll(double x, double y);

  public native void scroll(@Nonnull ScrollToOptions options);

  public native void scroll();
}
