package com.example;

import akasha.MyAnnotation;
import akasha.gl.GLSL;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNullable;
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
  @JsNullable
  public native String getShaderSource(@MyAnnotation @Nonnull WebGLShader shader);
}
