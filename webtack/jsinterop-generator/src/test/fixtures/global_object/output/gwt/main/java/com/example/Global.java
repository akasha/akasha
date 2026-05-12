package com.example;

import javax.annotation.processing.Generated;
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
  public static native String decodeURI(@JsNonNull String encodedURI);

  @JsNonNull
  public static native String decodeURIComponent(@JsNonNull String encodedURI);

  @JsNonNull
  public static native String encodeURI(@JsNonNull String uri);
}
