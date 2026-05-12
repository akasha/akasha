package com.example;

import javax.annotation.Nonnull;
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

  /**
   * @deprecated
   */
  @Deprecated
  @JsNonNull
  public static native String decodeURI(@Nonnull String encodedURI);
}
