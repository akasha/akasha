package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "WEBGL_debug_shaders"
)
public class WEBGL_debug_shaders {
  protected WEBGL_debug_shaders() {
  }

  @HasNoSideEffects
  @Nonnull
  public native String getTranslatedShaderSource(int shaderId);
}
