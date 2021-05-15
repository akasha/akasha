package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "OffscreenCanvas"
)
public class OffscreenCanvas {
  public OffscreenCanvas() {
  }

  public native void drawStuff();

  @HasNoSideEffects
  public native boolean isValid();
}
