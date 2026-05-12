package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Window"
)
public final class Window {
  private Window() {
  }

  @JsOverlay
  @Nonnull
  public static Window of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  @JsProperty(
      name = "speechSynthesis"
  )
  @Nonnull
  public native SpeechSynthesis speechSynthesis();
}
