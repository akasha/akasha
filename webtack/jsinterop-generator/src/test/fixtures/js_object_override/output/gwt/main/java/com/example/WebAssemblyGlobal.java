package com.example;

import javax.annotation.Generated;
import javax.annotation.Nullable;
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
  @Nullable
  public Any value;

  protected WebAssemblyGlobal() {
  }

  @Nullable
  public native Any valueOf();
}
