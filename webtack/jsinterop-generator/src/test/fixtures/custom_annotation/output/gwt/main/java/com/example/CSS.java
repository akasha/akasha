package com.example;

import akasha.MyAnnotation2;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(
    isNative = true,
    name = "CSS",
    namespace = JsPackage.GLOBAL
)
@Generated("org.realityforge.webtack")
public final class CSS {
  private CSS() {
  }

  @MyAnnotation2
  @Nonnull
  public static native String escape(@Nonnull String ident);
}
