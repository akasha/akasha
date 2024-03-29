package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = "<window>",
    name = "$wnd"
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
