package com.example;

import elemental3.MyAnnotation;
import elemental3.gl.GLSL;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@MyAnnotation
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "WebGL2RenderingContext"
)
public class WebGL2RenderingContext {
  protected WebGL2RenderingContext() {
  }

  @GLSL
  @Nullable
  public native String getShaderSource(@MyAnnotation @Nonnull WebGLShader shader);
}
