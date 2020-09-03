package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "DOMTokenList"
)
public class DOMTokenList {
  DOMTokenList() {
  }

  public native void add(@Nonnull String... tokens);

  public native boolean contains(@Nonnull String token);

  public native void remove(@Nonnull String... tokens);
}
