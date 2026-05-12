package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "DOMTokenList"
)
public class DOMTokenList {
  protected DOMTokenList() {
  }

  public native void add(@JsNonNull String... tokens);

  public native boolean contains(@JsNonNull String token);

  public native void remove(@JsNonNull String... tokens);
}
