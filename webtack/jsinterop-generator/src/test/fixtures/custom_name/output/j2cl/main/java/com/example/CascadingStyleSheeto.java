package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(
    isNative = true,
    name = "CSS",
    namespace = JsPackage.GLOBAL
)
@Generated("org.realityforge.webtack")
public final class CascadingStyleSheeto {
  private CascadingStyleSheeto() {
  }

  @JsNonNull
  public static native String escape(@JsNonNull String ident);
}
