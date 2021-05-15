package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
public final class Global {
  private Global() {
  }

  @Nonnull
  public static native String decodeURI(@Nonnull String encodedURI);

  @Nonnull
  public static native String decodeURIComponent(@Nonnull String encodedURI);

  @Nonnull
  public static native String encodeURI(@Nonnull String uri);
}
