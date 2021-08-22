package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "WebAssemblyGlobal"
)
public class WebAssemblyGlobal {
  @JsNullable
  public Any value;

  protected WebAssemblyGlobal() {
  }

  @JsNullable
  public native Any valueOf();
}
