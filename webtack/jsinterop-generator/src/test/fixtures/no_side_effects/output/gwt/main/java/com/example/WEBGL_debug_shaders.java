package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public class WEBGL_debug_shaders {
  protected WEBGL_debug_shaders() {
  }

  @HasNoSideEffects
  @JsNonNull
  public native String getTranslatedShaderSource(int shaderId);
}
