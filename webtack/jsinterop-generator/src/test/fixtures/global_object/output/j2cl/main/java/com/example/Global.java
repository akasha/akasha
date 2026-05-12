package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
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

  @JsNonNull
  public static native String decodeURI(@Nonnull String encodedURI);

  @JsNonNull
  public static native String decodeURIComponent(@Nonnull String encodedURI);

  @JsNonNull
  public static native String encodeURI(@Nonnull String uri);
}
