package com.example;

import akasha.MyAnnotation;
import akasha.MyAnnotation2;
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
@MyAnnotation
public final class CSS {
  private CSS() {
  }

  @MyAnnotation2
  @JsNonNull
  public static native String escape(@JsNonNull String ident);
}
