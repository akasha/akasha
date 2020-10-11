package com.example;

import elemental3.MyAnnotation;
import elemental3.MyAnnotation2;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@MyAnnotation
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "CSS"
)
public final class CSS {
  private CSS() {
  }

  @MyAnnotation2
  @Nonnull
  public native String escape(@Nonnull String ident);
}
