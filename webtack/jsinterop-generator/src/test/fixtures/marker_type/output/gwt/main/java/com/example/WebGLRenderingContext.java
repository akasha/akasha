package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "WebGLRenderingContext"
)
public class WebGLRenderingContext {
  protected WebGLRenderingContext() {
  }

  public native void texImage2D(@JsNonNull TexImageSource source);
}
