package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The global <b>globalThis</b> property or the global object.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis">globalThis - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
public final class GlobalWindow extends Window {
  private GlobalWindow() {
  }

  /**
   * @deprecated
   */
  @Deprecated
  @Nonnull
  public native String decodeURI(@Nonnull String encodedURI);
}
